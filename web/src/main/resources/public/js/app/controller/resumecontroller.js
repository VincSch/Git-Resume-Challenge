/**
 * Profile Controller.
 */
gitresumeControllers.controller('ResumeCtrl', ['$scope', '$routeParams', '$rootScope', '$location', '$http', '$cookieStore', 'ResumeService', '$route',
    function ($scope, $routeParams, $rootScope, $location, $http, $cookieStore, ResumeService, $route) {


        /**
         * Become Photographer
         * @param user photographer
         */
        $scope.getUserData = function (username) {
            ResumeService.getUserData(username).success(function (data) {
                if(data.inErrorState){
                    $rootScope.error = data.error;
                    $location.path("/");
                }else {
                    $rootScope.error = undefined;
                    $rootScope.gitdata = data;
                    $location.path("/resume");
                }
            }).error(function (data) {
                $rootScope.error = data.error;
            });
        };
    }
]);
