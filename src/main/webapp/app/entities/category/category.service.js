(function() {
    'use strict';
    angular
        .module('tuxAdminApp')
        .factory('Category', Category);

    Category.$inject = ['$resource', 'DateUtils'];

    function Category ($resource, DateUtils) {
        var resourceUrl =  'api/categories/:id';

        return $resource(resourceUrl, {}, {
            'query': { method: 'GET', isArray: true},
            'get': {
                method: 'GET',
                transformResponse: function (data) {
                    if (data) {
                        data = angular.fromJson(data);
                        data.crateTime = DateUtils.convertDateTimeFromServer(data.crateTime);
                        data.modifyTime = DateUtils.convertDateTimeFromServer(data.modifyTime);
                    }
                    return data;
                }
            },
            'update': { method:'PUT' }
        });
    }
})();
