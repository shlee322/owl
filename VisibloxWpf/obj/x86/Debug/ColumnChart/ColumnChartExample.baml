   M S B A M L   `   `   `  ����\  XVisiblox.Charts.Examples.Wpf.Free, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null[2clr-namespace:Visiblox.Charts.Examples.ColumnChart$Visiblox.Charts.Examples.ColumnChart  5      Y UVisiblox.Charts, Version=2.0.8.5757, Culture=neutral, PublicKeyToken=1543c03f04c4461bJ6clr-namespace:Visiblox.Charts;assembly=Visiblox.ChartsVisiblox.Charts 5	      =    7Visiblox.Charts.Examples.ColumnChart.ColumnChartExample   5      \ XPresentationFramework, Version=3.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35R NWindowsBase, Version=3.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35W SPresentationCore, Version=3.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35D 9http://schemas.microsoft.com/winfx/2006/xaml/presentation    5      8x,http://schemas.microsoft.com/winfx/2006/xaml    5      >d2http://schemas.microsoft.com/expression/blend/2008    5      Hmc;http://schemas.openxmlformats.org/markup-compatibility/2006    5      Blocal2clr-namespace:Visiblox.Charts.Examples.ColumnChart    5      Gcharts6clr-namespace:Visiblox.Charts;assembly=Visiblox.Charts    5	      -   5          >�Name$  Root1��5       � 	Resources 5      ;   5Visiblox.Charts.Examples.ColumnChart.GDPDataPointList   
GDPGermany7   1Visiblox.Charts.Examples.ColumnChart.GDPDataPoint   Date
   GDP  	GDPFrance 	 GDPUK  	GDPCanada  GDPItaly  GDPJapan 
 GDPUSA  NoBorder �� 
TargetType �� Property �� Value  CatAxisLine 	 CustomTooltipTemplate �� Orientation��%	  &	        &	 �     &	 �    &	 m    &	 9    &	     &	 �    &	 �    &	     &		 �      5   
     5      $
 1990��6!   $
 1550Q�6-     5      $
 1995��6!   $
 2520Q�6-     5      $
 2000��6!   $
 1900Q�6-     5      $
 2005��6!   $
 2790Q�6-   5        5   
     5      $
 1990��6!   $
 1250Q�6-     5      $
 1995��6!   $
 1570Q�6-     5      $
 2000��6!   $
 1330Q�6-     5      $
 2005��6!   $
 2150Q�6-   5        5   
     5      $
 1990��6!   $
 1020Q�6-     5      $
 1995��6!   $
 1160Q�6-     5      $
 2000��6!   $
 1480Q�6-     5      $
 2005��6!   $
 2280Q�6-   5        5    
     5!      $
 1990��6!   $	 580Q�6-     5"      $
 1995��6!   $	 590Q�6-     5#      $
 2000��6!   $	 720Q�6-     5$      $
 2005��6!   $
 1130Q�6-   5%        5&   
     5'      $
 1990��6!   $
 1140Q�6-     5(      $
 1995��6!   $
 1130Q�6-     5)      $
 2000��6!   $
 1100Q�6-     5*      $
 2005��6!   $
 1780Q�6-   5+        5,   
     5-      $
 1990��6!   $
 3030Q�6-     5.      $
 1995��6!   $
 5260Q�6-     5/      $
 2000��6!   $
 4670Q�6-     50      $
 2005��6!   $
 4550Q�6-   51        52   
     53      $
 1990��6!   $
 5800Q�6-     54      $
 1995��6!   $
 7400Q�6-     55      $
 2000��6!   $
 9950Q�6-     56      $
 2005��6!   $ 12640Q�6-   57      �� 59   
   " ��6!   .�5:      ��  � ��$ 0q�60   �� 5;       � ��
 �   �6,   5<      �� 5>   
   " ��6$   .�5?      ��  � ��$ 0��60   �� 5@       � ��
 �   �6'   5A      �� 5D   
   .R�5E      �� 
���   �$��1q�6)   $��15,0,0,0q�6=   ._�5F      � 
�������.+�5G      �� $ 
Horizontal=�6!   .+�5H      �� $��$��6$   �� 5I      ��6$   �� *GDP+�� 5J      $	��2,0q�6$   $��billion��62   5K      5L      5M      5N      5P      .��5R      � -   5         �Name$ 
LayoutRoot��5R      
�������	 � RowDefinitions	 5T   
   �� 5U      $	��90* �6   �� 5V      $	��10* �6   .+�5Y   
     Visiblox.Charts.Chart  -   5        
  Name$
 	MainChart��5Y      $	��575��6*     Visiblox.Charts.ChartBase   Title$ G7 Gross Domestic Product��66   $��Arial)�6X      PlotAreaBorderStyle# [ 6k   $��0��6�      LegendVisibility$ 	Collapsed=�6�      	Behaviour 5[      #  Visiblox.Charts.ZoomBehaviour  5\         YAxis 5`         Visiblox.Charts.LinearAxis  5a      �  ~Visiblox.Charts.AxisCommonBase`1[[System.Double, mscorlib, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089]]   Title$ USD in Billions��6$   ~  xVisiblox.Charts.AxisBase`1[[System.Double, mscorlib, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089]]   ShowMinorTicks .     LabelFormatString$ N0��6S   $��65��6j      Range 5b      !	  Visiblox.Charts.DoubleRange	  5c      
  yVisiblox.Charts.RangeBase`1[[System.Double, mscorlib, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089]] 
  Minimum$ 0Q�6-    
  Maximum$ 13000Q�69   5e         XAxis 5g      "  Visiblox.Charts.CategoryAxis  5h      �  �Visiblox.Charts.AxisCommonBase`1[[System.IComparable, mscorlib, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089]]   
