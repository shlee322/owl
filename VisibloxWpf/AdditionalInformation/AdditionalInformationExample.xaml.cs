using System.Collections.Generic;
using System.Windows;
using System.Windows.Controls;
using System.ComponentModel;
using System;
using System.Collections.Specialized;
using System.Windows.Media;
using System.Windows.Input;

namespace Visiblox.Charts.Examples.AdditionalInformation
{
    public partial class AdditionalInformationExample : UserControl
    {
        /// <summary>
        /// Default constructor
        /// </summary>
        public AdditionalInformationExample()
        { 
            InitializeComponent();

            CourseCollection c = Resources["Courses"] as CourseCollection;
            foreach (Course element in c)
            {
                element.Courses = c;
            }

            //add handlers to change cursor when mouse enters and leaves the bars
            (CourseInformation.Series[0] as BarSeries).MouseEnter += new MouseEventHandler(AdditionalInformationExample_MouseEnter);
            (CourseInformation.Series[0] as BarSeries).MouseLeave += new MouseEventHandler(AdditionalInformationExample_MouseLeave);

        }

        void AdditionalInformationExample_MouseLeave(object sender, MouseEventArgs e)
        {
            this.Cursor = Cursors.Arrow;
        }

        void AdditionalInformationExample_MouseEnter(object sender, System.Windows.Input.MouseEventArgs e)
        {
            this.Cursor = Cursors.Hand;
        }

        /// <summary>
        /// The accept changes button has been clicked
        /// </summary>
        private void AcceptChanges_Click(object sender, RoutedEventArgs e)
        {   
            // Forces the text box to give up focus and hence applies the changes
            CourseInformation.Focus();            
            
        }

    }
    
    // Internal classes for data representation

    /// <summary>
    /// A list of courses
    /// </summary>
    public class CourseCollection : List<Course> { }
    
    /// <summary>
    /// A course object
    /// </summary>
    public class Course : INotifyPropertyChanged
    {
        /// <summary>
        /// The private backing variable for Score
        /// </summary>
        private double _score;

        /// <summary>
        /// The private backing variable for CourseName
        /// </summary>
        private string _courseName;

        /// <summary>
        /// Private collection of all current courses
        /// </summary>
        private CourseCollection _courses;

        public CourseCollection Courses
        {
            get { return _courses; }

            set { _courses = value; }
        }


        /// <summary>
        /// The name of the course
        /// </summary>
        public string CourseName 
        { 
            get { return _courseName; }

            set
            {
                if (_courses != null)
                {
                    foreach (Course c in _courses)
                    {
                        if (c.CourseName == value)
                        {
                            throw new Exception("Course already exists");
                        }
                    }
                }

                _courseName = value; OnPropertyChanged("CourseName");
            }
        }

        /// <summary>
        /// A string description of the timetable
        /// </summary>
        public string Timetable { get; set; }

        /// <summary>
        /// The lecturer's name
        /// </summary>
        public string Lecturer { get; set; }

        /// <summary>
        /// The average score for people on this course
        /// </summary>
        public double Score 
        {  
            get { return _score; } 
            set
            {
                //throw exception if score not valid percent value
                if (value < 0 || value > 100)
                {
                    //TextBox binding sets ValidatesOnExceptions in XAML to display error message
                    throw new Exception("Score must be between 0 and 100%");
                }

                else
                {
                    _score = value; OnPropertyChanged("Score");
                }
            } 
        }

        /// <summary>
        /// Private helper for notifying that a particular property has changed
        /// </summary>
        private void OnPropertyChanged(string inName)
        {
            if (PropertyChanged != null)
                PropertyChanged(this, new PropertyChangedEventArgs(inName));
        }

        /// <summary>
        /// Event to notify if the property has changed
        /// </summary>
        public event PropertyChangedEventHandler PropertyChanged;

        /// <summary>
        /// Public override of ToString for category axis
        /// </summary>
        public override string ToString()
        {
            return CourseName.ToString(); ;
        }
    }
}