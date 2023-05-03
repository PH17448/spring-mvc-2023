<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng nhập</title>
</head>
<body>
	<div class="container">
		<div class="d-flex justify-content-center h-100">
			<div class="card">
				<div class="card-header">
					<h3>Sign In</h3>
					<div class="d-flex justify-content-end social_icon">
						<span><i class="fab fa-facebook-square"></i></span> <span><i
							class="fab fa-google-plus-square"></i></span> <span><i
							class="fab fa-twitter-square"></i></span>
					</div>
				</div>
				<div class="card-body">
					<c:if test="${ param.incorrectAccount != null }">
						<div class="alert alert-danger" role="alert">Username or password is incorrect ! </div>
					</c:if>
					<c:if test="${ param.denied != null }">
						<div class="alert alert-danger" role="alert">You don't access permission ! </div>
					</c:if>
					<form action="j_spring_security_check" method="POST">
						<div class="form-group">
							<input type="text" class="form-control" id="userName"
								name="j_username" placeholder="Tên đăng nhập">
						</div>

						<div class="form-group">
							<input type="password" class="form-control" id="password"
								name="j_password" placeholder="Mật khẩu">
						</div>
						<button type="submit" class="btn btn-primary">Đăng nhập</button>

					</form>
				</div>
				<div class="card-footer">
					<div class="d-flex justify-content-center links">
						Don't have an account?<a href="#">Sign Up</a>
					</div>
					<div class="d-flex justify-content-center">
						<a href="#">Forgot your password?</a>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>