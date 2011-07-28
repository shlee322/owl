using System;
using System.Collections.Generic;
using System.Windows;
using System.Windows.Controls;
using Visiblox.Charts;

namespace Visiblox.Charts.Examples.StackedColumnChart
{
    public partial class StackedColumnChartExample : UserControl
    {
        public StackedColumnChartExample()
        {
            InitializeComponent();
            MainChart.YAxis.Range = new DoubleRangeWithEffectiveLimits(0, 35);
        }

        private void Stacked_Checked(object sender, RoutedEventArgs e)
        {
            if (MainChart == null) { return; }
            var series = MainChart.Series[0] as Visiblox.Charts.StackedColumnSeries;
            series.StackingMode = StackingMode.Normal;

            MainChart.YAxis.Title = "Votes (millions)";
            MainChart.YAxis.Range = new DoubleRangeWithEffectiveLimits(0, 35);
        }

        private void OneHundredStacked_Checked(object sender, RoutedEventArgs e)
        {
            if (MainChart == null) { return; }
            var series = MainChart.Series[0] as Visiblox.Charts.StackedColumnSeries;
            series.StackingMode = StackingMode.HundredPercent;

            MainChart.YAxis.Title = "Vote Share (%)";
            MainChart.YAxis.Range = new DoubleRangeWithEffectiveLimits(0, 100);
        }
    }

    public class PartyList : List<ElectionResult> { }

    public class ElectionResult
    {
        public String Year { get; set; }
        public double VotesMillions { get; set; }
    }
}
