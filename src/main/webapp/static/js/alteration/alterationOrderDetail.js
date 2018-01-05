var orderDetailApp = angular.module("orderDetail", []);
orderDetailApp.config(['$locationProvider', function($locationProvider) {
    $locationProvider.html5Mode(true);
}]);
orderDetailApp.controller("orderDetailController", ["$scope","$location", function ($scope, $location) {
    $scope.orderId = $location.search().orderId;
    $scope.templateAttrList = [];
    $scope.alterationOrder = {
        "alterationFourOrder" : {
            "alterationFourOrderAttrList" : []
        },
        "alterationKirikaeOrder" : {}
    };
    $scope.getOrderDetail = function () {
        $.ajax({
            method: 'post',
            url: BASE_URL + "/alteration/order/getOrder.do",
            data : {orderId : $scope.orderId},
            async: false,
            success: function (resultJson) {
                var result = angular.fromJson(resultJson);
                if (result.success) {
                    $scope.alterationOrder = result.alterationOrder;
                    for(var i = 0; i < $scope.alterationOrder.alterationFourOrder.alterationFourOrderAttrList.length; i++){
                        var data = $scope.alterationOrder.alterationFourOrder.alterationFourOrderAttrList[i];
                        if(data.attrChecked == 1){
                            $("#order_attr_checkbox_"+data.attrType+"_"+data.attrId).attr('checked', "true");
                            if(data.attrOther == 1){
                                $("#order_attr_checkbox_"+data.attrType+"_"+data.attrId+"_div").html(data.attrValue);
                            }
                        }
                    }
                }else {
                    alert("请联系系统管理员！");
                }
            }
        });
    };
    $(document).ready(function () {
        $.ajax({
            method: 'post',
            url: BASE_URL + "/four/template/queryTemplateAttrList.do",
            async: false,
            success: function (resultJson) {
                var result = angular.fromJson(resultJson);
                if (result.success) {
                    $scope.templateAttrList = result.dataMapList;
                    $scope.$apply();
                    $scope.getOrderDetail();
                    $scope.$apply();
                }else {
                    alert("请联系系统管理员！");
                }
            }
        });
    });
}]);
orderDetailApp.filter('attrFilter', function() {
    return function(inputArray, attrType) {
        var array = [];
        for(var i = 0; i < inputArray.length ; i++){
            var obj = inputArray[i];
            var id = obj.attrType;
            if(id == attrType){
                array.push(obj);
            }
        }
        return array;
    };
});
angular.bootstrap(document, [ 'orderDetail' ]);