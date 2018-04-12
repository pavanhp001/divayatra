var app = angular.module('crudApp',['ui.router','ngStorage']);

app.constant('urls', {
    BASE: window.location.protocol+'//'+window.location.host+window.location.pathname,
    USER_SERVICE_API : 'http://localhost:8088/SpringBootCRUDApp/api/user/',
    BUILDING_SERVICE_API : 'http://localhost:8088/SpringBootCRUDApp/building/createBuilding/',
    BUILDING_UPDATE_SERVICE_API : 'http://localhost:8088/SpringBootCRUDApp/building/updateBuilding/',
    GET_BUILDING_BY_ID_API : 'http://localhost:8088/SpringBootCRUDApp/building/getBuilding/',
    ROOM_SERVICE_API : 'http://localhost:8088/SpringBootCRUDApp/room/createRoom/',
    ROOM_LIST_SERVICE_API : 'http://localhost:8088/SpringBootCRUDApp/room/listall/',
    GET_ROOM_BY_ID_API : 'http://localhost:8088/SpringBootCRUDApp/room/listbyid/',
    UPDATE_ROOM_BY_ID_API : 'http://localhost:8088/SpringBootCRUDApp/room/updateRoom/',
    ROOM_LIST_BY_BUILDING_SERVICE_API : 'http://localhost:8088/SpringBootCRUDApp/room/listRoomsByBuildingId/'

});
console.log("url = "+window.location.protocol+'//'+window.location.host+window.location.pathname);


app.config(['$stateProvider', '$urlRouterProvider',
    function($stateProvider, $urlRouterProvider) {

        $stateProvider.state('home1', {
        	name: 'home1',
            url: '/',
            templateUrl: 'partials/home',
            controller:'HomeController',
            controllerAs:'homectrl',
        }).state('home', {
            	name: 'home',
                url: '/hotelAdmin/',
                templateUrl: 'partials/list',
                controller:'UserController',
                controllerAs:'ctrl',
                resolve: {
                    users: function ($q, UserService) {
                        console.log('Load all users');
                        var deferred = $q.defer();
                        UserService.loadAllUsers().then(deferred.resolve, deferred.resolve);
                        return deferred.promise;
                    }
                }
            }).state('building', {
            	name: 'building',
                url: '/building',
                templateUrl: 'partials/building',
                controller:'BuildingController',
                controllerAs:'bctrl'
            }).state('room', {
            	name: 'room',
                url: '/room',
                templateUrl: 'partials/room',
                controller:'RoomController',
                controllerAs:'rctrl'
            });
        $urlRouterProvider.otherwise('/');
    }]);

