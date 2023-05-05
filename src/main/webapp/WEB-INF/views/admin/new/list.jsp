<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh sách bài viết</title>
</head>
<body>
	<div class="main-content">
		<form action="#" id="formSubmit" 
			method="get">

			<div class="main-content-inner">
				<div class="breadcrumbs ace-save-state" id="breadcrumbs">
					<ul class="breadcrumb">
						<li><i class="ace-icon fa fa-home home-icon"></i> <a href="#">Trang
								chủ</a></li>
					</ul>
					<!-- /.breadcrumb -->
				</div>
				<div class="page-content">
					<div class="row">
						<div class="col-xs-12">
							<c:if test="${not empty messageResponse}">
								<div class="alert alert-${alert}">${messageResponse}</div>
							</c:if>
							<div class="widget-box table-filter">
								<div class="table-btn-controls">
									<div class="pull-right tableTools-container">
										<div class="dt-buttons btn-overlap btn-group">
											<a flag="info"
												class="dt-button buttons-colvis btn btn-white btn-primary btn-bold"
												data-toggle="tooltip" title='Thêm bài viết'
												href='#'> <span>
													<i class="fa fa-plus-circle bigger-110 purple"></i>
											</span>
											</a>
											<button id="btnDelete" type="button"
												class="dt-button buttons-html5 btn btn-white btn-primary btn-bold"
												data-toggle="tooltip" title='Xóa bài viết'>
												<span> <i class="fa fa-trash-o bigger-110 pink"></i>
												</span>
											</button>
										</div>
									</div>
								</div>
							</div>
							<div class="row">
							
								<div class="col-sm-12">
									<table class="table table-bordered">
									<thead>
										<tr>
											<th>
												<input class="form-check-input" type="checkbox"
												value="" id="checkAll" name="checkAll" />
											</th>
											<th>Tên bài viết</th>
											<th>Mô tả ngắn</th>
											<th>Thao tác</th>
										</tr>
									</thead>
									
									<tbody>
									<c:if test="${not empty model.listResult  }">
										<c:forEach var="item" items="${model.listResult}">
											
												<tr>
												<td>
													<input class="form-check-input" type="checkbox"
													value="${item.id}" id="checkbox_${item.id}"  />
												</td>
												<td>${item.title}</td>
												<td>${item.shortDescription}</td>
												<td>
													<a class="btn btn-sm btn-primary btn-edit"
														data-toggle="tooltip" title="Cập nhật bài viết"
														href='#'><i class="fa fa-pencil-square-o"
														aria-hidden="true"></i> 
													</a>
												</td>
											</tr>
											
										</c:forEach>
										</c:if>
										<c:if test="${empty model.listResult  }">
											<p class="text-danger">Không có dữ liệu !</p>
										</c:if>
									</tbody>
								</table>
								</div>
								
							</div>
							<div class="row ">
								<div class="col-sm-12">
									<center>
										<ul class="pagination" id="pagination"></ul>
									</center>
									<input type="hidden" value="" id="page" name="page" /> <input
									type="hidden" value="" id="limit" name="limit" />
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>

		</form>
	</div>
	<script>
	var totalPages = ${model.totalPage}
	var currentPage = ${model.page};
	var limit = 1 ;
	$(function () {
        window.pagObj = $('#pagination').twbsPagination({
            totalPages: totalPages,
            visiblePages: 10,
            startPage : currentPage,
            onPageClick: function (event, page) {
            	$('#limit').val(limit);
				$('#page').val(page);
            	$('#formSubmit').submit();
            }
        })
    });
		
	</script>
</body>
</html>