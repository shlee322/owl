using System;
using System.Windows.Controls;
using System.IO;
using System.Windows;
using System.Windows.Resources;
using System.Windows.Data;
using System.Globalization;

namespace Visiblox.Charts.Examples.LineChart
{
    public partial class LineChartExample : UserControl
    {
        public LineChartExample()
        {
            InitializeComponent();

            //Specify which files we want to read from 
            String[] fileNames = new String[] { "GBPtoUSD.cvs", "GBPtoEUR.cvs", "EURtoUSD.cvs" };

            //Specify the name of each dataSeries
            String[] legendNames = new String[] { "£ vs $", "£ vs €", "€ vs $" };

            //Read each file, create DataSeries then add to the chart
            for (int i = 0; i < fileNames.Length; i++)
            {
                //Create a data series with the appropriate name
                DataSeries<DateTime, float> dataForSeries = new DataSeries<DateTime, float>(legendNames[i]);

                StreamResourceInfo resourceStream = Application.GetResourceStream(new Uri("/Visiblox.Charts.Examples.Wpf.Free;component/LineChart/Data/" + fileNames[i], UriKind.Relative));
                StreamReader streamReader = new StreamReader(resourceStream.Stream);
                float rebaseValue = 0;

                while (streamReader.Peek() >= 0)
                {
                    string line = streamReader.ReadLine();
                    string[] parts = line.Split(',');

                    //the files are formatted like so: "DD/MM/YYYY,VALUE"
                    String[] dateParts = parts[0].Split('/');
                    DateTime time = new DateTime(int.Parse(dateParts[2]), int.Parse(dateParts[0]), int.Parse(dateParts[1]));
                    float rate = float.Parse(parts[1]);

                    //If it's the first data point, work out the rebase value
                    if (rebaseValue == 0)
                    {
                        rebaseValue = 100 / rate;
                    }

                    //rebase value to 0
                    rate = (rate * rebaseValue) - 100;

                    dataForSeries.Add(new DataPoint<DateTime, float>(time, rate));
                }

                //Create the LineSeries, then add to the chart
                LineSeries lineSeries = new LineSeries();
                lineSeries.DataSeries = dataForSeries;
                lineSeries.LineStrokeThickness = 1.5;
                chart.Series.Add(lineSeries);
            }
        }
   }
}