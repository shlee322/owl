using System;
using System.Collections.Generic;
using System.Globalization;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Xml.Linq;

namespace Visiblox.Charts.Examples.TermStructure
{
    public partial class TermStructureExample : UserControl
    {
        public TermStructureExample()
        {
            InitializeComponent();
            
            //Create the data series from the points
            LineSeries visibleSeries = (LineSeries)TermStructureChart.Series[0];
            BindableDataSeries bindableDataSeries = new BindableDataSeries();
            bindableDataSeries.XValueBinding = new Binding("X");
            bindableDataSeries.YValueBinding = new Binding("Y");
            bindableDataSeries.ItemsSource = CreateYieldCurvePoints();
            visibleSeries.DataSeries = bindableDataSeries;

            //we only want the trackball on the points
            BehaviourManager bm = TermStructureChart.Behaviour as BehaviourManager;
            (bm.Behaviours[1] as TrackballBehaviour).Series.Add(TermStructureChart.Series[0]);

            //set up the "best fit" line series
            LineSeries bestFitVisibleSeries = (LineSeries)TermStructureChart.Series[1];
            bestFitVisibleSeries.DataSeries = CreateBestFitDataSeries();
        }

        private static List<YieldPoint> CreateYieldCurvePoints()
        {
            List<YieldPoint> points = new List<YieldPoint>();
            XDocument doc = XDocument.Load("TermStructure/Data/Yield.xml");
            IEnumerable<XElement> dataPoints = doc.Descendants("val");
            foreach (XElement dataPoint in dataPoints)
            {
                var xValue = Double.Parse(dataPoint.Attribute("x").Value);
                var yValue = Double.Parse(dataPoint.Attribute("y").Value);
                var instrumentName = dataPoint.Attribute("label").Value;
                points.Add(new YieldPoint(xValue, yValue, instrumentName));
            }
            return points;
        }

        public class YieldPoint
        {
            public YieldPoint(double xValue, double yValue, string instrumentName)
            {
                this.X = xValue;
                this.Y  = yValue;
                this.InstrumentName = instrumentName;
            }

            public double X { get; private set; }
            public double Y { get; private set; }
            public string InstrumentName { get; private set; }
        }

        public static DataSeries<double, double> CreateBestFitDataSeries()
        {
            DataSeries<double, double> curve = new DataSeries<double, double>();
            curve.Title = "Best Fit";
            curve.Add(new DataPoint<double, double>(00.00, 0.00));
            curve.Add(new DataPoint<double, double>(01.25, 0.50));
            curve.Add(new DataPoint<double, double>(02.50, 1.16));
            curve.Add(new DataPoint<double, double>(03.75, 1.80));
            curve.Add(new DataPoint<double, double>(05.00, 2.30));
            curve.Add(new DataPoint<double, double>(06.25, 2.78));
            curve.Add(new DataPoint<double, double>(07.50, 3.05));
            curve.Add(new DataPoint<double, double>(08.75, 3.35));
            curve.Add(new DataPoint<double, double>(10.00, 3.58));
            curve.Add(new DataPoint<double, double>(11.25, 3.73));
            curve.Add(new DataPoint<double, double>(12.50, 3.88));
            curve.Add(new DataPoint<double, double>(13.75, 3.95));
            curve.Add(new DataPoint<double, double>(15.00, 4.02));
            curve.Add(new DataPoint<double, double>(16.25, 4.07));
            curve.Add(new DataPoint<double, double>(17.50, 4.13));
            curve.Add(new DataPoint<double, double>(18.75, 4.20));
            curve.Add(new DataPoint<double, double>(20.00, 4.25));
            curve.Add(new DataPoint<double, double>(21.25, 4.27));
            curve.Add(new DataPoint<double, double>(22.50, 4.29));
            curve.Add(new DataPoint<double, double>(24.75, 4.30));
            curve.Add(new DataPoint<double, double>(26.00, 4.31));
            curve.Add(new DataPoint<double, double>(27.25, 4.32));
            curve.Add(new DataPoint<double, double>(28.50, 4.33));
            curve.Add(new DataPoint<double, double>(30.75, 4.34));
            return curve;
        }
    }
}
