   M S B A M L   `   `   `  ����\  XVisiblox.Charts.Examples.Wpf.Free, Version=1.0.0.0, Culture=neutral, PublicKeyToken=nullU/clr-namespace:Visiblox.Charts.Examples.BarChart!Visiblox.Charts.Examples.BarChart  5      Y UVisiblox.Charts, Version=2.0.8.5757, Culture=neutral, PublicKeyToken=1543c03f04c4461bJ6clr-namespace:Visiblox.Charts;assembly=Visiblox.ChartsVisiblox.Charts 5	      7    1Visiblox.Charts.Examples.BarChart.BarChartExample   5      \ XPresentationFramework, Version=3.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35R NWindowsBase, Version=3.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35W SPresentationCore, Version=3.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35D 9http://schemas.microsoft.com/winfx/2006/xaml/presentation    5      8x,http://schemas.microsoft.com/winfx/2006/xaml    5      >d2http://schemas.microsoft.com/expression/blend/2008    5      Hmc;http://schemas.openxmlformats.org/markup-compatibility/2006    5      ?local/clr-namespace:Visiblox.Charts.Examples.BarChart    5      Gcharts6clr-namespace:Visiblox.Charts;assembly=Visiblox.Charts    5	        � 	Resources  5      5   /Visiblox.Charts.Examples.BarChart.DebtLevelList 	  Y20071   +Visiblox.Charts.Examples.BarChart.DebtLevel   Country   
PercentGDP 	 Y2008 	 Y2009 	 Y2010  LegendNoBorder �� 
TargetType  Visiblox.Charts.Legend �� Property �� Value  NoBorder  CatAxisLine  CustomTooltipTemplate �� Orientation �� StringFormat��%}  &	        &	 g    &	 �    &	 6    &	 �    &	 R    &	 �    &	       5   
     5      $ Italy��6   $ 101.21Q�6.     5      $ Japan��6   $ 81.51Q�6.     5      $ Germany��6   $ 58.45Q�60     5      $ France��6   $ 54.10Q�6/     5      $	 USA��6   $ 42.35Q�6,     5      $ UK��6   $ 38.32Q�6+     5      $ Canada��6   $ 22.80Q�6/   5        5   
     5      $ Italy��6   $ 103.89Q�6.     5      $ Japan��6   $ 96.91Q�6.     5      $ Germany��6   $ 59.29Q�60     5      $ France��6   $ 57.78Q�6/     5      $	 USA��6   $ 47.18Q�6,     5      $ UK��6   $ 45.54Q�6+     5       $ Canada��6   $ 22.62Q�6/   5!        5"   
     5#      $ Italy��6   $ 113.20Q�6.     5$      $ Japan��6   $ 111.62Q�6.     5%      $ Germany��6   $ 64.30Q�60     5&      $ France��6   $ 67.74Q�6/     5'      $	 USA��6   $ 58.33Q�6,     5(      $ UK��6   $ 61.52Q�6+     5)      $ Canada��6   $ 28.25Q�6/   5*        5+   
     5,      $ Italy��6   $ 115.97Q�6.     5-      $ Japan��6   $ 121.73Q�6.     5.      $ Germany��6   $ 68.62Q�60     5/      $ France��6   $ 74.54Q�6/     50      $	 USA��6   $ 66.13Q�6,     51      $ UK��6   $ 71.57Q�6+     52      $ Canada��6   $ 31.82Q�6/   53      �� 55   
   "  6'   .�56      ��  � ��$ 0q�60   �� 57       � ��$ 80��6'   �� 58       � ��$ 70��6&   �� 59       � ��$	 Top=�62   5:      �� 5<   
   " ��6!   .�5=      ��  � ��$ 0q�60   �� 5>       � ��
 �   �6,   5?      �� 5A   
   " ��6$   .�5B      ��  � ��$ 0��60   5C      �� 5F   
   .R�5G      �� 
���   �$��1q�6)   $��15,0,0,0q�6=   ._�5H      � $��0q�6   
�������.+�5I      �� $ 
Horizontal=�6!   .+�5J      �� ��6$   �� *
PercentGDP+$ N2���� 5K      $	��2,0q�6$   $��% of GDP��62   5L      5M      5N      5O      5Q      .��5S      � -   5         �Name$ 
LayoutRoot��5S      
�������.+�5U   
     Visiblox.Charts.Chart  -   5        	  Name$	 	MainChart��5U      $	��575��6*     Visiblox.Charts.ChartBase
   Title$
 G7 Government Debt Levels��66   $��Arial)�6X      PlotAreaBorderStyle# [ 6k      LegendStyle# [ 6�      	Behaviour 5W      #  Visiblox.Charts.ZoomBehaviour  5X         YAxis 5\      "  Visiblox.Charts.CategoryAxis  5]      �  �Visiblox.Charts.AxisCommonBase`1[[System.IComparable, mscorlib, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089]]   
ShowLabels . �	  }Visiblox.Charts.AxisBase`1[[System.IComparable, mscorlib, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089]] 	  ShowGridStripes .   	  ShowGridlines .   	  ShowMajorTicks .     AxisLineStyle# [ 5b   "   $��65��5c   "      XAxis 5f       
  Visiblox.Charts.LinearAxis
  5g      �  ~Visiblox.Charts.AxisCommonBase`1[[System.Double, mscorlib, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089]]   Title$ Net debt (% of GDP)��6$   ~  xVisiblox.Charts.AxisBase`1[[System.Double, mscorlib, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089]]   ShowMinorTicks .     LabelFormatString$	 0'%��6W      Series 5l        Visiblox.Charts.BarSeries  +  %Visiblox.Charts.ChartSeriesCommonBase   ToolTipEnabled .    ToolTipTemplate# [ 69   +  %Visiblox.Charts.ChartSingleSeriesBase   SelectionMode$ Series=�6r      
DataSeries 5n      (  "Visiblox.Charts.BindableDataSeries  5o         Title$
 2007��64      ItemsSource# [  6A      XValueBinding 6f   ��   �� Path$  
PercentGDP�!   YValueBinding! 6�   �� $  Country�5q        5r       . # [ 69   $ Series=�6r    5t        5u      $
 2008��64   # [ 6A    6f   �� $  
PercentGDP�! 6�   �� $  Country�5w        5x       . # [ 69   $ Series=�6r    5z        5{      $
 2009��64   # [ 6A    6f   �� $  
PercentGDP�! 6�   �� $  Country�5}        5~       . # [ 69   $ Series=�6r    5�        5�      $
 2010��64   # [ 6A    6f   �� $  
PercentGDP�! 6�   �� $  Country�5�      5�      5�      5�      