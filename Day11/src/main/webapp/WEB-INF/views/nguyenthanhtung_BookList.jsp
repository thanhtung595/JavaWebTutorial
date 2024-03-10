
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
					<th>BookId</th>
					<th>Title</th>
					<th>Author</th>
					<th>Release</th>
					<th>Price</th>
					<th>Picture</th>
					<th>PublisherId</th>
					<th>CategoryName</th>
					<th>Edit</th>
					<th>Delete</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${bookList}" var="book">
					<tr>
						<td>${book.bookId}</td>
						<td>${book.title}</td>
						<td>${book.author}</td>
						<td>${book.release}</td>
						<td>${book.price}</td>
						<td>${book.picture}</td>
						<td>${book.publisherId}</td>
						<td>${book.category.categoryName}</td>
						<td><a href="bookEdit?bookId=${book.bookId}">Edit</a></td>
						<td><a href="bookDelete?bookId=${book.bookId}">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</section>
</body>
</html>