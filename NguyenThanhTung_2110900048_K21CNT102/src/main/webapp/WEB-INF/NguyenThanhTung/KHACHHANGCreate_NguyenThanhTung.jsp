<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">
</head>
<body>

	<section class="container">
		<h3>Khach Hang Create</h3>
		<p>${errorString}</p>

		<form method="POST"
			action="${pageContext.request.contextPath }/khachHangCreate">
			<table class="table table-bordered">
				<tr>
					<td>MAKH</td>
					<td><input type="text" name="MAKH_2110900048" value="" /></td>
				</tr>
				<tr>
					<td>HOTEN</td>
					<td><input type="text" name="HOTEN_2110900048" value="" /></td>
				</tr>
				<tr>
					<td>NGAYSINH</td>
					<td><input type="text" name="NGAYSINH_2110900048" value="" /></td>
				</tr>
				<tr>
					<td>GIOITINH</td>
					<td><select name="GIOITINH_2110900048">
							<option value="true">Nam</option>
							<option value="false">Nữ</option>
					</select></td>
				</tr>
				<tr>
					<td>ANH</td>
					<td><input type="text" name="ANH_2110900048" value="" /></td>
				</tr>
				<tr>
					<td>TINHTRANG</td>
					<td><input type="text" name="TINHTRANG_2110900048" value="" /></td>
				</tr>

				<tr>
					<td>
						<button type="submit" class="btn btn-success">Ghi Lai</button> <a
						href="khachHangList" class="btn btn-danger">Quay Lai</a>
					</td>
				</tr>
			</table>
		</form>
	</section>
</body>
</html>