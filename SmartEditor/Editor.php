<script type="text/javascript" src="js/HuskyEZCreator.js" charset="utf-8"></script>
<p>
<a href="#" onclick="javascript:window.open('uploader.php?id=ir1', 'uploader', 'width=300, height=200');">이미지 삽입</a>
</p>
<textarea name="ir1" id="ir1" style="width:100%; height:100%"></textarea>
<script type="text/javascript">
	var oEditors = [];
	nhn.husky.EZCreator.createInIFrame({
		oAppRef: oEditors,
		elPlaceHolder: "ir1",
		sSkinURI: "SEditorSkin.html",
		fCreator: "createSEditorInIFrame"
	});
function pasteHTMLDemo(id, sHTML){
    oEditors.getById[id].exec("PASTE_HTML", [sHTML]);
}

function getHTML(){
	alert(oEditors.getById["ir1"].getIR());
}
</script>
