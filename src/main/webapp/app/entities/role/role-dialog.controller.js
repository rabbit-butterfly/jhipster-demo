(function() {
    'use strict';

    angular
        .module('tuxAdminApp')
        .controller('RoleDialogController', RoleDialogController);

    RoleDialogController.$inject = ['$timeout', '$scope', '$stateParams', '$uibModalInstance', '$q', 'entity', 'Role', 'BizAuth'];

    function RoleDialogController ($timeout, $scope, $stateParams, $uibModalInstance, $q, entity, Role, BizAuth) {
        var vm = this;

        vm.role = entity;
        vm.clear = clear;
        vm.datePickerOpenStatus = {};
        vm.openCalendar = openCalendar;
        vm.save = save;
        vm.bizauths = BizAuth.query({filter: 'role-is-null'});
        $q.all([vm.role.$promise, vm.bizauths.$promise]).then(function() {
            if (!vm.role.bizAuthId) {
                return $q.reject();
            }
            return BizAuth.get({id : vm.role.bizAuthId}).$promise;
        }).then(function(bizAuth) {
            vm.bizauths.push(bizAuth);
        });
        vm.roles = Role.query();

        $timeout(function (){
            angular.element('.form-group:eq(1)>input').focus();
        });

        function clear () {
            $uibModalInstance.dismiss('cancel');
        }

        function save () {
            vm.isSaving = true;
            if (vm.role.id !== null) {
                Role.update(vm.role, onSaveSuccess, onSaveError);
            } else {
                Role.save(vm.role, onSaveSuccess, onSaveError);
            }
        }

        function onSaveSuccess (result) {
            $scope.$emit('tuxAdminApp:roleUpdate', result);
            $uibModalInstance.close(result);
            vm.isSaving = false;
        }

        function onSaveError () {
            vm.isSaving = false;
        }

        vm.datePickerOpenStatus.createdDate = false;
        vm.datePickerOpenStatus.lastModifiedDate = false;

        function openCalendar (date) {
            vm.datePickerOpenStatus[date] = true;
        }
    }
})();
