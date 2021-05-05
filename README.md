<h1>Service "patient"</h1>
<div>
<i>Service pour l'application Diabete Detector.</i>
<br>
Ce service contient les méthodes de lecture, d'ajout et de modification d'un patient.
</div>
<hr>
<div>
<ul>
<li> Projet Spring boot 2.4.4 Maven</li>
<li> Java 8</li>
</ul>
</div>
<hr>
<div>
<h2>Docker</h2>
<br>
<ul>
<li> création du jar : mvn package</li>
<li> création de l’image docker via la commande : <b>docker build --tag=patient:latest .</b> (le tag doit être en miniscule)</li>
<li> lancement de l’image via la commande : <b>docker run -p8081:8081 patient:latest</b></li>
</ul>
→ elle tournera sur le port 8081 <b>http://localhost:8081</b>

</div>

