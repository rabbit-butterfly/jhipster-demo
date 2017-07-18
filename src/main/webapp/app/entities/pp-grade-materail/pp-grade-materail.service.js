(function() {
    'use strict';
    angular
        .module('pcmsApp')
        .factory('PpGradeMaterail', PpGradeMaterail);

    PpGradeMaterail.$inject = ['$resource', 'DateUtils'];

    function PpGradeMaterail ($resource, DateUtils) {
        var resourceUrl =  'api/pp-grade-materails/:id';

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
