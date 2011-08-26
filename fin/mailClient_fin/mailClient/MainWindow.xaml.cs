using System;
using System.Collections.Generic;
using System.Text;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Shapes;
using System.Windows.Media.Animation;
using System.IO;
namespace mailClient
{
	/// <summary>
	/// Interaction logic for MainWindow.xaml
	/// </summary>
	public partial class MainWindow : Window
	{
		public MainWindow()
		{
			this.InitializeComponent();


            rpc.startRpc();
        }

        public static byte[] strToBytes(string str)
        {
            System.Text.UTF8Encoding encoding = new System.Text.UTF8Encoding();
            return encoding.GetBytes(str);
        }

        private void makeKey(string id, string passwd)
        {
            //암호화 추가//
            string key = "";
            byte[] temp = strToBytes(id + passwd);
            for (int i = 0; i < temp.Length; i++)
            {
                key += temp[i];
            }
            App.key = id + "@" + passwd;
        }

        private void clickBtn_MouseEnter(object sender, MouseEventArgs e)
        {
            Border btn = (Border)sender;
            btn.Opacity = 1;
        }

        private void clickBtn_MouseLeave(object sender, MouseEventArgs e)
        {
            Border btn = (Border)sender;
            btn.Opacity = 0.6;
        }

        private void clickBtn_MouseLeftButtonDown(object sender, MouseButtonEventArgs e)
        {
            App.UserId = idBox.Text;
            App.Passwd = pwBox.Password;

            makeKey(App.UserId, App.Passwd);

            if (rpc.client.logIn(App.key))
            {
                App.originWIndow = this.Window;

                Storyboard str = (Storyboard)FindResource("nextPage");
                str.Completed += new EventHandler(str_Completed);
                str.Begin();
            }
            else
                MessageBox.Show("로그인 에러\nLogin Fail");



        }

        void str_Completed(object sender, EventArgs e)
        {
            whereToGo wtg = new whereToGo();
            App.whertogoPage = wtg;
            App.originWIndow.Content = wtg;
        }
    }
}