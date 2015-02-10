var REST_PREFIX = "";
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
    $http.get(REST_PREFIX+'/rest/newslist')
        .then(function(response) {
            $scope.newsList = response.data;
        });

});

app.controller('NewsController', function ($rootScope, $scope, $http, $routeParams) {
    // Initially get news list:

    $http.get(REST_PREFIX+'/rest/news/'+$routeParams.newsId)
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
        $http.post(REST_PREFIX+'/rest/ratenote', {newsId: $scope.news.link, rating: vote} );
    }

});
app.controller('NewsCreateController', function ($rootScope, $scope, $http, $location) {
    // Initially get news list:
    $scope.news = {category: 'fast note'};
    $scope.addNews = function() {
        $http.post(REST_PREFIX+'/rest/savenews', $scope.news)
            .then(function(response) {
               // przekieruj na listę newsów:
                $location.path('/main');
            });
    }

});
