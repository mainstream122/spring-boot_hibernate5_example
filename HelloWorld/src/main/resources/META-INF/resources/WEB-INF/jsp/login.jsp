<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/account/login" method="post">
		<input type="hidden" name="_csrf">
		EMAIL : <input type="text" name="email" /><p/>
		PASSWORD : <input type="password" name="password" />
		<button type="submit">제출</button>
	</form>
</body>
</html>