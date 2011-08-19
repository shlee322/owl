using System;
using System.Collections.Generic;
using System.Configuration;
using System.Data;
using System.Linq;
using System.Windows;

namespace testWindow
{
    /// <summary>
    /// Interaction logic for App.xaml
    /// </summary>
    public partial class App : Application
    {
        static public string id;
        static public string passwd;
        static public Boolean isLogined;
        static public Window originWindow;
    }
}
