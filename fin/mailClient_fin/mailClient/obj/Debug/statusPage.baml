   M S B A M L   `   `   `  ����|  xSystem.Windows.Controls.DataVisualization.Toolkit, Version=3.5.40128.1, Culture=neutral, PublicKeyToken=31bf3856ad364e35�{clr-namespace:System.Windows.Controls.DataVisualization.Charting;assembly=System.Windows.Controls.DataVisualization.Toolkit2System.Windows.Controls.DataVisualization.Charting  5       
mailClient   mailClient.statusPage   5      W SPresentationCore, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35R NWindowsBase, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35\ XPresentationFramework, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35U QWPFToolkit, Version=3.5.40128.1, Culture=neutral, PublicKeyToken=31bf3856ad364e35^ ZWindowsFormsIntegration, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35H 9http://schemas.microsoft.com/winfx/2006/xaml/presentation      5      R NSystem.Xaml, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089:x,http://schemas.microsoft.com/winfx/2006/xaml     5      Jmc;http://schemas.openxmlformats.org/markup-compatibility/2006     5      @d2http://schemas.microsoft.com/expression/blend/2008     5      �DVC{clr-namespace:System.Windows.Controls.DataVisualization.Charting;assembly=System.Windows.Controls.DataVisualization.Toolkit     5        N� Title$  
statusPage��5	       � 	Resources 5
         timeStatusGridIn �� TargetProperty �� 
TargetName9  3System.Windows.Media.Animation.EasingDoubleKeyFrame O� KeyTime O� Value   EasingFunction-  'System.Windows.Media.Animation.BackEase7  1System.Windows.Media.Animation.EasingFunctionBase   
EasingMode  timeStatusGridOut  personStatusIn��% 	  &	        &	 *    &	 �    �� 5      .��5      U� $U O(UIElement.RenderTransform).(TransformGroup.Children)[3].(TranslateTransform.X)�6#   $ 
timeStatus��6�   .\�5        $ 0��6   $	 430Q�6'     5      $ 0:0:0.8��6   $	 -16Q�6-    5        5      $ EaseOut=�6   5      5      U� 5      $U O(UIElement.RenderTransform).(TransformGroup.Children)[3].(TranslateTransform.Y)�6#   $ 
timeStatus��6�   .\�5        $ 0��6   $ 1Q�6'     5      $ 0:0:0.8��6   $ 0Q�6-    5        5      $ EaseOut=�6   5      5      U� 5      $ (UIElement.Opacity)�6#   $ 
timeStatus��6S   .\�5        $ 0��6   $ 0Q�6'     5      $ 0:0:0.8��6   $ 1Q�6-    5        5       $ EaseOut=�6   5"      5#      5$      �� 5%      .��5&      U� $U O(UIElement.RenderTransform).(TransformGroup.Children)[3].(TranslateTransform.X)�6#   $ 
timeStatus��6�   .\�5'        $ 0:0:0.7��6   $	 423Q�6-    5(        5)      $ EaseOut=�6   5+      5,      U� 5-      $U O(UIElement.RenderTransform).(TransformGroup.Children)[3].(TranslateTransform.Y)�6#   $ 
timeStatus��6�   .\�5.        $ 0:0:0.7��6   $ 1Q�6-    5/        50      $ EaseOut=�6   52      53      U� 54      $ (UIElement.Opacity)�6#   $ 
timeStatus��6S   .\�55        $ 0:0:0.7��6   $ 0Q�6-    56        57      $ EaseOut=�6   59      5:      5;      �� 5<      .��5=      U� $ (UIElement.Opacity)�6#   $ personStatus��6S   .\�5>        $ 0��6   $ 0Q�6'     5?      $ 0:0:0.7��6   $	 0.8Q�6-    5@        5A      $ EaseOut=�6   5C      5D      U� 5E      $U O(UIElement.RenderTransform).(TransformGroup.Children)[3].(TranslateTransform.X)�6#   $ personStatus��6�   .\�5F        $ 0��6   $	 423Q�6'     5G      $ 0:0:0.7��6   $	 1.5Q�6-    5H        5I      $ EaseOut=�6   5K      5L      U� 5M      $U O(UIElement.RenderTransform).(TransformGroup.Children)[3].(TranslateTransform.X)�6#   $ tabItem��6�   .\�5N        $ 0:0:0.8��6   $ -1Q�6-    5O        5P      $ 	EaseInOut=�6   5R      5S      5T      5U      .��5W      � -   5        $��
statusGrid��5W      
�������.+�5X      � $��8q�6    � ColumnDefinitions 5Y      �� 5Z   	   �� 5[   	   $��1247.308 �6   �� 5\   	   $��20 �6   	 � RowDefinitions	 5^      �� 5_   	   $��0.165* �6   �� 5`   	   $��758.408 �6   �� 5a   	   $��0.835* �6   .+�5c      �� $��8,8,8,-15.296q�6   $��2��6*   $��3��6;   .@�5d      �� $��ServerStatus��6   .��5e      � .+�5f      7  1System.Windows.Forms.Integration.WindowsFormsHost  -   5        $	��CPU��5f   e   $	��250��6+   $
��Left=�68   $��5,12,0,0q�6S   $	��Top=�6p   $	��371��6�     5g      -   5        $��NowCPU��5g   g   $	��250��6+   $
��Left=�68   $��
382,12,0,0q�6S   $	��Top=�6u   $	��324��6�     5h      -   5        $��Memory��5h   f   $	��243��6+   $
��Left=�68   $��	5,268,0,0q�6S   $	��Top=�6t   $	��371��6�     5i      -   5        $��	NowMemory��5i   h   $	��243��6+   $
��Left=�68   $��382,268,0,0q�6S   $	��Top=�6y   $	��324��6�     5j      -   5        $��Network��5j   f   $	��232��6+   $
��Left=�68   $��	5,517,0,0q�6S   $	��Top=�6u   $	��371��6�     5k      -   5        $��
NowNetwork��5k   h   $	��232��6+   $
��Left=�68   $��382,517,0,0q�6S   $	��Top=�6z   $	��324��6�     5l      -   5        $��	SendCount��5l   h   $	��243��6+   $
��Left=�68   $��712,268,0,0q�6S   $	��Top=�6y   $	��281��6�     5m      -	   5        $��NowSendCount��5m   h   $	��243��6+   $
��Left=�68   $��999,268,0,0q�6S   $	��Top=�6|   $	��247��6�     5n      -
   5        $��Thread��5n   g   $	��250��6+   $
