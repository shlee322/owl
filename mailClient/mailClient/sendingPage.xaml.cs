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


namespace mailClient
{
    /// <summary>
    /// Interaction logic for sendingPage.xaml
    /// </summary>
    ///로딩시 로딩 화면 구현
    ///list box에서도 D&D 로 파일 읽어오기 구현하기

    public partial class sendingPage : Page
    {
        public sendingPage()
        {
            InitializeComponent();
            sendingGrid.Children.Add(new dockPannel());

            editor.Source = new Uri("http://www.owl.or.kr/SmartEditor/Editor.php"); //?hash="+App.UserId.ToString()+"&pwd="+App.Passwd);
            //db에서 읽어와서 그룹 그려주기
            //@로 처리하기//
            List<string> test = rpc.client.queryToControl(App.key, "read", App.UserId);
            foreach(string str in test)
            {
                addressList.Items.Add(str);
            }
            addressList.Items.RemoveAt(addressList.Items.Count - 1);
            
        }

        
        private void addressList_SelectionChanged(object sender, SelectionChangedEventArgs e)
        {
            //db에서 그룹 사용자 이름 읽어 오기//
            pop.IsOpen = false;
            List<String> person = rpc.client.queryToControl(App.key, "read", App.UserId + "@" + addressList.SelectedItem.ToString());
            foreach (String str in person)
            {
                personList.Items.Add(str);
            }

            pop.IsOpen = true;
        }

        private void popClose_Click(object sender, RoutedEventArgs e)
        {
            pop.IsOpen = false;
            personList.Items.Clear();
        }

        private void deleteAddress_Click(object sender, RoutedEventArgs e)
        {
            if (MessageBox.Show("주소록을 삭제 하시겠습니까?", "주소록 삭제", MessageBoxButton.YesNo) == MessageBoxResult.Yes)
            {
                addressList.Items.Remove(addressList.SelectedItem);
                pop.IsOpen = false;
            }
            else
                pop.IsOpen = false;
        }

        private void send_Click(object sender, RoutedEventArgs e)
        {

            api.mailSet ms = new api.mailSet();

            ms.CreatAddress = false;
            ms.MailContent = "제발가라";
            ms.WhenToSend = 1234556;
            ms.SenderAddress = "toori67@gmail.com";

            rpc.client.sendMailSet(App.key, ms);

        }

    }
}
