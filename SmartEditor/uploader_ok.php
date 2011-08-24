<?php
function show_msg($msg, $url) {
    echo "<meta HTTP-EQUIV='CONTENT-TYPE' content='text/html;charset=UTF-8'>
            <script language=\"JavaScript\">
              alert(\"$msg\"); 
             document.location.replace(\"$url\");
            </script>";
}

$max_file_size  = 1024000;
$uploaddir = 'upload/'; //서버에 저장될 디렉토리의 권한은 777로 해둔다.
$url = "uploader.php?id=".$_POST['id']; //에러 발생 시 돌아갈 URL


if($_FILES['uploadedfile']['name'] != "") {
        // 중복되지 않는 파일로 만든다
        $tmpfile = $uploaddir.substr(md5(uniqid($g4[server_time])),0,8)."_".$_FILES['uploadedfile']['name'];
        
        //공백이 있는 파일명을  "_"로 수정
        $tmpfile =  str_replace(" ","_", $tmpfile);
        $filename = $tmpfile; 
    
        $chk_file = explode('.', $filename);
        $extension = $chk_file[sizeof($chk_file)-1];
    
        if($extension == 'html' || $extension == 'htm' || $extension == 'php' || $extension == 'asp' || $extension == 'jsp' || $extension == 'exe') {            
                $errmsg = $_FILES['uploadedfile']['name'].' 파일은 금지된 확장자입니다.';
                show_msg($errmsg, $url);
                exit;
        }
                
        //파일용량 확인 
        if($_FILES['uploadedfile']['size'] > $max_file_size) {
            $errmsg = $_FILES['uploadedfile']['name'].' 파일 용량이 너무 큽니다.';
            show_msg($errmsg, $url);
            exit;
        }
            
        move_uploaded_file($_FILES["uploadedfile"]["tmp_name"], $filename);
        
  } 

?>
<meta http-equiv='Refresh' content='0; URL="uploader.php?mode=ok&amp;id=<?=$_POST['id']?>&amp;file=<?=$filename?>" ' />
