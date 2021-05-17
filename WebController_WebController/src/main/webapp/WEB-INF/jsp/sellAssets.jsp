<%@ page language="java" contentType="text/html;  charset=UTF-8"
	import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
<style>
body {
	color: #fff;
	background-image:
		url("https://images.unsplash.com/photo-1616261167032-b16d2df8333b?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1051&q=80s");
	background-repeat: no-repeat;
	background-size: cover;
}
</style>
<title>Sell Asset</title>

</head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl"
	crossorigin="anonymous">
<body>
	<nav class="navbar navbar-dark bg-dark">
		<a class="navbar-brand" href="#" style="margin-left: 20px;"> <img
			src="https://image.flaticon.com/icons/png/128/3135/3135679.png"
			width="30" height="30" class="d-inline-block align-top" alt="">
			Portfolio Manager
		</a>
		<form action="/home">
			<button type="button float-right" style="margin-right: 20px;"
				class="btn btn-outline-light">Home</button>
		</form>
	</nav>

	<br>
	<div class="container">
		<div class="row">
			<div class="col-sm-3"></div>
			<div class="col-sm-6 ">
				<div class="card text-center shadow-lg">
					<img class="card-img-top img-fluid"
						src="https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse1.mm.bing.net%2Fth%3Fid%3DOIP.YgT_JQlhcgGp1uglMmcqJAHaEK%26pid%3DApi&f=1"
						style="width: 1800x; height: 300px;" alt="Card image cap">
					<div class="card-block">
						<h4 class="card-title" style="padding: 10px;">Sell Assets</h4>
						<p class="card-text">Select the asset which you want to sell.</p>


						<form name="myForm" action="/sell-asset" method="POST">
							<div class="form-group">
								<select name="assetId">
									<c:forEach items="${asset}" var="temp">
										<option value="${temp.assetId}">${temp.assetId}</option>
									</c:forEach>
								</select> <input type="number" id="count" name="count" value="0" min="1"
									required="required"> <input class="btn btn-success"
									type="submit" value="Sell" name="submit" />
							</div>
						</form>

						<table class="table table-striped" style="margin-top: 10px;">
							<caption></caption>
							<thead>
								<tr>
									<th id="1">Asset Name</th>
									<th id="2">Available Qty</th>
								</tr>
								<c:forEach items="${asset}" var="temp">
							</thead>
							<tbody>
								<tr>
									<td><span id="assetId" name="assetId">
											${temp.assetId } </span></td>
									<td><span id="count" name="count"> ${temp.count }
									</span></td>
									</c:forEach>
								</tr>

							</tbody>
						</table>
					</div>
				</div>
			</div>

			<script type="text/javascript" src="js/jquery.1.11.1.js"></script>
</body>
</html>