   M S B A M L   `   `   `  ����  
mailClient    mailClient.sendingPage   5      W SPresentationCore, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35R NWindowsBase, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35\ XPresentationFramework, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35U QWPFToolkit, Version=3.5.40128.1, Culture=neutral, PublicKeyToken=31bf3856ad364e35F 9http://schemas.microsoft.com/winfx/2006/xaml/presentation     5      R NSystem.Xaml, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089:x,http://schemas.microsoft.com/winfx/2006/xaml     5      Jmc;http://schemas.openxmlformats.org/markup-compatibility/2006     5      @d2http://schemas.microsoft.com/expression/blend/2008     5      -   5          N�Name$
  page��5       J� 	AllowDrop .  N� Title$ sendingPage��5	       � 	Resources 5
         pageShow �� TargetProperty �� 
TargetName9  3System.Windows.Media.Animation.EasingDoubleKeyFrame O� KeyTime O� Value   EasingFunction-  'System.Windows.Media.Animation.BackEase7  1System.Windows.Media.Animation.EasingFunctionBase	   
EasingMode  DataTemplate1��%)  &	        &	 �     �� 5      .��5      U� $ (UIElement.Opacity)�6#   $
 page��6S   .\�5        $ 0��6   $ 0Q�6'     5      $ 0:0:1��6   $ 1Q�6+    5        5      $	 EaseOut=�6   5      5      5      �� 5      .R�5      � $��21��6
   $	��240��6   .+�5      �� $
��name��6   $
��Left=�6   $��0q�67   $
��Wrap=�6B   $	��103��6o   ��6V   �� *	rpcname+6o   �� 5      $
��mail��6   $��	107,0,0,0q�6   $
��Wrap=�60   ��6D   �� *	rpcmail+5      5      5      .��5      � -   5        $��sendingGrid��5      
�������.+�5   
   � $��433.66,8,8,89q�6   .+�5      �� 
���   �$��2q�6#   (  "System.Windows.Controls.WebBrowser  5       -   5        
  Name$
 editor��5       $��	8,103,8,8q�6$   �� 5!      $��30��6   $��142.5,9.207,24,0q�6    �� TextWrapping$
 Wrap=�66   $	��Top=�6J   $��16(�6b   �� 5"      $
��Left=�6   $��35��6-   $��	12,10,0,0q�69   $
��Wrap=�6L   $	��Top=�6`   $	��117��6x    J� RenderTransformOrigin$ 1.296,0.722&�6�   $��20(�6�   $
��Bold"�6�   �� 6�    � Language$ ko-kr�6�   $�보내는 사람��6�   6�   �� 5#      $
��Left=�6   $��35��6-   $��12,65.5,0,0q�69   $
��Wrap=�6N   $	��Top=�6b   $	��117��6z   $ 1.296,0.722&�6�   $��20(�6�   $
��Bold"�6�   �� 6�   $ ko-kr�6�   $�  제   목  ��6�   6�   �� 5$      $��30��6   $��142.5,65.5,24,0q�6   $
 Wrap=�65   $	��Top=�6I   $��16(�6a   5%      �� 5&   
   -   5         ��Name$ addressList��5&      $
��Left=�6'   $��8,115.5,0,153q�6B   $	��400��6Y   $��2q�6�   
���   �6�   �� 5'   
   -   5         ��Name$ getBtn��5'      $��가져오기��6"   $
��Left=�61   $��41��6L   $��	18,0,0,89q�6X   $��Bottom=�6k   $	��184��6�   �� 5(   
   $��주소록관리��6   $
��Left=�6!   $��41��6<   $��
224,0,0,89q�6H   $��Bottom=�6\   $	��184��6w   � 5)   
   -   5        $	��pop��5)   Y   $��
MousePoint=�6    � AllowsTransparency . $��Scroll=�6A   .��5*      � ���	#FFE5E5E5$	��327��6'   $��242.667��64   .+�5+      �� -   5        $��
personList��5+      $
��Left=�6(   $��8,26,0,8q�6C   $��226.667��6U   #���  6e    �� View 5,      �� 5-      .P�5.      �� $
��name��6-    �� Width$ 80��6;   �� 5/      $
��mail��6-   $	 140��6;   50      52      �� 53      -   5        $��popClose��53   �   $��X��6   $
��Left=�6   $��18��6:   $��8,4,0,0q�6F   $	��Top=�6W   $��24.667��6o   $��9.333(�6~   6�   �� 54      -	   5        $��deleteAddress��54      $��주소록 삭제��6E   $��Right=�6V   $��20.903��6r   $��0,1.097,8,0q�6�   $	��Top=�6�   $��81.333��6�   $��10.667(�6�   55      56      � 57   
   -
   5        $��infoGrid��57   n   $
��Left=�6   $��103.5��6*   $��8,8,0,0q�69   $	��Top=�6J   $	��400��6b   .+�58      �� 
���   �$��2q�6&   59      �� 5:   
   -   5        $
��send��5:   �   $
��send��6   $��Right=�6    $��32��6<   $��0,0,8,44q�6H   $��Bottom=�6Z   $	��206��6u   6�   5<      5=      