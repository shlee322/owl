using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Animation;
using System.Windows.Shapes;

namespace Visiblox.Charts.Examples.MultipleYAxes
{
    public partial class MultipleYAxesExample : UserControl
    {   
        private int totalData = 0;
        private bool checkDaily = false;
        private bool checkPercent = false;

        public MultipleYAxesExample()
        {
            InitializeComponent();

            //Generate daily sales data
            AxesChart.Series[0].DataSeries = generateData();
            
            //Generate cumulative % sales data
            (AxesChart.Series[1] as LineSeries).YAxis  = AxesChart.SecondaryYAxis;
            AxesChart.Series[1].DataSeries = generatePercent(AxesChart.Series[0] as LineSeries);            
        }

        private DataSeries<DateTime, double> generateData()
        {
            DataSeries<DateTime, double> data = new DataSeries<DateTime, double>() { Title = "Daily Sales" } ;
            DateTime currentDate = (DateTime)AxesChart.XAxis.Range.Minimum;
            DateTime maxDate = (DateTime)AxesChart.XAxis.Range.Maximum;
            DateTime midpointDate = new DateTime(2009, 12, 15);

            Random randomNumber = new Random();
            int number = randomNumber.Next(10, 20);

            while (currentDate <= maxDate)
            {

                data.Add(new DataPoint<DateTime,double>() { X = currentDate, Y = number}) ;
                totalData += number;

                //Change sales amount to give variation on chart
                if (currentDate < midpointDate)
                {
                    number = randomNumber.Next(10, 20);
                }
                else
                {
                    number = randomNumber.Next(30, 40);
                }

                currentDate = currentDate.AddDays(1);
            }

            return data;

        }

        private DataSeries<DateTime, double> generatePercent(LineSeries series)
        {
            DataSeries<DateTime, double> percentData = new DataSeries<DateTime, double>() { Title = "Total % Sales" };
            DataSeries<DateTime, double> dailyData = (DataSeries<DateTime, double>)series.DataSeries;

            double total = 0;

            //for each daily point, calculate its cumulative % of total sales
            for (int i = 0; i < dailyData.Count; i++)
            {
                DateTime date = dailyData.ElementAt(i).X;
                total += dailyData.ElementAt(i).Y;
                double percent = total / totalData * 100;

                //plot current date against cumulative total % of sales
                percentData.Add(new DataPoint<DateTime, double> { X = date, Y = percent });
                
            }

            return percentData;
        }

        private void dailyCheck_Checked(object sender, RoutedEventArgs e)
        {
            //only perform if chart has been created
            if (checkDaily)
            {
                LineSeries daily = (LineSeries)AxesChart.Series[0];

                //if already visible, hide series, else make it visible
                if (daily.Visibility == Visibility.Visible)
                {
                    daily.Visibility = Visibility.Collapsed;
                    (AxesChart.YAxis as LinearAxis).Visibility = Visibility.Collapsed;
                    SalesBlock.Fill = new SolidColorBrush(Colors.White);

                    //only allow one series to be hidden
                    cumulativeCheck.IsEnabled = false;
                }

                else
                {
                    daily.Visibility = Visibility.Visible;
                    (AxesChart.YAxis as LinearAxis).Visibility = Visibility.Visible;
                    SalesBlock.Fill = (AxesChart.Series[0] as LineSeries).PointFill;

                    cumulativeCheck.IsEnabled = true;
                }
            }

            checkDaily = true;
        }

        private void cumulativeCheck_Checked(object sender, RoutedEventArgs e)
        {
            //only perform is chart has been created
            if (checkPercent)
            {
                LineSeries percent = (LineSeries)AxesChart.Series[1];

                if (percent.Visibility == Visibility.Visible)
                {
                    percent.Visibility = Visibility.Collapsed;
                    (AxesChart.SecondaryYAxis as LinearAxis).Visibility = Visibility.Collapsed;
                    PercentBlock.Fill = new SolidColorBrush(Colors.White);

                    //only allow one series to be hidden
                    dailyCheck.IsEnabled = false;
                }

                else
                {
                    percent.Visibility = Visibility.Visible;
                    (AxesChart.SecondaryYAxis as LinearAxis).Visibility = Visibility.Visible;
                    PercentBlock.Fill = (AxesChart.Series[1] as LineSeries).PointFill;
                    dailyCheck.IsEnabled = true;
                }
            }

            checkPercent = true;

        }
    }
}