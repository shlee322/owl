   M S B A M L   `   `   `  ����\  XVisiblox.Charts.Examples.Wpf.Free, Version=1.0.0.0, Culture=neutral, PublicKeyToken=nulli9clr-namespace:Visiblox.Charts.Examples.StackedColumnChart+Visiblox.Charts.Examples.StackedColumnChart  5      Y UVisiblox.Charts, Version=2.0.8.5757, Culture=neutral, PublicKeyToken=1543c03f04c4461bJ6clr-namespace:Visiblox.Charts;assembly=Visiblox.ChartsVisiblox.Charts 5      K    EVisiblox.Charts.Examples.StackedColumnChart.StackedColumnChartExample   5      \ XPresentationFramework, Version=3.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35R NWindowsBase, Version=3.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35W SPresentationCore, Version=3.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35D 9http://schemas.microsoft.com/winfx/2006/xaml/presentation    5      8x,http://schemas.microsoft.com/winfx/2006/xaml    5      >d2http://schemas.microsoft.com/expression/blend/2008    5      Hmc;http://schemas.openxmlformats.org/markup-compatibility/2006    5      Ilocal9clr-namespace:Visiblox.Charts.Examples.StackedColumnChart    5      Gcharts6clr-namespace:Visiblox.Charts;assembly=Visiblox.Charts    5        � 	Resources  5         NoBorder �� 
TargetType �� Property �� Value;   5Visiblox.Charts.Examples.StackedColumnChart.PartyList 
 Labour@   :Visiblox.Charts.Examples.StackedColumnChart.ElectionResult   Year   VotesMillions  Conservatives 
 LibDem 
 Others��%�  &	        &	 m     &	 :    &	     &	 �    �� 5   
   " ��6!   .�5      ��  � ��$ 0q�60   �� 5       � ��
 �   �6,   5        5   
     5      $
 1997��6#   $
 13.5Q�6/     5      $
 2001��6#   $
 10.7Q�6/     5      $
 2005��6#   $	 9.6Q�6/     5      $
 2010��6#   $	 8.6Q�6/   5        5   
     5      $
 1997��6#   $	 9.6Q�6/     5      $
 2001��6#   $	 8.4Q�6/     5      $
 2005��6#   $	 8.8Q�6/     5      $
 2010��6#   $
 10.7Q�6/   5        5   
     5       $
 1997��6#   $	 5.2Q�6/     5!      $
 2001��6#   $	 4.8Q�6/     5"      $
 2005��6#   $	 6.0Q�6/     5#      $
 2010��6#   $	 6.8Q�6/   5$        5&   
     5'      $
 1997��6#   $	 2.9Q�6/     5(      $
 2001��6#   $	 2.5Q�6/     5)      $
 2005��6#   $	 2.8Q�6/     5*      $
 2010��6#   $	 3.5Q�6/   5+      5-      .��5/      � -   5         �Name$ 
LayoutRoot��5/      
�������$	��600��62   $	��350��6>    � RowDefinitions 50   
   �� 51      $��* �6   �� 52      $
��Auto �6   .+�55   
     Visiblox.Charts.Chart  -   5          Name$ 	MainChart��55        Visiblox.Charts.ChartBase	   Title$0	 *General Election Results from 1997 to 2010��6*   
   PlotAreaBorderStyle#
 [  6]      	Behaviour 57      #  Visiblox.Charts.ZoomBehaviour  58         YAxis 5;         Visiblox.Charts.LinearAxis  5<      ~  xVisiblox.Charts.AxisBase`1[[System.Double, mscorlib, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089]]   ShowMinorTicks .     ShowGridlines .     IsAutoMarginEnabled .  �  ~Visiblox.Charts.AxisCommonBase`1[[System.Double, mscorlib, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089]]   Title$ Votes (millions)��5?   $      XAxis 5D      "	  Visiblox.Charts.CategoryAxis	  5E      �
  }Visiblox.Charts.AxisBase`1[[System.IComparable, mscorlib, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089]] 
  ShowGridStripes .   
  ShowGridlines .   
  ShowMinorTicks .   
  IsAutoMarginEnabled .  �  �Visiblox.Charts.AxisCommonBase`1[[System.IComparable, mscorlib, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089]]   Title$ General Election��5I   &      Series 5M      )  #Visiblox.Charts.StackedColumnSeries  -  'Visiblox.Charts.ChartMultipleSeriesBase   Series. 5N      "  Visiblox.Charts.ColumnSeries  +  %Visiblox.Charts.BarOrColumnSeriesBase   	PointFill
 �""��+  %Visiblox.Charts.ChartSeriesCommonBase   
DataSeries 5P      (  "Visiblox.Charts.BindableDataSeries  5Q         Title$ Labour��68      ItemsSource# [ 5R   8      XValueBinding 5S   8   ��  �� Path$
 Year�   YValueBinding 5T   8   �� $ VotesMillions�5V        5W      
 ��d� 5Y        5Z      $ Conservatives��68   # [ 5[   4    5\   4   �� $
 Year� 5]   4   �� $ VotesMillions�5_        5`      
 � ��� 5b        5c      $ Liberal Democrats��68   # [ 5d   4    5e   4   �� $
 Year� 5f   4   �� $ VotesMillions�5h        5i      
 ���p� 5k        5l      $ Others��68   # [ 5m   4    5n   4   �� $
 Year� 5o   4   �� $ VotesMillions�5q      5r      5u      �� 5w   
   $��1��6     �� Orientation$  
Horizontal=�6"   $��0, 10, 0, 0q�6;   $��Center=�6P   .+�5x      �� $��Stacking Style: ��6   $��
0, 0, 5, 0q�60   $
��Bold"�6D   	� 5y      -   5        ! 	�Name$! Stacked��5y      $��Stacked��6+   $��
0, 0, 5, 0q�6=   " d� 	IsChecked$
" TrueY�6k   	� 5z      -   5        $! OneHundredStacked��5z      $��100% Stacked��65   6L   5{      5}      5~      