using System;
using System.Collections.Generic;
using System.Windows.Controls;
using System.ComponentModel;
using Visiblox.Charts.Primitives;

namespace Visiblox.Charts.Examples.BackgroundImage
{
    /// <summary>
    /// An example displaying a chart with a background image
    /// </summary>
    public partial class BackgroundImageExample : UserControl
    {
        /// <summary>
        /// Default constructor
        /// </summary>
        public BackgroundImageExample()
        {
            InitializeComponent();
        }
    }

    // Data model

    /// <summary>
    /// A list of data points
    /// </summary>
    public class DateDoubleDataPointList : List<DateDoubleDataPoint> { }

    /// <summary>
    /// A data point containing a datetime and a double value
    /// </summary>
    public class DateDoubleDataPoint
    {
        public DateDoubleDataPoint() { }

        [TypeConverter(typeof(Visiblox.Charts.Primitives.DateTimeConverter))]
        public DateTime X { get; set; }
        public double Y { get; set; }
    }
}
