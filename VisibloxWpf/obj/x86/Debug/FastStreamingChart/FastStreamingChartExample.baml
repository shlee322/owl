   M S B A M L   `   `   `  ����Y  UVisiblox.Charts, Version=2.0.8.5757, Culture=neutral, PublicKeyToken=1543c03f04c4461bJ6clr-namespace:Visiblox.Charts;assembly=Visiblox.ChartsVisiblox.Charts  5      % !Visiblox.Charts.Examples.Wpf.FreeK   EVisiblox.Charts.Examples.FastStreamingChart.FastStreamingChartExample   5      \ XPresentationFramework, Version=3.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35R NWindowsBase, Version=3.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35W SPresentationCore, Version=3.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35D 9http://schemas.microsoft.com/winfx/2006/xaml/presentation    5      8x,http://schemas.microsoft.com/winfx/2006/xaml    5      >d2http://schemas.microsoft.com/expression/blend/2008    5      Hmc;http://schemas.openxmlformats.org/markup-compatibility/2006    5      Gcharts6clr-namespace:Visiblox.Charts;assembly=Visiblox.Charts    5        � 	Resources  5
       �� 
TargetType   GridLabelStyle �� Property �� Value    Visiblox.Charts.LineSeries  LineNormalStyle��%�   &	        &	 J     �� 5   
   " ��6   .�5      ��  � ��
 �   �6+   5      �� 5   
   "  6   .�5      ��  �@ 
LineStroke �	#FF9900006+   �� 5       �@ LineStrokeThickness$ 2Q�64   5      5      .��5      � -   5         �Name$ 
LayoutRoot��5      
������� � RowDefinitions 5   
   �� 5      $��* �6   �� 5      $��50 �6   .+�5   
      Visiblox.Charts.Chart  -   5        $��chart��5      $	��575��6%   $��Stretch=�61   $��Stretch=�6O   
�������$��Arial)�6~      Visiblox.Charts.ChartBase   LegendVisibility$ 	Collapsed=�6�      XAxis 5      "   Visiblox.Charts.DateTimeAxis  5      �   zVisiblox.Charts.AxisBase`1[[System.DateTime, mscorlib, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089]]   ShowMinorTicks .  	   ShowGridlines	 .  6=   
   YAxis
 5#          Visiblox.Charts.LinearAxis  5$      �   ~Visiblox.Charts.AxisCommonBase`1[[System.Double, mscorlib, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089]]   LabelFormatString$ N2��6$      
ShowLabels .    ShowAxis .     
LabelStyle# [  5%   #   ~   xVisiblox.Charts.AxisBase`1[[System.Double, mscorlib, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089]]   ShowGridlines .  6P      Series 5*        +	   %Visiblox.Charts.ChartSeriesCommonBase 	  NormalStyle# [ 6$   5,      �� 5.   	    �� Orientation$ 
Horizontal=�6   $��2��6-   $��Center=�6:   .+�5/      �� $
��Slow��6   $��Center=�6$   $��0,0,5,0q�6?   �� 50      -   5         ��Name$ SpeedControl��50      $��Center=�6+   $	��200��6H   $��40��6T    � Minimum$ 50Q�51       � Maximum$	 250Q�6"    �� IsDirectionReversed .  � Value$	 250Q�6K    � SmallChange$ 1Q�52       � LargeChange$ 1Q�6%   65   �� 53      $
��Fast��6   $��Center=�6$   $��5,0,0,0q�6?   54      55      56      