   M S B A M L   `   `   `  ����  
mailClient    mailClient.dockPannel   5      W SPresentationCore, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35R NWindowsBase, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35\ XPresentationFramework, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35U QWPFToolkit, Version=3.5.40128.1, Culture=neutral, PublicKeyToken=31bf3856ad364e35^ ZWindowsFormsIntegration, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35H 9http://schemas.microsoft.com/winfx/2006/xaml/presentation      5      R NSystem.Xaml, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089:x,http://schemas.microsoft.com/winfx/2006/xaml     5      Jmc;http://schemas.openxmlformats.org/markup-compatibility/2006     5      @d2http://schemas.microsoft.com/expression/blend/2008     5      $��684.5��5   #     � 	Resources  5         moveDown �� TargetProperty �� 
TargetName9  3System.Windows.Media.Animation.EasingDoubleKeyFrame O� KeyTime O� Value 
 moveUp  dockShow  dockDisappear��%`  &	        &	 �     &	 �    &	 �    �� 5	      .��5
      U� $U O(UIElement.RenderTransform).(TransformGroup.Children)[3].(TranslateTransform.Y)�6#   $
 grid��6�   .\�5        $ 0��6'   $	 -40Q�63     5      $ 0:0:0.5��6   $ 0Q�6-   5      5      �� 5   
   .��5      U� $U O(UIElement.RenderTransform).(TransformGroup.Children)[3].(TranslateTransform.Y)�6,   $
 grid��6�   .\�5        $ 0��6'   $ 0Q�63     5      $ 0:0:0.5��6'   $	 -40Q�69   5      5      �� 5   
   .��5      U� $ (UIElement.Opacity)�6)   $
 grid��6Y   .\�5        $ 0��6!   $ 0Q�6-     5      $ 0:0:0.5��6!   $ 1Q�63   5      5      �� 5   
   .��5      U� $ (UIElement.Opacity)�6)   $
 grid��6Y   .\�5        $ 0:0:0.7��6!   $ 0Q�63   5      5      5       .��5!      � -   5         �Name$
 grid��5!      $	��150��6   $��Bottom=�6&   $
��Left=�6A   $��684.5��6\    J� RenderTransformOrigin$ 0.5,0.5&�6j   z�5"      V� 5#      .~�5$   	   �� �� 5%   	   �� 5&   	   T� 5'   	   5(   	   .+�5*      �� -   5         ��Name$ 	rectangle��5*       �� RadiusX$ 20��6+   	 �� RadiusY$	 20��68   $ 0.5,0.5&�6E   $	��150��6e   
 J� Opacity$	
 0.7Q�6r   z�5+      V� 5,      .~�5-      �� �� 5.      �� 5/      T� 50      51      ��53      �� 54       �� EndPoint$ 0.5,1&�6$    �� 
StartPoint$ 0.5,0&�65   .��55      �  � Color$ 	#FF619DCA��6   � 56      $ 	#FF020D18��6    � Offset$ 0.586Q�60   57      58   !   �� 59      -   5        $��sendMail��59      $
��Left=�6%   $��98.5,4,0,64q�6@   $��image/메일.png��6U   $
��Fill=�6k   $��81��6z    � Cursor$
 Hand��6�    J� Effect 5:      3  -System.Windows.Media.Effects.DropShadowEffect  5;         Color$ White��6!      Opacity$	 0.5Q�6/      ShadowDepth$ 3Q�6=      
BlurRadius$ 10Q�6M   5=      �� 5>      -   5        $��graphBtn��5>      $��307,-7,286,64q�6$   $��image/전송중2.png��6;   $
��Fill=�6S   $
 Hand��6b   �� 5?      -   5        $��
settingBtn��5?      $��505,11,0,64q�6&   $��image/설정.png��6;   $
��Fill=�6Q   $
��Left=�6`   $��75��6{   $
 Hand��6�   5@      5A      