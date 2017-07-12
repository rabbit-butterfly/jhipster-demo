'use strict';

angular.module('tuxAdminApp')
    .factory('checkConfigService', function ($resource) {
        return $resource('api/checkConfig/:id', {}, {
                'query': {method: 'GET'},
                'save': { method:'POST' },
                'update': { method:'PUT' },
            });
        });
