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
        public sendingPage()
        {
            InitializeComponent();
            sendingGrid.Children.Add(new dockPannel());

            editor.Source = new Uri("http://www.owl.or.kr/SmartEditor/Editor.php"); //?hash="+App.UserId.ToString()+"&pwd="+App.Passwd);

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
                person = rpc.client.queryToControl(App.key, "read", App.UserId + "@" + addressList.SelectedItem.ToString());
                foreach (String str in person)
                {
                    personList.Items.Add(str);
                }
                if (!isFileFromLocal)
                    pop.IsOpen = true;
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
            if (MessageBox.Show("주소록을 삭제 하시겠습니까?", "주소록 삭제", MessageBoxButton.YesNo) == MessageBoxResult.Yes)
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
            //ms.AddressBook = StrToByteArray(addressList.SelectedItem.ToString());
            if(sendRight.IsChecked.Value)
            {
                long time = (DateTime.Now.ToUniversalTime().Ticks - 621355968000000000) / 10000 + 100000;
            }
            else
            {
                DateTime dt = (DateTime)sendDate.SelectedDate;
                long temp = (dt.Ticks- 621355968000000000)/10000;
                MessageBox.Show(temp.ToString());
            }
            ms.CreatAddress = false;
            //ms.WhenToSend = time;
            ms.MailContent = text;
            ms.SenderAddress = this.senderAddress.Text.ToString();
            //rpc.client.sendMailSet(App.key, ms);
        }




        private byte[] StrToByteArray(string sStr)
        {
            System.Text.ASCIIEncoding encoding = new System.Text.ASCIIEncoding();
            return encoding.GetBytes(sStr);
        }

        //이거 죽이기//
        private void addressList_DragOver(object sender, DragEventArgs e)
        {
            bool dropEnabled = true;
            if (e.Data.GetDataPresent(DataFormats.FileDrop, true))
            {
                string[] filenames = e.Data.GetData(DataFormats.FileDrop, true) as string[];
                foreach (string filename in filenames)
                {
                    if (System.IO.Path.GetExtension(filename).ToUpperInvariant() != ".CSV")
                    {
                        dropEnabled = false;
                        break;
                    }
                }
            }
            else
            {
                dropEnabled = false;
            }
            if (!dropEnabled)
            {
                e.Effects = DragDropEffects.None;
                e.Handled = true;
            }
        }

        private void addressList_Drop(object sender, DragEventArgs e)
        {
            string[] droppedFilenames = e.Data.GetData(DataFormats.FileDrop, true) as string[];

            string line;
            StreamReader file = new StreamReader(droppedFilenames[0]);
            while ((line = file.ReadLine()) != null)
            {
                string tickle;
                string[] word = line.Split(',');
                tickle = word[0] + " " + word[1] + " " + word[2] + " " + word[3];
                addressList.Items.Add(tickle);
            }
            isFileFromLocal = true;
        }

    }
}
