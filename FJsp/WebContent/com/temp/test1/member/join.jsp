<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width", initial-scale="1">
<title>JSP BBS WebSite</title>
<link rel="stylesheet" href="/css/bootstrap.css" >
<script type="text/javascript" src="/js/jquery-3.4.1.min.js" ></script>
<script type="text/javascript" src="/js/bootstrap.js"></script>
<style>
</style>
</head>
<body> 
	<nav class="navbar navbar-default">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
					aria-expanded="false">
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="main.jsp">JSP 게시판 웹사이트</a>
		</div>
		<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li><a href="main.jsp">메인</a>
				<li><a href="bbs.jsp">게시판</a>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown">
					<a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="ture"
						aria-expanded="false">접속하기<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="login.jsp">로그인</a></li>
						<li class="active"><a href="join.jsp">회원가입</a></li>
					</ul>
				</li>
			</ul>
		</div>
	</nav>
	<div class="container">
		<div class="col-lg-4"></div>
		<div class="col-lg-4">
			<div class="jumbotron" style="padding-top:20px;">
				<form method="post" action="joinAction.jsp">
					<h3 style="text-align:center;">회원가입 화면</h3>
					<div class="form-group">
						<label>아이디</label>
						<input type="text" class="form-control" placeholder="id" name="userID" maxlength="20" id="id">
						<input type="button" id="btn" value="아이디중복확인" class="btn btn-primary">
					</div>
					<div class="alert alert-success" id="id_success">사용가능한 아이디입니다.</div> 
					<div class="alert alert-danger" id="id_fail">이미 사용중인 아이디입니다.</div>
					<script type="text/javascript">
						$(function(){
							$('#id_success').hide();
							$('#id_fail').hide();
							$('#btn').click(function(){
								var sid = $('#id').val();
								$.ajax({
									url : "/member/IdCheck.ck",
									type : "post",
									dataType : "json",
									data : {
										id : sid
									},
									
									success : function(data){
										var ck = data.cnt;
										if(ck == 1){
											// 이미 회원 가입한 사람이 있는 경우
											$('#id').val("");
											$('#id_fail').show();
										} else {
											// 아직 해당아이디로 회원가입한 사람이 없는 경우
											// 따라서 사용할 수 있는 아이디
											$('#id_success').show();
										}
									},
									error : function(request, status, error){
										//alert('### 통신 에러 ###');
										alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
									}
								});
							});
						});
					</script>
					<div class="form-group">
						<label>비밀번호</label>
						<input type="password" class="form-control" placeholder="비밀번호" name="userPassword" maxlength="20" id="pwd1">
					</div>
					<div class="form-group">
						<label>비밀번호 확인</label>
						<input type="password" class="form-control" placeholder="비밀번호확인" name="pwcheck" maxlength="20" id="pwd2">
					</div>
					<div class="alert alert-success" id="alert-success">비밀번호가 일치합니다.</div> 
					<div class="alert alert-danger" id="alert-danger">비밀번호가 일치하지 않습니다.</div>

					<script type="text/javascript"> 
						$(function(){ 
							$("#alert-success").hide(); 
							$("#alert-danger").hide(); 
							$("#pwd2").keyup(function(){ 
								var pwd1=$("#pwd1").val(); 
								var pwd2=$("#pwd2").val(); 
								if(pwd1 != "" || pwd2 != ""){ 
									if(pwd1 == pwd2){ 
										$("#alert-success").show(); 
										$("#alert-danger").hide(); 
										$("#submit").removeAttr("disabled"); 
									}else{ 
										$("#alert-success").hide(); 
										$("#alert-danger").show(); 
										$("#submit").attr("disabled", "disabled"); 
									} 
								} 
							}); 
						}); 
					</script>
					
					<div class="form-group">
						<label>이름</label>
						<input type="text" class="form-control" placeholder="이름" name="userName" maxlength="20">
					</div>
					<div class="form-group">
						<label>전화번호</label>
						<input type="text" class="form-control" placeholder="전화번호" name="userTel" maxlength="20">
					</div>
					<div class="form-group">
						<label>이메일</label>
						<input type="email" class="form-control" placeholder="이메일" name="userEmail" maxlength="20">
					</div>
					<input type="submit" class="btn btn-primary form-control" value="회원가입">
				</form>
			</div>
		</div>
		<div class="col-lg-4"></div>
	</div>
</body>
</html>