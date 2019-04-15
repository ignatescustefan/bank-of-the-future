<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<br/><br/>
<div class="container">
    <div class="row">
        <div class="col-sm-10">
            <div class="card">
                <div class="card-content">
                    <h4 class="card-title">
                        Tranzacții
                    </h4>
                     <hr>                 
                    
                    <form class="form-horizontal" method="post" action="Transaction">
					  <div class="form-group">
					    <label class="control-label col-sm-4">Operator tranzacție:</label>
					    <div class="col-sm-6">
					       <p class="form-control-static"><%=session.getAttribute("nume")%> <%=session.getAttribute("prenume")%></p>
					   		<input type="hidden" id="operator_tranzactie" name="operator_tranzactie" value="<%=session.getAttribute("nume")%> <%=session.getAttribute("prenume")%>">
					    </div>
					  </div>
					  <div class="form-group" id="selectare_cont">
					    <label class="control-label col-sm-4">Selectare cont:</label>
					    <div class="col-sm-4">
					      <select class="form-control" id="selectare_cont" name="selectare_cont">
					       <%
							 	int contor=(int)session.getAttribute("contor");
							    for(int i=0;i<contor;i++) {
							 %>   
					        <option value="<%=i%>"><%=session.getAttribute("tipCont"+i)%></option>
					       <% } %> 
					      </select>
					      </div>
					  </div>
					  <div class="form-group">
					    <label class="control-label col-sm-4">IBAN cont destinație:</label>
					    <div class="col-sm-4">
					      <input type="text" class="form-control" id="iban_destinatie" name="iban_destinatie" required>
					    </div>
					  </div>
					   <div class="form-group">
					    <label class="control-label col-sm-4">Suma:</label>
					    <div class="col-sm-4">
					      <input type="number" step=0.01 min=0 class="form-control" id="suma" name="suma" required>
					    </div>
					  </div>
					  
					  <div class="form-group" id="submit_tranzactii"> 
					    <div class="col-sm-offset-4 col-sm-4">
					      <button type="submit" class="btn btn-default">Efectuare tranzacție</button>
					    </div>
					  </div>
					</form>
									
                </div>
            </div>
        </div>
    </div>    
</div>
