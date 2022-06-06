<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Movimientos</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
</head>
<body>
	<header>
		<nav class="navbar navbar-expand-md navbar-dark" >
			<div>
				<img style="height: 10vh "alt="Logo BBVA" src="https://imgs.search.brave.com/I56CLl8ubHVXT8Pzwb4ubTiA-SJy3_ze0Wpj9EWULdA/rs:fit:1200:748:1/g:ce/aHR0cHM6Ly93d3cu/aW52ZXN0b3BlZGlh/LmNvbS90aG1iL1Z3/Z2VudFdWekh4eWhR/X0Q2NjJkSTFWYi1V/az0vMjUwMHg3NDgv/ZmlsdGVyczpub191/cHNjYWxlKCk6bWF4/X2J5dGVzKDE1MDAw/MCk6c3RyaXBfaWNj/KCkvYmJ2YS1sb2dv/LWM2NWVhNjE5YzBk/NzQ5YTE4MDQzMWMx/NzI5ODVkOGZhLnBu/Zw">
			</div>
		</nav>
	</header>
	
	<hr size="15" noshade="noshade" style="background-color: blue;" />
	
	<div class="row">
		<div class="container">
			<br>
			<table class="table">
				<thead>
					<tr>
						<th style="color:$blue-800">Movimientos</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="bill" items="${listBills}">
						<tr>
							<td><c:out value="${bill.id} ${bill.date_bill}" /></td>
							<td><c:out value="${bill.value}" /></td>
							<td><a href="ver?id=<c:out value="${bill.id}"/>">Ver</a>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<div class="container text-left">
				
				<form action="Bill">
					<button type="submit" class="btn rounded-circle">+</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>