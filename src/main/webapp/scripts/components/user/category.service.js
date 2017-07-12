'use strict';

angular.module('tuxAdminApp')
    .factory('categoryService', function ($resource) {
        return $resource('api/categories/:id', {}, {
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
            });
        })
        .factory('categorySearchService', function ($resource) {
        return $resource('api/_search/categories', {}, {
                'query': {method: 'GET', isArray: true},
                'get': {
                    method: 'GET',
                    isArray: true,
                    transformResponse: function (data) {
                        data = angular.fromJson(data);
                        return data;
                    }
                },
                'save': { method:'POST' },
                'update': { method:'PUT' },
            });
        });
