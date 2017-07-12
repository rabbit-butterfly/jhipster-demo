'use strict';

angular.module('tuxAdminApp')
    .factory('feedbackService', function ($resource) {
        return $resource('api/feedbacks/:id', {}, {
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
        });
