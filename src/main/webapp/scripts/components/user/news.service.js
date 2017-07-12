'use strict';

angular.module('tuxAdminApp')
    .factory('newsService', function ($resource) {
        return $resource('api/news/:id', {}, {
                'query': {method: 'GET', isArray: true},
                'get': {
                    method: 'GET',
                    transformResponse: function (data) {
                        data = angular.fromJson(data);
                        return data;
                    }
                },
                'save': { method:'POST' },
                'update': { method:'PUT' },
                'patch':{method:'PATCH'}
            });
        });