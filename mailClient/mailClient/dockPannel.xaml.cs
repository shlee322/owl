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
using System.Windows.Media.Animation;

namespace mailClient
{
    /// <summary>
    /// Interaction logic for dockPannel.xaml
    /// </summary>
    public partial class dockPannel : UserControl
    {
        public dockPannel()
        {
            InitializeComponent();
            this.HorizontalAlignment = HorizontalAlignment.Center;

            this.HorizontalAlignment = HorizontalAlignment.Center;
            this.Margin = new Thickness(0, 0, 0, -109);
            grid.MouseEnter += new MouseEventHandler(grid_MouseEnter);
            grid.MouseLeave += new MouseEventHandler(grid_MouseLeave);

            for (int i = 1; i < this.grid.Children.Count; i++)
            {
                this.grid.Children[i].MouseEnter += new MouseEventHandler(dockPannel_MouseEnter);
                this.grid.Children[i].MouseLeave += new MouseEventHandler(dockPannel_MouseLeave);
                this.grid.Children[i].MouseLeftButtonDown += new MouseButtonEventHandler(dockPannel_MouseLeftButtonDown);
            }
        }

        void grid_MouseLeave(object sender, MouseEventArgs e)
        {
            Storyboard str = new Storyboard();
            str = (Storyboard)grid.FindResource("moveDown");
            str.Begin();
        }
        void grid_MouseEnter(object sender, MouseEventArgs e)
        {
            Storyboard str = new Storyboard();
            str = (Storyboard)grid.FindResource("moveUp");
            str.Begin();
        }

        void dockPannel_MouseLeftButtonDown(object sender, MouseButtonEventArgs e)
        {
            Image im = (Image)sender;
            if (im.Name.Equals("sendMail"))
            {
                Storyboard str = new Storyboard();
                str = (Storyboard)grid.FindResource("dockDisappear");
                str.Completed += new EventHandler(str_Completed_to_sendPage);
                str.Begin();
            }
            else if(im.Name.Equals("graphBtn"))
            {
                Storyboard str = new Storyboard();
                str = (Storyboard)grid.FindResource("dockDisappear");
                str.Completed +=new EventHandler(str_Completed_to_statusPage);
                str.Begin();
            }
            else if(im.Name.Equals("settingBtn"))
            {
                Storyboard str = new Storyboard();
                str = (Storyboard)grid.FindResource("dockDisappear");
                str.Completed +=new EventHandler(str_Completed_to_settingPage);
                str.Begin();
            }
        }
        void str_Completed_to_settingPage(object sender, EventArgs e)
        {
            App.originWIndow.Content = new settingPage();
        }

        void str_Completed_to_sendPage(object sender, EventArgs e)
        {
            App.originWIndow.Content = new sendingPage();
        }

        void str_Completed_to_statusPage(object sender, EventArgs e)
        {
            App.originWIndow.Content = new statusPage();
        }



        void dockPannel_MouseLeave(object sender, MouseEventArgs e)
        {
            Image im = (Image)sender;
            im.Opacity = 1;
        }

        void dockPannel_MouseEnter(object sender, MouseEventArgs e)
        {
            Image im = (Image)sender;
            im.Opacity = 0.5;
        }
    }
}
