<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${contextPath}/static/css/bootstrap.min.css"/>
<script type="text/javascript" src="${contextPath}/static/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="${contextPath}/static/js/bootstrap.min.js"></script>
<script type="text/javascript">
    $.get("/account/user", function(data) {
        $("#user").html(data.userAuthentication.details.name);
        $(".unauthenticated").hide()
        $(".authenticated").show()
    });
</script>
</head>
<body>
	<form action="/account/login" method="post">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		EMAIL : <input type="text" name="email" /><p/>
		PASSWORD : <input type="password" name="password" />
		<button type="submit">제출</button>
	</form>
	<div class="container unauthenticated">
	    With Facebook: <a href="/login/facebook">click here</a>
	</div>
	<div class="container authenticated" style="display:none">
	    Logged in as: <span id="user"></span>
	</div>
</body>
</html>