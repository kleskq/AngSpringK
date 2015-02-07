describe('AuthenticationService Tests', function (){
    var AuthenticationService;

    // excuted before each "it" is run.
    beforeEach(function (){

        // load the module.
        module('app');

        // inject your service for testing.
        // The _underscores_ are a convenience thing
        // so you can have your variable name be the
        // same as your injected service.
        inject(function(_AuthenticationService_) {
            AuthenticationService = _AuthenticationService_;
        });
    });

    it('should have a login function', function () {
        expect(angular.isFunction(AuthenticationService.login)).toBe(true);
    });

    it('should have a logout function', function () {
        expect(angular.isFunction(AuthenticationService.logout)).toBe(true);
    });
});