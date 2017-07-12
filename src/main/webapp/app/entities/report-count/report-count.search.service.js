(function() {
    'use strict';

    angular
        .module('tuxAdminApp')
        .factory('ReportCountSearch', ReportCountSearch);

    ReportCountSearch.$inject = ['$resource'];

    function ReportCountSearch($resource) {
        var resourceUrl =  'api/_search/report-counts/:id';

        return $resource(resourceUrl, {}, {
            'query': { method: 'GET', isArray: true}
        });
    }
})();
