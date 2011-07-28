using System.Windows.Controls;

namespace Visiblox.Charts.Examples.PieChart
{
    /// <summary>
    /// A simple pie chart example showing a few categories of data
    /// </summary>
    public partial class PieChartExample : UserControl
    {
        public PieChartExample()
        {
            InitializeComponent();

            DataSeries<string, double> series = new DataSeries<string, double>();

            series.Add(new DataPoint<string, double>("F. Alonso", 5));
            series.Add(new DataPoint<string, double>("J. Button", 2));
            series.Add(new DataPoint<string, double>("L. Hamilton", 3));
            series.Add(new DataPoint<string, double>("S. Vettel", 5));
            series.Add(new DataPoint<string, double>("M. Webber", 4));           

            MainChart.DataSeries = series;
        }
    }
}
