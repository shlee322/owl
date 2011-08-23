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
using ZedGraph;

namespace Client_LSH
{
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();
            this.CPU.Child = new ZedGraphControl();
            this.NowCPU.Child = new ZedGraphControl();
            this.Memory.Child = new ZedGraphControl();
            this.NowMemory.Child = new ZedGraphControl();
            this.Network.Child = new ZedGraphControl();
            this.NowNetwork.Child = new ZedGraphControl();
            this.SendCount.Child = new ZedGraphControl();
            this.NowSendCount.Child = new ZedGraphControl();
            this.Thread.Child = new ZedGraphControl();
            this.NowThread.Child = new ZedGraphControl();
            this.View.Child = new ZedGraphControl();


            this.InitGraph((ZedGraphControl)this.CPU.Child, (ZedGraphControl)this.NowCPU.Child, "CPU");
            this.InitGraph((ZedGraphControl)this.Memory.Child, (ZedGraphControl)this.NowMemory.Child, "Memory");
            this.InitGraph((ZedGraphControl)this.Network.Child, (ZedGraphControl)this.NowNetwork.Child, "Network");
            this.InitGraph((ZedGraphControl)this.SendCount.Child, (ZedGraphControl)this.NowSendCount.Child, "SendCount");
            this.InitGraph((ZedGraphControl)this.Thread.Child, (ZedGraphControl)this.NowThread.Child, "Thread");

            ((ZedGraphControl)this.View.Child).GraphPane.Title.Text = "View";
            ((ZedGraphControl)this.View.Child).GraphPane.Title.FontSpec.Size = 36;
            ((ZedGraphControl)this.View.Child).GraphPane.XAxis.Title.Text = "Time";
            ((ZedGraphControl)this.View.Child).GraphPane.XAxis.Title.FontSpec.Size = 24;
            ((ZedGraphControl)this.View.Child).GraphPane.YAxis.Title.FontSpec.Size = 24;
        }

        private void InitGraph(ZedGraphControl zed1, ZedGraphControl zed2, string Title)
        {
            zed1.GraphPane.Title.Text = Title;
            zed1.GraphPane.Title.FontSpec.Size = 36;
            zed1.GraphPane.XAxis.Title.Text = "Time";
            zed1.GraphPane.XAxis.Title.FontSpec.Size = 24;
            zed1.GraphPane.YAxis.Title.FontSpec.Size = 24;

            zed2.GraphPane.Title.Text = "Now " + Title;
            zed2.GraphPane.Title.FontSpec.Size = 36;
            zed2.GraphPane.XAxis.Title.Text = "Sender";
            zed2.GraphPane.XAxis.Title.FontSpec.Size = 24;
            zed2.GraphPane.YAxis.Title.FontSpec.Size = 24;
        }
    }
}
