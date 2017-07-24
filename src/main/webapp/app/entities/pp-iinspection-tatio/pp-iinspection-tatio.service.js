(function() {
    'use strict';
    angular
        .module('tuxAdminApp')
        .factory('PpIinspectionTatio', PpIinspectionTatio);

    PpIinspectionTatio.$inject = ['$resource', 'DateUtils'];

    function PpIinspectionTatio ($resource, DateUtils) {
        var resourceUrl =  'api/pp-iinspection-tatios/:id';

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
