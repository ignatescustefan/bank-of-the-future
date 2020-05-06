<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>RIPBank</title>
<link rel='icon' href='../img/favicon.ico' type='image/x-icon' />

<meta name="viewport" content="width=device-width, initial-scale=1">

<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
<script src="../js/modernizr.js"></script>
<!-- Modernizr -->
<script src="../js/scripts.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.0.0/jquery.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"
	integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS"
	crossorigin="anonymous"></script>


<link
	href='https://fonts.googleapis.com/css?family=Open+Sans:300,400,700'
	rel='stylesheet' type='text/css'>

<link rel="stylesheet" href="../css/reset.css">
<!-- CSS reset -->
<link rel="stylesheet" href="../css/style.css">
<!-- Resource style -->

</head>
<body>

	<header class="cd-main-header">
		<a class="cd-logo"><img src="../img/logo2.png" alt="Logo"> </a>
	</header>
	<!-- .cd-main-header -->

	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
	<div class="container">
		<div class="row">
			<div class="col-sm-10">
				<div class="card">
					<div class="card-content">
						<div class="card-title">
							<h4>Raport tranzacții</h4>
							<hr>
						</div>

						<% 
	                    	int contor=(int)session.getAttribute("contor_RT"); 
	                    	if(contor>0) {
                    	%>

						<table class="table table-hover">
							<thead>
								<tr>
									<th scope="col">#</th>
									<th scope="col">Operator tranzacție</th>
									<th scope="col">Tip tranzacție</th>
									<th scope="col">IBAN sursă</th>
									<th scope="col">IBAN destinație</th>
									<th scope="col">Sumă</th>
									<th scope="col">ID tranzacție</th>
									<th scope="col">Dată tranzacție</th>
									<th scope="col">Oră tranzacție</th>
								</tr>
							</thead>
							<tbody>

								<%
									for(int i=0;i<contor;i++) {
								 %>
								<tr>
									<th scope="row"><%=i+1%></th>
									<td><%=session.getAttribute("operatorTranzactie_RT"+i)%></td>
									<td><%=session.getAttribute("tipTranzactie_RT"+i)%></td>
									<td><%=session.getAttribute("ibanSource_RT"+i)%></td>
									<td><%=session.getAttribute("ibanDest_RT"+i)%></td>
									<td><%=session.getAttribute("amount_RT"+i)%> lei</td>
									<td><%=session.getAttribute("idTranzactie_RT"+i)%></td>
									<td><%=session.getAttribute("dataTranzactie_RT"+i)%></td>
									<td><%=session.getAttribute("oraTranzactie_RT"+i)%></td>
								</tr>
								<% } %>

							</tbody>
						</table>

						<br />
						<div class="message_box">
							<button class="home_button"
								onclick="location.href='../index.jsp'">Înapoi la pagina
								principală</button>
						</div>

						<% } else { %>

						<div class="message_box">
							<p>Nu există tranzacții efectuate în intervalul selectat!</p>
							<br />
							<button class="home_button"
								onclick="location.href='../index.jsp'">Înapoi la pagina
								principală</button>
						</div>

						<% } %>
					</div>
				</div>
			</div>
		</div>
	</div>


</body>
</html>