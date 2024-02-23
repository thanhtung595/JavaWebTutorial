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
					<td>MaSach</td>
					<td><input type="text" name="maSach" value="${book.maSach }" readonly="readonly"/></td>
				</tr>
				<tr>
					<td>TenSach</td>
					<td><input type="text" name="tenSach" value="${book.tenSach }"/></td>
				</tr>
				<tr>
					<td>SoLuong</td>
					<td><input type="text" name="soLuong" value="${book.soLuong }"/></td>
				</tr>
				<tr>
					<td>DonGia</td>
					<td><input type="text" name="donGia" value="${book.donGia }"/></td>
				</tr>
				<tr>
					<td>Anh</td>
					<td><input type="text" name="anh" value="${book.anh }"/></td>
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