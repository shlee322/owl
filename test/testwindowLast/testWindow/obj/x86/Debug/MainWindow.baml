   M S B A M L   `   `   `  ����  
testWindow    testWindow.MainWindow   5   	   \ XPresentationFramework, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35W SPresentationCore, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35R NWindowsBase, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35D 9http://schemas.microsoft.com/winfx/2006/xaml/presentation    5   	   R NSystem.Xaml, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089:x,http://schemas.microsoft.com/winfx/2006/xaml     5   	   -   5        $��
mainWindow��5   6     � Title$  
MainWindow��6	   $	��700��6   $
��1024��6)   ���	#FF4B4B4B � 	Resources 5       	  logIn �� TargetProperty �� 
TargetName9  3System.Windows.Media.Animation.EasingDoubleKeyFrame O� KeyTime O� Value   EasingFunction-  'System.Windows.Media.Animation.BackEase7  1System.Windows.Media.Animation.EasingFunctionBase   
EasingMode  
startBoard��%�  &	        &	 �     �� 5      .��5      U� $ (UIElement.Opacity)�6#   $ 	firstPage��6S   .\�5        $ 0:0:1.0��6   $ 0Q�6-    5	        5
      $ EaseOut=�6   5      5      5      �� 5      .��5      U� $, &(UIElement.Effect).(BlurEffect.Radius)�6#   $ 
mainWindow��6f   .\�5        $ 0��6   $ 20Q�6'     5      $ 0:0:1��6   $ 0Q�6+   5      5      5       J� Effect 5      -  'System.Windows.Media.Effects.BlurEffect  5      	 � Triggers	 5      :� 5      
 :� RoutedEvent$
 FrameworkElement.Loaded��6   .[�5      �� #��[ 6   5      .��5      � -   5        $��	firstPage��5      
���   �.+�5      �� -   5        $��textId��5      $��52��6   $��157.333,0,137,180q�6*    �� TextWrapping$
 Wrap=�6E   $��ID��6Y   $��Bottom=�6c   $��26.667(�6~   G� 5    
   -   5        $��
textPasswd��5       $��52��6(   $��157.333,0,137,94q�64   $��Bottom=�6N   $��26.667(�6i   $��맑은 고딕)�6{   �� 5!   
   -   5        $��Login��5!      $��Right=�6!   $��33.334��6=   $��
0,0,137,21q�6M   $��Bottom=�6a   $��110.667��6|   $��21.333(�6�   $��Century Gothic)�6�   $
��Bold"�6�   �� 5"   
   $��342,72,382,306q�6   $��logo/owl.bmp��6(   $��UniformToFill=�6>   5#      5$      