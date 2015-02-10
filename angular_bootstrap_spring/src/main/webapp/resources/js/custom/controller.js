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

app.controller('UsersController', function ($rootScope, $scope, $http) {
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

app.controller('NewsListController', function ($rootScope, $scope, $http) {
    // Initially get news list:
    $http.get('/rest/newslist')
        .then(function(response) {
            $scope.newsList = response.data;
        });

});

app.controller('NewsController', function ($rootScope, $scope, $http, $routeParams) {
    // Initially get news list:

    $http.get('/rest/news/'+$routeParams.newsId)
        .then(function(response) {
            $scope.news = response.data;
        });

});