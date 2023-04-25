<%@page import="com.jsp.dto.User"%>
<%@page import="com.jsp.dto.Gallary"%>

<%@page import="com.jsp.service.FavoriteService"%>
<%@page import="java.util.List"%>
<%@page session="false"%>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="index.css">
<link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css'
	rel='stylesheet'>
<title>Dairy</title>
</head>
<body>
	<%
	HttpSession session = request.getSession(false);
	if (session != null) {
		User u = (User)session.getAttribute("email");
		FavoriteService fs=new FavoriteService();
	%>
	<nav class="sidebar ">
		<header>
			<div class="image-text">
				<span class="image"> <img src="get?email=<%=u.getEmail()%>"
					alt="vin-logo">
				</span>
				<div class="text header-text">
					<span class="name"> WELLCOME</span> <span class="profession"><%=u.getFname() %>&nbsp<%=u.getLname() %></span>
				</div>
			</div>
			<i class='bx bx-chevron-right toggle'></i>
		</header>
		<div class="menu-bar">
			<div class="menu">
				<li class="search-box"><i class='bx bx-search-alt icon'></i> <input
					type="search" placeholder="Search..."></li>
				<ul class="menu-links">
					<li class=" nav-links "><a href="home.jsp"> <i
							class='bx bxs-home icon'></i> <span class="text nav-text">ALL USER</span>
					</a></li>
					<li class="nav-links"><a href="profile.jsp"> <i class='bx bxs-user-detail icon'></i> <span
							class="text nav-text">Profile</span>
					</a></li>
					<li class="nav-links"><a href="insert.jsp"> <i
							class='bx bx-message-square-add icon'></i> <span
							class="text nav-text">Insert</span>
					</a></li>
					<li class="active1 nav-links"><a href="getallgallary"> <i class='bx bx-photo-album icon'></i> <span class="text nav-text">Gallary</span>
					</a></li>
					<li class="nav-links"><a href="getallfav"> <i
							class='bx bxs-heart icon'></i> <span class="text nav-text">Favorate</span>
					</a></li>
					<li class="nav-links"><a href="getalldraft"> <i
							class='bx bx-wallet icon'></i> <span class="text nav-text">Draft</span>
					</a></li>
				</ul>
			</div>
			<div class="button-content">
				<li class=""><a href="logout"> <i
						class='bx bx-log-out icon'></i> <span class="text nav-text">Exit</span>
				</a></li>
				<li class="mode">
					<div class="moon-sun">
						<i class='bx bx-moon icon moon'></i> <i class='bx bx-sun icon sun'></i>
					</div> <span class="mode-text text">Dark mode</span>
					<div class="toggle-switch">
						<span class="switch"> </span>
					</div>
				</li>
			</div>
		</div>

	</nav>

	<section class="home">
		<h1>Gallary</h1>
		<%
		List<Gallary> list = (List) request.getAttribute("image");
		for (Gallary e : list) {
			String e1 = e.getDate_time();
		%>
		<table>
		<tr >
		<td rowspan=3><img style="border-radius:0px" src="getgallaryimage?email=<%=e1%>"  ></td>
		<td>
		<h2><%=e.getDisc() %></h2></td>
		</tr>
		<tr>
		<td><h2><%=e.getDate_time() %></h2> </td>
		</tr>
		<%if(fs.getByEmail(e.getDate_time())!=null){ %>
		<tr><td><a href="addtofav?id=<%=e1%>"><i style="color:red;" class='bx bxs-heart'></i></a>
</td><td><a href="removefromgallary?id=<%=e1%>"><i class='bx bx-trash'></i></a></td>
</tr><%}else{ %>
<tr><td><a href="addtofav?id=<%=e1%>"><i class='bx bx-heart'></i></a>
</td><td><a href="removefromgallary?id=<%=e1%>"><i class='bx bx-trash'></i></a></td>
</tr>
<%
}
		}
		%>
		</table>
	</section>

	<script src="script.js"></script>
	<%
	} else {
	%>
	<h1>not a valid user</h1>
	<a href="index.jsp">click here to login</a>
	<%
	}
	%>
</body>
</html>