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

namespace testWindow
{
    /// <summary>
    /// Interaction logic for writeMail.xaml
    /// </summary>
    public partial class writeMail : Page
    {
        public writeMail()
        {
            InitializeComponent();
        }

        private void Grid_DragOver(object sender, DragEventArgs e)
        {
            bool dropEnabled = true; 
            if (e.Data.GetDataPresent(DataFormats.FileDrop, true)) 
            { 
                string[] filenames = e.Data.GetData(DataFormats.FileDrop, true) as string[];
                foreach (string filename in filenames)
                {
                    if (System.IO.Path.GetExtension(filename).ToUpperInvariant() != ".PNG")
                    {
                        dropEnabled = false; 
                        break;
                    }
                } 
            } else
            { 
                dropEnabled = false; 
            } 
            if (!dropEnabled) 
            {
                e.Effects = DragDropEffects.None; e.Handled = true;
            }
        }

        private void Grid_Drop(object sender, DragEventArgs e)
        {
            string[] droppedFilenames = e.Data.GetData(DataFormats.FileDrop, true) as string[];
            BitmapImage sImage = new BitmapImage();
            sImage.BeginInit();
            sImage.UriSource = new Uri(droppedFilenames[0], UriKind.RelativeOrAbsolute);
            sImage.EndInit();
            senderImg.Source = sImage;
        }
    }
}
