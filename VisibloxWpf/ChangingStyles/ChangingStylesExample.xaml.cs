using System;
using System.Windows;
using System.Windows.Controls;
using Visiblox.Charts;
using System.Windows.Media;

namespace Visiblox.Charts.Examples.LineStyleChanging
{
    /// <summary>
    /// A class for cycling through several different styles on
    /// associated LineSeries
    /// </summary>
    public partial class ChangingStylesExample : UserControl
    {
        /// <summary>
        /// The next change in the defined cycle to take effect
        /// </summary>
        private int _nextChange = 0;

        /// <summary>
        /// The size of the range of the minimum y value provided
        /// by the sin number generator, depending on the series, the height of the
        /// sin wave generated will be (N * value) where N is the number of the series
        /// </summary>
        private const int _YRangeValue = 50;

        /// <summary>
        /// The total number of values to generate
        /// </summary>
        private const int _numberOfValues = 50;

        /// <summary>
        /// Public constructor
        /// </summary>
        public ChangingStylesExample()
        {
            InitializeComponent();
            Int32 lcCount = 0;

            // Generate each of the assigned line series as a sin wave
            foreach (IChartSeries lcSeries in StyleChanging.Series)
            {
                if (!(lcSeries is LineSeries))
                    throw new NotSupportedException("Only LineSeries datatypes are supported as Series in this example, check your XAML!");

                lcSeries.DataSeries = GenerateSinData(10 + _YRangeValue * lcCount, (_YRangeValue * lcCount) + _YRangeValue);
                lcCount++;
            }
        }

        /// <summary>
        /// Generates a data series representing a trigonometric sin wave
        /// </summary>
        /// <param name="inMinValue">The minimum value (extended from -1)</param>
        /// <param name="inMaxValue">The maximum value (extended from 1)</param>
        private DataSeries<int, double> GenerateSinData(int inMinValue, int inMaxValue)
        {
            DataSeries<int, double> lcDataSeries = new DataSeries<int, double>();

            for (int x = 0; x < _numberOfValues; x++)
            {
                // Generates an individual point on the curve based on the number of values to calculate 4 complete sin waves
                lcDataSeries.Add(new DataPoint<int, double>(x, ((Math.Sin(((4 * Math.PI) / _numberOfValues) * x) + 1) * (inMaxValue / 2)) + inMinValue));
            }

            return lcDataSeries;
        }

        /// <summary>
        /// Switch the lines depending on the series that we are on, the style rotation is:
        /// 
        /// Cycle 1:    Line 2 change from BlueLineStyle to RedLineStyle
        /// Cycle 2:    Line 1 changed so as to display the area
        /// Cycle 3:    Line 2 stops showing points
        ///             Line 1 stops showing the points and the line
        /// Cycle 4:    Revert back to initial state
        /// </summary>
        private void ChangeStyle(int inNextChange)
        {
            // Each case needs to set all style parameters as the order the rotation is called in is not guaranteed
            switch (inNextChange)
            {
                case 0:
                    (StyleChanging.Series[1] as LineSeries).LineStroke = Resources["RedBrush"] as Brush;
                    (StyleChanging.Series[1] as LineSeries).LineStrokeThickness = (double)Resources["ThickThickness"];
                    (StyleChanging.Series[0] as LineSeries).ShowArea = false;
                    (StyleChanging.Series[1] as LineSeries).ShowPoints = true;
                    (StyleChanging.Series[0] as LineSeries).ShowLine = true;
                    break;
                case 1:
                    (StyleChanging.Series[1] as LineSeries).LineStroke = Resources["RedBrush"] as Brush;
                    (StyleChanging.Series[1] as LineSeries).LineStrokeThickness = (double)Resources["ThickThickness"];
                    (StyleChanging.Series[0] as LineSeries).ShowArea = true;
                    (StyleChanging.Series[1] as LineSeries).ShowPoints = true;
                    (StyleChanging.Series[0] as LineSeries).ShowLine = true;
                    break;
                case 2:
                    (StyleChanging.Series[1] as LineSeries).LineStroke = Resources["RedBrush"] as Brush;
                    (StyleChanging.Series[1] as LineSeries).LineStrokeThickness = (double)Resources["ThickThickness"];
                    (StyleChanging.Series[1] as LineSeries).ShowPoints = false;
                    (StyleChanging.Series[0] as LineSeries).ShowLine = false;
                    (StyleChanging.Series[0] as LineSeries).ShowArea = true;
                    break;
                case 3:
                    (StyleChanging.Series[1] as LineSeries).LineStroke = Resources["BlueBrush"] as Brush;
                    (StyleChanging.Series[1] as LineSeries).LineStrokeThickness = (double)Resources["MediumThickness"];
                    (StyleChanging.Series[0] as LineSeries).ShowArea = false;
                    (StyleChanging.Series[1] as LineSeries).ShowPoints = true;
                    (StyleChanging.Series[0] as LineSeries).ShowLine = true;
                    break;
            }

            // Prepare for the next change (this needs to be up to date for when cycle change is clicked)
            _nextChange = (inNextChange + 1) % 4;
        }

        #region Button Handlers

        /// <summary>
        /// Select style 1
        /// </summary>
        private void btn_Style1_Click(object sender, RoutedEventArgs e)
        {
            ChangeStyle(0);
        }

        /// <summary>
        /// Select style 2
        /// </summary>
        private void btn_Style2_Click(object sender, RoutedEventArgs e)
        {
            ChangeStyle(1);
        }

        /// <summary>
        /// Select style 3
        /// </summary>
        private void btn_Style3_Click(object sender, RoutedEventArgs e)
        {
            ChangeStyle(2);
        }

        /// <summary>
        /// Select style 4
        /// </summary>
        private void btn_Style4_Click(object sender, RoutedEventArgs e)
        {
            ChangeStyle(3);
        }

        /// <summary>
        /// Select the next style
        /// </summary>
        private void btn_Cycle_Click(object sender, RoutedEventArgs e)
        {
            ChangeStyle(_nextChange);
        }

        #endregion
    }
}