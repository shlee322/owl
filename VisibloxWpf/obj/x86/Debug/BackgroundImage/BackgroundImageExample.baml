   M S B A M L   `   `   `  ����Y  UVisiblox.Charts, Version=2.0.8.5757, Culture=neutral, PublicKeyToken=1543c03f04c4461bJ6clr-namespace:Visiblox.Charts;assembly=Visiblox.ChartsVisiblox.Charts  5      \ XVisiblox.Charts.Examples.Wpf.Free, Version=1.0.0.0, Culture=neutral, PublicKeyToken=nullc6clr-namespace:Visiblox.Charts.Examples.BackgroundImage(Visiblox.Charts.Examples.BackgroundImage 5      E   ?Visiblox.Charts.Examples.BackgroundImage.BackgroundImageExample   5      \ XPresentationFramework, Version=3.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35R NWindowsBase, Version=3.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35W SPresentationCore, Version=3.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35D 9http://schemas.microsoft.com/winfx/2006/xaml/presentation    5      8x,http://schemas.microsoft.com/winfx/2006/xaml    5      >d2http://schemas.microsoft.com/expression/blend/2008    5      Hmc;http://schemas.openxmlformats.org/markup-compatibility/2006    5      Gcharts6clr-namespace:Visiblox.Charts;assembly=Visiblox.Charts    5      Flocal6clr-namespace:Visiblox.Charts.Examples.BackgroundImage    5      $	��350��5	      $	��600��6     � 	Resources  5
      F  @Visiblox.Charts.Examples.BackgroundImage.DateDoubleDataPointList   	ChartDataB  <Visiblox.Charts.Examples.BackgroundImage.DateDoubleDataPoint   X2   ,Visiblox.Charts.Primitives.DateTimeConverter   Y �� 
TargetType  ChartPlotAreaStyle �� Property �� Value �� ImageSource �� Opacity  BarBrush �� Color  ColumnNormalStyle"   Visiblox.Charts.ColumnSeries+   %Visiblox.Charts.BarOrColumnSeriesBase  NoBorder  CustomTooltipTemplate	 �� Orientation��%  &	        &	 E    &	 �    &	 �    7  &	 M    &	 �      5   
     5      $ 
2000-01-01 6(   $ 62Q�67     5      $ 
2001-01-01 6(   $ 59Q�67     5      $ 
2002-01-01 6(   $ 87Q�67     5      $ 
2003-01-01 6(   $	 105Q�67     5      $ 
2004-01-01 6(   $	 124Q�67     5      $ 
2005-01-01 6(   $	 131Q�67     5      $ 
2006-01-01 6(   $	 147Q�67     5      $ 
2007-01-01 6(   $	 149Q�67     5      $ 
2008-01-01 6(   $	 168Q�67     5      $ 
2009-01-01 6(   $	 164Q�67     5      $ 
2010-01-01 6(   $	 167Q�67   5      �� 5   
   " �6   .�5      ��  � �� 5      �� 5      $ background.jpg��6!   $
 0.12Q�6>   5      5       �� 5"   
   $ 	#FF9E9E9E��6+   $	 0.7Q�6=   �� 5#   
   "  6*   .�5$      ��  �@ 	PointFill8   6*   5%      �� 5(   
   " ��6!   .�5)      ��  � ��$ 0q�60   �� 5*       � ��
 �   �6,   5+      �� 5.   
   .R�5/      �� 
���   �$��1q�6)   $��15,0,0,0q�6=   ._�50      � $��0q�6   
�������.+�51      �� $	 
Horizontal=�6!   .+�52      �� ��6$   �� *Y+�� 53      $��,000 units sold��6$   54      55      56      57      58      .��5:      � -   5        
 �Name$
 
LayoutRoot��5:      $��10q�6   .+�5<   
      Visiblox.Charts.Chart  -   5          Name$ BackgroundChart��5<      $	��575��60      Visiblox.Charts.ChartBase   PlotAreaStyle# [ 6<   $��Arial)�6p      LegendVisibility$ 	Collapsed=�6�      PlotAreaBorderStyle# [ 6�      	Behaviour 5D      #   Visiblox.Charts.ZoomBehaviour  5E         XAxis 5H      "	   Visiblox.Charts.DateTimeAxis	  5I      �
   zVisiblox.Charts.AxisBase`1[[System.DateTime, mscorlib, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089]] 
  ShowMinorTicks .   
  ShowGridlines .  �   �Visiblox.Charts.AxisCommonBase`1[[System.DateTime, mscorlib, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089]]   MajorTickInterval$ 1Q�6S    	  MajorTickIntervalType$ Years=�6i    
  ShowMajorTicks .  6�      YAxis 5K          Visiblox.Charts.LinearAxis  5L      ~   xVisiblox.Charts.AxisBase`1[[System.Double, mscorlib, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089]]   ShowGridlines .     ShowMinorTicks .  �   ~Visiblox.Charts.AxisCommonBase`1[[System.Double, mscorlib, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089]]   LabelFormatString$ N0��6Q      Title$ Units Sold (thousands)��6h      MajorTickInterval$ 20Q�6�      Series 5P        +   %Visiblox.Charts.ChartSeriesCommonBase   NormalStyle# [ 6&      ToolTipEnabled .    ToolTipTemplate# [ 6m       
DataSeries  5Q      (   "Visiblox.Charts.BindableDataSeries  5R      -   5        bindableSeries��!   ItemsSource#! [  5U   '   "   XValueBinding" 5S   '   �� # �� Path$# X�$   YValueBinding$ 5T   '   �� $# Y�5V      5X      5Z      5[      5\      