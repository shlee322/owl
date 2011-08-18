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

namespace testWindow
{
    /// <summary>
    /// Interaction logic for second.xaml
    /// </summary>
    public partial class second : Page
    {

        public second()
        {
            InitializeComponent();

            Storyboard story = (Storyboard)FindResource("logInDone");
            story.Begin();
        }

        private void mail_MouseEnter(object sender, MouseEventArgs e)
        {
            Storyboard story = (Storyboard)FindResource("clearMail");
            story.Begin();
        }

        private void mail_MouseLeave(object sender, MouseEventArgs e)
        {
            Storyboard story = (Storyboard)FindResource("clearMail");
            story.Remove();
        }

        private void chart_MouseEnter(object sender, MouseEventArgs e)
        {

            Storyboard story = (Storyboard)FindResource("clearChart");
            story.Begin();
        }

        private void chart_MouseLeave(object sender, MouseEventArgs e)
        {

            Storyboard story = (Storyboard)FindResource("clearChart");
            story.Remove();
        }

        private void page_Loaded(object sender, RoutedEventArgs e)
        {

        }

    }
}
