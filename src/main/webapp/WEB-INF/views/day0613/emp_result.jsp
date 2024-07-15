<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    info="부서별 사원정보 조회"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="icon" href="http://43.203.122.250/spring_mvc/common/favicon.ico"/>
<!--bootstrap 시작-->
   <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
   <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
<!--bootstrap 끝-->
<link rel="stylesheet" href="http://43.203.122.250/spring_mvc/common/css/main.css" type="text/css" media="all" />
<link rel="stylesheet" href="http://43.203.122.250/spring_mvc/common/css/board.css" type="text/css" media="all" />

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
<div>
입력하신 부서번호 [<strong><c:out value="${param.deptno}"/></strong>번]의 사원정보 검색결과<br>
<c:catch var="e">

<c:if test="${empty list }">
사원이 존재하지 않는 부서
</c:if>
<table class="table table-hover">
<tr> 
<th style="width: 80px">사원번호</th>
<th style="width: 200px">사원명</th>
<th style="width: 120px">사원직무</th>
<th style="width: 120px">연봉</th>
<th style="width: 300px">입사일</th>
</tr>
<c:if test="${empty requestScope.listEmp }">
<tr>
<td colspan="5" style="text-align: center">
사원이 존재하지 않는 부서
</td>
</tr>
</c:if>
<c:forEach var="ed" items="${requestScope.listEmp }" varStatus="i" >
<tr>
<td><c:out value="${ed.empno }"/></td>
<td><c:out value="${ed.ename }"/></td>
<td><c:out value="${ed.job }"/></td>
<td><c:out value="${ed.sal }"/></td>
<td><c:out value="${ed.hiredateStr }"/></td>
</tr>
</c:forEach>
</table>
<option value="${empno }"><c:out value="${i.count}.${empno }" /></option>
</c:catch>
<c:if test="${not empty e}">
부서번호는 숫자로만 구성됩니다.
</c:if>
</div>
</body>
</html>