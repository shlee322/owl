﻿#pragma checksum "..\..\..\second.xaml" "{406ea660-64cf-4c82-b6f0-42d48172a799}" "34B1005CCADB62B834E5B3B3FA293858"
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


namespace testWindow {
    
    
    /// <summary>
    /// second
    /// </summary>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("PresentationBuildTasks", "4.0.0.0")]
    public partial class second : System.Windows.Controls.Page, System.Windows.Markup.IComponentConnector {
        
        
        #line 1 "..\..\..\second.xaml"
        [System.Diagnostics.CodeAnalysis.SuppressMessageAttribute("Microsoft.Performance", "CA1823:AvoidUnusedPrivateFields")]
        internal testWindow.second page;
        
        #line default
        #line hidden
        
        
        #line 40 "..\..\..\second.xaml"
        [System.Diagnostics.CodeAnalysis.SuppressMessageAttribute("Microsoft.Performance", "CA1823:AvoidUnusedPrivateFields")]
        internal System.Windows.Controls.Image mail;
        
        #line default
        #line hidden
        
        
        #line 45 "..\..\..\second.xaml"
        [System.Diagnostics.CodeAnalysis.SuppressMessageAttribute("Microsoft.Performance", "CA1823:AvoidUnusedPrivateFields")]
        internal System.Windows.Controls.Image chart;
        
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
            System.Uri resourceLocater = new System.Uri("/testWindow;component/second.xaml", System.UriKind.Relative);
            
            #line 1 "..\..\..\second.xaml"
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
            this.page = ((testWindow.second)(target));
            
            #line 8 "..\..\..\second.xaml"
            this.page.Loaded += new System.Windows.RoutedEventHandler(this.page_Loaded);
            
            #line default
            #line hidden
            return;
            case 2:
            this.mail = ((System.Windows.Controls.Image)(target));
            
            #line 40 "..\..\..\second.xaml"
            this.mail.MouseEnter += new System.Windows.Input.MouseEventHandler(this.mail_MouseEnter);
            
            #line default
            #line hidden
            
            #line 40 "..\..\..\second.xaml"
            this.mail.MouseLeave += new System.Windows.Input.MouseEventHandler(this.mail_MouseLeave);
            
            #line default
            #line hidden
            
            #line 40 "..\..\..\second.xaml"
            this.mail.MouseLeftButtonDown += new System.Windows.Input.MouseButtonEventHandler(this.mail_MouseLeftButtonDown);
            
            #line default
            #line hidden
            return;
            case 3:
            this.chart = ((System.Windows.Controls.Image)(target));
            
            #line 45 "..\..\..\second.xaml"
            this.chart.MouseEnter += new System.Windows.Input.MouseEventHandler(this.chart_MouseEnter);
            
            #line default
            #line hidden
            
            #line 45 "..\..\..\second.xaml"
            this.chart.MouseLeave += new System.Windows.Input.MouseEventHandler(this.chart_MouseLeave);
            
            #line default
            #line hidden
            return;
            }
            this._contentLoaded = true;
        }
    }
}
