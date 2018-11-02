// Modulo angular
// scope: Alcance de variables 
// hhtp: libreria HTPP consulta de servicios REST
angular.module("MyApp", [])
    .controller("MyController",["$scope", "$http", function($scope, $http){
    	
    	$scope.showData = false; 	// Variable para mostrar resultados
    	$scope.champions = {};     	// Campeones encontrados en la consulta

    	// Consultar todos los campeonatos - protocolo HTTP
    	$scope.getAllChampions = function(){
    	  $http.get("/champion/allChampions")      // URI de llamada
    	  .then(function onSuccess(response) {     // Respuesta OK
    	
    		$scope.showData = true;
    	    $scope.champions = response.data.champions;
    	  
    	  }).catch(function onError(response) {   // Respuesta Error
    		
    		$scope.showData = false;
    	    console.log("##=> Error: ", response);
    	  
    	  });       
    	}
    	
    	// Consultar campeon para un año requerido - protocolo HTTP
    	$scope.getChampionByYear = function(){
    	  $http.get("/champion/championByYear/1986")    // URI de llamada
    	  .then(function onSuccess(response) {     		// Respuesta OK
    	
    		$scope.showData = true;
    	    $scope.champions = response.data.champions;
    	  
    	  }).catch(function onError(response) {   // Respuesta Error
    		
    		$scope.showData = false;
    	    console.log("##=> Error: ", response);
    	  
    	  });       
    	}
    	
    	// Consultar campeones ganadores por cantidad de ganados - protocolo HTTP
    	$scope.getChampionsByWins = function(){
    	  $http.get("/champion/championsByWins/2")      // URI de llamada
    	  .then(function onSuccess(response) {     // Respuesta OK
    	
    		$scope.showData = true;
    	    $scope.champions = response.data.champions;
    	    console.log("##=> champions: ", $scope.champions);
    	  
    	  }).catch(function onError(response) {   // Respuesta Error
    		
    		$scope.showData = false;
    	    console.log("##=> Error: ", response);
    	  
    	  });       
    	}
    	
    }]);