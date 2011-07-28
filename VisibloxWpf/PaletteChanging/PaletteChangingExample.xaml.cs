using System;
using System.Collections.Generic;
using System.Windows.Controls;
using System.Windows.Threading;
using System.Windows;
using Visiblox.Charts;

namespace Visiblox.Charts.Examples.PaletteChanging
{
    /// <summary>
    /// An example for automatically changing the palette of a chart
    /// at set time increments in a continuous cycle
    /// </summary>
    public partial class PaletteChangingExample : UserControl
    {
        /// <summary>
        /// A list of the available resource names. 
        /// These are defined in XAML.
        /// </summary>
        private List<string> _resourceNames = new List<string>() { "GreyPalette", "RedPalette", "GreenPalette" };

        /// <summary>
        /// The timer for firing the event to change the style
        /// </summary>
        private DispatcherTimer _timer;

        /// <summary>
        /// The current index of the palette in the resources
        /// </summary>
        private int _currentIndex = 0;

        /// <summary>
        /// The tick duration as the styles should change in milliseconds
        /// </summary>
        private const int _timerTickDuration = 2000;

        /// <summary>
        /// The maximum y value in the randomly generated data
        /// </summary>
        private const int _randomYMaxValue = 50;

        /// <summary>
        /// The total number of values to generate
        /// </summary>
        private const int _numberOfValues = 50;

        /// <summary>
        /// Default constructor
        /// </summary>
        public PaletteChangingExample()
        {
            InitializeComponent();

            // Initiate the first data line
            PaletteChanging.Series[0].DataSeries = GenerateData();

            InitialiseTimer();
        }

        /// <summary>
        /// Create the data series for this chart - randomly generate 3 lines
        /// </summary>
        private DataSeries<int, int> GenerateData()
        {
            Random lcRandom = new Random();
            DataSeries<int, int> lcDataSeries = new DataSeries<int, int>();

            for (int x = 1; x < _numberOfValues; x++)
            {
                int next = lcRandom.Next(1, _randomYMaxValue);

                lcDataSeries.Add(new DataPoint<int, int>(x, next));
            }
            
            return lcDataSeries;
            
        }

        /// <summary>
        /// Initialise a timer to toggle the styles from RedPalette to BluePalette
        /// </summary>
        private void InitialiseTimer()
        {
            _timer = new DispatcherTimer();
            _timer.Interval = new TimeSpan(0, 0, 0, 0, _timerTickDuration);
            _timer.Tick += new EventHandler(_timer_Tick);
            _timer.Start();
        }

        /// <summary>
        /// Switch the palette styles based on Resources
        /// </summary>
        void _timer_Tick(object sender, EventArgs e)
        {
            if (((FrameworkElement)PaletteChanging.Parent).ActualWidth == 0)
            {
                // If the chart is no longer displayed, stop running so that it can be garbage collected. 
                _timer.Stop();
            }

            // Else cycle to next style
            _currentIndex = (_currentIndex + 1) % _resourceNames.Count;
            PaletteChanging.Palette = (Palette)Resources[_resourceNames[_currentIndex]];
        }
    }
}
