(function() {
    'use strict';
    angular
        .module('pcmsApp')
        .factory('ProjectSpec', ProjectSpec);

    ProjectSpec.$inject = ['$resource', 'DateUtils'];

    function ProjectSpec ($resource, DateUtils) {
        var resourceUrl =  'api/project-specs/:id';

        return $resource(resourceUrl, {}, {
            'query': { method: 'GET', isArray: true},
            'get': {
                method: 'GET',
                transformResponse: function (data) {
                    if (data) {
                        data = angular.fromJson(data);
                        data.createTime = DateUtils.convertDateTimeFromServer(data.createTime);
                    }
                    return data;
                }
            },
            'update': { method:'PUT' }
        });
    }
})();
