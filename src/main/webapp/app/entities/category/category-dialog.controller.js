(function() {
    'use strict';

    angular
        .module('tuxAdminApp')
        .controller('CategoryDialogController', CategoryDialogController);

    CategoryDialogController.$inject = ['$timeout', '$scope', '$stateParams', '$uibModalInstance', 'entity', 'Category'];

    function CategoryDialogController ($timeout, $scope, $stateParams, $uibModalInstance, entity, Category) {
        var vm = this;

        vm.category = entity;
        vm.clear = clear;
        vm.datePickerOpenStatus = {};
        vm.openCalendar = openCalendar;
        vm.save = save;

        $timeout(function (){
            angular.element('.form-group:eq(1)>input').focus();
        });

        function clear () {
            $uibModalInstance.dismiss('cancel');
        }

        function save () {
            vm.isSaving = true;
            if (vm.category.id !== null) {
                Category.update(vm.category, onSaveSuccess, onSaveError);
            } else {
                Category.save(vm.category, onSaveSuccess, onSaveError);
            }
        }

        function onSaveSuccess (result) {
            $scope.$emit('tuxAdminApp:categoryUpdate', result);
            $uibModalInstance.close(result);
            vm.isSaving = false;
        }

        function onSaveError () {
            vm.isSaving = false;
        }

        vm.datePickerOpenStatus.crateTime = false;
        vm.datePickerOpenStatus.modifyTime = false;

        function openCalendar (date) {
            vm.datePickerOpenStatus[date] = true;
        }
    }
})();
