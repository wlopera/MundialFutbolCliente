// Modulo angular
// scope: Alcance de variables 
// hhtp: libreria HTPP consulta de servicios REST
angular.module("MyApp", [])
    .controller("MyController",["$scope", "$http", function($scope, $http){
    	
    	$scope.showData = false; 	// Variable para mostrar resultados
    	$scope.clients = {};     	// Clientes encontrados en la consulta

    	// Permite consultar clientes - protocolo HTTP
    	$scope.getCustomer = function(){
    	  $http.get("/client/allClient")        // URI de llamada
    	  .then(function onSuccess(response) {     // Respuesta OK
    		$scope.showData = true;
    	    $scope.clients=response.data.clients;
    	    console.log("##=> clientes: ", $scope.clients);
    	  }).catch(function onError(response) {   // Respuesta Error
    		$scope.showData = false;
    	    console.log("##=> Error: ", response);
    	  });       
    	}
    	
    }]);