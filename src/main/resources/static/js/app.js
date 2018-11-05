// Modulo angular
// scope: Alcance de variables 
// hhtp: libreria HTPP consulta de servicios REST
var MyApp = angular.module("MyApp", []);

MyApp.controller("MyController",["$scope", "service", function($scope, service){
    	
	
    	
    	$scope.showData = false; 	// Variable para mostrar resultados
    	$scope.champions = {};     	// Campeones encontrados en la consulta
    	
    	$scope.qtys = {};
    	$scope.years = {};

    	// Consultar todos los campeonatos - protocolo HTTP
    	$scope.getAllChampions = function(){
    	  getHttp("/champion/allChampions");
    	};
    	
    	// Consultar campeon para un año requerido - protocolo HTTP
    	$scope.getChampionByYear = function(){
    		getHttp("/champion/championByYear/" + $scope.param);
    	};
    	
    	// Consultar campeones ganadores por cantidad de ganados - protocolo HTTP
    	$scope.getChampionsByWins = function(){
    	  getHttp("/champion/championsByWins/" + $scope.param);       
    	};
    	
    	function getHttp(uri) {
	    	service.getHttp(uri)
	    	.then(function(response) {
	    		console.log(response);
	    		$scope.showData = true;
	    	    $scope.champions = response.data.champions;
	        }).catch(function(err) {
	        	$scope.showData = false;
	            console.error("Error del servicio consulta http: ", err);
	        });
    	};

    	function getData(uri) {
	    	service.getHttp(uri)
	    	.then(function(response) {
	    		$scope.qtys = response.data.qtys;
	    		$scope.years = response.data.years;
	    		console.log(response);
	        }).catch(function(err) {
	            console.error("Error del servicio consulta http: ", err);
	        });
    	};

    	getHttp("/champion/allChampions");
    	getData("/champion/data");
    	
    	$scope.hideTable = function() {
    		$scope.param = "";
    		$scope.showData = false;
    	}
    	
    }]);