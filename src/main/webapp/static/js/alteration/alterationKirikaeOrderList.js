var alterationKirikaeOrderListApp = angular.module("alterationKirikaeOrderList", []);
alterationKirikaeOrderListApp.controller("alterationKirikaeOrderListController", function ($scope) {
    $scope.alterationKirikaeOrderList = [];
    $scope.pageTool = {
        "url" : BASE_URL + "/alteration/kirikaeOrder/getPageInfo.do"
    };
    $scope.pageTool.searchForm = {};
    $scope.pageTool.firstPage = function () {
        $scope.pageTool.page = 1;
        $scope.pageTool.search();
    };
    $scope.pageTool.prevPage = function () {
        $scope.pageTool.page = $scope.pageTool.page - 1;
        $scope.pageTool.search();
    };
    $scope.pageTool.nextPage = function () {
        $scope.pageTool.page = $scope.pageTool.page + 1;
        $scope.pageTool.search();
    };
    $scope.pageTool.lastPage = function () {
        $scope.pageTool.page = $scope.pageTool.totalPage;
        $scope.pageTool.search();
    };
    $scope.pageTool.search = function () {
        $scope.pageTool.searchForm.size = 10;
        $scope.pageTool.searchForm.start = ($scope.pageTool.page-1)*$scope.pageTool.searchForm.size;
        $.ajax({
            method:'post',
            url:$scope.pageTool.url,
            data:$scope.pageTool.searchForm,
            async:false,
            success: function(resultJson) {
                var result = angular.fromJson(resultJson);
                if (result.success) {
                    $scope.alterationKirikaeOrderList = result.dataMapList;
                    $scope.pageTool.totalCount = result.totalCount;
                    $scope.pageTool.totalPage = result.totalPage;
                    if ($scope.pageTool.page <= 1) {
                        $scope.pageTool.firstPageDisabled = true;
                        $scope.pageTool.prevPageDisabled = true;
                    } else {
                        $scope.pageTool.firstPageDisabled = false;
                        $scope.pageTool.prevPageDisabled = false;
                    }
                    if ($scope.pageTool.page >= $scope.pageTool.totalPage) {
                        $scope.pageTool.nextPageDisabled = true;
                        $scope.pageTool.lastPageDisabled = true;
                    } else {
                        $scope.pageTool.nextPageDisabled = false;
                        $scope.pageTool.lastPageDisabled = false;
                    }
                    $scope.$apply();
                }else {
                    alert(result.message);
                }
            }
        });
    };

    //新增切替变更单
    $scope.addAlterationKirikaeOrder = function () {
        window.location.href = BASE_URL + "/alteration/order/add.do";
    };

    //修改切替变更单
    $scope.addAlterationKirikaeOrder = function () {

    };

    //作废切替变更单
    $scope.voidAlterationKirikaeOrder = function () {

    };

    $(document).ready(function () {
        $("input[data-type='date']").each(function(){
            $(this).datetimepicker({
                timepicker:false,
                format:'Y-m-d'
            });
        });

        var height = document.body.clientHeight;
        var searchTableHeight = $("#searchTable").height();
        var footTableHeight = $("#footTable").height();
        height = height - searchTableHeight - footTableHeight - 35;
        $("#listTable").css("height", height);

        $scope.pageTool.firstPage();

    });
});

angular.bootstrap(document, [ 'alterationKirikaeOrderList' ]);