function load(f) {
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function () {
		if (this.readyState == 4 && this.status == 200) {
			document.getElementById("continut").innerHTML = this.responseText;
		}
	};
	xhttp.open("GET", f, true);
	xhttp.send();
}

function displayNume() {
	var elem = document.getElementById("nume");
	var btn = document.getElementById("submit");
	elem.style.display="block";
	btn.style.display="block";
}
function displayPrenume() {
	var elem = document.getElementById("prenume");
	var btn = document.getElementById("submit");
	elem.style.display="block";
	btn.style.display="block";
}
function displayTelefon() {
	var elem = document.getElementById("telefon");
	var btn = document.getElementById("submit");
	elem.style.display="block";
	btn.style.display="block";
}

function detaliiCont() {
	var elem = document.getElementById("conturi_disponibile");
	elem.style.display="block";
}