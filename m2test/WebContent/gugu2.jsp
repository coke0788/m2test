<!-- 값을 받아서 출력함. view라고 부름. -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	//object 타입을 arrayList 타입으로 형변환 해야 함. 왜? list 안에 ArrayList가 들어있기 때문에.
	ArrayList<String> list = (ArrayList<String>)request.getAttribute("list");
	for(String s : list) {
%>
		<div><%=s%></div>
<%
	}
%>
</body>
</html>