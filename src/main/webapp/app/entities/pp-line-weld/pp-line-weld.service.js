(function() {
    'use strict';
    angular
        .module('tuxAdminApp')
        .factory('PpLineWeld', PpLineWeld);

    PpLineWeld.$inject = ['$resource', 'DateUtils'];

    function PpLineWeld ($resource, DateUtils) {
        var resourceUrl =  'api/pp-line-welds/:id';

        return $resource(resourceUrl, {}, {
            'query': { method: 'GET', isArray: true},
            'get': {
                method: 'GET',
                transformResponse: function (data) {
                    if (data) {
                        data = angular.fromJson(data);
                        data.finishDate = DateUtils.convertDateTimeFromServer(data.finishDate);
                        data.createTime = DateUtils.convertDateTimeFromServer(data.createTime);
                    }
                    return data;
                }
            },
            'update': { method:'PUT' }
        });
    }
})();
