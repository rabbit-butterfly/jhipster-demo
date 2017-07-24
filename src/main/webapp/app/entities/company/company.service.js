(function() {
    'use strict';
    angular
        .module('tuxAdminApp')
        .factory('Company', Company);

    Company.$inject = ['$resource', 'DateUtils'];

    function Company ($resource, DateUtils) {
        var resourceUrl =  'api/companies/:id';

        return $resource(resourceUrl, {}, {
            'query': { method: 'GET', isArray: true},
            'get': {
                method: 'GET',
                transformResponse: function (data) {
                    if (data) {
                        data = angular.fromJson(data);
                        data.createTime = DateUtils.convertDateTimeFromServer(data.createTime);
                        data.updateTime = DateUtils.convertDateTimeFromServer(data.updateTime);
                    }
                    return data;
                }
            },
            'update': { method:'PUT' }
        });
    }
})();
