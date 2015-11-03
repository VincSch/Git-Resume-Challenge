/**
 * ResumeService.
 * Retrieves information about the GitHub user from the spring boot webservice.
 */
angular.module('gitresume').factory(
    'ResumeService',
    [
        '$http',
        function ($http) {

            var urlBase = '/api/git';

            var resumeService = {};

            resumeService.getUserData = function (username) {
                return $http.post(urlBase + '/search', username);
            };

            return resumeService;
        }]);