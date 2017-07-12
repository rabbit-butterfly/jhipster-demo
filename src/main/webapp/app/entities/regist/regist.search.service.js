(function() {
    'use strict';

    angular
        .module('tuxAdminApp')
        .factory('RegistSearch', RegistSearch);

    RegistSearch.$inject = ['$resource'];

    function RegistSearch($resource) {
        var resourceUrl =  'api/_search/regists/:id';

        return $resource(resourceUrl, {}, {
            'query': { method: 'GET', isArray: true}
        });
    }
})();
