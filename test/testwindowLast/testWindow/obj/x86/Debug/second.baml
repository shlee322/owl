   M S B A M L   `   `   `  ����  
testWindow    testWindow.second   5      \ XPresentationFramework, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35W SPresentationCore, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35R NWindowsBase, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35D 9http://schemas.microsoft.com/winfx/2006/xaml/presentation    5      R NSystem.Xaml, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089:x,http://schemas.microsoft.com/winfx/2006/xaml     5      Jmc;http://schemas.openxmlformats.org/markup-compatibility/2006     5      @d2http://schemas.microsoft.com/expression/blend/2008     5      -   5          N�Name$
  page��5       N� Title$ second��5       N� 
Background �	#FF4B4B4B � 	Resources 5	         	logInDone �� TargetProperty �� 
TargetName9  3System.Windows.Media.Animation.EasingDoubleKeyFrame O� KeyTime O� Value   EasingFunction-  'System.Windows.Media.Animation.BackEase7  1System.Windows.Media.Animation.EasingFunctionBase	   
EasingMode  	clearMail  
clearChart��%�  &	        &	 �     &	 �    �� 5
      .��5      U� $ (UIElement.Opacity)�6#   $
 page��6S   .\�5        $ 0��6   $ 0Q�6'     5      $ 0:0:2.1��6   $ 1Q�6-    5        5      $	 EaseOut=�6   5      5      5      �� 5      .��5      U� $, &(UIElement.Effect).(BlurEffect.Radius)�6#   $
 mail��6f   .\�5        $ 0:0:1.1��6   $ 0Q�6-    5        5      $	 EaseOut=�6   5      5      5      �� 5      .��5      U� $, &(UIElement.Effect).(BlurEffect.Radius)�6#   $ chart��6f   .\�5        $ 0:0:1.1��6   $ 0Q�6-    5         5!      $	 EaseOut=�6   5#      5$      5%      5&      .��5'      � 
���   �.+�5(   
   �� -   5        $
��mail��5(      $��168,196.5,0,247.5q�6   $��Icon/Mail.png��67   $
��Fill=�6N   $
��Left=�6^   $	��256��6y   
 � Cursor$

 Hand��6�    J� Effect 5)      -  'System.Windows.Media.Effects.BlurEffect  5*         Radius$ 10Q�6   5,      �� 5-   
   -   5        $��chart��5-      $��Right=�6   $��0,241.5,168,247.5q�69   $��Icon/bar_chart_256.png��6T   $
��Fill=�6t   $	��211��6�   $

 Hand��6�    5.        5/      $ 10Q�6   51      52      53      