describe('MainController Tests', function() {

    var $rootScope, $controller;

    beforeEach(function() {

        // load the module.
        module('app');

        inject(function(_$rootScope_, _$controller_) {

            $rootScope = _$rootScope_;

            $controller = _$controller_('MainController', {'$scope': $rootScope });
        });
    });

    it('should have an logout function in scope', function () {
        expect(angular.isFunction($rootScope.logout)).toBe(true);
    });
});