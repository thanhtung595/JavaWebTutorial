
<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book List</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">
</head>
<body>

	<section class="container">
		<h3>Product List</h3>
		<a href="bookCreate" class="btn btn-success">Create Book</a>
		<p>${errorString}</p>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>MaSach</th>
					<th>TenSach</th>
					<th>SoLuong</th>
					<th>DonGia</th>
					<th>Anh</th>
					<th>Edit</th>
					<th>Delete</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${bookList}" var="book">
					<tr>
						<td>${book.maSach}</td>
						<td>${book.tenSach}</td>
						<td>${book.soLuong}</td>
						<td>${book.donGia}</td>
						<td><img width="50px" src="${book.anh}"/></td>
						<td><a href="bookEdit?maSach=${book.maSach}">Edit</a></td>
						<td><a href="bookDelete?maSach=${book.maSach}">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</section>
</body>
</html>