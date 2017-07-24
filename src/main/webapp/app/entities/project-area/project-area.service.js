(function() {
    'use strict';
    angular
        .module('tuxAdminApp')
        .factory('ProjectArea', ProjectArea);

    ProjectArea.$inject = ['$resource'];

    function ProjectArea ($resource) {
        var resourceUrl =  'api/project-areas/:id';

        return $resource(resourceUrl, {}, {
            'query': { method: 'GET', isArray: true},
            'get': {
                method: 'GET',
                transformResponse: function (data) {
                    if (data) {
                        data = angular.fromJson(data);
                    }
                    return data;
                }
            },
            'update': { method:'PUT' }
        });
    }
})();
