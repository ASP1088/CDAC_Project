<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cafe Dosti</title>
<%@ include file="components/common_cs_js.jsp"%>
</head>

<body>
	<%@ include file="components/navbar.jsp"%>
	<script type="text/javascript">
		function checkUser() {
	<%if (userType != null && userType.equals("user")) {%>
		return true;
	<%} else {%>
		alert("Please login to buy the food.");
			return false;
	<%}%>
		}
	</script>
	<%
	List<Food> foods = new ArrayList<Food>();
	/* Food food = (Food)request.getAttribute("food"); */
	String foodsSource = (String) request.getAttribute("food-source");

	if (foodsSource == null) {
		foods = foodDao.findAll();
	}

	else {
		foods = (List<Food>) request.getAttribute("foods");
	}

	/* String userType=(String)session.getAttribute("user-login");
	Admin admin = null;
	User user = null ;
	if(userType != null && userType.equals("admin")){
		 admin = (Admin) session.getAttribute("active-user");
	}

	else if(userType != null && userType.equals("user")){
		 user= (User)session.getAttribute("active-user");
	} */
	%>

	<div id="carouselExampleIndicators" class="carousel slide"
		data-ride="carousel">
		<ol class="carousel-indicators">
			<li data-target="#carouselExampleIndicators" data-slide-to="0"
				class="active"></li>
			<li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
			<li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
		</ol>
		<div class="carousel-inner" style="width: 100%">
			<div class="carousel-item active">
				<img class="d-block w-100" src="resources/images/ca1.webp"
					alt="First slide">
			</div>
			<div class="carousel-item">
				<img class="d-block w-100" src="resources/images/ca2.webp"
					alt="Second slide">
			</div>
			<div class="carousel-item">
				<img class="d-block w-100" src="resources/images/ca3.webp"
					alt="Third slide">
			</div>
		</div>
		<a class="carousel-control-prev" href="#carouselExampleIndicators"
			role="button" data-slide="prev"> <span
			class="carousel-control-prev-icon" aria-hidden="true"></span> <span
			class="sr-only">Previous</span>
		</a> <a class="carousel-control-next" href="#carouselExampleIndicators"
			role="button" data-slide="next"> <span
			class="carousel-control-next-icon" aria-hidden="true"></span> <span
			class="sr-only">Next</span>
		</a>
	</div>

	<div class="text-center"><%@ include
			file="components/message.jsp"%></div>

	<div class="container-fluid">
		<div class="row1 flex-nowrap mt-3">
			<div class="col-auto col-md-3 col-xl-2 px-sm-2 px-0 bg-dark">
				<div
					class="nav nav-pills d-flex flex-column align-items-center align-items-sm-start px-3 pt-2 text-white min-vh-100">
					<a href="/"
						class="nav-link w-100 align-middle text-center px-0 custom-bg mb-1 text-white textCol hover">
						<span class="fs-5 d-none d-sm-inline">Menu</span>
					</a>
					<ul class="nav nav-pills w-100 flex-column mb-sm-auto mb-0 align-items-center align-items-sm-start" id="menu">
						<%
						/* List<Food> food = foodDao.findByCategoryId(categoryId);
						for(Food c : food){ */
						List<Category> category = categoryDao.findAll();
						for(Category c : category){
						%>
						<li class="nav-item w-100"><a href="searchfoods?categoryId=<%=c.getId()%>" class="nav-link hover text-white text-center align-middle px-0 custom-bg mb-1"> 
												<!-- <i class="fs-4 bi-house"></i> -->
													<span class="<!-- ms-1 --> d-none d-sm-inline "><%=c.getCategoryName()%></span>
											</a>
						</li>
						<%
						}
						%>
					</ul>
				</div>
			</div>
			<div class="row1 h-25">
				<%
				String stock = "Out Of Stock!!!";
				for (Food f : foods) {

					/*  PizzaStore s= null;
					
					Optional<PizzaStore> optionalStore = storeDao.findById(f.getStoreId());
					if(optionalStore.isPresent()) {
					  s = optionalStore.get();
					} */
				%>

				<div class="card ml-3 mb-3 border border-dark">

					<div class="card-header">
						<img src="resources/foodImage/<%=f.getImage()%>"
							style="max-height: 100px; max-width: 100%; width: auto;"
							class="card-img-top rounded mx-auto d-block m-2" alt="img">
					</div>

					<div class="card-body">
						<h2 class="card-title">
							<%=f.getName()%></h2>
						<p class="card-text"><%=f.getDescription()%></p>
						<hr>


						<%
						if (userType != null && userType.equals("admin")) {
						%>
						<!-- <form class="form-inline" action="updatefood"> -->
						<div class="form-inline">
							<input type="hidden" name="foodId" value="<%=f.getId()%>">
							<input type="hidden" name="userId"
								value="<%if (user != null) {%><%=user.getId()%> <%}%>">

							<a href="updatefood?foodId=<%=f.getId()%>"><button
									type="submit" class="btn btn-success text-white mr-4">Update</button></a>
							<a href="deletefood?foodId=<%=f.getId()%>"><button
									type="submit" class="btn btn-danger text-white ml-4">Delete</button></a>
						</div>
						<!-- 	                                 </form> -->
						<%
						}

						else {
						%>
						<form class="form-inline" action="addtocart"
							onclick="return checkUser()">
							<input type="hidden" name="foodId" value="<%=f.getId()%>">
							<input type="hidden" name="userId"
								value="<%if (user != null) {%><%=user.getId()%> <%}%>">

							<div class="form-group mx-sm-3 mb-2">
								<input type="number" class="form-control" name="quantity"
									placeholder="0" required>
							</div>
							<button type="submit" class="btn custom-bg text-white mb-2">Add
								To Cart</button>
						</form>
						<%
						}
						%>
					</div>
					<div class="card-footer text-center">
						<p style="font-size: 25px">
							<span class="ml-2"><b>Rs. <%=f.getPrice()%>/-
							</b></span>
					</div>

				</div>

				<%
				}
				%>
			</div>
		</div>
	</div>
</body>
</html>