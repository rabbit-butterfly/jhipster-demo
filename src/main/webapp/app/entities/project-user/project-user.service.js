(function() {
    'use strict';
    angular
        .module('tuxAdminApp')
        .factory('ProjectUser', ProjectUser);

    ProjectUser.$inject = ['$resource', 'DateUtils'];

    function ProjectUser ($resource, DateUtils) {
        var resourceUrl =  'api/project-users/:id';

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
