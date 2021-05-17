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
	background-image: url("https://content.fortune.com/wp-content/uploads/2019/10/GettyImages-1158402857.jpg?resize=1000,666 ");
    background-repeat: no-repeat;
    background-size: cover;
}

        .img{
            
            
        }

a.iprodev {
  line-height: normal;
  font-family: Varela Round, sans-serif;
  font-weight: 600;
  text-decoration: none;
  font-size: 13px;
  color: #A7AAAE;
  position: absolute;
  left: 20px;
  bottom: 20px;
  border: 1px solid #A7AAAE;
  padding: 12px 20px 10px;
  border-radius: 50px;
  transition: all .1s ease-in-out;
  text-transform: uppercase;
}
a.iprodev:hover {
  background: #A7AAAE;
  color: white;
}
        
.container_100{
            width:100%;
        }

</style>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl"
	crossorigin="anonymous">
<link rel="stylesheet" href="style/viewNetworth-style.css">
<title>View Networth</title>



</head>



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
    
	<div class="container" style="width:100%;"> 
		<div class="row">
			<div class="col-sm-3"></div>
			<div class="col-sm-6 ">
				<div class="card text-center shadow-lg">
					<img class="card-img-top img-fluid"
						src="https://specials-images.forbesimg.com/imageserve/5f3a9bf8ea6250a0856f35b4/960x0.jpg?fit=scale"
						style="width: 600x; height: 300px;" alt="Card image cap">
					<div class="card-block">
					
                        <h5 style="padding-top:10px;">Your Total Networth is:</h5>
						
						<h2 class="card-text" style="color:green;">Rs. ${networth}</h2>
						<br> 
						<c:if test="${assetMap != null}" >
						<br>
						<div class="container">
							<table class="table">
                                <caption>Assets</caption>
								<thead class="thead-dark">
									<tr>
										<th id='1'>Asset</th>
										<th id='2'>Units Sold</th>
									</tr>
								</thead>
                                
								<tbody>
                                    <c:forEach items="${assetMap}" var="temp">
										<tr>
											<td>${temp.key}</td>
											<td>${temp.value}</td>
										</tr>
								    </c:forEach>
								</tbody>
                                
							</table>
							
						</div>
						</c:if>
					</div>
				</div>
			</div>
		</div>
	</div>
	
</body>
    
</html>