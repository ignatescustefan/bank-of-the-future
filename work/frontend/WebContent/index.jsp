<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ro">

<head>
    <title>RIPBank</title>
	<link rel='icon' href='img/favicon.ico' type='image/x-icon' />
	
   <meta name="viewport" content="width=device-width, initial-scale=1">
   
   <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
	<script src="js/modernizr.js"></script> <!-- Modernizr -->
	<script src="js/scripts.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.0.0/jquery.js"></script>
   <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
   
   <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
   

	<link href='https://fonts.googleapis.com/css?family=Open+Sans:300,400,700' rel='stylesheet' type='text/css'>

	<link rel="stylesheet" href="css/reset.css"> <!-- CSS reset -->
	<link rel="stylesheet" href="css/style.css"> <!-- Resource style -->
  	
</head>
<body onload="load('pages/contul_meu.jsp');">
	<header class="cd-main-header">
		<a href="#0" class="cd-logo"><img src="img/logo2.png" alt="Logo"> </a>
		<a href="#0" class="cd-nav-trigger">Menu<span></span></a>

		<nav class="cd-nav">
			<ul class="cd-top-nav">
				<li><a href="#" onclick="load('pages/contact.jsp')">Contact</a></li>
				<li class="has-children account">
					<a href="#">
						<img src="img/cd-avatar.png" alt="avatar">
						<%=session.getAttribute("prenume")%>
					</a>

					<ul>

						<li><a href="#" onclick="load('pages/setari_cont.jsp')">Setări cont</a></li>
						<li><a href="pages/logout.jsp">Logout</a></li>
					</ul>
				</li>
			</ul>
		</nav>
	</header> <!-- .cd-main-header -->

	<main class="cd-main-content">
		<nav class="cd-side-nav">
			<ul>
				<li class="has-children overview">
					<a href="#" onclick="load('pages/contul_meu.jsp')">Contul meu</a>
				</li>
				
				<li class="has-children comments">
					<a href="#0">Plăți</a>					
					<ul>
						<li><a href="#0">Plată între conturile mele</a></li>
						<li><a href="#0">Plată în lei</a></li>
						<li><a href="#0">Plată în valută</a></li>
					</ul>
				</li>
			
				<li class="has-children bookmarks">
					<a href="#0">Rapoarte și extrase</a>
					
					<ul>
						<li><a href="#0">Raport tranzacții</a></li>
						<li><a href="#0">Extras de cont</a></li>
					</ul>
				</li>
			</ul>

		</nav>

		<div class="content-wrapper">
			<section id=continut>
			</section>
		</div> <!-- .content-wrapper -->
	</main> <!-- .cd-main-content -->
	
<script src="js/jquery-2.1.4.js"></script>
<script src="js/jquery.menu-aim.js"></script>
<script src="js/main.js"></script> <!-- Resource jQuery -->
</body>
</html>