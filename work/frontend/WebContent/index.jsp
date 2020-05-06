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

<%  
     if (session.getAttribute("cnp") != null) {  
%>

<body onload="load('pages/contul_meu.jsp');">
	<header class="cd-main-header">
		<a href="#" class="cd-logo" onclick="load('pages/contul_meu.jsp')"><img src="img/logo2.png" alt="Logo"> </a>
		<a href="#" class="cd-nav-trigger">Menu<span></span></a>

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
					<a href="#" onclick="load('pages/tranzactii.jsp')">Tranzacții</a>					
				</li>
			
				<li class="has-children bookmarks">
					<a href="#">Rapoarte și extrase</a>
					
					<ul>
						<li><a href="#" onclick="load('pages/raport_tranzactii.jsp')">Raport tranzacții</a></li>
						<li><a href="#" onclick="load('pages/extras_cont.jsp')">Extras de cont</a></li>
					</ul>
				</li>
				
				<li class="has-children notifications">
					<a href="pages/curs_valutar.jsp">Curs valutar</a>
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
	
<%  
     } else {
 %>
 	<body>
	<br/><br/> <br/><br/> <br/><br/>
	<div class="container">
	    <div class="row">
	        <div class="col-sm-10">
	            <div class="card">
	                <div class="card-content atention">
	                    <div class="card-title">
                        <h4>Nu puteți accesa această pagină dacă nu sunteți autentificat!</h4>
	                    <hr>
                    </div>
                    <div class="message_box">
						<button class="home_button" onclick="location.href='login.jsp'">Accesează pagina de login</button>
					</div> 	    			               
	                </div>
	            </div>
	        </div>
	    </div>
	</div>
	</body>	
<%  
     }
 %>

</html>