<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">
</head>
<body>
	<jsp:include page="_header.jsp"></jsp:include>
	<jsp:include page="_navTop.jsp"></jsp:include>	
	
	<section class = "container">
		<h3>Product Edit</h3>
		<p> ${errorString}</p>
		
		<form method="POST" action="${pageContext.request.contextPath }/productEdit">
			<table class="table table-bordered">
				<tr>
					<td>Code</td>
					<td><input type="text" name="code" value="${product.code }"/></td>
				</tr>
				<tr>
					<td>Name</td>
					<td><input type="text" name="name" value="${product.name }"/></td>
				</tr>
				<tr>
					<td>Price</td>
					<td><input type="text" name="price" value="${product.price }"/></td>
				</tr>
				<tr>
					<td>
						<button type="submit" class="btn btn-success">Ghi Lai</button>
						<a href="productList" class="btn btn-danger">Quay Lai</a>
					</td>
				</tr>
			</table>
		</form>
	</section>
	
	
	
	<jsp:include page="_footer.jsp"></jsp:include>	
</body>
</html>