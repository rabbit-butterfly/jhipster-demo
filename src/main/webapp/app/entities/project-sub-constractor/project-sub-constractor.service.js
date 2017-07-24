(function() {
    'use strict';
    angular
        .module('tuxAdminApp')
        .factory('ProjectSubConstractor', ProjectSubConstractor);

    ProjectSubConstractor.$inject = ['$resource', 'DateUtils'];

    function ProjectSubConstractor ($resource, DateUtils) {
        var resourceUrl =  'api/project-sub-constractors/:id';

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
