(function() {
    'use strict';
    angular
        .module('pcmsApp')
        .factory('UserArea', UserArea);

    UserArea.$inject = ['$resource'];

    function UserArea ($resource) {
        var resourceUrl =  'api/user-areas/:id';

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
