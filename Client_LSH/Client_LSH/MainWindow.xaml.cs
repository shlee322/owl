﻿using System;
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
        System.Threading.Thread RunThread;
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

            this.InitGraph((ZedGraphControl)this.CPU.Child, (ZedGraphControl)this.NowCPU.Child, "CPU");
            this.InitGraph((ZedGraphControl)this.Memory.Child, (ZedGraphControl)this.NowMemory.Child, "Memory");
            this.InitGraph((ZedGraphControl)this.Network.Child, (ZedGraphControl)this.NowNetwork.Child, "Network");
            this.InitGraph((ZedGraphControl)this.SendCount.Child, (ZedGraphControl)this.NowSendCount.Child, "SendCount");
            this.InitGraph((ZedGraphControl)this.Thread.Child, (ZedGraphControl)this.NowThread.Child, "Thread");

            this.Init();
            this.RunThread = new System.Threading.Thread(this.Run);
            this.RunThread.Start();
        }

        public void Init()
        {
            List<string> SenderList = new List<string>();
            SenderList.Add("Sender1");
            SenderList.Add("Sender2");

            Random r = new Random();

            string[] SenderArray = SenderList.ToArray();

            ((ZedGraphControl)this.NowCPU.Child).GraphPane.AddBar("", new PointPairList(), System.Drawing.Color.White);
            ((ZedGraphControl)this.NowMemory.Child).GraphPane.AddBar("", new PointPairList(), System.Drawing.Color.White);
            ((ZedGraphControl)this.NowNetwork.Child).GraphPane.AddBar("", new PointPairList(), System.Drawing.Color.White);
            ((ZedGraphControl)this.NowSendCount.Child).GraphPane.AddBar("", new PointPairList(), System.Drawing.Color.White);
            ((ZedGraphControl)this.NowThread.Child).GraphPane.AddBar("", new PointPairList(), System.Drawing.Color.White);

            for(int i = 0; i<SenderArray.Length; i++)
            {
                string name = SenderArray[i];

                System.Drawing.Color c = System.Drawing.Color.FromArgb(r.Next(0, 255), r.Next(0, 255), r.Next(0, 255));
                ((ZedGraphControl)this.CPU.Child).GraphPane.AddCurve(name, new PointPairList(), c);
                ((ZedGraphControl)this.Memory.Child).GraphPane.AddCurve(name, new PointPairList(), c);
                ((ZedGraphControl)this.Network.Child).GraphPane.AddCurve(name, new PointPairList(), c);
                ((ZedGraphControl)this.SendCount.Child).GraphPane.AddCurve(name, new PointPairList(), c);
                ((ZedGraphControl)this.Thread.Child).GraphPane.AddCurve(name, new PointPairList(), c);

                ((ZedGraphControl)this.NowCPU.Child).GraphPane.CurveList[0].AddPoint(i, r.Next(0, 100));
                ((ZedGraphControl)this.NowMemory.Child).GraphPane.CurveList[0].AddPoint(i, r.Next(0, 100));
                ((ZedGraphControl)this.NowNetwork.Child).GraphPane.CurveList[0].AddPoint(i, r.Next(0, 100));
                ((ZedGraphControl)this.NowSendCount.Child).GraphPane.CurveList[0].AddPoint(i, r.Next(0, 100));
                ((ZedGraphControl)this.NowThread.Child).GraphPane.CurveList[0].AddPoint(i, r.Next(0, 100));

                

                //((ZedGraphControl)this.NowThread.Child).GraphPane.CurveList[0].

                //((ZedGraphControl)this.NowCPU.Child).GraphPane.CurveList[0].Points[i].ColorValue = 1111111111111111;
            }

            //((ZedGraphControl)this.View.Child).GraphPane.

            ((ZedGraphControl)this.NowCPU.Child).GraphPane.XAxis.Scale.TextLabels = SenderArray;
            ((ZedGraphControl)this.NowMemory.Child).GraphPane.XAxis.Scale.TextLabels = SenderArray;
            ((ZedGraphControl)this.NowNetwork.Child).GraphPane.XAxis.Scale.TextLabels = SenderArray;
            ((ZedGraphControl)this.NowSendCount.Child).GraphPane.XAxis.Scale.TextLabels = SenderArray;
            ((ZedGraphControl)this.NowThread.Child).GraphPane.XAxis.Scale.TextLabels = SenderArray;



        }

        private void InitGraph(ZedGraphControl zed1, ZedGraphControl zed2, string Title)
        {
            zed1.GraphPane.Title.Text = Title;
            zed1.GraphPane.Title.FontSpec.Size = 36;
            zed1.GraphPane.XAxis.Title.Text = "Time";
            zed1.GraphPane.XAxis.Title.FontSpec.Size = 24;
            zed1.GraphPane.YAxis.Title.FontSpec.Size = 24;
            zed1.GraphPane.XAxis.Type = AxisType.Date;

            zed2.GraphPane.Title.Text = "Now " + Title;
            zed2.GraphPane.Title.FontSpec.Size = 36;
            zed2.GraphPane.XAxis.Title.Text = "Sender";
            zed2.GraphPane.XAxis.Title.FontSpec.Size = 24;
            zed2.GraphPane.YAxis.Title.Text = "";
            zed2.GraphPane.YAxis.Title.FontSpec.Size = 24;
            zed2.GraphPane.XAxis.Type = AxisType.Text;
        }


        private void Run()
        {
            Random r = new Random();
            while (true)
            {
                System.Threading.Thread.Sleep(500);
                double time = new XDate(DateTime.Now);

                for (int i = 0; i < ((ZedGraphControl)this.CPU.Child).GraphPane.CurveList.Count; i++)
                {
                    ((ZedGraphControl)this.CPU.Child).GraphPane.CurveList[i].AddPoint(time, r.Next(0, 100));
                    ((ZedGraphControl)this.Memory.Child).GraphPane.CurveList[i].AddPoint(time, r.Next(0, 100));
                    ((ZedGraphControl)this.Network.Child).GraphPane.CurveList[i].AddPoint(time, r.Next(0, 100));
                    ((ZedGraphControl)this.SendCount.Child).GraphPane.CurveList[i].AddPoint(time, r.Next(0, 100));
                    ((ZedGraphControl)this.Thread.Child).GraphPane.CurveList[i].AddPoint(time, r.Next(0, 100));

                    ((ZedGraphControl)this.NowCPU.Child).GraphPane.CurveList[0].Points[i].Y = r.Next(0, 100);
                    ((ZedGraphControl)this.NowMemory.Child).GraphPane.CurveList[0].Points[i].Y = r.Next(0, 100);
                    ((ZedGraphControl)this.NowNetwork.Child).GraphPane.CurveList[0].Points[i].Y = r.Next(0, 100);
                    ((ZedGraphControl)this.NowSendCount.Child).GraphPane.CurveList[0].Points[i].Y = r.Next(0, 100);
                    ((ZedGraphControl)this.NowThread.Child).GraphPane.CurveList[0].Points[i].Y = r.Next(0, 100);
                }

                ((ZedGraphControl)this.CPU.Child).AxisChange();
                ((ZedGraphControl)this.Memory.Child).AxisChange();
                ((ZedGraphControl)this.Network.Child).GraphPane.AxisChange();
                ((ZedGraphControl)this.SendCount.Child).GraphPane.AxisChange();
                ((ZedGraphControl)this.Thread.Child).GraphPane.AxisChange();

                ((ZedGraphControl)this.NowCPU.Child).AxisChange();
                ((ZedGraphControl)this.NowMemory.Child).AxisChange();
                ((ZedGraphControl)this.NowNetwork.Child).GraphPane.AxisChange();
                ((ZedGraphControl)this.NowSendCount.Child).GraphPane.AxisChange();
                ((ZedGraphControl)this.NowThread.Child).GraphPane.AxisChange();

                Dispatcher.Invoke(System.Windows.Threading.DispatcherPriority.Normal, new Action(delegate
                {
                    this.CPU.Child.Refresh();
                    this.Memory.Child.Refresh();
                    this.Network.Child.Refresh();
                    this.SendCount.Child.Refresh();
                    this.Thread.Child.Refresh();

                    this.NowCPU.Child.Refresh();
                    this.NowMemory.Child.Refresh();
                    this.NowNetwork.Child.Refresh();
                    this.NowSendCount.Child.Refresh();
                    this.NowThread.Child.Refresh();
                }));
            }
        }
    }
}
