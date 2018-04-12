'use strict';

angular.module('crudApp').controller('CustController',
    ['CustService', '$scope',  function( CustService, $scope) {

        var self = this;
        self.search = {};
        
        self.cities = ["Vemulawada","Thirupathi","Yadadri"];
        
        console.log("name"+self.search.name);

        self.submit = submit;
       
        self.successMessage = '';
        self.errorMessage = '';
        self.done = false;
        self.max = new Date();
        
        console.log('Submitting'+self.max);

        self.onlyIntegers = /^\d+$/;
        self.onlyNumbers = /^\d+([,.]\d+)?$/;

        function submit() {
            console.log('Submitting'+JSON.stringify(self.search));
        }
    }


    ]);