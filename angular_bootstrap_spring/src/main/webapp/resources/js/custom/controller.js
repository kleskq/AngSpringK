app.controller('MainController', function ($rootScope, $scope, $location) {
    $scope.logout = function () {
        $scope.$emit('event:logoutRequest');

        $location.path("/main");
    };

    $scope.login = function (credentials) {
        $scope.$emit('event:loginRequest', credentials.email, credentials.password);

        $location.path($rootScope.navigateTo);
    };
});

app.controller('UsersController', function ($rootScope, $scope, $http, CustomerService) {
    // Initially get users list:
    $http.get('/springAngular/rest/users')
        .then(function(response){
            $scope.users = response.data;
        });

    $scope.saveUser = function(user) {
        $http.post('/springAngular/rest/save', user)
            .then(function(response) {
                console.log("User saved, response: ");
                console.log(response);
            });
    }
});

app.controller('StatsController', function ($rootScope, $scope, $http, CustomerService) {
    // Initially get users list:
    $http.get('/springAngular/rest/noteInfo')
        .then(function(response){
            $scope.noteStats = response.data;
        });

});