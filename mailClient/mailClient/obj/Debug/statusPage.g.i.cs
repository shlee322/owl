﻿#pragma checksum "..\..\statusPage.xaml" "{406ea660-64cf-4c82-b6f0-42d48172a799}" "6008FFFE87ED531A21DFC43DE29FB366"
//------------------------------------------------------------------------------
// <auto-generated>
//     This code was generated by a tool.
//     Runtime Version:4.0.30319.235
//
//     Changes to this file may cause incorrect behavior and will be lost if
//     the code is regenerated.
// </auto-generated>
//------------------------------------------------------------------------------

using System;
using System.Diagnostics;
using System.Windows;
using System.Windows.Automation;
using System.Windows.Controls;
using System.Windows.Controls.DataVisualization.Charting;
using System.Windows.Controls.Primitives;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Ink;
using System.Windows.Input;
using System.Windows.Markup;
using System.Windows.Media;
using System.Windows.Media.Animation;
using System.Windows.Media.Effects;
using System.Windows.Media.Imaging;
using System.Windows.Media.Media3D;
using System.Windows.Media.TextFormatting;
using System.Windows.Navigation;
using System.Windows.Shapes;
using System.Windows.Shell;


namespace mailClient {
    
    
    /// <summary>
    /// statusPage
    /// </summary>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("PresentationBuildTasks", "4.0.0.0")]
    public partial class statusPage : System.Windows.Controls.Page, System.Windows.Markup.IComponentConnector {
        
        
        #line 11 "..\..\statusPage.xaml"
        [System.Diagnostics.CodeAnalysis.SuppressMessageAttribute("Microsoft.Performance", "CA1823:AvoidUnusedPrivateFields")]
        internal System.Windows.Controls.Grid statusGrid;
        
        #line default
        #line hidden
        
        
        #line 25 "..\..\statusPage.xaml"
        [System.Diagnostics.CodeAnalysis.SuppressMessageAttribute("Microsoft.Performance", "CA1823:AvoidUnusedPrivateFields")]
        internal System.Windows.Controls.Grid graphGrid;
        
        #line default
        #line hidden
        
        
        #line 37 "..\..\statusPage.xaml"
        [System.Diagnostics.CodeAnalysis.SuppressMessageAttribute("Microsoft.Performance", "CA1823:AvoidUnusedPrivateFields")]
        internal System.Windows.Controls.DataVisualization.Charting.Chart Test;
        
        #line default
        #line hidden
        
        
        #line 47 "..\..\statusPage.xaml"
        [System.Diagnostics.CodeAnalysis.SuppressMessageAttribute("Microsoft.Performance", "CA1823:AvoidUnusedPrivateFields")]
        internal System.Windows.Controls.DataVisualization.Charting.Chart Test2;
        
        #line default
        #line hidden
        
        
        #line 57 "..\..\statusPage.xaml"
        [System.Diagnostics.CodeAnalysis.SuppressMessageAttribute("Microsoft.Performance", "CA1823:AvoidUnusedPrivateFields")]
        internal System.Windows.Controls.DataVisualization.Charting.Chart Test3;
        
        #line default
        #line hidden
        
        
        #line 67 "..\..\statusPage.xaml"
        [System.Diagnostics.CodeAnalysis.SuppressMessageAttribute("Microsoft.Performance", "CA1823:AvoidUnusedPrivateFields")]
        internal System.Windows.Controls.DataVisualization.Charting.Chart Test4;
        
        #line default
        #line hidden
        
        
        #line 79 "..\..\statusPage.xaml"
        [System.Diagnostics.CodeAnalysis.SuppressMessageAttribute("Microsoft.Performance", "CA1823:AvoidUnusedPrivateFields")]
        internal System.Windows.Controls.Grid mailStatus;
        
        #line default
        #line hidden
        
        
        #line 80 "..\..\statusPage.xaml"
        [System.Diagnostics.CodeAnalysis.SuppressMessageAttribute("Microsoft.Performance", "CA1823:AvoidUnusedPrivateFields")]
        internal System.Windows.Controls.ListView groupStatus;
        
        #line default
        #line hidden
        
        
        #line 87 "..\..\statusPage.xaml"
        [System.Diagnostics.CodeAnalysis.SuppressMessageAttribute("Microsoft.Performance", "CA1823:AvoidUnusedPrivateFields")]
        internal System.Windows.Controls.ListView timeStatus;
        
        #line default
        #line hidden
        
        
        #line 94 "..\..\statusPage.xaml"
        [System.Diagnostics.CodeAnalysis.SuppressMessageAttribute("Microsoft.Performance", "CA1823:AvoidUnusedPrivateFields")]
        internal System.Windows.Controls.ListView personStatus;
        
        #line default
        #line hidden
        
        private bool _contentLoaded;
        
        /// <summary>
        /// InitializeComponent
        /// </summary>
        [System.Diagnostics.DebuggerNonUserCodeAttribute()]
        public void InitializeComponent() {
            if (_contentLoaded) {
                return;
            }
            _contentLoaded = true;
            System.Uri resourceLocater = new System.Uri("/mailClient;component/statuspage.xaml", System.UriKind.Relative);
            
            #line 1 "..\..\statusPage.xaml"
            System.Windows.Application.LoadComponent(this, resourceLocater);
            
            #line default
            #line hidden
        }
        
        [System.Diagnostics.DebuggerNonUserCodeAttribute()]
        [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Never)]
        [System.Diagnostics.CodeAnalysis.SuppressMessageAttribute("Microsoft.Design", "CA1033:InterfaceMethodsShouldBeCallableByChildTypes")]
        [System.Diagnostics.CodeAnalysis.SuppressMessageAttribute("Microsoft.Maintainability", "CA1502:AvoidExcessiveComplexity")]
        [System.Diagnostics.CodeAnalysis.SuppressMessageAttribute("Microsoft.Performance", "CA1800:DoNotCastUnnecessarily")]
        void System.Windows.Markup.IComponentConnector.Connect(int connectionId, object target) {
            switch (connectionId)
            {
            case 1:
            this.statusGrid = ((System.Windows.Controls.Grid)(target));
            return;
            case 2:
            this.graphGrid = ((System.Windows.Controls.Grid)(target));
            
            #line 25 "..\..\statusPage.xaml"
            this.graphGrid.Loaded += new System.Windows.RoutedEventHandler(this.graphGrid_Loaded);
            
            #line default
            #line hidden
            return;
            case 3:
            this.Test = ((System.Windows.Controls.DataVisualization.Charting.Chart)(target));
            return;
            case 4:
            this.Test2 = ((System.Windows.Controls.DataVisualization.Charting.Chart)(target));
            return;
            case 5:
            this.Test3 = ((System.Windows.Controls.DataVisualization.Charting.Chart)(target));
            return;
            case 6:
            this.Test4 = ((System.Windows.Controls.DataVisualization.Charting.Chart)(target));
            return;
            case 7:
            this.mailStatus = ((System.Windows.Controls.Grid)(target));
            return;
            case 8:
            this.groupStatus = ((System.Windows.Controls.ListView)(target));
            return;
            case 9:
            this.timeStatus = ((System.Windows.Controls.ListView)(target));
            return;
            case 10:
            this.personStatus = ((System.Windows.Controls.ListView)(target));
            return;
            }
            this._contentLoaded = true;
        }
    }
}

