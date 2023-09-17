<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Category - Cafe Dosti</title>
<%@ include file="components/common_cs_js.jsp"%>
</head>
<body>
  <%@ include file="components/navbar.jsp"%>
  
 <div class="container-fluid">
  <div class="row mt-2">
       <div class="col-md-4 offset-md-4 admin" >
            <div class="card">
                <%@ include file="components/message.jsp"%>
                <div class="card-body px-5">
                    <h3 class="text-center my-3">Add Category here..!!</h3>
		            <form action="addcategory" method="post">
		                 <div class="form-group">
		                     <label for="name">Category Name</label>
		                     <input type="text" class="form-control" id="name" aria-describedby="emailHelp" name="categoryName" placeholder="Enter Category name" required>
		                 </div>
		                 
		                 <div class="container text-center">
		                      <button class="btn text-white custom-bg">Add Category</button>
		                 </div>
		            </form>
                </div>
            </div>
       </div>
  </div>
</div>
</body>
</html>