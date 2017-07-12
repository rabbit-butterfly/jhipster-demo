(function() {
    'use strict';

    angular
        .module('tuxAdminApp')
        .factory('MemberSearch', MemberSearch);

    MemberSearch.$inject = ['$resource'];

    function MemberSearch($resource) {
        var resourceUrl =  'api/_search/members/:id';

        return $resource(resourceUrl, {}, {
            'query': { method: 'GET', isArray: true}
        });
    }
})();
