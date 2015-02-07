describe('Base64Service Tests', function (){
    var Base64Service;

    // excuted before each "it" is run.
    beforeEach(function (){

        // load the module.
        module('app');

        // inject your service for testing.
        // The _underscores_ are a convenience thing
        // so you can have your variable name be the
        // same as your injected service.
        inject(function(_Base64Service_) {
            Base64Service = _Base64Service_;
        });
    });

    it('should have an encode function', function () {
        expect(angular.isFunction(Base64Service.encode)).toBe(true);
    });

    it('should have an decode function', function () {
        expect(angular.isFunction(Base64Service.decode)).toBe(true);
    });
});