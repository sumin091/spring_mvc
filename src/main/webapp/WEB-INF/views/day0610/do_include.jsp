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
		
	});//ready
</script>
</head>
<body>
<!-- 지시자, action, jstl 모두 사용가능 -->
<div id="wrap">
	<div id="header">
	<!-- webapp하위폴더에 존재하는 JSP -->
	<%-- include directive가능 
	<%@ include file="/common/jsp/header.jsp"%> --%>
	<%-- action tag
	<jsp:include page="/common/jsp/header.jsp"/> --%>
	<c:import url="/common/jsp/header.jsp"/>
	<c:import url="http://localhost/spring_mvc/common/jsp/header.jsp"/>
	<c:import url="http://localhost${pageContext.request.contextPath }/common/jsp/header.jsp"/>
	${pageContext.request.contextPath }
	</div>
	<div id="container">사용자에게 제공할 내용들...</div>
	<div id="footer">
	<!-- WEB-INF/views/하위폴더에 존재하는 JSP -->
	<%-- <%@ include file="/WEB-INF/views/common/jsp/footer.jsp"%> --%>
	<%-- <jsp:include page="/WEB-INF/views/common/jsp/footer.jsp"/> --%>
	<c:import url="/WEB-INF/views/common/jsp/footer.jsp"/>
	</div>
</div>
</body>
</html>