��Left=�68   $��
712,12,0,0q�6S   $	��Top=�6u   $	��281��6�     5o      -   5        $��	NowThread��5o   g   $	��250��6+   $
��Left=�68   $��
999,12,0,0q�6S   $	��Top=�6x   $	��247��6�   �� 5p      -   5        
 ��Name$
 button2��5p   p   $
��stop��6!   $��81��60   $
��Left=�6<   $��1011,537.04,0,0q�6W   $	��Top=�6�   $	��112��6�   $��33.333(�6�   �� 5q      -   5        $
 button1��5q   q   $��start��6!   $��81��61   $
��Left=�6=   $��1127,537.04,0,0q�6X   $	��Top=�6�   $	��103��6�   $��33.333(�6�   5r      5s      �� 5t      -   5         ��Name$ tabItem��5t      $��Sending Status��6+    J� RenderTransformOrigin$ 0.5,0.5&�6C   z�5u   
   V� 5v      .~�5w      �� �� 5x      �� 5y      T� 5z      5{      .��5}   
   � -   5        $��
mailStatus��5}   &   ���	#FFE5E5E5.+�5�      �� -   5        $��groupStatus��5�   L   $
��Left=�6   $��8,8,0,8q�6/   $	��267��6@    �� View 5�      �� 5�      .P�5�      �� $��	사용자��6    �� Width$	 120��6*   5�      5�      �� 5�      -   5        $��
timeStatus��5�   )   $��144,8,438,8q�6   $ 0.5,0.5&�6;   z�5�      V� 5�      .~�5�      �� �� 5�      �� 5�      T� 5�      5�       5�      �� 5�      .P�5�      �� $	 600��6   $��발송된 메일��6)   5�      5�      �� 5�      -   5        $��personStatus��5�   O   $��Right=�6   $��0,8,12,8q�60   $	��735��6B   $ 0.5,0.5&�6c   z�5�      V� 5�      .~�5�      �� �� 5�      �� 5�      T� 5�      5�       5�      �� 5�      .P�5�      �� $��상태��6   $	 700��6)   5�      5�      5�      5�   
   5�   	   5�      � 5�      -   5        $��mailPop��5�      $��Scroll=�6    � AllowsTransparency . $��
MousePoint=�6O   .��5�      � ���	#FFE5E5E5$	��345��6$   $��320.667��61   .+�5�   	   �� -   5        $��mailPopClose��5�      $��X��6@   $��Right=�6L   $��20��6h   $��0,8,8,0q�6t   $	��Top=�6�   $��20.667��6�   $��10.667(�6�   �� 5�   	   -   5        $��removeMailSend��5�      $��발송 취소��6D   $��20��6T   $��8,8,42.167,0q�6`   $	��Top=�6v   $��10.667(�6�   �� 5�   	   -   5         ��Name$ cordText��5�      $��	13,44,8,8q�6$    5�   
   �� 5�      .P�5�      �� $��cord 값��6   $	 280��6+   5�      5�   
   5�   	   5�      5�      5�      