(function() {
    'use strict';
    angular
        .module('tuxAdminApp')
        .factory('PpInspectionRule', PpInspectionRule);

    PpInspectionRule.$inject = ['$resource', 'DateUtils'];

    function PpInspectionRule ($resource, DateUtils) {
        var resourceUrl =  'api/pp-inspection-rules/:id';

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
