using System.Collections.Generic;
using System.Windows.Controls;
using System.Windows.Data;
using System;
using System.Globalization;
using System.Windows.Input;

namespace Visiblox.Charts.Examples.BarChart
{
    /// <summary>
    /// A simple chart example displaying bar charts
    /// </summary>
    public partial class BarChartExample : UserControl
    {
        public BarChartExample()
        {
            InitializeComponent();

            //Fix HighlightedStyle to Normal style and add mouse enter and leave events on series
            foreach (BarSeries series in MainChart.Series)
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
    public class DebtLevelList : List<DebtLevel> { }

    /// <summary>
    /// Class representing a GPD data point
    /// </summary>
    public class DebtLevel
    {
        /// <summary>
        /// The Country, as a string, that this debt data point applies to
        /// </summary>
        public string Country { get; set; }

        /// <summary>
        /// The Percent of GDP value for this country
        /// </summary>
        public double PercentGDP { get; set; }
    }
}
