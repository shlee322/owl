using System;
using System.Windows;
using System.Windows.Controls;
using System.Text.RegularExpressions;
using System.IO;
using Visiblox.Charts;

namespace Visiblox.Charts.Examples.ScatterChart
{
    /// <summary>
    /// An example for displaying scatter chart data
    /// </summary>
    public partial class ScatterChartExample : UserControl
    {
        /// <summary>
        /// The number of points to be displayed from each series
        /// </summary>
        private const int _numberOfPoints = 200;

        /// <summary>
        /// The names of each of the series to be displayed
        /// </summary>
        private string[] _seriesNames = { "1500M", "10K", "Marathon" };

        /// <summary>
        /// The regular expression pattern for date of birth
        /// </summary>
        private Regex _dateOfBirthPattern = new Regex("\\d{2}\\.\\d{2}.\\d{2}");

        /// <summary>
        /// The regular expression pattern for numbers
        /// </summary>
        private Regex _numberPattern = new Regex("\\d+");

        /// <summary>
        /// Default constructor
        /// </summary>
        public ScatterChartExample()
        {
            InitializeComponent();

            for (int distance = 0; distance < _seriesNames.Length; distance++)
            {
                Uri lcFilename = new Uri(String.Format("ScatterChart/Data/{0}Rankings2009.txt", _seriesNames[distance]), UriKind.Relative);

                using (StreamReader streamReader = new StreamReader(Application.GetResourceStream(lcFilename).Stream))
                {
                    DataSeries<int, int> dataSeries = new DataSeries<int, int>();

                    int numPointsRead = 0;
                    // Read each line in the file
                    while (streamReader.Peek() >= 0)
                    {
                        string line = streamReader.ReadLine();
                        string[] parts = line.Split(new char[] { ' ', '\t' });

                        if (_numberPattern.IsMatch(parts[0]))
                        {
                            int linePos = int.Parse(parts[0]);
                            // Only read the first _numberOfPoints points
                            if (linePos >= _numberOfPoints-1)
                                break;

                            foreach (String part in parts)
                            {
                                if (_dateOfBirthPattern.IsMatch(part))
                                {
                                    DateTime dob = GetDateOfBirth(part);
                                    // Get the age of the person from the date of birth
                                    int age = Convert.ToInt32(Math.Round((double)(DateTime.Now - dob).Days / 365));
                                    dataSeries.Add(new DataPoint<int, int>(linePos, age));
                                    numPointsRead++;
                                    break;
                                }
                            }
                        }
                    }

                    // Set the created DataSeries to be the data source of one of the chart series
                    dataSeries.Title = _seriesNames[distance];
                    ScatterChart.Series[distance].DataSeries = dataSeries;
                }
            }

        }

        /// <summary>
        /// Convert a string representation to a date of birth
        /// </summary>
        private DateTime GetDateOfBirth(string dobString)
        {
            string[] parts = dobString.Split('.');
            return new DateTime(int.Parse(parts[2]) + 1900, int.Parse(parts[1]), int.Parse(parts[0]));
        }


        #region Check Box event handlers

        private void Button_Checked(object sender, RoutedEventArgs e)
        {
            CheckBox checkBox = sender as CheckBox;
            LineSeries toggleSeries = (LineSeries)ScatterChart.Series[0];

            switch(checkBox.Name)
            {
                case "FiftenHundred": toggleSeries = (LineSeries)ScatterChart.Series[0]; break;
                case "TenThousand": toggleSeries = (LineSeries)ScatterChart.Series[1]; break;
                case "Marathon": toggleSeries = (LineSeries)ScatterChart.Series[2]; break;
            }

            if (checkBox.IsChecked == true)
            {
                toggleSeries.Visibility = Visibility.Visible;
            }

            else
            {
                toggleSeries.Visibility = Visibility.Collapsed;
            }
        }

        #endregion
    }
}