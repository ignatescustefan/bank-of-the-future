<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<br/><br/>
<div class="container">
    <div class="row">
        <div class="col-sm-10">
            <div class="card">
                <div class="card-content title">
                    <h4 class="card-title">
                        Contul meu
                    </h4>                                
               </div>
            </div>
        </div>
    </div>
</div>
<% 
	int contor=(int)session.getAttribute("contor"); 
	if(contor>0) {
 	
    for(int i=0;i<contor;i++) {
 %>     
 <div class="container">
    <div class="row">
        <div class="col-sm-10">
            <div class="card">
                <div class="card-content">                    
                   <br/>
                   <div class="table-responsive">
					  <table class="table">
					  <tr>
					    <th scope="row">Tip cont:</th>
					  <td><%=session.getAttribute("tipCont"+i)%></td>
					  </tr>
					   <tr>
					    <th scope="row">IBAN:</th>
					    <td><%=session.getAttribute("iban"+i)%></td>
					  </tr>
					  <tr>
					    <th scope="row">Sold:</th>
					    <td><%=session.getAttribute("sold"+i)%> lei</td>
					  </tr>
					  </table>
					</div>                  
               </div>
            </div>
        </div>
    </div>
</div> 
            
<% }   
} else { %>

<div class="container">
    <div class="row">
        <div class="col-sm-10">
            <div class="card">
                <div class="card-content">
                    <div class="message_box">
						<p>Nu există conturi de afișat!</p>
					</div>                            
               </div>
            </div>
        </div>
    </div>
</div>
	
<% } %>