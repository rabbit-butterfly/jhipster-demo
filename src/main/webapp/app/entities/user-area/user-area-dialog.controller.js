(function() {
    'use strict';

    angular
        .module('pcmsApp')
        .controller('UserAreaDialogController', UserAreaDialogController);

    UserAreaDialogController.$inject = ['$timeout', '$scope', '$stateParams', '$uibModalInstance', 'entity', 'UserArea'];

    function UserAreaDialogController ($timeout, $scope, $stateParams, $uibModalInstance, entity, UserArea) {
        var vm = this;

        vm.userArea = entity;
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
            if (vm.userArea.id !== null) {
                UserArea.update(vm.userArea, onSaveSuccess, onSaveError);
            } else {
                UserArea.save(vm.userArea, onSaveSuccess, onSaveError);
            }
        }

        function onSaveSuccess (result) {
            $scope.$emit('pcmsApp:userAreaUpdate', result);
            $uibModalInstance.close(result);
            vm.isSaving = false;
        }

        function onSaveError () {
            vm.isSaving = false;
        }


    }
})();
