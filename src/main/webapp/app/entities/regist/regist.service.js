(function() {
    'use strict';
    angular
        .module('tuxAdminApp')
        .factory('Regist', Regist);

    Regist.$inject = ['$resource', 'DateUtils'];

    function Regist ($resource, DateUtils) {
        var resourceUrl =  'api/regists/:id';

        return $resource(resourceUrl, {}, {
            'query': { method: 'GET', isArray: true},
            'get': {
                method: 'GET',
                transformResponse: function (data) {
                    if (data) {
                        data = angular.fromJson(data);
                        data.createTime = DateUtils.convertDateTimeFromServer(data.createTime);
                        data.modifyTime = DateUtils.convertDateTimeFromServer(data.modifyTime);
                    }
                    return data;
                }
            },
            'update': { method:'PUT' }
        });
    }
})();
