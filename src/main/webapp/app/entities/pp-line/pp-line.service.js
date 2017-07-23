(function() {
    'use strict';
    angular
        .module('tuxAdminApp')
        .factory('PpLine', PpLine);

    PpLine.$inject = ['$resource', 'DateUtils'];

    function PpLine ($resource, DateUtils) {
        var resourceUrl =  'api/pp-lines/:id';

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