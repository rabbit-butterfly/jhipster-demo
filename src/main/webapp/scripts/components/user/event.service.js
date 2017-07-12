'use strict';

angular.module('tuxAdminApp')
    .factory('eventService', function ($resource) {
        return $resource('api/events/:id', {}, {
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
        })
	.factory('registService', function ($resource) {
	    return $resource('api/_search/regists', {}, {
	            'query': {method: 'GET',isArray: true},
	            'get': {
	                method: 'GET',
	                transformResponse: function (data) {
	                    data = angular.fromJson(data);
	                    return data;
	                }
	            }
	        });
	    })
	.factory('reportCountService', function ($resource) {
	    return $resource('api/_search/report-counts', {}, {
	            'query': {method: 'GET',isArray: true},
	            'get': {
	                method: 'GET',
	                transformResponse: function (data) {
	                    data = angular.fromJson(data);
	                    return data;
	                }
	            }
	        });
	    });