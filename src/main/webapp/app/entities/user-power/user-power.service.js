(function() {
    'use strict';
    angular
        .module('tuxAdminApp')
        .factory('UserPower', UserPower);

    UserPower.$inject = ['$resource'];

    function UserPower ($resource) {
        var resourceUrl =  'api/user-powers/:id';

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
