(function() {
    'use strict';

    angular
        .module('tuxAdminApp')
        .factory('NewsSearch', NewsSearch);

    NewsSearch.$inject = ['$resource'];

    function NewsSearch($resource) {
        var resourceUrl =  'api/_search/news/:id';

        return $resource(resourceUrl, {}, {
            'query': { method: 'GET', isArray: true}
        });
    }
})();
