using System.Collections.Generic;
using System.Windows.Controls;
using System.Windows.Input;

namespace Visiblox.Charts.Examples.ColumnChart
{
    /// <summary>
    /// A simple chart example displaying bar charts
    /// </summary>
    public partial class ColumnChartExample : UserControl
    {
        public ColumnChartExample()
        {
            InitializeComponent();

            //Fix HighlightedStyle to Normal style and add mouse enter and leave events on series
            foreach (ColumnSeries series in MainChart.Series)
            {
                series.HighlightedStyle = series.NormalStyle;
                series.MouseEnter += new MouseEventHandler(series_MouseEnter);
                series.MouseLeave += new MouseEventHandler(series_MouseLeave);
            }

        }

        //Mouse enters series, change to hand cursor
        void series_MouseEnter(object sender, System.Windows.Input.MouseEventArgs e)
        {
            this.Cursor = Cursors.Hand;
        }

        //Mouse leaves series, change back to arrow cursor
        void series_MouseLeave(object sender, MouseEventArgs e)
        {
            this.Cursor = Cursors.Arrow;
        }
    }

    // Data model

    /// <summary>
    /// List of GDPDataPoints
    /// This class is needed as XAML can't handle generics
    /// </summary>
    public class GDPDataPointList : List<GDPDataPoint> { }

    /// <summary>
    /// Class representing a GPD data point
    /// </summary>
    public class GDPDataPoint
    {
        /// <summary>
        /// The year, as a string, that this GDP data point aligns to
        /// </summary>
        public string Date { get; set; }

        /// <summary>
        /// The GDP value for this date
        /// </summary>
        public double GDP { get; set; }
    }
}