<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<br/><br/>
<div class="container">
    <div class="row">
        <div class="col-sm-10">
            <div class="card">
                <div class="card-content">
                    <h4 class="card-title">
                        Extras de cont
                    </h4>
                    <hr>
                   <br/>  
                    <div class="form-group" id="text_raport"> 
						<div class="col-sm-offset-4">
						 	&nbsp;&nbsp;Selectați intervalul de timp:
						</div>
					</div>                  
                   
					<form class="form-horizontal" method="post" action="GeneratePDF">
					 <div class="form-group">
					    <label class="control-label col-sm-4">Dată început:</label>
					    <div class="col-sm-4">
					    <input type="text" class="form-control" name="data_start" placeholder="YYYY-MM-DD" required 
						pattern="(?:19|20)[0-9]{2}-(?:(?:0[1-9]|1[0-2])-(?:0[1-9]|1[0-9]|2[0-9])|(?:(?!02)(?:0[1-9]|1[0-2])-(?:30))|(?:(?:0[13578]|1[02])-31))" 
						title="Enter a date in this format YYYY-MM-DD"/>
					    </div>
					  </div>
					 <div class="form-group">
					    <label class="control-label col-sm-4">Dată sfârșit:</label>
					    <div class="col-sm-4">
					      <input type="text" class="form-control" name="data_stop" placeholder="YYYY-MM-DD" required 
						pattern="(?:19|20)[0-9]{2}-(?:(?:0[1-9]|1[0-2])-(?:0[1-9]|1[0-9]|2[0-9])|(?:(?!02)(?:0[1-9]|1[0-2])-(?:30))|(?:(?:0[13578]|1[02])-31))" 
						title="Enter a date in this format YYYY-MM-DD"/>
					    </div>
					  </div>
					  <div class="form-group" id="submit_raport"> 
					    <div class="col-sm-offset-4 col-sm-4">
					      <button type="submit" class="btn btn-default">Generare extras de cont</button>
					    </div>
					  </div>
					</form>
					
                </div>
            </div>
        </div>
    </div>
</div>
