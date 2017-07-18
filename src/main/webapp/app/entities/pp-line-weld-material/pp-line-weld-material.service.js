(function() {
    'use strict';
    angular
        .module('pcmsApp')
        .factory('PpLineWeldMaterial', PpLineWeldMaterial);

    PpLineWeldMaterial.$inject = ['$resource', 'DateUtils'];

    function PpLineWeldMaterial ($resource, DateUtils) {
        var resourceUrl =  'api/pp-line-weld-materials/:id';

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
