'use strict';

angular.module('crudApp').controller('BuildingController',
    ['BuildingService', '$scope','$state',  function( BuildingService, $scope, $state) {
        console.log('BuildingController');
        var self = this;
        self.building = {};
        self.createdBuilding = {};
        self.buildings=[];

        self.submit = submit;
        self.isNotEmpty = isNotEmpty;
        self.getCreatedBuilding = getCreatedBuilding;
        self.createBuilding = createBuilding;
        self.updateBuilding = updateBuilding;
        self.removeBuilding = removeBuilding;
        self.editBuilding = editBuilding;
        self.reset = reset;
        self.room = room;

        self.successMessage = '';
        self.errorMessage = '';
        self.done = false;

        self.onlyIntegers = /^\d+$/;
        self.onlyNumbers = /^\d+([,.]\d+)?$/;
        
        function room()
		{
        	console.log("building room"+building);
			//next();
			$state.go('room');
		}

        function submit() {
            console.log('Submitting building');
            if ((self.building.id === undefined || self.building.id === null) 
            		&& (self.building.building_name != undefined && self.building.building_name != '')) {
                console.log('Saving New Building', self.building);
                createBuilding(self.building);
            } else {
                updateBuilding(self.building, self.building.id);
                console.log('Building updated with id ', self.building.id);
            }
        }
        
        function isNotEmpty(building) {
        	if(building == undefined || building.id == undefined || building.id == '' ){
        		return false;
        	}else{
        		return true;
        		
        	}
        }

        function createBuilding(building) {
            console.log('About to create Building');
            BuildingService.createBuilding(building)
                .then(
                    function (response) {
                        console.log('Building created successfully');
                        self.successMessage = 'Building created successfully';
                        self.errorMessage='';
                        self.done = true;
                        self.building={};
                        $scope.myForm.$setPristine();
                    },
                    function (errResponse) {
                        console.error('Error while creating Building');
                        self.errorMessage = 'Error while creating Building: ' + errResponse.data.errorMessage;
                        self.successMessage='';
                    }
                );
        }


        function updateBuilding(building, id){
            console.log('About to update Building');
            BuildingService.updateBuilding(building, id)
                .then(
                    function (response){
                        console.log('Building updated successfully');
                        self.successMessage='Building updated successfully';
                        self.errorMessage='';
                        self.done = true;
                        $scope.myForm.$setPristine();
                    },
                    function(errResponse){
                        console.error('Error while updating Building');
                        self.errorMessage='Error while updating Building '+errResponse.data;
                        self.successMessage='';
                    }
                );
        }


        function removeBuilding(id){
            console.log('About to remove Building with id '+id);
            BuildingService.removeBuilding(id)
                .then(
                    function(){
                        console.log('Building '+id + ' removed successfully');
                    },
                    function(errResponse){
                        console.error('Error while removing Building '+id +', Error :'+errResponse.data);
                    }
                );
        }


        function getCreatedBuilding(){
        	if(BuildingService.getCreatedBuilding() != undefined){
        		
        		self.building = BuildingService.getCreatedBuilding();
        	}
        	
            return BuildingService.getCreatedBuilding();
        }

        function editBuilding(id) {
            self.successMessage='';
            self.errorMessage='';
            BuildingService.getBuilding(id).then(
                function (building) {
                    self.building = building;
                },
                function (errResponse) {
                    console.error('Error while removing Building ' + id + ', Error :' + errResponse.data);
                }
            );
        }
        function reset(){
            self.successMessage='';
            self.errorMessage='';
            self.building={};
            $scope.myForm.$setPristine(); //reset Form
        }
    }


    ]);