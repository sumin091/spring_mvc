<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    info="파라메터 연습 폼"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="icon" href="http://211.63.98.143/spring_mvc/common/favicon.ico"/>
<!--bootstrap 시작-->
   <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
   <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
<!--bootstrap 끝-->
<link rel="stylesheet" href="http://211.63.98.143/spring_mvc/common/css/main.css" type="text/css" media="all" />
<link rel="stylesheet" href="http://211.63.98.143/spring_mvc/common/css/board.css" type="text/css" media="all" />

<!--jQuery CDN 시작-->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<!--jQuery CDN 끝-->

<style type="text/css">
	
</style>
<script type="text/javascript">
	$(function(){
		$("#btnSingle").click(function(){
			$("#frmGet")[0].action="single_param.do";
			$("#frmGet").submit();
		});//click
		$("#btnSingle2").click(function(){
			$("#frmPost")[0].action="post_single_param.do";
			$("#frmPost").submit();
		});//click
		$("#btnVO").click(function(){
			$("#frmGet")[0].action="../day0605/vo_param.do";
			$("#frmGet").submit();
		});//click
		$("#btnVO2").click(function(){
			$("#frmPost")[0].action="post_vo_param.do";
			$("#frmPost").submit();
		});//click
		$("#btnVO2").click(function(){
			$("#frmPost")[0].action="../day0605/post_vo_param.do";
			$("#frmPost").submit();
		});//click
		$("#btnHsr").click(function(){
			$("#frmGet")[0].action="../day0605/hsr_param.do";
			$("#frmGet").submit();
		});//click
		
		$("#btnHsr2").click(function(){
			$("#frmPost")[0].action="../day0605/post_hsr_param.do";
			$("#frmPost").submit();
		});//click
		
		$("#btnRp").click(function(){
			$("#frmGet")[0].action="../day0605/btn_rp.do";
			$("#frmGet").submit();
		});//click
		
		$("#btnRpVO").click(function(){
			$("#frmGet")[0].action="../day0605/btn_rp.do";
			$("#frmGet").submit();
		});//click
	});//ready
</script>
</head>
<body>
<div>
	<div>
	<h2>GET방식의 요청</h2>
	<form id="frmGet" method="get">
	<label>이름</label>
	<input type="text" name="name" value="박시현"/><br>
	<label>나이</label>
	<input type="text" name="age" value="25"/><br>
	<label>이메일</label>
	<input type="text" name="email" value="test@test.com"/><br>
	<input type="button" value="단일형" class="btn btn-info btn-sm" id="btnSingle"/>
	<input type="button" value="HttpServletRequest" class="btn btn-info btn-sm" id="btnHsr"/>
	<input type="button" value="VO" class="btn btn-info btn-sm" id="btnVO"/>
	<input type="button" value="RequestParam사용" class="btn btn-info btn-sm" id="btnRp"/>
	<input type="button" value="RequestParam을 VO사용" class="btn btn-info btn-sm" id="btnRpVO"/>
		
	</form>
	</div>
	
	<div>
	<h2>POST방식의 요청</h2>
	<form id="frmPost" method="post">
	<label>이름</label>
	<input type="text" name="name" value="이명화"/><br>
	<label>나이</label>
	<input type="text" name="age" value="24"/><br>
	<label>이메일</label>
	<input type="text" name="email" value="lee@test.com"/><br>
	<input type="button" value="단일형" class="btn btn-info btn-sm" id="btnSingle2"/>
	<input type="button" value="HttpServletRequest" class="btn btn-info btn-sm" id="btnHsr2"/>
	<input type="button" value="VO" class="btn btn-info btn-sm" id="btnVO2"/>
	</form>
	</div>
	
</div>
</body>
</html>