<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<br />
<br />
<div class="container">
	<div class="row">
		<div class="col-sm-10">
			<div class="card">
				<div class="card-content">
					<h4 class="card-title">Tranzacții</h4>
					<hr>

					<%
						int contor = (int) session.getAttribute("contor");
						System.out.println("[tranzactii] Informatii:");
						System.out.println("Nume: " + session.getAttribute("nume"));
						System.out.println("Prenume: " + session.getAttribute("prenume"));
						System.out.println("Nr. conturi: " + contor);
						if (contor > 0) {
					%>

					<form class="form-horizontal" method="post" action="Transaction">
						<div class="form-group">
							<label class="control-label col-sm-4">Operator
								tranzacție:</label>
							<div class="col-sm-6">
								<p class="form-control-static"><%=session.getAttribute("nume")%>
									<%=session.getAttribute("prenume")%></p>
								<input type="hidden" id="operator_tranzactie"
									name="operator_tranzactie"
									value="<%=session.getAttribute("nume")%> <%=session.getAttribute("prenume")%>">
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-sm-4">Selectare cont:</label>
							<div class="col-sm-4">
								<select class="form-control" id="selectare_cont"
									name="selectare_cont">
									<%
										for (int i = 0; i < contor; i++) {
									%>
									<option value="<%=i%>"><%=session.getAttribute("tipCont" + i)%></option>
									<%
										}
									%>
								</select>
							</div>
							<button type="button" class="btn btn-link btn-sm"
								onclick="detaliiCont()">Detalii conturi</button>
						</div>

						<div class="form-group" id="conturi_disponibile">
							<label class="control-label col-sm-4">Conturi
								disponibile:</label>
							<div class="col-sm-4">

								<table class="table">
									<thead>
										<tr>
											<th scope="col">#</th>
											<th scope="col">Tip cont</th>
											<th scope="col">Sold</th>
										</tr>
									</thead>
									<tbody>
										<%
											for (int i = 0; i < contor; i++) {
										%>
										<tr>
											<th scope="row"><%=i + 1%></th>
											<td><%=session.getAttribute("tipCont" + i)%></td>
											<td><%=session.getAttribute("sold" + i)%> lei</td>
										</tr>
										<%
											}
										%>
									</tbody>
								</table>

							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-sm-4">IBAN cont
								destinație:</label>
							<div class="col-sm-4">
								<input type="text" class="form-control" id="iban_destinatie"
									name="iban_destinatie" required>
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-sm-4">Suma:</label>
							<div class="col-sm-4">
								<input type="number" step=0.01 min=0 class="form-control"
									id="suma" name="suma" required>
							</div>
						</div>

						<div class="form-group" id="submit_tranzactii">
							<div class="col-sm-offset-4 col-sm-4">
								<button type="submit" class="btn btn-default">Efectuare
									tranzacție</button>
							</div>
						</div>
					</form>

					<%
						} else {
					%>
					<p>Nu se pot efectua tranzacții deoarece nu există conturi
						asociate acestui utilizator!</p>
					<%
						}
					%>

				</div>
			</div>
		</div>
	</div>
</div>
