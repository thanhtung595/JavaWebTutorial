<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">
</head>
<body>
	
	<section class = "container">
		<h3>Book Edit</h3>
		<p> ${errorString}</p>
		
		<form method="POST" action="${pageContext.request.contextPath }/bookEdit">
			<table class="table table-bordered">
				<tr>
					<td>BookId</td>
					<td><input type="text" name="bookId" value="${book.bookId }"/></td>
				</tr>
				<tr>
					<td>Title</td>
					<td><input type="text" name="title" value="${book.title }"/></td>
				</tr>
				<tr>
					<td>Author</td>
					<td><input type="text" name="author" value="${book.author }"/></td>
				</tr>
				<tr>
					<td>Release</td>
					<td><input type="text" name="release" value="${book.release }"/></td>
				</tr>
				<tr>
					<td>Price</td>
					<td><input type="text" name="price" value="${book.price }"/></td>
				</tr>
				<tr>
					<td>Picture</td>
					<td><input type="text" name="picture" value="${book.picture }"/></td>
				</tr>
				<tr>
					<td>PublisherId</td>
					<td><input type="text" name="publisherId" value="${book.publisherId }"/></td>
				</tr>
				<tr>
					<td>CategoryId</td>
					<td><input type="text" name="categoryId" value="${book.categoryId }"/></td>
				</tr>
				<tr>
					<td>
						<button type="submit" class="btn btn-success">Ghi Lai</button>
						<a href="bookList" class="btn btn-danger">Quay Lai</a>
					</td>
				</tr>
			</table>
		</form>
	</section>
</body>
</html>