var monitorApp = angular.module("monitorApp", []);

/**
 * monitorMainController (home page)
 */
monitorApp.controller('monitorMainController', function($scope, $rootScope, $http) {
	
	// Loaded list of Machine
	$scope.machineList     = null;
	
	// Selected values by the user
	$scope.selectedParkId  = null;
	$scope.selectedMachine = null;
	
	// Loading all the machine in the current park
	$http.get("/WS-MASTERE-IS/machine?parkId=1&selectMode=all")
		.then(function(response){
			$scope.machineList = response.data;
		});
	
	// Delete a machine from the park
	$scope.deleteSelectedMachine = function(){
		
		console.log("Deleting : " + $scope.selectedMachine);
		
		if($scope.selectedMachine == null)
			return;
		
		// Data for DELETE : only machine id
		var data = {machineId: $scope.selectedMachine.id}
		
		// Sending DELETE request
		$http.delete("/WS-MASTERE-IS/machine", data)
			.then(function(response) {

				if(response != null)
					console.log(response.data);
				
		});
		
	}
	
});