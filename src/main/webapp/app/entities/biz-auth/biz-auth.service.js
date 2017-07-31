(function() {
    'use strict';
    angular
        .module('tuxAdminApp')
        .factory('BizAuth', BizAuth);

    BizAuth.$inject = ['$resource', 'DateUtils'];

    function BizAuth ($resource, DateUtils) {
        var resourceUrl =  'api/biz-auths/:id';

        return $resource(resourceUrl, {}, {
            'query': { method: 'GET', isArray: true},
            'get': {
                method: 'GET',
                transformResponse: function (data) {
                    if (data) {
                        data = angular.fromJson(data);
                        data.createdDate = DateUtils.convertDateTimeFromServer(data.createdDate);
                        data.lastModifiedDate = DateUtils.convertDateTimeFromServer(data.lastModifiedDate);
                    }
                    return data;
                }
            },
            'update': { method:'PUT' }
        });
    }
})();
