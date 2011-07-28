using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;

using Visiblox.Charts.Examples.AdditionalInformation;
using Visiblox.Charts.Examples.AreaChart;
using Visiblox.Charts.Examples.BackgroundImage;
using Visiblox.Charts.Examples.BandChart;
using Visiblox.Charts.Examples.BarChart;
using Visiblox.Charts.Examples.ColumnChart;
using Visiblox.Charts.Examples.CombinationChart;
using Visiblox.Charts.Examples.FastStreamingChart;
using Visiblox.Charts.Examples.LargeDataSets;
using Visiblox.Charts.Examples.LineChart;
using Visiblox.Charts.Examples.LineStyleChanging;
using Visiblox.Charts.Examples.PaletteChanging;
using Visiblox.Charts.Examples.PieChart;
using Visiblox.Charts.Examples.ScatterChart;
using Visiblox.Charts.Examples.Internationalization;
using Visiblox.Charts.Examples.StackedBarChart;
using Visiblox.Charts.Examples.StackedColumnChart;
using Visiblox.Charts.Examples.StackedAreaChart;
using Visiblox.Charts.Examples.StaircaseChart;
using Visiblox.Charts.Examples.TermStructure;
using Visiblox.Charts.Examples.MultipleYAxes;
using System.Threading;
using System.Globalization;


namespace Visiblox.Charts.Examples
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();
            PlotAreaContainer.Height = 350;
            PlotAreaContainer.Width = 600;
            InitalizeTestSelectDropdown();
        }
        // Add newly added usercontrols in this list
        private void InitalizeTestSelectDropdown()
        {
            TestSelect.Items.Add(new ComboBoxItem() { Content = new TextBlock() { Text = "Basic Charting", FontWeight = FontWeights.Bold } });
            TestSelect.Items.Add(new ComboBoxItem() { Content = "Line Chart", Tag = typeof(LineChartExample) });
            TestSelect.Items.Add(new ComboBoxItem() { Content = "Bar Chart", Tag = typeof(BarChartExample) });
            TestSelect.Items.Add(new ComboBoxItem() { Content = "Stacked Bar Chart", Tag = typeof(StackedBarChartExample) });
            TestSelect.Items.Add(new ComboBoxItem() { Content = "Column Chart", Tag = typeof(ColumnChartExample) });
            TestSelect.Items.Add(new ComboBoxItem() { Content = "Stacked Column Chart", Tag = typeof(StackedColumnChartExample) });
            TestSelect.Items.Add(new ComboBoxItem() { Content = "Combination", Tag = typeof(CombinationChartExample) });
            TestSelect.Items.Add(new ComboBoxItem() { Content = "Area Chart", Tag = typeof(AreaChartExample) });
            TestSelect.Items.Add(new ComboBoxItem() { Content = "Stacked Area Chart", Tag = typeof(StackedAreaChartExample) });
            TestSelect.Items.Add(new ComboBoxItem() { Content = "Band Chart", Tag = typeof(BandChartExample) });
            TestSelect.Items.Add(new ComboBoxItem() { Content = "Staircase Chart", Tag = typeof(StaircaseChartExample) });
            TestSelect.Items.Add(new ComboBoxItem() { Content = "Pie Chart", Tag = typeof(PieChartExample) });
            TestSelect.Items.Add(new ComboBoxItem() { Content = "Scatter Chart", Tag = typeof(ScatterChartExample) });

            TestSelect.Items.Add(new ComboBoxItem() { Content = new TextBlock() { Text = "High Performance / Real Time", FontWeight = FontWeights.Bold } });
            TestSelect.Items.Add(new ComboBoxItem() { Content = "Fast Streaming", Tag = typeof(FastStreamingChartExample) });
            TestSelect.Items.Add(new ComboBoxItem() { Content = "Large Data Sets", Tag = typeof(LargeDataSetsExample) });
            TestSelect.Items.Add(new ComboBoxItem() { Content = "Additional Information", Tag = typeof(AdditionalInformationExample) });

            TestSelect.Items.Add(new ComboBoxItem() { Content = new TextBlock() { Text = "Financial", FontWeight = FontWeights.Bold } });
            TestSelect.Items.Add(new ComboBoxItem() { Content = "Term Structure", Tag = typeof(TermStructureExample) });

            TestSelect.Items.Add(new ComboBoxItem() { Content = new TextBlock() { Text = "Presentational", FontWeight = FontWeights.Bold } });
            TestSelect.Items.Add(new ComboBoxItem() { Content = "Multiple Y Axes", Tag = typeof(MultipleYAxesExample) });
            TestSelect.Items.Add(new ComboBoxItem() { Content = "Background Image", Tag = typeof(BackgroundImageExample) });
            TestSelect.Items.Add(new ComboBoxItem() { Content = "Palettes", Tag = typeof(PaletteChangingExample) });
            TestSelect.Items.Add(new ComboBoxItem() { Content = "Changing Styles", Tag = typeof(ChangingStylesExample) });
            TestSelect.Items.Add(new ComboBoxItem() { Content = "Internationalization", Tag = typeof(InternationalizationExample) });
        }

        /// <summary>
        /// Called when only a given example is to be created
        /// </summary>
        /// <param name="exampleName"></param>
        public void InitalizeExample(string exampleName)
        {
            DropDownContainer.Visibility = Visibility.Collapsed;
            TestSelect.Height = 0;
            PlotAreaContainer.Margin = new Thickness(0, 0, 0, 0);
            PlotAreaContainer.Padding = new Thickness(0, 0, 0, 0);
            PlotAreaContainer.VerticalAlignment = VerticalAlignment.Top;
            PlotAreaContainer.HorizontalAlignment = HorizontalAlignment.Left;
            foreach (ComboBoxItem item in TestSelect.Items)
            {
                if (exampleName.Equals(item.Content))
                {
                    TestSelect.SelectedItem = item;
                    break;
                }
            }
        }

        private void AddTestSelectorTitle(string title)
        {
            ComboBoxItem item = new ComboBoxItem();
            item.Content = title;
            item.Tag = null;
            item.Background = new SolidColorBrush(Colors.LightGray);
            TestSelect.Items.Add(item);
        }

        private void TestSelect_SelectionChanged(object sender, SelectionChangedEventArgs e)
        {
            if (GetSelectedChartType() != null)
            {
                UserControl testChart = System.Activator.CreateInstance(GetSelectedChartType()) as UserControl;
                if (testChart == null)
                    return;

                testChart.Width = PlotArea.Width;
                testChart.Height = PlotArea.Height;

                if (PlotArea.Children.Count > 0)
                {
                    UIElement lcElement = PlotArea.Children[0] as UIElement;
                    PlotArea.Children.Clear();

                    lcElement = null;
                }

                PlotArea.Children.Add(testChart);
            }
        }

        private Type GetSelectedChartType()
        {
            //set culture to GB in case I18n example has changed it
            Thread.CurrentThread.CurrentCulture = new CultureInfo("en-GB");

            Type selectedItem = ((ComboBoxItem)TestSelect.SelectedItem).Tag as Type;


            PlotAreaContainer.Height = 350;
            PlotAreaContainer.Width = 600;

            if (selectedItem == null)
            {
                if (TestSelect.SelectedIndex < TestSelect.Items.Count)
                {
                    TestSelect.SelectedIndex += 1;
                    return GetSelectedChartType();
                }
                else
                {
                    return null; // Reached end
                }
            }
            else
            {
                return selectedItem;
            }
        }
    }
}
