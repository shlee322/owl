   M S B A M L   `   `   `  ����Y  UVisiblox.Charts, Version=2.0.8.5757, Culture=neutral, PublicKeyToken=1543c03f04c4461bJ6clr-namespace:Visiblox.Charts;assembly=Visiblox.ChartsVisiblox.Charts  5      % !Visiblox.Charts.Examples.Wpf.FreeA   ;Visiblox.Charts.Examples.MultipleYAxes.MultipleYAxesExample   5      \ XPresentationFramework, Version=3.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35R NWindowsBase, Version=3.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35W SPresentationCore, Version=3.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35D 9http://schemas.microsoft.com/winfx/2006/xaml/presentation    5      8x,http://schemas.microsoft.com/winfx/2006/xaml    5      >d2http://schemas.microsoft.com/expression/blend/2008    5      Hmc;http://schemas.openxmlformats.org/markup-compatibility/2006    5      Gcharts6clr-namespace:Visiblox.Charts;assembly=Visiblox.Charts    5        � 	Resources  5
         NoBorder �� 
TargetType �� Property �� Value��%w   &	        �� 5   
   " ��6!   .�5      ��  � ��$ 0q�60   �� 5       � ��
 �   �6,   5      5      .��5      � -   5         �Name$ 
LayoutRoot��5      
������� � RowDefinitions 5   
   �� 5      $	��90* �6   �� 5      $	��10* �6   .+�5   
      Visiblox.Charts.Chart  -   5          Name$ 	AxesChart��5         Visiblox.Charts.ChartBase   Title$( "Monthly Sales Data (December 2009)��6*      PlotAreaBorderStyle# [  6U   $��0��6�   	   LegendVisibility$	 	Collapsed=�6�   
   	Behaviour
 5      #   Visiblox.Charts.ZoomBehaviour  5         XAxis 5      "   Visiblox.Charts.DateTimeAxis  5      �   zVisiblox.Charts.AxisBase`1[[System.DateTime, mscorlib, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089]]   ShowGridlines .     ShowMinorTicks .  �   �Visiblox.Charts.AxisCommonBase`1[[System.DateTime, mscorlib, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089]]   LabelFormatString$ dd/MM��6S      Range 5       #   Visiblox.Charts.DateTimeRange  5!         Minimum2   ,Visiblox.Charts.Primitives.DateTimeConverter$ 
2009-12-01 6/      Maximum$ 
2010-01-01 6D   5#         YAxis 5&       	   Visiblox.Charts.LinearAxis	  5'      �
   ~Visiblox.Charts.AxisCommonBase`1[[System.Double, mscorlib, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089]] 
  Title$ Daily Sales��6$   ~   xVisiblox.Charts.AxisBase`1[[System.Double, mscorlib, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089]]   ShowMinorTicks .     ShowGridlines .   
  MajorTickInterval$ 5Q�6e    
  Range 5(      !   Visiblox.Charts.DoubleRange  5)         yVisiblox.Charts.RangeBase`1[[System.Double, mscorlib, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089]]   Minimum$ 5Q�6-      Maximum$ 40Q�69   5+         SecondaryYAxis 5.      	  5/      $ Cumulative Total��6$    .   .  $ 10Q�6j    
  LabelFormatString$	 0'%��6�    50        51      $ 0Q�6-   $	 100Q�69   53         Series 57          Visiblox.Charts.LineSeries     LineStrokeThickness$	 1.5Q�6$     58      $	 1.5Q�6$   5:      �� 5<   
   $��1��6    �� Orientation$ 
Horizontal=�6"   $��Center=�6;   $��Center=�6X   $��0,0,20,0q�6s   .+�5=      �� -   5         ��Name$ 
SalesBlock��5=      $��0,0,5,0q�6,   $��10��6=   $��10��6I   $��Center=�6�   ��6T   ��   �� ElementName$  	AxesChart��! �� Path$! Series[0].PointFill�6�   �� 5>      $��View Daily Sales��6   $��0,0,5,0q�60   �� 5?      -   5        " ��Name$" 
dailyCheck��5?      # d� 	IsChecked$
# TrueY�6+   $��0,0,15,0q�6<   6k   �� 5@      -   5        $ PercentBlock��5@      $��20,0,5,0q�6.   $��10��6@   $��10��6L   $��Center=�6�   ��6W   �� $  	AxesChart��$! Series[1].PointFill�6�   �� 5A      $��View Cumulative % Sales��6   $��0,0,5,0q�67   �� 5B      -   5        $" cumulativeCheck��5B      $
# TrueY�60   6c   5C      5E      5F      