<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Contul meu</title>
</head>
<body>
<br/><br/>
<div class="container">
    <div class="row">
        <div class="col-sm-10">
            <div class="card">
                <div class="card-content">
                    <h4 class="card-title">
                        Contul meu
                    </h4>
                   <br/><br/> 
                   <%
                   int contor=(int)session.getAttribute("contor");
                   for(int i=0;i<contor;i++) {
                   %>                  
                    <div class="table-responsive">
					  <table class="table">
					   <tr>
					    <th scope="row">IBAN:</th>
					    <td><%=session.getAttribute("iban"+i)%></td>
					  </tr>
					  <tr>
					    <th scope="row">Tip cont:</th>
					  <td><%=session.getAttribute("tipCont"+i)%></td>
					  </tr>
					  <tr>
					    <th scope="row">Sold:</th>
					    <td><%=session.getAttribute("sold"+i)%></td>
					  </tr>
					  </table>
					</div>
                    <% } %>   
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>