'use strict';

angular.module('crudApp').factory('BuildingService',
    ['$localStorage', '$http', '$q', 'urls',
        function ($localStorage, $http, $q, urls) {

            var factory = {
                loadAllBuildings: loadAllBuildings,
                getCreatedBuilding: getCreatedBuilding,
                getBuilding: getBuilding,
                createBuilding: createBuilding,
                updateBuilding: updateBuilding,
                removeBuilding: removeBuilding
            };

            return factory;

            function loadAllBuildings() {
                console.log('Fetching all Buildings');
                var deferred = $q.defer();
                $http.get(urls.BUILDING_SERVICE_API)
                    .then(
                        function (response) {
                            console.log('Fetched successfully all Buildings');
                            $localStorage.Buildings = response.data;
                            deferred.resolve(response);
                        },
                        function (errResponse) {
                            console.error('Error while loading Buildings');
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

            function getCreatedBuilding(){
                return $localStorage.createdBuilding;
            }

            function getBuilding(id) {
                console.log('Fetching Building with id :'+id);
                var deferred = $q.defer();
                $http.get(urls.GET_BUILDING_BY_ID_API + id)
                    .then(
                        function (response) {
                            console.log('Fetched successfully Building with id :'+id);
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                            console.error('Error while loading Building with id :'+id);
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

            function createBuilding(building) {
                console.log('Creating service Building'+JSON.stringify(building));
               // var obj = JSON.stringify(building);
                var deferred = $q.defer();
                $http.post(urls.BUILDING_SERVICE_API, building)
                    .then(
                        function (response) {
                            //loadAllBuildings();
                            deferred.resolve(response.data);
                            $localStorage.createdBuilding = response.data;
                            console.log("created building response= "+$localStorage.createdBuilding);
                        },
                        function (errResponse) {
                           console.error('Error while creating Building : '+errResponse.data.errorMessage);
                           deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

            function updateBuilding(Building, id) {
                console.log('Updating Building with id '+id);
                var deferred = $q.defer();
                $http.put(urls.BUILDING_UPDATE_SERVICE_API + id, Building)
                    .then(
                        function (response) {
                           // loadAllBuildings();
                        	$localStorage.createdBuilding = response.data;
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                            console.error('Error while updating Building with id :'+id);
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

            function removeBuilding(id) {
                console.log('Removing Building with id '+id);
                var deferred = $q.defer();
                $http.delete(urls.Building_SERVICE_API + id)
                    .then(
                        function (response) {
                            loadAllBuildings();
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                            console.error('Error while removing Building with id :'+id);
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

        }
    ]);