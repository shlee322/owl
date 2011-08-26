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
using System.IO;
using System.Windows.Media.Animation;
using System.Net;


//group 삭제 구현 완료//
//로그인 구현 하기//


namespace mailClient
{
    /// <summary>
    /// Interaction logic for sendingPage.xaml
    /// </summary>
    ///로딩시 로딩 화면 구현
    ///list box에서도 D&D 로 파일 읽어오기 구현하기

    public partial class sendingPage : Page
    {
        bool isDeleted = false;
        bool isFileFromLocal = false;
        Microsoft.Win32.OpenFileDialog ofd;
        string selectItem;


        public sendingPage()
        {
            InitializeComponent();
            sendingGrid.Children.Add(new dockPannel());

            editor.Source = new Uri("http://www.owl.or.kr/SmartEditor/Editor.php");

            Loaded += new RoutedEventHandler(sendingPage_Loaded);

        }

        void sendingPage_Loaded(object sender, RoutedEventArgs e)
        {

            List<string> test = rpc.client.queryToControl(App.key, "read", App.UserId);
            foreach (string str in test)
            {
                addressList.Items.Add(str);
            }
            addressList.Items.RemoveAt(addressList.Items.Count - 1);
        }


        private void addressList_SelectionChanged(object sender, SelectionChangedEventArgs e)
        {
            pop.IsOpen = false;
            List<String> person = new List<String>();
            if (!isDeleted && addressList.SelectedItems.Count != 0)
            {
                if (!isFileFromLocal)
                {
                    pop.IsOpen = true;
                    person = rpc.client.queryToControl(App.key, "read", App.UserId + "@" + addressList.SelectedItem.ToString());
                    foreach (String str in person)
                    {
                        String[] word = str.Split(',');
                        personList.Items.Add(word[0]+" "+word[1]);
                    }
                }
                else
                    addressList.UnselectAll();
            }

        }

        private void popClose_Click(object sender, RoutedEventArgs e)
        {
            pop.IsOpen = false;
            addressList.UnselectAll();
            personList.Items.Clear();
        }

        private void deleteAddress_Click(object sender, RoutedEventArgs e)
        {
            pop.IsOpen = false;
            if (System.Windows.MessageBox.Show("주소록을 삭제 하시겠습니까?", "주소록 삭제", MessageBoxButton.YesNo) == MessageBoxResult.Yes)
            {
                String str = "group@" + addressList.SelectedItems[0].ToString();
                List<String> acx = rpc.client.queryToControl(App.key, "delete", str);
                isDeleted = true;
                addressList.Items.Remove(addressList.SelectedItem);
            }
            else
            {
                pop.IsOpen = false;
                isDeleted = false;
            }
        }

        private void send_Click(object sender, RoutedEventArgs e)
        {
            string text = (string)this.editor.InvokeScript("getHTML");
            //메일셋 설정//
            api.mailSet ms = new api.mailSet();
            long time;
            if (sendRight.IsChecked.Value)
            {
                time = (DateTime.Now.ToUniversalTime().Ticks - 621355968000000000) / 10000 + 100000;
            }
            else
            {
                //시간 부분 구현//
                DateTime dt = (DateTime)sendDate.SelectedDate;
                String Shour = hourBlock.Text.ToString();
                String[] minandhour = Shour.Split(':');

                time = (dt.Ticks - 621355968000000000) / 10000 + 6000;
            }

            if (isFileFromLocal)
            {
                ms.CreatAddress = true;
                String temp = "";
                for (int i = 0; i < addressList.Items.Count; i++)
                {
                    temp += addressList.Items.GetItemAt(i).ToString();
                }
                ms.AddressBook = StrToByteArray(temp);
            }
            else
            {
                ms.CreatAddress = false;
                ms.AddressBook = StrToByteArray(selectItem);
            }


            ms.WhenToSend = time;
            ms.MailContent = title.Text.ToString() + "@" + text;
            ms.SenderAddress = this.senderAddress.Text.ToString();


            rpc.client.sendMailSet(App.key, ms);
        }




        private byte[] StrToByteArray(string sStr)
        {
            System.Text.ASCIIEncoding encoding = new System.Text.ASCIIEncoding();
            return encoding.GetBytes(sStr);
        }

        private void getBtn_Click(object sender, RoutedEventArgs e)
        {
            ofd = new Microsoft.Win32.OpenFileDialog();
            ofd.Filter = "csv files (*.csv)|*.csv";
            ofd.Multiselect = false;
            ofd.Title = "주소록을 선택해 주세요.";

            Nullable<bool> result = ofd.ShowDialog();

            if (result == true)
            {
                addressList.Items.Clear();
                string add = File.ReadAllText(ofd.FileName);
                String[] word = add.Split('\n');
                foreach (String s in word)
                {
                    addressList.Items.Add(s);
                }
                isFileFromLocal = true;
            }
            else
                isFileFromLocal = false;


        }

        private void selectAddress_Click(object sender, RoutedEventArgs e)
        {
            selectItem = addressList.SelectedItem.ToString();
            pop.IsOpen = false;
        }


    }
}
