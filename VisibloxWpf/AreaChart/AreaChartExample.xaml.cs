using System;
using System.Linq;
using System.Windows.Controls;
using Visiblox.Charts;

namespace Visiblox.Charts.Examples.AreaChart
{
    /// <summary>
    /// An example chart for displaying areas
    /// </summary>
    public partial class AreaChartExample : UserControl
    {
        
        private Random random = new Random();

        /// <summary>
        /// Default constructor
        /// </summary>
        public AreaChartExample()
        {
            InitializeComponent();

            // Generate data points for the series
            DataSeries<DateTime, double> currentSeries = GenerateDataSeries();
            AreaChart.Series[0].DataSeries = currentSeries;

            // Set X axis range
            DateTimeRange range = new DateTimeRange();
            range.Minimum = currentSeries.ElementAt(0).X;
            range.Maximum = currentSeries.ElementAt(currentSeries.Count - 1).X;
            AreaChart.XAxis.Range = range;
        }

        private DataSeries<DateTime, double> GenerateDataSeries()
        {
            DataSeries<DateTime, double> series = new DataSeries<DateTime, double>();
            DateTime startingDateTime = new DateTime(2010, 2, 18);

            //Generate random temperature data for every hour on a given day
            double prevValue = 0;
            double seriesCounter = 0;

            for (int i = 0; i < 24; i++)
            {
                double nextValue;
                double seed = random.NextDouble() * (seriesCounter +1);
                if (i > 8 - seriesCounter && i < 17 - seriesCounter)
                    nextValue = prevValue + 2 * seed;
                else
                    nextValue = prevValue - seed;

                // Add a DataPoint to the DataSeries
                series.Add(new DataPoint<DateTime, double>() { X = startingDateTime.AddHours(i), Y = nextValue });
                prevValue = nextValue;
            }
            return series;
        }
    }
}
