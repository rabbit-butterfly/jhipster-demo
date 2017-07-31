(function() {
    'use strict';

    angular
        .module('tuxAdminApp')
        .controller('BizDialogController', BizDialogController);

    BizDialogController.$inject = ['$timeout', '$scope', '$stateParams', '$uibModalInstance', 'entity', 'Biz'];

    function BizDialogController ($timeout, $scope, $stateParams, $uibModalInstance, entity, Biz) {
        var vm = this;

        vm.biz = entity;
        vm.clear = clear;
        vm.save = save;

        $timeout(function (){
            angular.element('.form-group:eq(1)>input').focus();
        });

        function clear () {
            $uibModalInstance.dismiss('cancel');
        }

        function save () {
            vm.isSaving = true;
            if (vm.biz.id !== null) {
                Biz.update(vm.biz, onSaveSuccess, onSaveError);
            } else {
                Biz.save(vm.biz, onSaveSuccess, onSaveError);
            }
        }

        function onSaveSuccess (result) {
            $scope.$emit('tuxAdminApp:bizUpdate', result);
            $uibModalInstance.close(result);
            vm.isSaving = false;
        }

        function onSaveError () {
            vm.isSaving = false;
        }


    }
})();
