app.config([ '$routeProvider', '$httpProvider', 'localStorageServiceProvider', function($routeProvider, $httpProvider, localStorageServiceProvider) {

	// ======= router configuration =============

	$routeProvider
		.when('/main', {
            controller: 'NewsListController',
			templateUrl: 'resources/html/partials/view/newslist.html'
		})
        .when('/news/:newsId', {
            controller: 'NewsController',
            templateUrl: 'resources/html/partials/view/news.html'
        })
        .when('/newscreate', {
            controller: 'NewsCreateController',
            templateUrl: 'resources/html/partials/view/newscreate.html'
        })

		.otherwise({ redirectTo : "/main"});
	
	// ======== http configuration ===============
	
	//configure $http to view a login whenever a 401 unauthorized response arrives
    /*$httpProvider.responseInterceptors.push(function ($rootScope, $q) {
        return function (promise) {
            return promise.then(
                //success -> don't intercept
                function (response) {
                    return response;
                },
                //error -> if 401 save the request and broadcast an event
                function (response) {
                    if (response.status === 401) {
                        var deferred = $q.defer(),
                            req = {
                                config: response.config,
                                deferred: deferred
                            };

                        $httpProvider.defaults.headers.common.Authorization = null;

                        $rootScope.requests401.push(req);
                        $rootScope.$broadcast('event:loginRequired');

                        return deferred.promise;
                    }
                    return $q.reject(response);
                }
            );
        };
    });*/
}]);