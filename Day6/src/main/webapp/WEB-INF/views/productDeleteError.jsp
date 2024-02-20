<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">
</head>
<body>
	<jsp:include page="_header.jsp"></jsp:include>
	<jsp:include page="_navTop.jsp"></jsp:include>	
	
	<section class = "container">
		<h3>Product Edit</h3>
		<p> ${errorString}</p>
	</section>	
	<jsp:include page="_footer.jsp"></jsp:include>	
</body>
</html>