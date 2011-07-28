using System;
using System.Collections.Generic;
using System.Windows;
using System.Windows.Controls;
using Visiblox.Charts;

namespace Visiblox.Charts.Examples.StackedAreaChart
{
    public partial class StackedAreaChartExample : UserControl
    {
        public StackedAreaChartExample()
        {
            InitializeComponent();
            MainChart.YAxis.Range = new DoubleRange(0, 60);
        }

        private void Stacked_Checked(object sender, RoutedEventArgs e)
        {
            if (MainChart == null) { return; }
            var series = MainChart.Series[0] as Visiblox.Charts.StackedLineSeries;
            series.StackingMode = StackingMode.Normal;

            MainChart.YAxis.Range = new DoubleRange(0, 60);
            MainChart.YAxis.Title = "Sales (millions)";
        }

        private void OneHundredStacked_Checked(object sender, RoutedEventArgs e)
        {
            if (MainChart == null) { return; }
            var series = MainChart.Series[0] as Visiblox.Charts.StackedLineSeries;
            series.StackingMode = StackingMode.HundredPercent;

            MainChart.YAxis.Range = new DoubleRange(0, 100);
            MainChart.YAxis.Title = "Sales (%)";
        }

        private void Line_Checked(object sender, RoutedEventArgs e)
        {
            if (MainChart == null || MainChart.Series.Count < 1)
                return;

            List<BindableDataSeries> series = GetDataSeries();

            var stackedSeries = MainChart.Series[0] as Visiblox.Charts.StackedLineSeries;
            stackedSeries.Series.Clear();

            foreach(BindableDataSeries ds in series) {
                stackedSeries.Series.Add(new LineSeries()
                { 
                    DataSeries = ds, 
                    SelectionMode=SelectionMode.Series,
                    ShowLine=true,
                    ShowArea=true
                });
            }
        }

        private void Spline_Checked(object sender, RoutedEventArgs e)
        {
            List<BindableDataSeries> series = GetDataSeries();

            var stackedSeries = MainChart.Series[0] as Visiblox.Charts.StackedLineSeries;
            stackedSeries.Series.Clear();

            foreach (BindableDataSeries ds in series)
            {
                stackedSeries.Series.Add(new SplineSeries()
                {
                    DataSeries = ds,
                    SelectionMode = SelectionMode.Series,
                    ShowLine = true,
                    ShowArea = true
                });
            }
        }

        private List<BindableDataSeries> GetDataSeries()
        {
            List<BindableDataSeries> dataSeries = new List<BindableDataSeries>();
            
            var stackedSeries = MainChart.Series[0] as Visiblox.Charts.StackedLineSeries;
            foreach (IChartSingleSeries singleSeries in stackedSeries.Series)
            {
                dataSeries.Add(singleSeries.DataSeries as BindableDataSeries);
            }

            return dataSeries;
        }
    }

    public class SalesList : List<Sale> { }

    public class Sale
    {
        public string Quarter { get; set; }
        public int Sales { get; set; }
    }
}
