using System;
using System.Collections.Generic;
using System.Globalization;
using System.IO;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Input;
using System.Windows.Resources;

namespace Visiblox.Charts.Examples.BandChart
{
    /// <summary>
    /// A simple chart example displaying band data
    /// </summary>
    public partial class BandChartExample : UserControl
    {
        //how many points we want to show
        const int POINT_COUNT = 30;

        public BandChartExample()
        {
            InitializeComponent();
            MainChart.Series[0].DataSeries = GetMSFTDataSeries();
        }

        /// <summary>
        /// Load the data from the CSV file and return it as a data series
        /// </summary>
        /// <returns>The data series</returns>
        private DataSeries<DateTime, double> GetMSFTDataSeries()
        {
            // Create a DataSeries to later fill up and set as data source for the candlestick series
            DataSeries<DateTime, double> series = new DataSeries<DateTime, double>();
            StreamResourceInfo sri = Application.GetResourceStream(new Uri("/Visiblox.Charts.Examples.Wpf.Free;component/BandChart/Data/MSFT.csv", UriKind.Relative));
            StreamReader reader = new StreamReader(sri.Stream);

            // First line is header information, so skip before reading data
            reader.ReadLine();
            while (reader.Peek() >= 0 && series.Count < POINT_COUNT)
            {
                string line = reader.ReadLine();
                string[] values = line.Split(',');

                DateTime date = DateTime.Parse(values[0]);
                double open = double.Parse(values[1]);
                double high = double.Parse(values[2]);
                double low = double.Parse(values[3]);
                double close = double.Parse(values[4]);

                series.Add(new MultiValuedDataPoint<DateTime, double>(date,
                    new Dictionary<object, double>()
                    {
                        {BandSeries.Lower, open},
                        {BandSeries.Upper, close}
                    }
                ));
            }


            return series;
        }
    }

    /// <summary>
    /// Value converter to extract the relevant YValue from the data point and display it in a suitable format
    /// </summary>
    public class YValuesConverter : IValueConverter
    {
        public object Convert(object value, Type targetType, object parameter, CultureInfo culture)
        {
            IDataPoint dataPoint = value as IDataPoint;
            if (dataPoint != null)
            {
                return ((double)dataPoint[parameter]).ToString("N2");
            }

            return value;
        }

        public object ConvertBack(object value, Type targetType, object parameter, CultureInfo culture)
        {
            throw new NotImplementedException();
        }
    }
}
