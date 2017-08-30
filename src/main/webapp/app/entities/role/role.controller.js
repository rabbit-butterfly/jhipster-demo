(function() {
    'use strict';

    angular
        .module('tuxAdminApp')
        .controller('RoleController', RoleController);

    RoleController.$inject = ['$state', 'Role', 'ParseLinks', 'AlertService', 'paginationConstants', 'pagingParams'];

    function RoleController($state, Role, ParseLinks, AlertService, paginationConstants, pagingParams) {

        var vm = this;

        vm.loadPage = loadPage;
        vm.predicate = pagingParams.predicate;
        vm.reverse = pagingParams.ascending;
        vm.transition = transition;
        vm.itemsPerPage = paginationConstants.itemsPerPage;

        loadAll();

        function loadAll () {
          /*  <id column="ID_" property="id" jdbcType="DECIMAL" />
                <result column="LADDER_" property="level" jdbcType="DECIMAL" />
                <result column="MODEL_CODE" property="code" jdbcType="VARCHAR" />
                <result column="NAME_" property="name" jdbcType="VARCHAR" />
                <result column="PARENT_ID" property="parentId" jdbcType="DECIMAL" />
                <association property="children" column="parentId=ID_,parentLadder=LADDER_" select="selectByParentId"/>
                    */

            Role.query({
                page: pagingParams.page - 1,
                size: vm.itemsPerPage,
                sort: sort()
            }, onSuccess, onError);
            function sort() {
                var result = [vm.predicate + ',' + (vm.reverse ? 'asc' : 'desc')];
                if (vm.predicate !== 'id') {
                    result.push('id');
                }
                return result;
            }
            function onSuccess(data, headers) {
                vm.links = ParseLinks.parse(headers('link'));
                vm.totalItems = headers('X-Total-Count');
                vm.queryCount = vm.totalItems;
                vm.roles = data;
                vm.page = pagingParams.page;


                var json=[{"id":"1","name":"test","code":"bytSoft","parentId":"0","level":"1","children":[{"id":"2","name":"浙江","code":"330000","parentId":"1","level":"2","children":[{"id":"3","name":"杭州","code":"330100","parentId":"2","level":"3","children":[{"id":"5","name":"余杭","code":"330101","parentId":"3","level":"4","children":[]},{"id":"6","name":"富阳","code":"330102","parentId":"3","level":"4","children":[]}]},{"id":"4","name":"宁波","code":"330200","parentId":"2","level":"3","children":[]}]}]}];

                var tree = new CSST.UI.Tree("west",{children:"children",view:"name"},json);
                tree.children[0].focus();
                tree.onChanged=function(node){
                    /*$('#grid').datagrid({
                        url:'doBrowser.json?page=0&rows=10&orgId='+node.data.id
                    });*/
                    alert(node.data.id);
                }


            }
            function onError(error) {
                AlertService.error(error.data.message);
            }
        }

        function loadPage(page) {
            vm.page = page;
            vm.transition();
        }

        function transition() {
            $state.transitionTo($state.$current, {
                page: vm.page,
                sort: vm.predicate + ',' + (vm.reverse ? 'asc' : 'desc'),
                search: vm.currentSearch
            });
        }
    }
})();
