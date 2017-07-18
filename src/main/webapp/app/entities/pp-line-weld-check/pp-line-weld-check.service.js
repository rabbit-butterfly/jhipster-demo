(function() {
    'use strict';
    angular
        .module('pcmsApp')
        .factory('PpLineWeldCheck', PpLineWeldCheck);

    PpLineWeldCheck.$inject = ['$resource', 'DateUtils'];

    function PpLineWeldCheck ($resource, DateUtils) {
        var resourceUrl =  'api/pp-line-weld-checks/:id';

        return $resource(resourceUrl, {}, {
            'query': { method: 'GET', isArray: true},
            'get': {
                method: 'GET',
                transformResponse: function (data) {
                    if (data) {
                        data = angular.fromJson(data);
                        data.reworkDate = DateUtils.convertDateTimeFromServer(data.reworkDate);
                        data.createTime = DateUtils.convertDateTimeFromServer(data.createTime);
                    }
                    return data;
                }
            },
            'update': { method:'PUT' }
        });
    }
})();
