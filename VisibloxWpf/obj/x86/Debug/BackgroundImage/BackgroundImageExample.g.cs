﻿#pragma checksum "..\..\..\..\BackgroundImage\BackgroundImageExample.xaml" "{406ea660-64cf-4c82-b6f0-42d48172a799}" "E5CFB20F167658E1DCF43B8F7167AECD"
//------------------------------------------------------------------------------
// <auto-generated>
//     이 코드는 도구를 사용하여 생성되었습니다.
//     런타임 버전:4.0.30319.235
//
//     파일 내용을 변경하면 잘못된 동작이 발생할 수 있으며, 코드를 다시 생성하면
//     이러한 변경 내용이 손실됩니다.
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
using Visiblox.Charts;
using Visiblox.Charts.Examples.BackgroundImage;


namespace Visiblox.Charts.Examples.BackgroundImage {
    
    
    /// <summary>
    /// BackgroundImageExample
    /// </summary>
    public partial class BackgroundImageExample : System.Windows.Controls.UserControl, System.Windows.Markup.IComponentConnector {
        
        
        #line 58 "..\..\..\..\BackgroundImage\BackgroundImageExample.xaml"
        internal System.Windows.Controls.Grid LayoutRoot;
        
        #line default
        #line hidden
        
        
        #line 60 "..\..\..\..\BackgroundImage\BackgroundImageExample.xaml"
        internal Visiblox.Charts.Chart BackgroundChart;
        
        #line default
        #line hidden
        
        
        #line 82 "..\..\..\..\BackgroundImage\BackgroundImageExample.xaml"
        internal Visiblox.Charts.BindableDataSeries bindableSeries;
        
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
            System.Uri resourceLocater = new System.Uri("/Visiblox.Charts.Examples.Wpf.Free;component/backgroundimage/backgroundimageexamp" +
                    "le.xaml", System.UriKind.Relative);
            
            #line 1 "..\..\..\..\BackgroundImage\BackgroundImageExample.xaml"
            System.Windows.Application.LoadComponent(this, resourceLocater);
            
            #line default
            #line hidden
        }
        
        [System.Diagnostics.DebuggerNonUserCodeAttribute()]
        [System.Diagnostics.CodeAnalysis.SuppressMessageAttribute("Microsoft.Performance", "CA1811:AvoidUncalledPrivateCode")]
        internal System.Delegate _CreateDelegate(System.Type delegateType, string handler) {
            return System.Delegate.CreateDelegate(delegateType, this, handler);
        }
        
        [System.Diagnostics.DebuggerNonUserCodeAttribute()]
        [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Never)]
        [System.Diagnostics.CodeAnalysis.SuppressMessageAttribute("Microsoft.Design", "CA1033:InterfaceMethodsShouldBeCallableByChildTypes")]
        void System.Windows.Markup.IComponentConnector.Connect(int connectionId, object target) {
            switch (connectionId)
            {
            case 1:
            this.LayoutRoot = ((System.Windows.Controls.Grid)(target));
            return;
            case 2:
            this.BackgroundChart = ((Visiblox.Charts.Chart)(target));
            return;
            case 3:
            this.bindableSeries = ((Visiblox.Charts.BindableDataSeries)(target));
            return;
            }
            this._contentLoaded = true;
        }
    }
}

