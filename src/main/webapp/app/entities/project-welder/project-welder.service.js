(function() {
    'use strict';
    angular
        .module('tuxAdminApp')
        .factory('ProjectWelder', ProjectWelder);

    ProjectWelder.$inject = ['$resource', 'DateUtils'];

    function ProjectWelder ($resource, DateUtils) {
        var resourceUrl =  'api/project-welders/:id';

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
