function incarca(f){
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
	  if (this.readyState == 4 && this.status == 200) {
        if (f == "biblioteca.html") {
            setTimeout(function(){
                loadXML();
            }, 2000);
        }
	   document.getElementById("continut").innerHTML = this.responseText;
	  }
	};
	xhttp.open("GET", f, true);
	xhttp.send();

}

$('.btn-expand-collapse').click(function(e) {
	$('.navbar-primary').toggleClass('collapsed');
});