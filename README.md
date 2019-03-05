## Structura de directoare și fișiere

* **db** - script-uri sql de creare/populare a bazei de date
* **docs** - documente
* **sandbox** - loc unde se pot testa diverse componente
* **work** - codul aplicației
	* **api** - servicii web (fișiere php care sunt cerute prin intermediul AJAX)
	* **css** - fișierele de stil
	* **img** - imagini
	* **include** - fișiere php care sunt incluse în alte fișiere
	* **js** - fișiere javascript
	* fișierele php ale apicației (index.php, login.php, ...)

---


## Task-uri/Componente

* Stabilirea structurii bazei de date + aplicatie desktop (**Ștefan Ignătescu**)
* Design-ul site-ului (layout, meniu, logo, ...) + api (**Nicolae Boca**)
* Servicii web + servere (**Gabriel Răileanu**)
* Hardware + interfațare (**Cosmin Popovici**)

---

## Tipuri de utilizatori

* **Guest**
	* Vizualizarea ocupării sălilor
	* Căutarea unui eveniment după tipul acestuia
* **Teacher**
	* Programarea unui examen/colocviu (ideal ar fi ca fiecare cadru didactic să poată să programeze doar examenele la care este titular)
	* Rezervarea unei săli pentru un alt eveniment
	* Modificarea unei rezervări proprii
* **Admin**
	* Setarea calendarului după calendarul anului universitar (când sunt semestrele, vacanțele, ..)
	* Încărcarea orarului în format excel pentru introducerea în baza de date
	* Rezervarea unei săli
	* Modificarea unei rezervări
	* Confirmarea rezervării unei săli (poate să fie user separat pentru confirmare?)
* **Client**
	*

* **Operator bancar**
	*

