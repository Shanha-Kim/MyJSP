<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Form tag test</title>
<link rel="stylesheet" href="../css/w3.css">
<script type="text/javascript" src="/js/jquery3.4.1.js"></script>
</head>
<body>
	<br>
	<div class="w3-col m3"><p></p></div>
	<div class="w3-container w3-col w3-half">
		<form method="GET" action="submit-target.jsp" >
			<div class="w3-content "><span>I D :</span><input type="text" name="id"></div>
			<div class="w3-content "><span>P W :</span><input type="password" name="pw"></div>
			<input type="submit" value="btn1">
		</form>
		<br>
		<form method="POST" action="submit-target.jsp" >
			<div class="w3-content "><span>I D :</span><input type="text" name="id"></div>
			<div class="w3-content "><span>P W :</span><input type="password" name="pw"></div>
			<input type="submit" value="btn1-01">
		</form>
		<hr>
		<form method="GET" action="submit-target.jsp" >
			<div class="w3-content "><span>I D :</span><input type="text" name="id2" id="id1"></div>
			<div class="w3-content "><span>P W :</span><input type="password" name="pw2" id="pw1"></div>
			<input type="button" value="btn2" id="btn2">
		</form>
		<hr><br>
		<form method="POST" action="submit-target.jsp" >
			<input type="hidden" name="id" id="id2" value="taeeun">
			<input type="hidden" name="pw" id="pw2" value="9999">
			<input type="submit" value="btn3">
		</form>
	</div>
</body>
<!-- <script type="text/javascript">
	var el=document.getElementById('btn2');
	el.onclick = function(){
		//아이디값 읽고
		var sid = document.getElementById('id1').value;
		var spw = document.getElementById('pw1').value;
		
		document.getElementById('id2').value=sid;
		document.getElementById('pw2').value=spw;
		
		var sid1 = document.getElementById('id2').value;
		var spw1 = document.getElementById('pw2').value;
		
		alert(sid1+' - ' +spw1);
	};
</script> -->
<script>
	$(document).ready(function(){
		$("#btn2").click(function(){
			var sid = $("#id1").val();
			var spw = $("#pw1").val();
			$('#id2').val(sid)
			$('#pw2').val(spw)
			alert($('#id2').val() + ' - '+ $('#pw2').val())
		})
	})
	
</script>
</html>