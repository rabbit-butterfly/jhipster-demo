'use strict';

angular.module('tuxAdminApp')
    .factory('WorkOvertimeService', function ($resource) {
        return $resource('api/workOvertime/:id', {}, {
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
                'delete':{ method:'DELETE'},
                'patch':{ method:'PATCH'},
            });
        })
.factory('ImportService', function ($resource) {
    return $resource('api/import/:id', {}, {
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
            'delete':{ method:'DELETE'},
            'patch':{ method:'PATCH'},
        });
    });
