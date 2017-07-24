(function() {
    'use strict';
    angular
        .module('tuxAdminApp')
        .factory('PpThickness', PpThickness);

    PpThickness.$inject = ['$resource', 'DateUtils'];

    function PpThickness ($resource, DateUtils) {
        var resourceUrl =  'api/pp-thicknesses/:id';

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
