   M S B A M L   `   `   `  ����Y  UVisiblox.Charts, Version=2.0.8.5757, Culture=neutral, PublicKeyToken=1543c03f04c4461bJ6clr-namespace:Visiblox.Charts;assembly=Visiblox.ChartsVisiblox.Charts  5      % !Visiblox.Charts.Examples.Wpf.FreeG   AVisiblox.Charts.Examples.CombinationChart.CombinationChartExample   5      \ XPresentationFramework, Version=3.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35R NWindowsBase, Version=3.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35W SPresentationCore, Version=3.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35D 9http://schemas.microsoft.com/winfx/2006/xaml/presentation    5      8x,http://schemas.microsoft.com/winfx/2006/xaml    5      >d2http://schemas.microsoft.com/expression/blend/2008    5      Hmc;http://schemas.openxmlformats.org/markup-compatibility/2006    5      Gcharts6clr-namespace:Visiblox.Charts;assembly=Visiblox.Charts    5        � 	Resources  5
         NoBorder �� 
TargetType �� Property �� Value  LinePointTooltip �� Orientation  ColumnTooltip��%9  &	        &	 m     &	 �    �� 5   
   " ��6!   .�5      ��  � ��$ 0q�60   �� 5       � ��
 �   �6,   5      �� 5   
   .R�5      �� 
���   �$��1q�6)   $��15,0,0,0q�6=   ._�5      � $��0q�6   
�������.+�5      �� $ 
Horizontal=�6!   .+�5      �� $��Up to ��6$   �� 5      ��6$   �� *X+�� 5      $�� counts for ��6$   �� 5      ��6$   �� *Y+�� 5      $��%��6$   5      5      5      5      �� 5!   
   .R�5"      �� 
���   �$��1q�6)   $��15,0,0,0q�6=   ._�5#      � $��0q�6   
�������.+�5$      �� $ 
Horizontal=�6!   .+�5%      �� ��6$   �� *X+�� 5&      $�� counts for ��6$   �� 5'      ��6$   �� *Y+�� 5(      $��%��6$   5)      5*      5+      5,      5.      .��50      � -   5         �Name$ 
LayoutRoot��50      
�������.+�51   
      Visiblox.Charts.Chart  -   5          Name$ CombinationChart��51      $	��575��61      Visiblox.Charts.ChartBase   Title$2 ,Laptop Computer Returns Percentage by Reason��6=      LegendVisibility$ 	Collapsed=�6r   	   PlotAreaBorderStyle#	 [  6�   
   	Behaviour
 52      #   Visiblox.Charts.ZoomBehaviour  53         XAxis 55      "   Visiblox.Charts.CategoryAxis  56      �   }Visiblox.Charts.AxisBase`1[[System.IComparable, mscorlib, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089]]   ShowMinorTicks .     ShowMajorTicks .     ShowGridlines .  6T      YAxis 58          Visiblox.Charts.LinearAxis  59      �   ~Visiblox.Charts.AxisCommonBase`1[[System.Double, mscorlib, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089]]   LabelFormatString$	 0'%��6$   ~   xVisiblox.Charts.AxisBase`1[[System.Double, mscorlib, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089]]   ShowMinorTicks .     ShowGridlines .     Range 5:      !	   Visiblox.Charts.DoubleRange	  5;      
   yVisiblox.Charts.RangeBase`1[[System.Double, mscorlib, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089]] 
  Minimum$ 0Q�6-    
  Maximum$	 105Q�69   5=         Series 5@      "   Visiblox.Charts.ColumnSeries  +   %Visiblox.Charts.BarOrColumnSeriesBase   	PointFill �	#FF939898   BarWidthFraction$
 0.45Q�6<   +   %Visiblox.Charts.ChartSeriesCommonBase   ToolTipEnabled .    ToolTipTemplate# [ 6j       Visiblox.Charts.LineSeries  5A         
LineStroke �	#FFD77171   	PointFill �	#FFD77171   LineStrokeThickness$ 3Q�6Q      
ShowPoints .    	PointSize$ 7Q�6{    . # [ 6�   5C      5D      5E      