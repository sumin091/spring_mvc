<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    info=""%>
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
		$("#btn").click(function(){
			var ext=$("#upfile").val();
			
			if(ext==""){
				alert("파일을 선택해주세요")
				return;
			}
			
			if(ext.substring(ext.lastIndexOf(".")+1).toUpperCase()=="JSP"){
				alert("업로드 불가능한 파일입니다.");
				return;
			}//end if
			
			
			$("#frm").submit();
		});//click
	});//ready
</script>
</head>
<body>
<div>
	<h2>파일업로드 폼</h2>
	<form action="upload_process.do?temp=2024" id="frm" method="post" enctype="multipart/form-data">
	<label>업로더</label>
	<input type="text" name="uploader"/><br>
	
	<label>파일</label>
	<input type="file" name="upfile" id="upfile"/><br>
	<input type="button" value="전송" id="btn" class="btn btn-info btn-sm"/><br>
	
	</form>
</div>
</body>
</html>