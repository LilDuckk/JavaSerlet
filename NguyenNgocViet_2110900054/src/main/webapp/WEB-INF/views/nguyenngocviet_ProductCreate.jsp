<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Product</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<section class="container">
		<h3>Create Product</h3>
		<p style="color: red">${errorString}</p>
		<form method="post" action="${pageContext.request.contextPath}/nguyenngocviet_ProductCreate">
			<table class="table table-bordered">
					<tr>
						<td>Mã SP</td>
						<td><input type="text" name="maSP" value="${product.maSP}" /></td>
					</tr>
					<tr>
						<td>Tên SP</td>
						<td><input type="text" name="tenSP" value="${product.tenSP}" /></td>
					</tr>
					<tr>
						<td>Số Lượng</td>
						<td><input type="text" name="soLuong" value="${product.soLuong}" /></td>
					</tr>
					<tr>
						<td>Đơn giá</td>
						<td><input type="text" name="donGia" value="${product.donGia}" /></td>
					</tr>
					<tr>
						<td>Ảnh</td>
						<td><input type="text" name="anh" value="${product.anh}" /></td>
					</tr>
				<tr>
					<td></td>
					<td>
						<input type="submit" value="Ghi lại" class="btn btn-success">
						<a href="nguyenngocviet_ProductList" class="btn btn-danger">Quay lại</a>
					</td>
				</tr>
			</table>
		</form>
	</section>
</body>
</html>