(function() {
    'use strict';

    angular
        .module('tuxAdminApp')
        .controller('BizAuthDialogController', BizAuthDialogController);

    BizAuthDialogController.$inject = ['$timeout', '$scope', '$stateParams', '$uibModalInstance', '$q', 'entity', 'BizAuth', 'Biz', 'Role'];

    function BizAuthDialogController ($timeout, $scope, $stateParams, $uibModalInstance, $q, entity, BizAuth, Biz, Role) {
        var vm = this;

        vm.bizAuth = entity;
        vm.clear = clear;
        vm.datePickerOpenStatus = {};
        vm.openCalendar = openCalendar;
        vm.save = save;
        vm.bizs = Biz.query({filter: 'bizauth-is-null'});
        $q.all([vm.bizAuth.$promise, vm.bizs.$promise]).then(function() {
            if (!vm.bizAuth.bizId) {
                return $q.reject();
            }
            return Biz.get({id : vm.bizAuth.bizId}).$promise;
        }).then(function(biz) {
            vm.bizs.push(biz);
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
            if (vm.bizAuth.id !== null) {
                BizAuth.update(vm.bizAuth, onSaveSuccess, onSaveError);
            } else {
                BizAuth.save(vm.bizAuth, onSaveSuccess, onSaveError);
            }
        }

        function onSaveSuccess (result) {
            $scope.$emit('tuxAdminApp:bizAuthUpdate', result);
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
