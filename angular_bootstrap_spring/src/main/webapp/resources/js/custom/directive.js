app.directive('exampleFocus', function ($timeout) {
    return {
        scope: {
            trigger: '@exampleFocus'
        },
        link: function (scope, element) {
            scope.$watch('trigger', function () {
                $timeout(function () {
                    element[0].focus();
                });
            });
        }
    };
});

app.directive('exampleHasError', function ($timeout) {
    return {
        restrict: "A",
        link: function (scope, element) {
            $timeout(function () {
                var input = element.find('input[data-ng-model]');
                if (input) {
                    scope.$watch(function () {
                        return (input.hasClass('ng-invalid') && input.hasClass('ng-dirty'));
                    }, function (isInvalid) {
                        element.toggleClass('has-error', isInvalid);
                    });
                }
            });
        }
    };
});