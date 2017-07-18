(function() {
    'use strict';

    angular
        .module('pcmsApp')
        .controller('WelderDialogController', WelderDialogController);

    WelderDialogController.$inject = ['$timeout', '$scope', '$stateParams', '$uibModalInstance', 'entity', 'Welder'];

    function WelderDialogController ($timeout, $scope, $stateParams, $uibModalInstance, entity, Welder) {
        var vm = this;

        vm.welder = entity;
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
            if (vm.welder.id !== null) {
                Welder.update(vm.welder, onSaveSuccess, onSaveError);
            } else {
                Welder.save(vm.welder, onSaveSuccess, onSaveError);
            }
        }

        function onSaveSuccess (result) {
            $scope.$emit('pcmsApp:welderUpdate', result);
            $uibModalInstance.close(result);
            vm.isSaving = false;
        }

        function onSaveError () {
            vm.isSaving = false;
        }

        vm.datePickerOpenStatus.createTime = false;

        function openCalendar (date) {
            vm.datePickerOpenStatus[date] = true;
        }
    }
})();
