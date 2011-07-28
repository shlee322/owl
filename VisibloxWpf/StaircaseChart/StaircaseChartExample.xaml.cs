using System;
using System.Windows.Controls;

namespace Visiblox.Charts.Examples.StaircaseChart
{
    /// <summary>
    /// A simple chart example displaying staircase data
    /// </summary>
    public partial class StaircaseChartExample : UserControl
    {
        public StaircaseChartExample()
        {
            InitializeComponent();

            StaircaseSeries series = MainChart.Series[0] as StaircaseSeries;
            series.DataSeries = StaircaseChartExample.GetData();
        }

        //Generate some data
        public static DataSeries<string, double> GetData()
        {
            DataSeries<string, double> series = new DataSeries<string, double>();
            series.Title = "English letter frequencies";

            series.Add(new DataPoint<string, double>("A", 08.167));
            series.Add(new DataPoint<string, double>("B", 01.492));
            series.Add(new DataPoint<string, double>("C", 02.782));
            series.Add(new DataPoint<string, double>("D", 04.253));
            series.Add(new DataPoint<string, double>("E", 12.702));
            series.Add(new DataPoint<string, double>("F", 02.228));
            series.Add(new DataPoint<string, double>("G", 02.015));
            series.Add(new DataPoint<string, double>("H", 06.094));
            series.Add(new DataPoint<string, double>("I", 06.966));
            series.Add(new DataPoint<string, double>("J", 00.153));
            series.Add(new DataPoint<string, double>("K", 00.772));
            series.Add(new DataPoint<string, double>("L", 04.025));
            series.Add(new DataPoint<string, double>("M", 02.406));
            series.Add(new DataPoint<string, double>("N", 06.749));
            series.Add(new DataPoint<string, double>("O", 07.507));
            series.Add(new DataPoint<string, double>("P", 01.929));
            series.Add(new DataPoint<string, double>("Q", 00.095));
            series.Add(new DataPoint<string, double>("R", 05.987));
            series.Add(new DataPoint<string, double>("S", 06.327));
            series.Add(new DataPoint<string, double>("T", 09.056));
            series.Add(new DataPoint<string, double>("U", 02.758));
            series.Add(new DataPoint<string, double>("V", 00.978));
            series.Add(new DataPoint<string, double>("W", 02.360));
            series.Add(new DataPoint<string, double>("X", 00.150));
            series.Add(new DataPoint<string, double>("Y", 01.974));
            series.Add(new DataPoint<string, double>("Z", 00.074));

            return series;
        }
    }
}
