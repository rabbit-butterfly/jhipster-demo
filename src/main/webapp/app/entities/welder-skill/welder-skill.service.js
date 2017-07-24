(function() {
    'use strict';
    angular
        .module('tuxAdminApp')
        .factory('WelderSkill', WelderSkill);

    WelderSkill.$inject = ['$resource', 'DateUtils'];

    function WelderSkill ($resource, DateUtils) {
        var resourceUrl =  'api/welder-skills/:id';

        return $resource(resourceUrl, {}, {
            'query': { method: 'GET', isArray: true},
            'get': {
                method: 'GET',
                transformResponse: function (data) {
                    if (data) {
                        data = angular.fromJson(data);
                        data.assessmentDate = DateUtils.convertDateTimeFromServer(data.assessmentDate);
                        data.effectiveDate = DateUtils.convertDateTimeFromServer(data.effectiveDate);
                        data.createTime = DateUtils.convertDateTimeFromServer(data.createTime);
                    }
                    return data;
                }
            },
            'update': { method:'PUT' }
        });
    }
})();
