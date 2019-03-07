## Structura de directoare și fișiere

* **db** - script-uri sql de creare/populare a bazei de date
* **docs** - documente
* **sandbox** - loc unde se pot testa diverse componente
* **work** - codul aplicației
* * **backend** - servere, aplicație desktop
    * **embedded** - token pentru autentificarea în doi pași
    * **frontend**
	* * **css** - fișierele de stil
	* * **img** - imagini
	* * **include** - fișiere php care sunt incluse în alte fișiere
	* * **js** - fișiere javascript
	* * fișierele **jsp** ale apicației

---


## Task-uri/Componente

* Stabilirea structurii bazei de date + aplicație desktop (**Ștefan Ignătescu**)
* Design-ul site-ului (layout, meniu, logo, ...) + api (**Nicolae Boca**)
* Servicii web + servere (**Gabriel Răileanu**)
* Hardware + interfațare (**Cosmin Popovici**)

---

## Tipuri de utilizatori

* **Client al băncii**
* 	* poate să-și vadă soldul
	* generează extras de cont/informații despre cont
	* istoric tranzacții (generare PDF)
	* schimbare informații cont/PIN
	* închidere/deschidere depozit

* **Operator bancar**
* 	* search(după CNP, nume)
	* administrare conturi, detalii user + acțiuni privilegiate
    * generare extras cont
    * poate face încasări/depuneri/alte operațiuni
    * înregistrare/creare cont pentru un nou client

