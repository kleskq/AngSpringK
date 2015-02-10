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

    $scope.voteNews = function(vote) {
        // Update on view:
        if ($scope.news.rating != vote) {
            if (vote >= 1) {
                $scope.news.plus++;
                if ($scope.news.rating != 0) $scope.news.plus++; // bo już zagłosowałem
                $scope.news.rating = vote; // zaktualizuj obecny rate
            } else {
                $scope.news.minus++;
                if ($scope.news.rating != 0) $scope.news.minus++;
                $scope.news.rating = vote;
            }
        }
        $http.post('/rest/ratenote', {newsId: $scope.news.link, rating: vote} );
    }

});
app.controller('NewsCreateController', function ($rootScope, $scope, $http) {
    // Initially get news list:
    $scope.news = {};
    $scope.addNews = function() {
        $http.post('/rest/savenews', $scope.news)
            .then(function(response) {
               // przekieruj na listę newsów:
            });
    }

});
