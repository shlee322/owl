using System;
using System.Windows.Controls;
using System.Windows.Input;
using System.Windows.Media;
using Visiblox.Charts;
using System.ComponentModel;

namespace Visiblox.Charts.Examples.LargeDataSets
{
    /// <summary>
    /// An example to display how the chart handles very large datasets
    /// </summary>
    public partial class LargeDataSetsExample : UserControl
    {
        /// <summary>
        /// The number of datapoints in each series
        /// </summary>
        private int _dataPerSeries;

        //ensure toggle buttons only active once chart is available
        //private bool _toChange = false;

        //used to store current zoom scale on chart
        private double _zoomScale;

        private ZoomBehaviour _zoom;
        private CrosshairBehaviour _crosshair;

        /// <summary>
        /// Default constructor
        /// </summary>
        public LargeDataSetsExample()
        {
            InitializeComponent();

            // Use maximum X axis range value as number of data points to create
            _dataPerSeries = Convert.ToInt32(LargeDataSetChart.XAxis.Range.Maximum);

            _zoom = new ZoomBehaviour();
            _crosshair = new CrosshairBehaviour();
            ((BehaviourManager)LargeDataSetChart.Behaviour).Behaviours.Add(_zoom);

            // Generate the random data points for the series
            DataSeries<int, double> series1 = new DataSeries<int, double>();
            DataSeries<int, double> series2 = new DataSeries<int, double>();
            DataSeries<int, double> series3 = new DataSeries<int, double>();
            DataSeries<int, double> series4 = new DataSeries<int, double>();
            DataSeries<int, double> series5 = new DataSeries<int, double>();
            DataSeries<int, double> series6 = new DataSeries<int, double>();

            Random rand = new Random();
            double y = 0;
            
            for (int i = 0; i <= _dataPerSeries; i++)
            {
                y = 1.25 + rand.NextDouble()/2;
                series1.Add(new DataPoint<int, double>(i, y));

                y = 2.25 + rand.NextDouble()/2;
                series2.Add(new DataPoint<int, double>(i, y));

                y = 3.25 + rand.NextDouble()/2;
                series3.Add(new DataPoint<int, double>(i, y));

                y = 4.25 + rand.NextDouble()/2;
                series4.Add(new DataPoint<int, double>(i, y));

                y = 5.25 + rand.NextDouble()/2;
                series5.Add(new DataPoint<int, double>(i, y));

                y = 6.25 + rand.NextDouble()/2;
                series6.Add(new DataPoint<int, double>(i, y));  
            }

            LargeDataSetChart.Series[0].DataSeries = series1;
            LargeDataSetChart.Series[1].DataSeries = series2;
            LargeDataSetChart.Series[2].DataSeries = series3;
            LargeDataSetChart.Series[3].DataSeries = series4;
            LargeDataSetChart.Series[4].DataSeries = series5;
            LargeDataSetChart.Series[5].DataSeries = series6;

            // Listen to X axis property changed events to handle custom zoom behaviour
            LargeDataSetChart.XAxis.PropertyChanged += HandleZoom;
        }

        private void ZoomButton_Checked(object sender, System.Windows.RoutedEventArgs e)
        {
            if (BehaviourManager != null && BehaviourManager.Behaviours.Count > 0)
            {
                BehaviourManager.Behaviours[0] = _zoom;
            }
        }

        private void CrosshairButton_Checked(object sender, System.Windows.RoutedEventArgs e)
        {
            BehaviourManager.Behaviours[0] = _crosshair;
        }

        void HandleZoom(object sender, PropertyChangedEventArgs e)
        {
            if (e.PropertyName == "Zoom")
            {
                _zoomScale = (LargeDataSetChart.XAxis as LinearAxis).Zoom.Scale;

                //if X axis zoomed far enough, show tick interval at 2
                if (_zoomScale < 0.03)
                {
                    (LargeDataSetChart.XAxis as LinearAxis).MajorTickInterval = 2;
                }

                //else use default tick interval
                else
                {
                    (LargeDataSetChart.XAxis as LinearAxis).MajorTickInterval = 0;
                }
            }
        }
    }
}