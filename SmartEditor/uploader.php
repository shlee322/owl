<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<head>
<script type="text/javascript">
function putImg(id, file) {
    opener.pasteHTMLDemo(id, file);
    self.close();
}
</script>
</head>

<body>
<?php
if($_GET['mode'] == "ok") {
?>
 <p>image uploaded!</p>
    <a href="#" onclick="javascript:putImg('<?=$_GET['id']?>', '<img src=http://www.owl.or.kr/SmartEditor/<?=$_GET['file']?>>');">확인</a>
<?php
}else {
?>
<form action="uploader_ok.php" enctype="multipart/form-data" method="post">
<input type="hidden" name="id" value="<?=$_GET['id']?>" />
<input type="file" name="uploadedfile" /><input type="submit" value="업로드" />
</form>
<?php
}
?>
</body>