ShowLabels . �  }Visiblox.Charts.AxisBase`1[[System.IComparable, mscorlib, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089]]   ShowGridStripes .     ShowGridlines .     ShowMajorTicks .     AxisLineStyle# [ 5m   "      Series 5s      "  Visiblox.Charts.ColumnSeries  +  %Visiblox.Charts.ChartSeriesCommonBase   ToolTipEnabled .    ToolTipTemplate# [	 6<   +  %Visiblox.Charts.ChartSingleSeriesBase   SelectionMode$ Series=�6u       
DataSeries  5t      (  "Visiblox.Charts.BindableDataSeries  5u      !   Title$	! USA��64   "   ItemsSource#" [ 6@   #   XValueBinding# 6f   �� $ �� Path$
$ Date�%   YValueBinding% 6�   �� $	$ GDP�5w        5x       . # [	 6<   $ Series=�6u     5y        5z      $! Japan��64   #" [ 6B   # 6j   �� $
$ Date�% 6�   �� $	$ GDP�5|        5}       . # [	 6<   $ Series=�6u     5~        5      $! Germany��64   #" [  6D   # 6n   �� $
$ Date�% 6�   �� $	$ GDP�5�        5�       . # [	 6=   $ Series=�6v     5�        5�      $! France��64   #" [ 6C   # 6l   �� $
$ Date�% 6�   �� $	$ GDP�5�        5�       . # [	 6<   $ Series=�6u     5�        5�      $! UK��64   #" [ 6?   # 6d   �� $
$ Date�% 6�   �� $	$ GDP�5�        5�       . # [	 6<   $ Series=�6u     5�        5�      $! Italy��64   #" [ 6B   # 6j   �� $
$ Date�% 6�   �� $	$ GDP�5�        5�       . # [	 6<   $ Series=�6u     5�        5�      $! Canada��64   #" [ 6C   # 6l   �� $
$ Date�% 6�   �� $	$ GDP�5�      5�      �� 5�   
   -   5        & ��Name$& CustomLegend��5�      $ 
Horizontal=�6+   $��1��6D   $��Center=�6Q   $��
0,0,-30,15q�6n   .+�5�      �� $��0,0,2,0q�6   $��10��6)   $��10��65   $��Center=�6�   ��6@   �� ' �� ElementName$' 	MainChart��$$ Series[0].PointFill�6�   �� 5�      $��0,0,8,0q�6   $��Center=�6q   ��6)   �� $' 	MainChart��$ $ Series[0].DataSeries.Title�6q   �� 5�      $��5,0,2,0q�6   $��10��6)   $��10��65   $��Center=�6�   ��6@   �� $' 	MainChart��$$ Series[1].PointFill�6�   �� 5�      $��0,0,8,0q�6   $��Center=�6q   ��6)   �� $' 	MainChart��$ $ Series[1].DataSeries.Title�6q   �� 5�      $��5,0,2,0q�6   $��10��6)   $��10��65   $��Center=�6�   ��6@   �� $' 	MainChart��$$ Series[2].PointFill�6�   �� 5�      $��0,0,8,0q�6   $��Center=�6q   ��6)   �� $' 	MainChart��$ $ Series[2].DataSeries.Title�6q   �� 5�      $��5,0,2,0q�6   $��10��6)   $��10��65   $��Center=�6�   ��6@   �� $' 	MainChart��$$ Series[3].PointFill�6�   �� 5�      $��0,0,8,0q�6   $��Center=�6q   ��6)   �� $' 	MainChart��$ $ Series[3].DataSeries.Title�6q   �� 5�      $��5,0,2,0q�6   $��10��6)   $��10��65   $��Center=�6�   ��6@   �� $' 	MainChart��$$ Series[4].PointFill�6�   �� 5�      $��0,0,8,0q�6   $��Center=�6q   ��6)   �� $' 	MainChart��$ $ Series[4].DataSeries.Title�6q   �� 5�      $��5,0,2,0q�6   $��10��6)   $��10��65   $��Center=�6�   ��6@   �� $' 	MainChart��$$ Series[5].PointFill�6�   �� 5�      $��0,0,8,0q�6   $��Center=�6q   ��6)   �� $' 	MainChart��$ $ Series[5].DataSeries.Title�6q   �� 5�      $��5,0,2,0q�6   $��10��6)   $��10��65   $��Center=�6�   ��6@   �� $' 	MainChart��$$ Series[6].PointFill�6�   �� 5�      $��0,0,8,0q�6   $��Center=�6q   ��6)   �� $' 	MainChart��$ $ Series[6].DataSeries.Title�6q   5�      5�      5�      