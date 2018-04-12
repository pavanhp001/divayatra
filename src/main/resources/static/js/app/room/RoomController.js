'use strict';

angular.module('crudApp').controller('RoomController',
    ['RoomService', '$scope','$state','BuildingService',  function( RoomService, $scope, $state, BuildingService) {

    	console.log("RoomController called");
    	
    	
        var self = this;
        self.room = {};
        self.createdBuildingData = {};
        self.rooms=[];
        self.showRoomDetails = false;

        self.submit = submit;
        self.getAllRooms = getAllRooms;
        self.getAllRoomsByBuildingId = getAllRoomsByBuildingId;
       // self.createBuilding = createBuilding;
        self.createRoom = createRoom;
        self.updateRoom = updateRoom;
        self.removeRoom = removeRoom;
        self.editRoom = editRoom;
        self.reset = reset;
        self.getCreatedBuilding = getCreatedBuilding;
        self.isNotEmpty = isNotEmpty;
        self.getBuildingData = getBuildingData;
        
        

        self.successMessage = '';
        self.errorMessage = '';
        self.done = false;
        self.room_types = ["AC", "NON_AC", "2BHK_AC", "2BHK_NON_AC"];

        self.onlyIntegers = /^\d+$/;
        self.onlyNumbers = /^\d+([,.]\d+)?$/;
        
        $scope.tabs = ['home', 'building', 'room'];
        
        $scope.currentIndex = -1;
		$scope.maxIndex = $scope.tabs.length;
        
        function next()
		{
        	console.log("next");
			$scope.currentIndex = $scope.currentIndex+1 < $scope.maxIndex ? $scope.currentIndex+1 : 0;
			var name = $scope.tabs[$scope.currentIndex];
			$state.go( name );
		}
        $scope.building = function()
		{
        	console.log("building");
			//next();
			$state.go('building');
		}
        
        $scope.room = function()
		{
        	console.log(" room controller room stage");
			//next();
			$state.go('room');
		}

        function submit() {
            console.log('Submitting room');
            if (self.room.id === undefined || self.room.id === null) {
                console.log('Saving New Room', self.room);
                if(self.createdBuildingData != undefined 
                		&& self.createdBuildingData != null 
                		&& self.createdBuildingData.id != undefined){
                	
                	self.room.building_id = self.createdBuildingData;
                	console.log("submiting room data: "+self.room);
                	createRoom(self.room);
                }
            } else {
                updateRoom(self.room, self.room.id);
                console.log('Room updated with id ', self.room.id);
            }
        }

        function createRoom(Room) {
            console.log('createRoom About to create Room');
            RoomService.createRoom(Room)
                .then(
                    function (response) {
                        console.log('Room created successfully');
                        self.successMessage = 'Room created successfully';
                        self.errorMessage='';
                        self.done = true;
                        self.room={};
                        $scope.roomForm.$setPristine();
                        self.rooms = getAllRoomsByBuildingId(self.createdBuildingData.id);
                        console.log('Room created successfully 2');
                        self.room={};
                    },
                    function (errResponse) {
                        console.error('Error while creating Room');
                        self.errorMessage = 'Error while creating Room: ' + errResponse.data.errorMessage;
                        self.successMessage='';
                    }
                );
        }


        function updateRoom(Room, id){
            console.log('updateRoom About to update Room');
            RoomService.updateRoom(Room, id)
                .then(
                    function (response){
                        console.log('Room updated successfully');
                        self.successMessage='Room updated successfully';
                        self.errorMessage='';
                        self.done = true;
                        $scope.roomForm.$setPristine();
                    },
                    function(errResponse){
                        console.error('Error while updating Room');
                        self.errorMessage='Error while updating Room '+errResponse.data;
                        self.successMessage='';
                    }
                );
        }


        function removeRoom(id){
            console.log('removeRoom About to remove Room with id '+id);
            RoomService.removeRoom(id)
                .then(
                    function(){
                        console.log('Room '+id + ' removed successfully');
                    },
                    function(errResponse){
                        console.error('Error while removing Room '+id +', Error :'+errResponse.data);
                    }
                );
        }


        function getAllRooms(){
        	console.log('getAllRooms contrller');
        	/*if(self.rooms != undefined){
        		console.log('getAllRooms :'+JSON.stringify(self.rooms));
        		return self.rooms;
        	}*/
        	return RoomService.getAllRooms();
        }
        
        /*function getAllRoomsByBuildingId(id){
        	console.log('getAllRoomsByBuildingId contrller');
        	self.rooms = RoomService.getAllRoomsByBuildingId(id);
        	console.log('getAllRoomsByBuildingId contrller'+JSON.stringify(self.rooms));
        	if(self.rooms != undefined ){
        		self.showRoomDetails = true;
        	}
            //return rooms
        }*/
        function getAllRoomsByBuildingId(id){
        	console.log('getAllRoomsByBuildingId contrller');
        	self.rooms = RoomService.getAllRoomsByBuildingId(id).then(
                    function (Rooms) {
                    	self.rooms = Rooms.data;
                    },
                    function (errResponse) {
                        console.error('Error while getAllRoomsByBuildingId ' + errResponse.data);
                    }
                );
        	console.log('getAllRoomsByBuildingId contrller'+JSON.stringify(self.rooms));
        	if(self.rooms != undefined ){
        		self.showRoomDetails = true;
        	}
            //return rooms
        }

        function editRoom(id) {
        	console.log('editRoom contrller');
            self.successMessage='';
            self.errorMessage='';
            RoomService.getRoom(id).then(
                function (Room) {
                    self.room = Room;
                },
                function (errResponse) {
                    console.error('Error while editRoom Room ' + id + ', Error :' + errResponse.data);
                }
            );
        }
        function reset(){
        	console.error('reset contrller');
            self.successMessage='';
            self.errorMessage='';
            self.room={};
            $scope.roomForm.$setPristine(); //reset Form
        }
        
        function getCreatedBuilding(){
        	console.log("getCreatedBuilding in room controller : ");
        	if(BuildingService.getCreatedBuilding() != undefined 
        			&& BuildingService.getCreatedBuilding().id != undefined){
        		self.createdBuildingData = BuildingService.getCreatedBuilding();
        		self.room.building_id = self.createdBuildingData;
        	}if(self.createdBuildingData != undefined && self.createdBuildingData.building_name !=undefined ){
        		return self.createdBuildingData;
        	}
        	console.log("getCreatedBuilding in room controller return statment: ");
            return BuildingService.getCreatedBuilding();
        }
        function isNotEmpty(obj) {
        	console.log("isNotEmpty in room controller : ");
        	if(obj == undefined || obj.id == undefined || obj.id == '' ){
        		console.log("isNotEmpty : false");
        		return false;
        	}else{
        		console.log("building_name: "+obj.building_name);
        		if(obj.building_name == undefined || obj.building_name == ''){
        			console.log("isNotEmpty else : false");
        			return false;
        		}
        		console.log("isNotEmpty else : true");
        		return true;
        		
        	}
        }
        function getBuildingData(id){
        	console.log("getBuildingData in room controller : "+id);
        	
        	BuildingService.getBuilding(id).then(
                    function (building) {
                        self.createdBuildingData = building;
                        console.log("building success :"+building.building_name);
                        console.log("getBuildingData success :"+self.createdBuildingData.building_name);
                    },
                    function (errResponse) {
                        console.error('Error while removing Building ' + id + ', Error :' + errResponse.data);
                    }
                );
        	getAllRoomsByBuildingId(id);
        }
    }


    ]);