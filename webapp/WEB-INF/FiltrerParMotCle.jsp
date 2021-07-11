<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="UTF-8">
<title>EniOnlineAuctionSite</title>

<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

</head>
<body class="container">
<nav class="navbar navbar-light bg-light  text-center">
	    <div class="navbar-brand mb-0 h1">ENI-ENCHERES</div>
        <div > <a class="navbar-item" href="#"> S'inscrire/Se connecter</a></div>
</nav>
<div class="row">
<div class= "col-lg-2"></div>
<h1 class="col-lg-4 mx-auto">Liste des enchères</h1>
</div>


	<div class="row"> <h2 class="col-lg-4"> Filtres </h2></div>
	
	
	<div class="row">
  
  	<form  action="${pageContext.request.contextPath}/AccueilRechercherParMotCle"  method="get">
  <span>
      <input   class="form-control border-primary" type="text" name="motCle" placeholder="le nom de l'article contient" id="search-input4">
    </span>
     <input class="btn btn-primary" type="submit" value="Rechercher">  
     </form>
     </div>
        
    <div class="row">
	<div> Categorie :</div>
	</div> 

	<div class="row">
	<form  action="${pageContext.request.contextPath}/AccueilRechercherParCategorie2"  method="get">
	<input type="text" name="categorie" list="categories" >
<datalist id="categories">
            <option value ="Toutes" selected="selected">Toutes</option>
			<option value="Ameublement">Ameublement</option>
			<option value="SportLoisirs">SportLoisirs</option>
			<option value="Informatique">Informatique</option>
			<option value="vetement">vetement</option>
</datalist>
	</form>
	</div>
<br>
<br>
<br>
       <div class="row row-cols-1 row-cols-md-2 g-4">
     <c:forEach var="table" items="${requestScope.Articles}">
   <div class="col">
  <div class="card border-primary mb-3">
      <div class="card-body">
        <h5 class="card-title"><a href="#" class="card-link"> <c:out value="${table.nomArticle}">
	</c:out> </a> </h5>
        <p class="card-text">
        
       <p> Prix : <c:out value="${table.miseAPrix}"></c:out> points </p> 
        <p> Fin de l'enchére : <c:out value="${table.dateFinEncheres}"></c:out> </p> 
         <p> Vendeur : <c:out value="${table.utilisateur.pseudo}"></c:out>  </p> 
        
        
        
       
        </div>
        </div>
        </div>
  
        </c:forEach>
         </div>
   
   
 
  
 


<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

</body>
</html>
