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
using System.Windows.Controls.DataVisualization.Charting;

namespace mailClient
{
    /// <summary>
    /// Interaction logic for statusPage.xaml
    /// </summary>
    public partial class statusPage : Page
    {
        class TestData
        {
            public DateTime Time;
            public int data;
        }

        TestData[] Sender1;
        TestData[] Sender2;


        public statusPage()
        {
            InitializeComponent();
            statusGrid.Children.Add(new dockPannel());
            timeStatus.Opacity = 0;
            personStatus.Opacity = 0;
            groupStatus.Items.Add(App.UserId);
            groupStatus.SelectionChanged += new SelectionChangedEventHandler(groupStatus_SelectionChanged);
        }

        void groupStatus_SelectionChanged(object sender, SelectionChangedEventArgs e)
        {
            timeStatus.Opacity = 1;
            List<string> time = rpc.client.queryToControl(App.key, "read", "a@a@a@");
            foreach(String str in time)
            {
                timeStatus.Items.Add(str);
            }
        }





        private void graphGrid_Loaded(object sender, RoutedEventArgs e)
        {

        }
    }
}
