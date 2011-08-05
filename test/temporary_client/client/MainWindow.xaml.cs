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
using Microsoft.Research.DynamicDataDisplay;
using Microsoft.Research.DynamicDataDisplay.DataSources;
using Thrift;
using Thrift.Collections;
using Thrift.Protocol;
using Thrift.Server;
using Thrift.Transport;
using contorlApi;
using PerfCounterChart;

namespace client
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        
        public MainWindow()
        {
            InitializeComponent();

        }
        public static byte[] strToBytes(string str)
        {
            System.Text.UTF8Encoding encoding = new System.Text.UTF8Encoding();
            return encoding.GetBytes(str);
        }

        private LineGraph CreatePerformanceGraph(string categoryName, string counterName)
        {
            PerformanceData data = new PerformanceData(categoryName, counterName);

            var filteredData = new FilteringDataSource<PerformanceInfo>(data, new MaxSizeFilter());

            var ds = new EnumerableDataSource<PerformanceInfo>(filteredData);
            ds.SetXMapping(pi => pi.Time.TimeOfDay.TotalSeconds);
            ds.SetYMapping(pi => pi.Value);

            LineGraph chart = plotter.AddLineGraph(ds, 2.0, String.Format("{0} - {1}", categoryName, counterName));
            return chart;
        }

        private void button1_Click(object sender, RoutedEventArgs e)
        {
            int timeout = 10 * 1000;

            TSocket socket = new TSocket("127.0.0.1", 9099);
            socket.Timeout = timeout;

            TTransport transport = new TFramedTransport(socket);
            TProtocol protocol = new TBinaryProtocol(transport);
            controlApi.Client client1 = new controlApi.Client(protocol);

            transport.Open();


            var mailset = new mailSet();
            mailset.SenderAddress = "toori67@gmail.com";
            mailset.Template = "<p>awdasc<p>";
            mailset.WhenToSend = "2011.08.12";
            mailset.AddressBook = strToBytes("this may be addressbook");


            client1.sendMailSet(mailset);

            textBox.Text = client1.getStatic("2011.08.12");
            
        }

        private void Window_Loaded(object sender, RoutedEventArgs e)
        {

            LineGraph chart = CreatePerformanceGraph("Memory", "Available MBytes");
            chart.DataChanged += new EventHandler(chart_DataChanged);
        }

        void chart_DataChanged(object sender, EventArgs e)
        {
            LineGraph graph = (LineGraph)sender;

            double mbytes = graph.DataSource.GetPoints().LastOrDefault().Y;

            graph.Description = new PenDescription(String.Format("Memory - available {0} MBytes", mbytes));
        }
    }
}
