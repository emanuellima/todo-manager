<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>List</title>
		<%@ include file="/WEB-INF/jsp/common/libs.jsp" %>
	</head>
	<body>
		
		<div class="container">
			<h1>Listas de ToDos</h1>
			<table class="table table-striped table-bordered table-condensed">
				<thead>
					<tr>
						<th style="width: 80%">Lista</th>
						<th style="width: 20%; text-align: center">Acções</th>
					</tr>
				<tbody>
				<c:forEach var="todoList" items='${todoLists}'>
					<tr>
						<td><a href="/lists/${todoList.oid}">${todoList.oid}</a></td>
						<td style="text-align: center"><a class="btn btn-mini btn-danger" href="/lists/${todoList.oid}/delete"><i class="icon-trash icon-white"></i> Apagar</a></td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
			<p class="pull-right">
				<form method="POST" action="/lists">
					<button type="submit" class="btn btn-success"><i class="icon-edit icon-white"></i> Criar Nova Lista</button>
				</form>
			</p>
		</div>
	</body>
</html>