using System;
using System.Windows.Controls;
using System.Windows.Threading;
using System.Windows.Data;
using System.Windows;
using Visiblox.Charts;
using System.Windows.Media;

namespace Visiblox.Charts.Examples.FastStreamingChart
{
    /// <summary>
    /// An example to display a chart streaming data quickly
    /// </summary>
    public partial class FastStreamingChartExample : UserControl
    {
        /// <summary>
        /// Random seed generator
        /// </summary>
        private Random rand = new Random();

        /// <summary>
        /// The data source of the volume bar chart
        /// </summary>
        private DataSeries<DateTime, double> _volumeData = new DataSeries<DateTime, double>();

        /// <summary>
        /// The current date and time that is plotted at the moment
        /// </summary>
        private DateTime _currentTime;

        /// <summary>
        /// The volume of the stock traded plotted at the moment
        /// </summary>
        private double _currentVolume = 1000;

        /// <summary>
        /// Number of updates on the chart
        /// Used to ensure that volume chart is updated less frequent than the price chart
        /// </summary>
        private int _tick = 0;

        /// <summary>
        /// Maximum points to display on the charts
        /// </summary>
        private const int _MaxPoints = 80;

        /// <summary>
        /// Time between updates (in ms)
        /// </summary>
        private int _tickInterval = 250;

        private DateTime _lastUpdated;
        
        /// <summary>
        /// Initalizes the component
        /// </summary>
        public FastStreamingChartExample()
        {
            InitializeComponent();

            // Add zooming to the chart by setting its behavour to ZoomBehaviour
            chart.Behaviour = new ZoomBehaviour();

            // Set the starting date a year earlier & set initial price
            this._currentTime = DateTime.Now.AddYears(-1);
            double price = 25.00;

            var data = new DataSeries<DateTime, double>();

            // Create initial data for the charts and assign it to them
            for (int i = 0; i < 100; i++)
            {
                _currentTime = _currentTime.AddMinutes(1);
                // Generate the price
                price += rand.NextDouble() - 0.5;
                data.Add(new DataPoint<DateTime, double>(_currentTime, price));

                // Update the volume data every 4th tick
                if (_tick % 4 == 0)
                {
                    // Volume price is changed and updated less often than the price
                    _currentVolume += (rand.NextDouble() - 0.5) * 100;
                    _volumeData.Add(new DataPoint<DateTime, double>(_currentTime, Math.Abs(_currentVolume)));
                }
                _tick++;
            }

            // Assign the data source to the price series
            chart.Series[0].DataSeries = data;

            CompositionTarget.Rendering += new EventHandler(CompositionTarget_Rendering);
        }

        private void SpeedControl_ValueChanged(object sender, RoutedPropertyChangedEventArgs<double> e)
        {
            _tickInterval = (int)e.NewValue;
        }

        void CompositionTarget_Rendering(object sender, EventArgs e)
        {
            if ((DateTime.Now - _lastUpdated).TotalMilliseconds > _tickInterval)
            {
                UpdateChart();
            }
        }

        /// <summary>
        /// Updates the charts
        /// </summary>
        void UpdateChart()
        {
            if (((FrameworkElement)chart.Parent).ActualWidth == 0 || chart.Series.Count < 1)
            {
                return;
                // If the chart is no longer displayed, stop running so that it can be garbage collected. 
            }
            // Generate the current price based on the previous price and update the data source of the price series
            // The price chart is automatically updated because its DataSeries property implements INotifyCollectionChanged
            var priceData = (DataSeries<DateTime, double>)chart.Series[0].DataSeries;
            priceData.Title = priceData.Count.ToString();
            double currentPrice = priceData[priceData.Count - 1].Y + rand.NextDouble() - 0.5;
            priceData.Add(new DataPoint<DateTime, double>(_currentTime, currentPrice));
            _currentTime = _currentTime.AddMinutes(1);

            if (priceData.Count > _MaxPoints)
            {
                priceData.RemoveAt(0);
            }

            // Update the volume data every 4th tick
            if (_tick % 4 == 0)
            {
                // Generate the current volume based on the previous volume.
                // Note that by changing volumeData the chart is updated because the DataSeries implements INotifyCollectionChanged
                _currentVolume += (rand.NextDouble() - 0.5) * 300;
                _volumeData.Add(new DataPoint<DateTime, double>(_currentTime, Math.Abs(_currentVolume)));

                if (_volumeData.Count > _MaxPoints / 4)
                {
                    _volumeData.RemoveAt(0);
                }
            }
            _tick++;
            _lastUpdated = DateTime.Now;
        }
    }
}
