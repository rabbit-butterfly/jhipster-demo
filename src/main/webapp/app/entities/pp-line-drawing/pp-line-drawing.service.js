(function() {
    'use strict';
    angular
        .module('pcmsApp')
        .factory('PpLineDrawing', PpLineDrawing);

    PpLineDrawing.$inject = ['$resource', 'DateUtils'];

    function PpLineDrawing ($resource, DateUtils) {
        var resourceUrl =  'api/pp-line-drawings/:id';

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
