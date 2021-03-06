<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<br />
<br />
<div class="container">
	<div class="row">
		<div class="col-sm-10">
			<div class="card">
				<div class="card-content">
					<h4 class="card-title">Setări cont</h4>
					<br />
					
					<% 
					System.out.println("[setari_cont] Informatii:");
					System.out.println("Nume: " + session.getAttribute("nume"));
					System.out.println("Prenume: " + session.getAttribute("prenume"));
					System.out.println("CNP: " + session.getAttribute("cnp"));
					%>
					
					<div class="table-responsive">
						<table class="table">
							<tr>
								<th scope="row">Nume:</th>
								<td><%=session.getAttribute("nume")%></td>
								<td><button type="button" class="btn btn-secondary btn-sm"
										onclick="displayNume()">Modifică</button></td>
							</tr>
							<tr>
								<th scope="row">Prenume:</th>
								<td><%=session.getAttribute("prenume")%></td>
								<td><button type="button" class="btn btn-secondary btn-sm"
										onclick="displayPrenume()">Modifică</button></td>
							</tr>
							<tr>
								<th scope="row">CNP:</th>
								<td><%=session.getAttribute("cnp")%></td>
								<td></td>
							</tr>
							<tr>
								<th scope="row">Email:</th>
								<td><%=session.getAttribute("email")%></td>
								<td></td>
							</tr>
							<tr>
								<th scope="row">Telefon:</th>
								<td><%=session.getAttribute("telefon")%></td>
								<td><button type="button" class="btn btn-secondary btn-sm"
										onclick="displayTelefon()">Modifică</button></td>
							</tr>
						</table>
					</div>

					<br />
					<br />
					<form class="form-horizontal" method="post" action="Modify">
						<div class="form-group" id="nume">
							<label class="control-label col-sm-2" for="nume">Nume:</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" id="inputNume"
									name="nume" value="<%=session.getAttribute("nume")%>">
							</div>
						</div>
						<div class="form-group" id="prenume">
							<label class="control-label col-sm-2" for="prenume">Prenume:</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" id="inputPrenume"
									name="prenume" value="<%=session.getAttribute("prenume")%>">
							</div>
						</div>
						<div class="form-group" id="telefon">
							<label class="control-label col-sm-2" for="telefon">Telefon:</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" id="inputTelefon"
									name="telefon" value="<%=session.getAttribute("telefon")%>">
							</div>
						</div>

						<div class="form-group" id="submit">
							<div class="col-sm-offset-2 col-sm-10">
								<button type="submit" class="btn btn-default">Efectuare
									modificări</button>
							</div>
						</div>
					</form>

				</div>
			</div>
		</div>
	</div>
</div>
