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

        public LineGraph create()
        {
            
           // LineGraph chart = plotter.AddLineGraph();
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
            
        }
    }
}
