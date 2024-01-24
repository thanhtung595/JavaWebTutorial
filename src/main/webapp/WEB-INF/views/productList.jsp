<%@page import="beans.Product"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    // Assume you have a List of products named 'productList' in request scope

    List<Product> productList = (List<Product>) request.getAttribute("productList");
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product List</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">
</head>
<body>
	<jsp:include page="_header.jsp"></jsp:include>
	<jsp:include page="_navTop.jsp"></jsp:include>	
	
	<section class = "container">
		<h3>Product List</h3>
		<a href="productCreate" class="btn btn-success">Create Product</a>
		<p> ${errorString}</p>
		<table class="table table-bordered">
		<thead>
			<tr>
				<th>Code</th>
				<th>Name</th>
				<th>Price</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
		</thead>
		<tbody>
			<% for (Product product : productList) { %>
            <tr>
                <td><%= product.getCode() %></td>
                <td><%= product.getName() %></td>
                <td><%= product.getPrice() %></td>
                <td><a href ="productEdit?code=<%= product.getCode() %>">Edit</a></td>
                <td><a href ="productDelete?code=<%= product.getCode() %>">Delete</a></td>
            </tr>
        	<% } %>
		</tbody>
		</table>
		
	</section>
	
	<jsp:include page="_footer.jsp"></jsp:include>	
</body>
</html>