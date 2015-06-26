describe('app', function() {
    beforeEach(module('app'));
    describe('IndexController', function() {
        var $scope;
        beforeEach(inject(function($rootScope, $controller) {
            $scope = $rootScope.$new();
            $controller('IndexController', {
                $scope: $scope,
                $http: null // TODO
            });
        }));

        it('should set result to null', function() {
            expect($scope.result).toBeNull();
        });

        it('should set a to 2', function() {
            expect($scope.a).toBe(2);
        });

        it('should set b to 3', function() {
            expect($scope.b).toBe(3);
        });

        it('should put addNumbers to the scope', function() {
            expect($scope.addNumbers).toBeDefined();
        });
    });
});
