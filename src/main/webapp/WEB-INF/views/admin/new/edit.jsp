<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="APIurl" value="/api/new"  />
<c:url var="NewURL" value="/quan-tri/bai-viet/danh-sach"/>
<c:url var="EditNewUrl" value="/quan-tri/bai-viet/chinh-sua"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Chỉnh sửa bài viết</title>
</head>
<body>
	<div class="main-content">
		<div class="main-content-inner">
			<div class="breadcrumbs" id="breadcrumbs">
				<script type="text/javascript">
					try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
				</script>

				<ul class="breadcrumb">
					<li>
						<i class="ace-icon fa fa-home home-icon"></i>
						<a href="#">Home</a>
					</li>

					<li>
						<a href="#">Forms</a>
					</li>
					<li class="active">Form Elements</li>
				</ul><!-- /.breadcrumb -->

				<div class="nav-search" id="nav-search">
					<form class="form-search">
						<span class="input-icon">
							<input type="text" placeholder="Search ..." class="nav-search-input" id="nav-search-input" autocomplete="off" />
							<i class="ace-icon fa fa-search nav-search-icon"></i>
						</span>
					</form>
				</div><!-- /.nav-search -->
			</div>
		
			<div class="page-content">
				<div class="row">
					<div class="col-xs-12">
						<c:if test="${not empty message }">
							<div class="alert alert-${alert}">
								<strong>${message}</strong>
							</div>
						</c:if>
						<form:form class="form-horizontal" role="form" id="formSubmit" modelAttribute="model">
							<div class="form-group">
								<div class="col-sm-3 control-label no-padding-right" for="categoryCode">Thể loại bài viết :</div>
								<div class="col-sm-9">
									<form:select path="categoryCode" id="categoryCode" cssClass="form-select"> 
										<form:option value="" label="-- chọn thể loại --"/>
										<form:options items="${categories}" />
									</form:select>
								</div>
							</div>
							<div class="form-group">
								<div class="col-sm-3 control-label no-padding-right" for="title">Tên bài viết :</div>
								<div class="col-sm-9">
									<form:input path="title" cssClass="col-xs-10 col-sm-5 form-control"/>
								</div>
							</div>
							<div class="form-group">
								<div class="col-sm-3 control-label no-padding-right" for="thumbnail">Ảnh đại diện :</div>
								<div class="col-sm-9">
									<input type="file" id="thumbnail" name="thumbnail" class="col-xs-10 col-sm-5 form-control"/>
								</div>
							</div>
							
							<div class="form-group">
								<div class="col-sm-3 control-label no-padding-right" for="shortDescription">Mô tả ngắn :</div>
								<div class="col-sm-9">
									<form:textarea path="shortDescription" cssClass="form-control" row="5" cols="10" id="shortDescription"/>
								</div>
							</div>
							<div class="form-group">
								<div class="col-sm-3 control-label no-padding-right" for="content">Nội dung :</div>
								<div class="col-sm-9">
									<form:textarea path="content" cssClass="form-control" row="5" cols="10" id="content"/>
								</div>
							</div>
							<div class="form-group">
								<div class="col-sm-9">
									<form:hidden path="id" cssClass="form-control" row="5" cols="10" id="newId"/>
								</div>
							</div>
							<div class="clearfix form-actions">
										<div class="col-md-offset-3 col-md-9">
											<c:if test="${not empty model.id }">
												<button class="btn btn-info" type="button" id="btnAddOrUpdateNew">
													<i class="ace-icon fa fa-check bigger-110"></i>
													Cập nhật bài viết
												</button>
											</c:if>
											<c:if test="${ empty model.id }">
												<button class="btn btn-info" type="button" id="btnAddOrUpdateNew">
													<i class="ace-icon fa fa-check bigger-110"></i>
													Thêm mới bài viết
												</button>
											</c:if>

											&nbsp; &nbsp; &nbsp;
											<button class="btn" type="reset">
												<i class="ace-icon fa fa-undo bigger-110"></i>
												Reset
											</button>
										</div>
									</div>
						</form:form>
					</div>
				</div>
			</div>
		</div>
		</div>
		<script>
			$('#btnAddOrUpdateNew').click(function (e) {
				//Ko co cai nay la no se submit vao url no dang dung
				e.preventDefault();
				var data = {};
				var formData = $('#formSubmit').serializeArray();
				$.each(formData,function(i,v){
					data[""+v.name+""] = v.value;
				});
				var id  = $('#newId').val();
				if(id == ""){
					addNew(data);
				}else{
					updateNew(data);
				}
				
			});
			
			function addNew(data) {
				$.ajax({
					url : '${APIurl}' ,
					type : 'POST' ,
					contentType : 'application/json' ,
					data : JSON.stringify(data) ,
					dataType : 'json' ,
					success : function(result) {
						window.location.href = "${EditNewUrl}?id="+result.id+"&message=insert_success" ;
					},
					error : function (error) {
						window.location.href = "${NewURL}?page=1&limit=2&message=error_system" ;
					}
				});
			};
			function updateNew(data) {
				$.ajax({
					url : '${APIurl}' ,
					type : 'PUT' ,
					contentType : 'application/json' ,
					data : JSON.stringify(data) ,
					dataType : 'json' ,
					success : function(result) {
						window.location.href = "${EditNewUrl}?id="+result.id+"&message=update_success"  ;
					},
					error : function (error) {
						window.location.href = "${EditNewUrl}?id="+result.id+"&message=error_system"  ;
						console.log(error);
					}
				});
			}
		</script>
</body>
</html>