(function() {
    'use strict';

    angular
        .module('tuxAdminApp')
        .factory('EventSearch', EventSearch);

    EventSearch.$inject = ['$resource'];

    function EventSearch($resource) {
        var resourceUrl =  'api/_search/events/:id';

        return $resource(resourceUrl, {}, {
            'query': { method: 'GET', isArray: true}
        });
    }
})();
