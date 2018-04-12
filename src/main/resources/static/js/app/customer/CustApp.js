var app = angular.module('crudApp',['ui.router','ngStorage']);

app.constant('urls', {
    BASE: 'http://localhost:8088/SpringBootCRUDApp',
    USER_SERVICE_API : 'http://localhost:8088/SpringBootCRUDApp/api/user/'
});

app.config(['$stateProvider', '$urlRouterProvider',
    function($stateProvider, $urlRouterProvider) {

        $stateProvider
            .state('chome', {
                url: '/',
                templateUrl: 'partials/cHome',
                controller:'CustController',
                controllerAs:'custCtrl'
            });
        $urlRouterProvider.otherwise('/');
    }]);

