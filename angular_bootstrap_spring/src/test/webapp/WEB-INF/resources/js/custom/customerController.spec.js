describe('CustomerController Tests', function() {
    var $rootScope, $controller, mockCustomerService, deferred, spyPromise, customerData;

    beforeEach(function() { module('app'); });

    beforeEach(
        inject(function(_$rootScope_, _$controller_, _$q_) {

            $rootScope = _$rootScope_.$new();

            //create a promise for the spy to return to mock the async calls to the service
            deferred = _$q_.defer();
            spyPromise = deferred.promise;

            //create spy for the service being called so it is mocked out
            mockCustomerService = jasmine.createSpyObj('CustomerService',['getCustomers', 'deleteCustomer', 'saveCustomer']);

            // initialize controller
            $controller = _$controller_('CustomerController', {'$scope': $rootScope, CustomerService : mockCustomerService });

            // define initial customer data
            customerData = [
                {"id": 1, "firstName": "Foo", "lastName": "Bar"},
                {"id": 2, "firstName": "Jim", "lastName": "Sunny"},
                {"id": 3, "firstName": "Peter", "lastName": "Prone"},
                {"id": 4, "firstName": "Sam", "lastName": "Sully"}
            ];
        })
    );

    describe('CustomerController Structural Tests', function() {

        it('should have an init function in scope', function () {
            expect(angular.isFunction($rootScope.init)).toBe(true);
        });

        it('should have an save function in scope', function () {
            expect(angular.isFunction($rootScope.save)).toBe(true);
        });

        it('should have an delete function in scope', function () {
            expect(angular.isFunction($rootScope.delete)).toBe(true);
        });
    });

    describe('CustomerController Init Tests', function() {

        beforeEach(function() {
            //setup the spy to always return the spyPromise for the entire test spec
            mockCustomerService.getCustomers.and.returnValue(spyPromise);
        });

        it('should initially has customers undefined before any calls are made', function(){
            expect($rootScope.customers).toEqual(undefined);
        });

        it('should have scope variable customers populated', function () {
            $rootScope.init();

            deferred.resolve(customerData);

            $rootScope.$apply();

            expect($rootScope.customers).toEqual(customerData);
            expect(mockCustomerService.getCustomers).toHaveBeenCalled();
        });
    });

    describe('CustomerController Save Tests', function() {

        beforeEach(function() {
            spyOn(console, 'error');

            $rootScope.customers = customerData;

            //setup the spy to always return the spyPromise for the entire test spec
            mockCustomerService.saveCustomer.and.returnValue(spyPromise);
        });

        it('should initially has customers populated before any calls are made', function(){
            expect($rootScope.customers).toEqual(customerData);
        });

        it('should have not saved any data with service call returning true', function () {
            $rootScope.save(2);

            deferred.resolve(true);

            $rootScope.$apply();

            expect($rootScope.customers).toEqual(customerData);
            expect(mockCustomerService.saveCustomer).toHaveBeenCalled();
            expect(console.error).not.toHaveBeenCalled();
        });

        it('should have not saved any data with service call returning false', function () {
            $rootScope.save(2);

            deferred.resolve(false);

            $rootScope.$apply();

            expect($rootScope.customers).toEqual(customerData);
            expect(mockCustomerService.saveCustomer).toHaveBeenCalled();
            expect(console.error).toHaveBeenCalled();
        });

        it('should have not saved any data with customers undefined', function () {
            $rootScope.customers = undefined;

            $rootScope.save(2);

            deferred.resolve(false);

            $rootScope.$apply();

            expect($rootScope.customers).toEqual(undefined);
            expect(mockCustomerService.saveCustomer).not.toHaveBeenCalled();
            expect(console.error).not.toHaveBeenCalled();
        });
    });

    describe('CustomerController Delete Tests', function() {

        beforeEach(function() {
            spyOn(console, 'error');

            $rootScope.customers = customerData;

            //setup the spy to always return the spyPromise for the entire test spec
            mockCustomerService.deleteCustomer.and.returnValue(spyPromise);
        });

        it('should initially has customers populated before any calls are made', function(){
            expect($rootScope.customers).toEqual(customerData);
        });

        it('should have scope variable customers populated with deleted customer removed', function () {
            $rootScope.delete(2);

            deferred.resolve(true);

            $rootScope.$apply();

            expect($rootScope.customers).toEqual([ { id : 1, firstName : 'Foo', lastName : 'Bar' }, { id : 3, firstName : 'Peter', lastName : 'Prone' }, { id : 4, firstName : 'Sam', lastName : 'Sully' } ]);
            expect(mockCustomerService.deleteCustomer).toHaveBeenCalled();
            expect(console.error).not.toHaveBeenCalled();
        });

        it('should have not deleted any data with service call returning false', function () {
            $rootScope.delete(2);

            deferred.resolve(false);

            $rootScope.$apply();

            expect($rootScope.customers).toEqual(customerData);
            expect(mockCustomerService.deleteCustomer).toHaveBeenCalled();
            expect(console.error).toHaveBeenCalled();
        });

        it('should have not deleted any data with customers undefined', function () {
            $rootScope.customers = undefined;

            $rootScope.delete(2);

            deferred.resolve(false);

            $rootScope.$apply();

            expect($rootScope.customers).toEqual(undefined);
            expect(mockCustomerService.deleteCustomer).toHaveBeenCalled();
            expect(console.error).toHaveBeenCalled();
        });
    });
});