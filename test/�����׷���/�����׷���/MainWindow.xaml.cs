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

namespace 상혁그래프
{
    /// <summary>
    /// MainWindow.xaml에 대한 상호 작용 논리
    /// </summary>
    public partial class MainWindow : Window
    {
        class TestData
        {
            public DateTime Time;
            public int data;
        }

        TestData[] Sender1;
        TestData[] Sender2;


        public MainWindow()
        {
            InitializeComponent();

            Sender1 = new TestData[50];
            for (int i = 0; i < 50; i++)
            {
                Sender1[i] = new TestData();
                Sender1[i].Time = DateTime.Now.AddMilliseconds(-500 * i);
                Sender1[i].data = 0;
            }

            Sender2 = new TestData[50];
            for (int i = 0; i < 50; i++)
            {
                Sender2[i] = new TestData();
                Sender2[i].Time = DateTime.Now.AddMilliseconds(-500 * i);
                Sender2[i].data = 0;
            }


            KeyValuePair<DateTime, int>[] t = new KeyValuePair<DateTime, int>[50];
            for (int i = 0; i < 50; i++)
                t[i] = new KeyValuePair<DateTime, int>(Sender1[i].Time, Sender1[i].data);
            ((LineSeries)this.Test.Series[0]).ItemsSource = t;

            KeyValuePair<DateTime, int>[] t2 = new KeyValuePair<DateTime, int>[50];
            for (int i = 0; i < 50; i++)
                t2[i] = new KeyValuePair<DateTime, int>(Sender2[i].Time, Sender2[i].data);
            ((LineSeries)this.Test.Series[1]).ItemsSource = t2;
            

            new System.Threading.Thread(this.TestTh).Start();
        }

        void TestTh()
        {
            Random R = new Random();

            while (true)
            {
                System.Threading.Thread.Sleep(500);
                R = new Random();

                for (int i = 0; i < 49; i++)
                    this.Sender1[i] = this.Sender1[i + 1];
                this.Sender1[49] = new TestData();
                this.Sender1[49].Time = DateTime.Now;
                this.Sender1[49].data = R.Next(0, 200);

                for (int i = 0; i < 49; i++)
                    this.Sender2[i] = this.Sender2[i + 1];
                this.Sender2[49] = new TestData();
                this.Sender2[49].Time = DateTime.Now;
                this.Sender2[49].data = R.Next(0, 200);

                Dispatcher.Invoke(System.Windows.Threading.DispatcherPriority.Normal, new Action(delegate
                {
                    KeyValuePair<DateTime, int>[] t = new KeyValuePair<DateTime, int>[50];
                    for (int i = 0; i < 50; i++)
                        t[i] = new KeyValuePair<DateTime, int>(Sender1[i].Time, Sender1[i].data);
                    ((LineSeries)this.Test.Series[0]).ItemsSource = t;

                    KeyValuePair<DateTime, int>[] t2 = new KeyValuePair<DateTime, int>[50];
                    for (int i = 0; i < 50; i++)
                        t2[i] = new KeyValuePair<DateTime, int>(Sender2[i].Time, Sender2[i].data);
                    ((LineSeries)this.Test.Series[1]).ItemsSource = t2;
                }));
            }
            
        }
    }
}
