(function() {
    'use strict';
    angular
        .module('tuxAdminApp')
        .factory('ProjectMaterial', ProjectMaterial);

    ProjectMaterial.$inject = ['$resource', 'DateUtils'];

    function ProjectMaterial ($resource, DateUtils) {
        var resourceUrl =  'api/project-materials/:id';

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
