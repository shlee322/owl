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
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();
        }

        private void Button_Click(object sender, RoutedEventArgs e)
        {
            App.id = textId.Text;
            App.passwd = textPasswd.Password;
            App.originWindow = mainWindow;
            //로그인이 참이면//
            //if loged in//
            App.isLogined = true;



            if (App.isLogined)
            {
                Storyboard story = (Storyboard)FindResource("logIn");
                story.Completed += new EventHandler(story_Completed);
                story.Begin();
            }
        }

        void story_Completed(object sender, EventArgs e)
        {
            mainWindow.Content = new second();
        }

    }
}
