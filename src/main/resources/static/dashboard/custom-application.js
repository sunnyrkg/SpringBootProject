var myApp = angular.module("myApp",[]);
    myApp.controller("headerController",function($scope,$http)
    {
        $http.get("/session-services/get-loggedinuser").then(function(response){
            $scope.userName = response.data.firstName + " " +response.data.lastName;
        });
    });
    myApp.controller("staticsController",function($scope,$http){
        $http.get("/session-services/get-loggedinuser-statics").then(function(response)
        {
            $scope.staticsData = response.data;
            console.log(response.data);
        });
    });
    myApp.controller("raisedEventTableControl",function($scope,$http){
        $http.get("/session-services/get-raised-event-details").then(function(response){
            $scope.eventsRaised = response.data;
        })
    });
    myApp.controller("raiseNewEventForm",function($scope,$http){
        $http.get("/data-controller/get/designation").then(function(response){
            $scope.allDesignations = response.data;
        });
        $http.get("/data-controller/get/skill").then(function(response){
            $scope.allSkills = response.data;
        });
    });