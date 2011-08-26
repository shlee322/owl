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
    /// Interaction logic for whereToGo.xaml
    /// </summary>
    public partial class whereToGo : Page
    {
        public whereToGo()
        {
            InitializeComponent();
            this.Loaded += new RoutedEventHandler(whereToGo_Loaded);
        }
        void whereToGo_Loaded(object sender, RoutedEventArgs e)
        {
            dockPannel dcp = new dockPannel();
            whereMain.Children.Add(dcp);
        }
    }
}
