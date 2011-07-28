using System.Windows.Controls;
using System;
using Visiblox.Charts;
using System.Collections.Generic;

namespace Visiblox.Charts.Examples.CombinationChart
{
    /// <summary>
    /// An example to display a combined bar and line chart
    /// </summary>
    public partial class CombinationChartExample : UserControl
    {
        List<Return> data = new List<Return>();

        public CombinationChartExample()
        {
            InitializeComponent();

            //Create list of data
            data.Add(new Return() { Percent = 30, Reason = "Setup Issue" });
            data.Add(new Return() { Percent = 25, Reason = "Hard to Use" });
            data.Add(new Return() { Percent = 15, Reason = "Too Slow" });
            data.Add(new Return() { Percent = 15, Reason = "Too Heavy" });
            data.Add(new Return() { Percent = 10, Reason = "Wrong Manual" });
            data.Add(new Return() { Percent = 5, Reason = "No Cord" });

            //Add data to series
            AddToSeries();
        }

        public void AddToSeries()
        {
            DataSeries<string, double> barSeries = new DataSeries<string, double>();
            DataSeries<string, double> lineSeries = new DataSeries<string, double>();

            double runningTotal = 0;

            foreach (Return r in data)
            {
                //Add actual value to bar series, cumulative total to line series
                runningTotal += r.Percent;
                barSeries.Add(new DataPoint<string, double>() { X = r.Reason, Y = r.Percent });
                lineSeries.Add(new DataPoint<string, double>() { X = r.Reason, Y = runningTotal });

            }

            CombinationChart.Series[0].DataSeries = barSeries;
            CombinationChart.Series[1].DataSeries = lineSeries;
        }

    }

    /// <summary>
    /// Class representing a return
    /// </summary>
    public class Return
    {
        public double Percent { get; set; }

        public string Reason { get; set; }
    }
}
