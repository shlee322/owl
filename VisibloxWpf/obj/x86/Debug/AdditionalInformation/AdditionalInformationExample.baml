   M S B A M L   `   `   `  ����Y  UVisiblox.Charts, Version=2.0.8.5757, Culture=neutral, PublicKeyToken=1543c03f04c4461bJ6clr-namespace:Visiblox.Charts;assembly=Visiblox.ChartsVisiblox.Charts  5      \ XVisiblox.Charts.Examples.Wpf.Free, Version=1.0.0.0, Culture=neutral, PublicKeyToken=nullo<clr-namespace:Visiblox.Charts.Examples.AdditionalInformation.Visiblox.Charts.Examples.AdditionalInformation 5      O Kmscorlib, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e0891&clr-namespace:System;assembly=mscorlibSystem 5      Q   KVisiblox.Charts.Examples.AdditionalInformation.AdditionalInformationExample   5      \ XPresentationFramework, Version=3.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35R NWindowsBase, Version=3.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35W SPresentationCore, Version=3.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35D 9http://schemas.microsoft.com/winfx/2006/xaml/presentation    5      8x,http://schemas.microsoft.com/winfx/2006/xaml    5      >d2http://schemas.microsoft.com/expression/blend/2008    5      Hmc;http://schemas.openxmlformats.org/markup-compatibility/2006    5      Gcharts6clr-namespace:Visiblox.Charts;assembly=Visiblox.Charts    5      Llocal<clr-namespace:Visiblox.Charts.Examples.AdditionalInformation    5      4sys&clr-namespace:System;assembly=mscorlib    5        � 	Resources  5      E  ?Visiblox.Charts.Examples.AdditionalInformation.CourseCollection   Courses;  5Visiblox.Charts.Examples.AdditionalInformation.Course   
CourseName   	Timetable   Lecturer   Score  CustomTooltipTemplate �� Orientation �� Path 
 NoLine �� 
TargetType �� Property	 �� Value  NoBorder��%=  &	        &	      &	 a    &	 �      5   
     5      $ Computer Architecture��6   $ 
Monday 9am��6>   $ 
Len Dahand��6U   $ 37Q�6k     5      $ Software Engineering��6   $ Tuesday 2pm��6=   $ Mike Rowesoft��6U   $ 74Q�6n     5      $ Computer Security��6   $ Wednesday 10am��6:   $ 	Alice Non��6U   $ 56Q�6j     5      $	 UML��6   $ Friday 11am��6,   $ 
Gill Bates��6D   $ 95Q�6Z     5      $$ Algorithms and Data Structures��6   $ Thursday 9am��6G   $ 
Len Dahand��6`   $ 22Q�6v   5      �� 5   
   .R�5      �� 
���   �$��1q�6)   $��15,0,0,0q�6=   ._�5      � $��0q�6   
�������.+�5      �� $ 
Horizontal=�6!   .+�5      �� $��	Click on ��6$   �� 5      ��6$   �� $ 
CourseName��� 5      $�� bar to edit its data��6$   5      5      5      5       �� 5"   
   " ��6   .�5#      ��  � ��$	 0��60   5$      �� 5&   
   " ��6!   .�5'      ��  � ��$	 0q�60   �� 5(       � ��
	 �   �6,   5)      5+      .��5-      � -   5        
 �Name$
 
LayoutRoot��5-      
�������.+�5.   
   �� $ Vertical=�6   .+�50         Visiblox.Charts.Chart  -   5          Name$ CourseInformation��50         Visiblox.Charts.ChartBase   Title$ Data Binding Example��66   $	��575��6S   $	��215��6_   $��Arial)�51         LegendVisibility$ 	Collapsed=�6.      PlotAreaBorderStyle# [ 6K      YAxis 52      "   Visiblox.Charts.CategoryAxis  53      �   }Visiblox.Charts.AxisBase`1[[System.IComparable, mscorlib, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089]]   ShowMajorTicks .     ShowGridlines .  �   �Visiblox.Charts.AxisCommonBase`1[[System.IComparable, mscorlib, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089]]   AxisLineStyle# [ 6W   54         XAxis 56          Visiblox.Charts.LinearAxis  57      ~	   xVisiblox.Charts.AxisBase`1[[System.Double, mscorlib, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089]] 	  ShowGridlines .  	  ShowMinorTicks .  �
   ~Visiblox.Charts.AxisCommonBase`1[[System.Double, mscorlib, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089]] 
  MajorTickInterval$ 10Q�6T    
  Title$ Average Score��6k    
  LabelFormatString$	 0'%��6�    
  Range 58      !   Visiblox.Charts.DoubleRange  59         yVisiblox.Charts.RangeBase`1[[System.Double, mscorlib, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089]]   Minimum$ 0Q�61      Maximum$ 99Q�6=   5;         Series 5>         Visiblox.Charts.BarSeries  +   %Visiblox.Charts.ChartSingleSeriesBase   SelectionMode$ SinglePoint=�6'   +   %Visiblox.Charts.ChartSeriesCommonBase   ToolTipEnabled .    ToolTipTemplate# [ 6Y       
DataSeries  5?      (   "Visiblox.Charts.BindableDataSeries  5@      !   ItemsSource#! [  68   "   YValueBinding" 6_   �� $ 
CourseName�#   XValueBinding# 6�   �� $ Score�5B      5D      �� 5G      -   5        $��CourseDetails��5G   Z   $ Vertical=�6   $	��125��60   $��Center=�6=   $��0,10,0,0q�6o   .+�5H      � $��Center=�6   $ � DataContext$ 5I      �� % �� ElementName$% CourseInformation��& � RowDefinitions& 5J      �� 5K      $
��Auto �6$   �� 5L      $
��Auto �6$   �� 5M      $
��Auto �6$   �� 5N      $
��Auto �6$   �� 5O      $
��Auto �6$   ' � ColumnDefinitions' 5Q      �� 5R      $	��110 �6'   �� 5S      $
��Auto �6'   .+�5V      �� $��Course Name:��6   $��0��60   $��0��6=   �� 5W      -   5        $��
CourseName��5W      $	��200��6�   $��0��6�   $��1��6�   ��60   �� $+ %Series[0].SelectedItems[0].CourseName�( �� Mode$( TwoWay=�) �� ValidatesOnExceptions) . 6�   �� 5Y      $��
Timetable:��6   $��2��6.   $��0��6;   �� 5Z      -   5        $��	Timetable��5Z      $	��200��6w   $��2��6�   $��1��6�   ��6/   �� $* $Series[0].SelectedItems[0].Timetable�$( TwoWay=�6�   �� 5\      $��	Lecturer:��6   $��3��6.   $��0��6;   �� 5]      -   5        $��Lecturer��5]      $	��200��6u   $��3��6�   $��1��6�   ��6.   �� $) #Series[0].SelectedItems[0].Lecturer�$( TwoWay=�6�   �� 5_      $��Average % Score:��6   $��4��64   $��0��6A   �� 5`      -   5        $��AverageScore��5`      $	��200��6�   $��4��6�   $��1��6�   ��62   �� $&  Series[0].SelectedItems[0].Score�$( TwoWay=�) . 6�   5b      �� 5c      -   5        $��AcceptChanges��5c      $��Accept Changes��6J   $	��100��6c   $��0,5,0,0q�6o   $��Right=�6�   5d      5e      5f      5g      