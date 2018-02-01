<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link rel="stylesheet" type="text/css" href="${contextPath}/static/css/bootstrap.min.css"/>
<script type="text/javascript" src="${contextPath}/static/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="${contextPath}/static/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>
Hello ! <c:out value="${user.nickname}"/>
<br/>You are <c:out value="${user.auth}"/> User!!
</body>
</html>