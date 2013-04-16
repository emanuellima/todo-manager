<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Todo List ${todoList.oid}</title>
		<%@ include file="/WEB-INF/jsp/common/libs.jsp" %>
	</head>
	<body>
		
		<div class="container">
			<ul>
			<c:forEach items="${todoSortedList}" var="todo">
				<c:if test="${todo.completed}">
				<li><a href="/todos/${todo.oid}"><del>${todo.text}</del></a></li>
				</c:if>
				<c:if test="${!todo.completed}">
				<li><a href="/todos/${todo.oid}">${todo.text}</a></li>
				</c:if>
			</c:forEach>
			</ul>
			<form method="POST" action="/lists/${todoList.oid}">
				<input type="text" class="input-xlarge input-todo" placeholder="ex: Fazer o projecto de ES" name="todoText" autofocus />
	  		</form>
		</div>
	</body>
</html>