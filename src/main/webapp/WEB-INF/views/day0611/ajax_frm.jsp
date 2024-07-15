<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    info="AJAX 요청"%>
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
		//alert("${pageContext.request.contextPath}");
		$("#btn").click(function(){
		$.ajax({
			url:"http://localhost/spring_mvc/day0611/ajax_result.do",
			type:"GET",
			dataType:"JSON",
			error:function( xhr ){
				console.log(xhr.status);
				alert("서비스가 원활하지 못한점 뎨둉합니다.");
			},
			success : function( jsonObj ){
				var output="응답결과<br>";
				output+= jsonObj.msg+"<br/>";
				output+= jsonObj.msg2+"<br/>";
				
				$("#output").html( output );
				
				var sel=$("#sel")[0];
				sel.options[1]=new Option(jsonObj.msg, jsonObj.msg);
				sel.options[2]=new Option(jsonObj.msg2, jsonObj.msg2);
			}//success
		});//ajax
	});//click
	
	$("#btn2").click(function(){
		$.ajax({
			url:"http://localhost${pageContext.request.contextPath}/day0611/ajax_responsebody.do",
			type: "GET",
			dataType: "JSON",
			error: function(xhr){
				console.log(xhr.status+":"+"xhr.statusText");
				alert("뎨둉합니다");
			},
			success:function(jsonObj){
				var output="";
				output+= "<strong>"+jsonObj.name+"</strong>";
				
				output+="<ul>";
				$.each(jsonObj.lunchList, function(i, jsonTemp){
					output+="<li>"+jsonTemp.lunch+"</li>";
				});
				output+="</ul>";
				$("#output").html(output);
			}//success
		});//ajax
	});//click
	
	});//ready
</script>
</head>
<body>
<div>
<h2>AJAX요청</h2>
<div>
<input type="button" value="ajax요청" id="btn" class="btn btn-success btn-sm"/>
<input type="button" value="ajax요청 @ResponseBody" id="btn2" class="btn btn-info btn-sm"/>

</div>
<div id="output"></div>
<select id="sel">
	<option>-----선택-----</option>
</select>
</div>
</body>
</html>