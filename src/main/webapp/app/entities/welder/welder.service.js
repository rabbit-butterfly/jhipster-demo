(function() {
    'use strict';
    angular
        .module('pcmsApp')
        .factory('Welder', Welder);

    Welder.$inject = ['$resource', 'DateUtils'];

    function Welder ($resource, DateUtils) {
        var resourceUrl =  'api/welders/:id';

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
