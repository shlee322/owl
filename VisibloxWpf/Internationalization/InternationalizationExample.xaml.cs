using System.Windows.Controls;
using System;
using System.Globalization;
using System.Threading;
using System.Windows;
using System.IO;
using System.Windows.Resources;
using Visiblox.Charts;

namespace Visiblox.Charts.Examples.Internationalization
{
    public partial class InternationalizationExample : UserControl
    {
        public InternationalizationExample()
        {
            InitializeComponent();

            // Define data series
            var dataSeries = GetDataSeries();
            var lineSeries = new LineSeries() { DataSeries = dataSeries };
            lineSeries.LineStrokeThickness = 1.5;
            Chart.Series.Add(lineSeries);

            // Define cultures to use on chart
            Culture[] cultures = new Culture[]{
                  new Culture{Description = "British English", Name = "en-GB", YAxisLabel = "Price", ChartTitle = "Exchange Rate (GBP/JPY)" },
                  new Culture{Description = "Czech", Name = "cs-CZ", YAxisLabel = "Cena", ChartTitle = "Kurz (GBP/JPY)" },
                  new Culture{Description = "Hungarian", Name = "hu-HU", YAxisLabel = "Ár", ChartTitle = "Árfolyam (GBP/JPY)" },
                  new Culture{Description = "French", Name = "fr-FR", YAxisLabel = "Prix", ChartTitle = "Taux de change (GBP/JPY)" },
                  new Culture{Description = "Russian", Name = "ru-RU", YAxisLabel = "Цена", ChartTitle = "Обмен валюты (GBP/JPY)" }
                
            };

            // Add each culture to combo box
            foreach (Culture culture in cultures)
            {
                CultureInfoComboBox.Items.Add(new ComboBoxItem() { Content = culture.Description, Tag = culture });
            }
            // Set English as default
            CultureInfoComboBox.SelectedIndex = 0;
        }

        public static DataSeries<DateTime, double> GetDataSeries()
        {
            DataSeries<DateTime, double> dataSeries = new DataSeries<DateTime, double>();

            //open stream of data file
            StreamResourceInfo resourceStream = Application.GetResourceStream(new Uri("/Visiblox.Charts.Examples.Wpf.Free;component/Internationalization/Data/gbpjpy.csv", UriKind.Relative));
            using (StreamReader streamReader = new StreamReader(resourceStream.Stream))
            {
                // Read through the csv file and fill up dataSeries with the data
                {
                    streamReader.ReadLine();
                    while (streamReader.Peek() >= 0)
                    {
                        string line = streamReader.ReadLine();
                        string[] values = line.Split(',');

                        String[] dateParts = values[0].Split('/');
                        DateTime date = new DateTime(int.Parse(dateParts[2]), int.Parse(dateParts[0]), int.Parse(dateParts[1]));
                        double price = double.Parse(values[1]);

                        dataSeries.Add(new DataPoint<DateTime, double>(date, price));
                    }
                }
            }

            return dataSeries;
        }

        // Handle ComboBox changing cultures
        private void CultureInfoComboBox_SelectionChanged(object sender, SelectionChangedEventArgs e)
        {
            Culture selectedCulture = (Culture)((ComboBoxItem)CultureInfoComboBox.SelectedItem).Tag;
            DateTimeAxis xaxis = (DateTimeAxis)Chart.XAxis;
            try
            {
                ((LinearAxis)Chart.YAxis).Title = selectedCulture.YAxisLabel;
                ((DateTimeAxis)Chart.XAxis).Title = selectedCulture.XAxisLabel;
                Chart.Title = selectedCulture.ChartTitle;
                xaxis.LabelFormatString = selectedCulture.LongDatePattern;
                ErrorMessagePanel.Visibility = Visibility.Collapsed;
                Thread.CurrentThread.CurrentCulture = new CultureInfo(selectedCulture.Name);
                Chart.Invalidate();
            }
            catch (ArgumentException)
            {
                ErrorMessagePanel.Visibility = Visibility.Visible;
            }
        }

        // Class to store cultures to use on chart
        private class Culture
        {
            public string Name { get; set; }
            public string Description { get; set; }
            public string YAxisLabel { get; set; }
            public string XAxisLabel { get; set; }
            public string ChartTitle { get; set; }
            public string LongDatePattern
            {
                get
                {
                    return new CultureInfo(Name).DateTimeFormat.LongDatePattern;
                }
            }
        }
    }
}