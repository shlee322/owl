   M S B A M L   `   `   `  ����Y  UVisiblox.Charts, Version=2.0.8.5757, Culture=neutral, PublicKeyToken=1543c03f04c4461bJ6clr-namespace:Visiblox.Charts;assembly=Visiblox.ChartsVisiblox.Charts  5      % !Visiblox.Charts.Examples.Wpf.FreeE   ?Visiblox.Charts.Examples.PaletteChanging.PaletteChangingExample   5      \ XPresentationFramework, Version=3.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35R NWindowsBase, Version=3.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35W SPresentationCore, Version=3.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35D 9http://schemas.microsoft.com/winfx/2006/xaml/presentation    5      8x,http://schemas.microsoft.com/winfx/2006/xaml    5      >d2http://schemas.microsoft.com/expression/blend/2008    5      Hmc;http://schemas.openxmlformats.org/markup-compatibility/2006    5      Gcharts6clr-namespace:Visiblox.Charts;assembly=Visiblox.Charts    5        � 	Resources  5
         Visiblox.Charts.Palette   
RedPalette �� 
TargetType    Visiblox.Charts.LineSeries �� Property �� Value  GreyPalette  GreenPalette  NoBorder��%a  &	        &	 �     &	 �    &	 �      5   
   �� 5      "  6   .�5      ��  �@ 
LineStroke �	#FFD771716/   �� 5       �@ LineStrokeThickness$	 1.5Q�68   �� 5       �@ 	PointFill �	#FFD771716.   5      5        5   
   �� 5      "  6   .�5      ��  �@ 
LineStroke �	#FF9398986/   �� 5       �@ LineStrokeThickness$ 3Q�68   �� 5       �@ 	PointFill �	#FF9398986.   �� 5       �@ 	PointSize$ 8Q�6.   5      5        5   
   �� 5      "  6   .�5       ��  �@ 
LineStroke �	#FF91BF706/   �� 5!       �@ LineStrokeThickness$ 5Q�68   �� 5"       �@ 	PointFill �	#FF91BF706.   5#      5$      �� 5&   
   " ��6!   .�5'      ��  � ��$ 0q�60   �� 5(       � ��
 �   �6,   5)      5+      .��5-      � -   5         �Name$ 
LayoutRoot��5-      
�������.+�5.   
      Visiblox.Charts.Chart  -   5        $��PaletteChanging��5.         Visiblox.Charts.ChartBase   Title$ Changing Palettes��6/   $	��300��6I   $	��575��6V      Palette# [  6b   $��Arial)�5/         LegendVisibility$ 	Collapsed=�6*      PlotAreaBorderStyle# [ 6G   	   	Behaviour	 50      #   Visiblox.Charts.ZoomBehaviour  51      
   Series
 54           ShowLine .    
ShowPoints . 64      XAxis 57          Visiblox.Charts.LinearAxis  58      ~   xVisiblox.Charts.AxisBase`1[[System.Double, mscorlib, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089]]   ShowMinorTicks .     ShowGridlines .  �   ~Visiblox.Charts.AxisCommonBase`1[[System.Double, mscorlib, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089]]   Range 59      !	   Visiblox.Charts.DoubleRange	  5:      
   yVisiblox.Charts.RangeBase`1[[System.Double, mscorlib, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089]] 
  Minimum$ 0Q�6-    
  Maximum$ 50Q�69   5<         YAxis 5?        5@       .   .   5A      	  5B      $ 0Q�6-   $ 50Q�69   5D      5F      5G      5H      