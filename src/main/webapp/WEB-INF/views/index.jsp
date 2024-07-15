<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    info=""%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="icon" href="http://stu11.sist.co.kr/spring_mvc/common/favicon.ico"/>
<!--bootstrap 시작-->
   <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
   <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
<!--bootstrap 끝-->
<link rel="stylesheet" href="http://stu11.sist.co.kr/spring_mvc/common/css/main.css" type="text/css" media="all" />
<link rel="stylesheet" href="http://stu11.sist.co.kr/spring_mvc/common/css/board.css" type="text/css" media="all" />

<!--jQuery CDN 시작-->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<!--jQuery CDN 끝-->

<style type="text/css">
	
</style>
<script type="text/javascript">
	$(function(){
		$("#btnGet").click(function(){
			location.href="http://localhost/spring_mvc/get.do";
		});//click
		
		$("#btnGetSubmit").click(function(){
			$("#frmGet").submit();
		});//click
		
		$("#btnPostSubmit").click(function(){
			$("#frmPost").submit();
		});//click
		
		$("#btnGet2").click(function(){
			$("#frmGetPost")[0].method="GET";
			$("#frmGetPost").submit();
		});//click
		
		$("#btnPost2").click(function(){
			$("#frmGetPost")[0].method="POST";
			$("#frmGetPost").submit();
		});//click
	});//ready
</script>
</head>
<body>
<div>
	<div>
		<h3>GET방식의 요청</h3>
		<div>
		<a href="get.do">링크요청</a><br>
		<input type="button" value="JS Location요청" id="btnGet" class="btn-info btn-sm"/><br>
		<form action="get.do" method="get" id="frmGet">
		<input type="button" class="btn-success btn-sm" value="GET요청" id="btnGetSubmit"/>
		</form>
		</div>
	</div>
	<div>
		<h3>POST방식의 요청</h3>
		<div>
		<form action="post.do" method="post" id="frmPost">
		<input type="button" class="btn-success btn-sm" value="POST요청" id="btnPostSubmit"/>
		</form>
		</div>
	</div>
	<div>
		<h3>GET/POST방식의 요청</h3>
		<div>
		<form action="get_post.do" id="frmGetPost">
		<input type="button" class="btn-success btn-sm" value="GET요청" id="btnGet2"/>
		<input type="button" class="btn-success btn-sm" value="POST요청" id="btnPost2"/>
		</form>
		</div>
	</div>
	<div>
		<h3>하나의 method로 여러요청을 받을때</h3>
		<a href="a.do">a.do요청</a>
		<a href="b.do">b.do요청</a>
		<a href="yana.do">yana.do요청</a>
	</div>
	
	<div>
		<ul>
			<li><a href="day0604/param_frm.do">파라메터 연습</a></li>
		</ul>
	</div>
	<div>
		<ul>
			<li><a href="day0605/hsr_hs.do">Controller에서 View로 전달</a></li>
			<li><a href="day0605/model.do">Model View로 전달</a></li>
			<li><a href="day0605/mav.do">ModelAndView View로 전달</a></li>
		</ul>
	</div>
	<div>
		<ul>
			<li><a href="day0610/test.jsp">JSP호출</a></li>
			<li><a href="day0610/use_redirect.do">Controller통해서 redirect로 JSP호출</a></li>
			<li><a href="day0610/use_redirect2.do">Controller통해서 redirect로 /day0605/hsr_hs.do 호출</a></li>
		</ul>
	</div>
	<div>
		<ul>
			<li><a href="day0610/forward_a.do?year=2024">a.do호출 => b.do => c.do</a></li>
			<li><a href="day0610/forward_b.do?month=6">b.do호출 => c.do</a></li>
		</ul>
	</div>
	<div>
		<ul>
			<li><a href="day0610/jsp_include.do?name=dongsub.kim">jsp include</a></li>
			<li><a href="day0610/temp.do">temp.do 요청</a></li>
			<li><a href="day0610/do_include.do?name=suyeon.choi">do include</a></li>
		</ul>
	</div>
	<div>
		<ul>
			<li><a href="day0610/set_session.do">세션 값 설정</a></li>
			<li><a href="day0610/get_session.do">세션 값 얻기</a></li>
			<li><a href="day0610/remove_session.do">HttpSession 세션사용 종료(삭제안됨)</a></li>
			<li><a href="day0610/remove_session2.do">SessionStatus 세션사용 종료</a></li>
		</ul>
	</div>
	<div>
		<ul>
			<li><a href="day0611/add_cookie.do">쿠키 값 설정</a></li>
			<li><a href="day0611/cookie_annotation.do">@CookieValue 값 얻기</a></li>
			<li><a href="day0611/web_utils.do">WebUtils 값 얻기</a></li>
		</ul>
	</div>
	<div>
		<ul>
			<li><a href="day0611/ajax.do">AJAX 사용</a></li>
		</ul>
	</div>
	<div>
		<ul>
			<li><a href="day0611/test_exception.do">Controller에 예외발생</a></li>
			<li><a href="day0611/test_exception2.do">Controller에 예외발생</a></li>
		</ul>
	</div>
	<div>
		<ul>
			<li><a href="day0612/err_405.do">405</a></li>
			<li>
				<form action="day0612/err_405.do" method="post">
				<input type="submit" value="POST요청" class="btn btn-success btn-sm"/>
				</form>
			</li>	
			<li><a href="day0612/err_500.do">500</a></li>
			
		</ul>
	</div>
	<div>
		<ul>
			<li><a href="day0613/file_upload_frm.do">파일업로드</a></li>
		</ul>
	</div>
	<div>
		<ul>
			<li><a href="day0613/mybatis_search.do?deptno=10">10번 부서 조회</a></li>
			<li><a href="day0613/mybatis_search.do?deptno=20">20번 부서 조회</a></li>
			<li><a href="day0613/mybatis_search.do?deptno=30">30번 부서 조회</a></li>
		</ul>
	</div>
	<div>
		<ul>
			<li>
			<form action="day0614/login_process.do" method="post">
			<label>id</label>
			<input type="text" name="id"/>
			<label>pass</label>
			<input type="password" name="pass"/>
			<input type="submit" value="로그인" class="btn btn-success btn-sm"/>
			</form>
			</li>
			<li><a href="day0614/plain_text.do">복호화</a></li>
		</ul>
	</div>
</div>
</body>
</html>