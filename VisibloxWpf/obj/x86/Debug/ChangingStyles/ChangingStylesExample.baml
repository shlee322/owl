   M S B A M L   `   `   `  ����Y  UVisiblox.Charts, Version=2.0.8.5757, Culture=neutral, PublicKeyToken=1543c03f04c4461bJ6clr-namespace:Visiblox.Charts;assembly=Visiblox.ChartsVisiblox.Charts  5      O Kmscorlib, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e0891&clr-namespace:System;assembly=mscorlibSystem 5      % !Visiblox.Charts.Examples.Wpf.FreeF   @Visiblox.Charts.Examples.LineStyleChanging.ChangingStylesExample   5      \ XPresentationFramework, Version=3.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35R NWindowsBase, Version=3.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35W SPresentationCore, Version=3.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35D 9http://schemas.microsoft.com/winfx/2006/xaml/presentation    5      8x,http://schemas.microsoft.com/winfx/2006/xaml    5      >d2http://schemas.microsoft.com/expression/blend/2008    5      Hmc;http://schemas.openxmlformats.org/markup-compatibility/2006    5      Gcharts6clr-namespace:Visiblox.Charts;assembly=Visiblox.Charts    5      4sys&clr-namespace:System;assembly=mscorlib    5        � 	Resources  5         RedFill �� Color  	BlueBrush  RedBrush  
BlackBrush  ThinThickness  MediumThickness  ThickThickness  	PointSize  NoBorder �� 
TargetType �� Property �� Value��%�  &	        &	 #     &	 F     &	 i     &	 �     &	 �     &	 �     &	 �     &	 �     �� 5   
   $ 	#FFD77171��6*   �� 5   
   $ 	#FF939898��6,   �� 5   
   $ 	#FF91BF70��6+   �� 5   
   $ Black��6-   X�5   
   1.0Q�60   X�5   
   2.0Q�62   X�5   
   3.0Q�61   X�5   
   4.0Q�6,   �� 5   
   " ��6!   .�5      ��  � ��$ 0q�60   �� 5       � ��
 �   �6,   5      5      .��5      � -   5         �Name$ 
LayoutRoot��5      .+�5   
   ��  �� Orientation$ Vertical=�6   .+�5         Visiblox.Charts.Chart  -   5        $��StyleChanging��5         Visiblox.Charts.ChartBase   Title$ Changing Line Styles��61      LegendVisibility$ 	Collapsed=�6N   $	��290��5      $	��575��6'   $��Arial)�63   	   PlotAreaBorderStyle#	 [ 6F   
   XAxis
 5!          Visiblox.Charts.LinearAxis  5"      ~   xVisiblox.Charts.AxisBase`1[[System.Double, mscorlib, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089]]   ShowGridlines .     ShowMinorTicks .  �   ~Visiblox.Charts.AxisCommonBase`1[[System.Double, mscorlib, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089]]   LabelFormatString$ N0��6U      Range 5#      !   Visiblox.Charts.DoubleRange  5$         yVisiblox.Charts.RangeBase`1[[System.Double, mscorlib, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089]]   Minimum$ 0Q�61      Maximum$ 50Q�6=   5&         YAxis 5)        5*       .   .  $ N0��6U    5+        5,      $ 5Q�61   $	 165Q�6=   5.         Series 53          Visiblox.Charts.LineSeries     ShowLine .    
ShowPoints .     ShowArea .     
LineStroke# [ 54   (      LineStrokeThickness# [ 6Q      AreaFill# [  55   (     57       .  .  .  # [ 58   (   # [ 6P      	PointFill# [ 59   (      	PointSize# [ 6P   5;      �� 5>      $ 
Horizontal=�6   $��Center=�62   .+�5?      �� -   5        $��
btn_Style1��5?      $��Style 1��6D   $��10q�6V   �� 5@      -   5        $��
btn_Style2��5@      $��Style 2��6D   $��10q�6V   �� 5A      -   5        $��
btn_Style3��5A      $��Style 3��6D   $��10q�6V   �� 5B      -   5        $��
btn_Style4��5B      $��Style 4��6D   $��10q�6V   �� 5C      -   5        $��	btn_Cycle��5C      $��Cycle Styles��6B   $��10q�6Y   5D      5E      5F      5G      