var gitresume = angular.module('gitresume',
    [
        'ngRoute',
        'ngCookies',
        'gitresumeControllers',
        'ui.bootstrap'
    ]);
var gitresumeControllers = angular.module('gitresumeControllers', []);

/**
 * App configuration.
 */
gitresume.config([
    '$routeProvider',
    '$locationProvider',
    '$httpProvider',
    function ($routeProvider, $locationProvider, $httpProvider) {

        // Enable HTML5 strategy (without # in urls)
        $locationProvider.html5Mode(true);

        $routeProvider.when('/', {
            templateUrl: '/views/partials/home/home.html',
            controller: 'ResumeCtrl'
        }).when('/resume', {
            templateUrl: '/views/partials/resume/resume.html',
            controller: ''
        }).otherwise({
            redirectTo: '/'
        });

    }
]).run(function ($rootScope, $http, $location, $cookieStore) {

    console.log("Test");

});
