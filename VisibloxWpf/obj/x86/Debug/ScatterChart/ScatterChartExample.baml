   M S B A M L   `   `   `  ����Y  UVisiblox.Charts, Version=2.0.8.5757, Culture=neutral, PublicKeyToken=1543c03f04c4461bJ6clr-namespace:Visiblox.Charts;assembly=Visiblox.ChartsVisiblox.Charts  5      % !Visiblox.Charts.Examples.Wpf.Free?   9Visiblox.Charts.Examples.ScatterChart.ScatterChartExample   5      \ XPresentationFramework, Version=3.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35R NWindowsBase, Version=3.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35W SPresentationCore, Version=3.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35D 9http://schemas.microsoft.com/winfx/2006/xaml/presentation    5      8x,http://schemas.microsoft.com/winfx/2006/xaml    5      >d2http://schemas.microsoft.com/expression/blend/2008    5      Hmc;http://schemas.openxmlformats.org/markup-compatibility/2006    5      Gcharts6clr-namespace:Visiblox.Charts;assembly=Visiblox.Charts    5      $	��400��5      $	��600��6     � 	Resources  5
         NoBorder �� 
TargetType �� Property �� Value  	RedColour �� Color  
BlueColour  GreenColour��%�   &	        &	 m     &	 �     &	 �     �� 5   
   " ��6!   .�5      ��  � ��$ 0q�60   �� 5       � ��
 �   �6,   5      �� 5   
   $ 	#FFD77171��6,   �� 5   
   $ 	#FF82A2CD��6-   �� 5   
   $ 	#FF91BF70��6.   5      .��5      � -   5         �Name$ 
LayoutRoot��5      
������� � ColumnDefinitions 5   
   �� 5      $	��80* �6   �� 5      $	��20* �6   .+�5   
      Visiblox.Charts.Chart  -   5        $��ScatterChart��5      $��0��6+      Visiblox.Charts.ChartBase   Title$+ %Age vs Rank of the UK's Elite Runners��6<   $	��475��6j   $��Arial)�5         PlotAreaBorderStyle# [  6*   	   LegendVisibility$	 	Collapsed=�6Z   $��Center=�5      
   	Behaviour
 5      &    Visiblox.Charts.BehaviourManager  5          AllowMultipleEnabled .    
Behaviours. 5!      #   Visiblox.Charts.ZoomBehaviour  5"         XAxis 5$          Visiblox.Charts.LinearAxis  5%      �   ~Visiblox.Charts.AxisCommonBase`1[[System.Double, mscorlib, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089]]   Title$
 Rank��6$   ~   xVisiblox.Charts.AxisBase`1[[System.Double, mscorlib, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089]]   ShowGridlines .     ShowMinorTicks .     LabelFormatString$ 0��6^      Range 5'      !   Visiblox.Charts.DoubleRange  5(      	   yVisiblox.Charts.RangeBase`1[[System.Double, mscorlib, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089]] 	  Minimum$ 0Q�6.    	  Maximum$	 200Q�6:   5*         YAxis 5,        5-       .  $	 Age��6;    .  $ 0��6]    5.        5/      $ 15Q�6-   $ 55Q�6:   51         Series 54       
   Visiblox.Charts.LineSeries
  -   5         
 Name$ FifteenHundredSeries��54   (    
  ShowLine .   
  
ShowPoints .  
  	PointSize$ 6Q�6i    
  	PointFill# [ 6w   
  55      -   5        $ TenThousandSeries��55   (    .   . $ 6Q�6f   # [ 6t   
  56      -   5        $ MarathonSeries��56   (    .   . $ 6Q�6c   # [ 6q   58      �� 5;   
    �� Orientation$ Vertical=�6   $��1��6,   $	��Top=�6<   $��Center=�6T   $��0,30,0,0q�6q   .+�5=      �� $ 
Horizontal=�6   .+�5>      A� $��0,0,5,2q�6   $��10��6+   $��10��67   $��Bottom=�6�   ��6B   ��  �� ElementName$ ScatterChart�� �� Path$ Series[2].PointFill�6�   �� 5?      $��Marathon��6   $��0,0,4,0q�6,   �� 5@      -   5         ��Name$ Marathon��5@        d� 	IsChecked$
  TrueY�6-   6>   5A      �� 5C      $ 
Horizontal=�6   .+�5D      A� $��0,0,5,2q�6   $��10��6+   $��10��67   $��Bottom=�6�   ��6B   �� $ ScatterChart��$ Series[1].PointFill�6�   �� 5E      $	��10k��6   $��0,0,36,0q�6'   �� 5F      -   5        $ TenThousand��5F      $
  TrueY�60   6A   5G      �� 5I      $ 
Horizontal=�6   .+�5J      A� $��0,0,5,2q�6   $��10��6+   $��10��67   $��Bottom=�6�   ��6B   �� $ ScatterChart��$ Series[0].PointFill�6�   �� 5K      $��1500m��6   $��0,0,18,0q�6)   �� 5L      -   5        $ FifteenHundred��5L      $
  TrueY�63   6D   5M      5O      5Q      5R      