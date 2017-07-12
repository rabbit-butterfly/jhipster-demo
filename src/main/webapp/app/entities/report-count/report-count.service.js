(function() {
    'use strict';
    angular
        .module('tuxAdminApp')
        .factory('ReportCount', ReportCount);

    ReportCount.$inject = ['$resource', 'DateUtils'];

    function ReportCount ($resource, DateUtils) {
        var resourceUrl =  'api/report-counts/:id';

        return $resource(resourceUrl, {}, {
            'query': { method: 'GET', isArray: true},
            'get': {
                method: 'GET',
                transformResponse: function (data) {
                    if (data) {
                        data = angular.fromJson(data);
                        data.createTime = DateUtils.convertDateTimeFromServer(data.createTime);
                        data.modifyTime = DateUtils.convertDateTimeFromServer(data.modifyTime);
                    }
                    return data;
                }
            },
            'update': { method:'PUT' }
        });
    }
})();
