'use strict';

angular.module('crudApp').factory('RoomService',
    ['$localStorage', '$http', '$q', 'urls',
        function ($localStorage, $http, $q, urls) {
    	
    	console.log("RoomService called");


            var factory = {
                loadAllRooms: loadAllRooms,
                getAllRooms: getAllRooms,
                getRoom: getRoom,
                createRoom: createRoom,
                updateRoom: updateRoom,
                removeRoom: removeRoom,
                getAllRoomsByBuildingId: getAllRoomsByBuildingId
            };

            return factory;

            function loadAllRooms() {
                console.log('loadAllRooms Rooms');
                var deferred = $q.defer();
                $http.get(urls.ROOM_LIST_SERVICE_API)
                    .then(
                        function (response) {
                            console.log('Fetched successfully all Rooms');
                            $localStorage.Rooms = response.data;
                            deferred.resolve(response);
                        },
                        function (errResponse) {
                            console.error('Error while loading Rooms');
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }
            function getAllRoomsByBuildingId(id){
            	
            	console.log('getAllRoomsByBuildingId Rooms'+id);
                var deferred = $q.defer();
                $http.get(urls.ROOM_LIST_BY_BUILDING_SERVICE_API+id)
                    .then(
                        function (response) {
                            console.log('Fetched successfully all Rooms');
                            $localStorage.rooms = response.data;
                            deferred.resolve(response);
                        },
                        function (errResponse) {
                            console.error('Error while loading Rooms');
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            	
            }

            function getAllRooms(){
            	console.log("getAllRooms");
                return $localStorage.rooms;
            }

            function getRoom(id) {
                console.log('getRoom Room with id :'+id);
                var deferred = $q.defer();
                $http.get(urls.ROOM_SERVICE_API + id)
                    .then(
                        function (response) {
                            console.log('Fetched successfully Room with id :'+id);
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                            console.error('Error while loading Room with id :'+id);
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

            function createRoom(room) {
                console.log('Creating Room');
                var deferred = $q.defer();
                $http.post(urls.ROOM_SERVICE_API, room)
                    .then(
                        function (response) {
                            //loadAllRooms();
                        	getAllRoomsByBuildingId(room.building_id.id);
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                           console.error('Error while creating Room : '+errResponse.data.errorMessage);
                           deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

            function updateRoom(room, id) {
                console.log('updateRoom with id '+id);
                var deferred = $q.defer();
                $http.put(urls.ROOM_SERVICE_API + id, room)
                    .then(
                        function (response) {
                            //loadAllRooms();
                        	getAllRoomsByBuildingId(room.building_id);
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                            console.error('Error while updating Room with id :'+id);
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

            function removeRoom(id) {
                console.log('removeRoom Room with id '+id);
                var deferred = $q.defer();
                $http.delete(urls.ROOM_SERVICE_API + id)
                    .then(
                        function (response) {
                            //loadAllRooms();
                        	getAllRoomsByBuildingId(room.building_id);
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                            console.error('Error while removing Room with id :'+id);
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

        }
    ]);