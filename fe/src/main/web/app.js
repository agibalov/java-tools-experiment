angular.module("app", ["ngRoute"])
.config(["$routeProvider", function($routeProvider) {
    $routeProvider
    .when("/", {
        templateUrl: "index.tmpl.html",
        controller: "IndexController"
    })
    .otherwise({
        redirectTo: "/"
    });
}])
.controller("IndexController", ["$scope", "$http", function($scope, $http) {
    $scope.result = null;
    $scope.a = 2;
    $scope.b = 3;

    $scope.addNumbers = function() {
        $scope.result = null;
        var a = parseInt($scope.a, 10);
        var b = parseInt($scope.b, 10);

        $http.post("/addNumbers", { a: a, b: b }).then(function(response) {
            $scope.result = response.data.result;
        }, function(error) {
            throw error;
        });
    };
}]);
