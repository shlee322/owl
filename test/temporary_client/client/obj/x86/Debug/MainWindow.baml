   M S B A M L   `   `   `  ����Y  UDynamicDataDisplay, Version=0.3.0.0, Culture=neutral, PublicKeyToken=5b7d744a7263923fyOclr-namespace:Microsoft.Research.DynamicDataDisplay;assembly=DynamicDataDisplay%Microsoft.Research.DynamicDataDisplay  5   	   
 client   client.MainWindow   5   	   \ XPresentationFramework, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35W SPresentationCore, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35R NWindowsBase, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35D 9http://schemas.microsoft.com/winfx/2006/xaml/presentation    5   	   \d3Oclr-namespace:Microsoft.Research.DynamicDataDisplay;assembly=DynamicDataDisplay    5   	   R NSystem.Xaml, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089:x,http://schemas.microsoft.com/winfx/2006/xaml     5   	   -   5          � Title$  
MainWindow��5   	   $	��350��6   $	��525��6)    � 	Resources 5       
  fillgu �� TargetProperty �� 
TargetName9  3System.Windows.Media.Animation.EasingDoubleKeyFrame O� KeyTime O� Value   EasingFunction-  'System.Windows.Media.Animation.BackEase7  1System.Windows.Media.Animation.EasingFunctionBase   
EasingMode��%�   &	        �� 5      .��5      U� $ (UIElement.Opacity)�6#   $	 rec��6S   .\�5	        $ 0��6   $ 0Q�6'     5
      $ 0:0:2��6   $ 1Q�6+    5        5      $ 	EaseInOut=�6   5      5      5      5       � Triggers 5      :� 5      	 :� RoutedEvent$	 FrameworkElement.Loaded��6   .[�5      �� #��[  6   5      .��5      �� .+�5   
   � -   5        
 �Name$
 leftTop��5      $
��Left=�6    $	��136��6;   $��8,8,0,0q�6H   $	��Top=�6Y   $	��400��6q   .+�5      8   2Microsoft.Research.DynamicDataDisplay.ChartPlotter  -   5        $��plotter��5      $��
0,-8,0,-49q�6-   3   -Microsoft.Research.DynamicDataDisplay.Plotter   Children. 5      2   ,Microsoft.Research.DynamicDataDisplay.Header  $��
test_graph��6   5      5      �� 5   
   -   5        $��textBox��5   @    �� Left$ 26��6   
 �� Top$	 207��6#   $��34��64   $	��263��6O   �� 5   
   -   5        $��button1��5   Q   $	 324��6   $	 218��6#   $��Button��64   $��23��6E   $��75��6`   6k   �� 5   
   -   5        $	��rec��5      $��81��6   $	 425��6+   
���   �$	 172��6L   $��41��6]   ��5       �� 5!       �� EndPoint$ 0.5,1&�6     �� 
StartPoint$ 0.5,0&�61   .��5"      �  � Color$ Black��6    � Offset$ 0Q�6(   � 5#      $ 	#FFF72525��6   $ 1Q�6,   5$      5&      5'      5(      