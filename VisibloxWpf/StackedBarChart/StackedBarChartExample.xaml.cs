using System;
using System.Collections.Generic;
using System.Globalization;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Input;
using Visiblox.Charts;

namespace Visiblox.Charts.Examples.StackedBarChart
{
    public partial class StackedBarChartExample : UserControl
    {
        public StackedBarChartExample()
        {
            InitializeComponent();
            SetUp();
        }

        private void SetUp()
        {
            var series = MainChart.Series[0] as IChartMultipleSeries;

            foreach (BarSeries b in series.Series)
            {
                b.HighlightedStyle = b.SelectedStyle;
                b.MouseEnter += new MouseEventHandler(b_MouseEnter);
                b.MouseLeave += new MouseEventHandler(b_MouseLeave);
            }
        }

        //Mouse enters series, change to hand cursor
        void b_MouseEnter(object sender, System.Windows.Input.MouseEventArgs e)
        {
            this.Cursor = Cursors.Hand;
        }

        //Mouse leaves series, change back to arrow cursor
        void b_MouseLeave(object sender, MouseEventArgs e)
        {
            this.Cursor = Cursors.Arrow;
        }

        private void Stacked_Checked(object sender, RoutedEventArgs e)
        {
            if (MainChart == null) { return; }
            var series = MainChart.Series[0] as Visiblox.Charts.StackedBarSeries;
            series.StackingMode = StackingMode.Normal;

            MainChart.XAxis.Title = "Dwellings built (thousands)";
        }

        private void OneHundredStacked_Checked(object sender, RoutedEventArgs e)
        {
            if (MainChart == null) { return; }
            var series = MainChart.Series[0] as Visiblox.Charts.StackedBarSeries;
            series.StackingMode = StackingMode.HundredPercent;

            MainChart.XAxis.Title = "Dwellings built (%)";
        }
    }

    public class HousingStockNumberList : List<HousingStockNumber> { }

    public class HousingStockNumber
    {
        public String Period { get; set; }
        public double ThousandsOfDwellings { get; set; }
    }
}
