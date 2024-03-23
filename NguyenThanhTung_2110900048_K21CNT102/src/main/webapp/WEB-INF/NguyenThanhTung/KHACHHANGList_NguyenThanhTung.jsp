
<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List Khach Hang</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">
</head>
<body>

	<section class="container">
		<h3>Khach Hang List</h3>
		<a href="khachHangCreate" class="btn btn-success">Create Khach
			Hang</a>
		<p>${errorString}</p>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>MAKH</th>
					<th>HOTEN</th>
					<th>NGAYSINH</th>
					<th>GIOITINH</th>
					<th>ANH</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${khachHangList}" var="khachhang">
					<tr>
						<td>${khachhang.MAKH_2110900048}</td>
						<td>${khachhang.HOTEN_2110900048}</td>
						<td>${khachhang.NGAYSINH_2110900048}</td>
						<c:if test="${khachhang.GIOITINH_2110900048 == true}">
							<td>Nam</td>
						</c:if>
						<c:if test="${khachhang.GIOITINH_2110900048 == false}">
							<td>Nữ</td>
						</c:if>
						<td><img style="width: 60px"
							src="img/${khachhang.ANH_2110900048}" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</section>
</body>
</html>