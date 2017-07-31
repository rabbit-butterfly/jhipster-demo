(function() {
    'use strict';
    angular
        .module('tuxAdminApp')
        .factory('Biz', Biz);

    Biz.$inject = ['$resource'];

    function Biz ($resource) {
        var resourceUrl =  'api/bizs/:id';

        return $resource(resourceUrl, {}, {
            'query': { method: 'GET', isArray: true},
            'get': {
                method: 'GET',
                transformResponse: function (data) {
                    if (data) {
                        data = angular.fromJson(data);
                    }
                    return data;
                }
            },
            'update': { method:'PUT' }
        });
    }
})();
