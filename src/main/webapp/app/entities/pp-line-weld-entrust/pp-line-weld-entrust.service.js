(function() {
    'use strict';
    angular
        .module('pcmsApp')
        .factory('PpLineWeldEntrust', PpLineWeldEntrust);

    PpLineWeldEntrust.$inject = ['$resource', 'DateUtils'];

    function PpLineWeldEntrust ($resource, DateUtils) {
        var resourceUrl =  'api/pp-line-weld-entrusts/:id';

        return $resource(resourceUrl, {}, {
            'query': { method: 'GET', isArray: true},
            'get': {
                method: 'GET',
                transformResponse: function (data) {
                    if (data) {
                        data = angular.fromJson(data);
                        data.entrustDate = DateUtils.convertDateTimeFromServer(data.entrustDate);
                        data.createTime = DateUtils.convertDateTimeFromServer(data.createTime);
                    }
                    return data;
                }
            },
            'update': { method:'PUT' }
        });
    }
})();
