var kirikaeOrderAddOrEditApp = angular.module("kirikaeOrderAddOrEdit", []);
kirikaeOrderAddOrEditApp.controller("kirikaeOrderAddOrEditController", ["$scope", "$location", function ($scope, $location) {
    if(!($location.search().id == undefined || $location.search().id == null)){
        $("#id").val(id);
    }
    if(!($location.search().orderChannel == undefined || $location.search().orderChannel == null)){
        $("#orderChannel").val(orderChannel);
    }

    $scope.systemUserList = [];
    $scope.alterationOrder = {
        "kirikaeOrder" : {
            "kirikaeOrderChangeContentList" : [],
            "kirikaeOrderPartsNumberList" : []
        }
    };

    $scope.validKirikaeOrder = function () {
        return true;
    };

    $scope.addKirikaeOrder = function () {
        if(!$scope.validKirikaeOrder()){
            return;
        }
        var id = $("#id").val();
        var url = "";
        var comment = "";
        if(id == undefined || id == null || id == ""){
            url = "/alteration/order/add.do";
            comment = "确定新增变更单！";
        }else {
            url = "/alteration/order/edit.do";
            comment = "确定修改变更单！";
        }
        var con = confirm(comment);
        if (con == true){
            $("#kirikaeOrderAddOrEditForm").ajaxSubmit({
                type: "post",
                dataType : "json",
                url : BASE_URL + url,
                success : function(resultJson) {
                    var result = angular.fromJson(resultJson);
                    if (result.success) {
                        $scope.$apply();
                    }else {
                        alert(result.message);
                    }
                },
                error : function(jqXHR, textStatus, errorThrown) {
                    alert("系统出现异常!!");
                }
            });
        }
    };

    $scope.addKirikaeOrderChangeContent = function () {
        $scope.alterationOrder.kirikaeOrder.kirikaeOrderChangeContentList[$scope.alterationOrder.kirikaeOrder.kirikaeOrderChangeContentList.length] = {};
    };

    $scope.delKirikaeOrderChangeContent = function (index) {
        $scope.alterationOrder.kirikaeOrder.kirikaeOrderChangeContentList.splice(index, 1);
    };

    $scope.uploadBeforeFile = function (index) {

    };

    $scope.uploadNewFile = function (index) {

    };

    $scope.addKirikaeOrderPartsNumber = function () {
        $scope.alterationOrder.kirikaeOrder.kirikaeOrderPartsNumberList[$scope.alterationOrder.kirikaeOrder.kirikaeOrderPartsNumberList.length] = {};
    };

    $scope.delKirikaeOrderPartsNumber = function (index) {
        $scope.alterationOrder.kirikaeOrder.kirikaeOrderPartsNumberList.splice(index, 1);
    };

    $scope.getAlterAtionOrder = function () {
        var id = $("#id").val();
        if(id == undefined || id == null || id == ""){
            $.ajax({
                method: 'post',
                url: BASE_URL + "/system/user/queryAllUser.do",
                async: false,
                success: function (resultJson) {
                    var result = angular.fromJson(resultJson);
                    if (result.success) {

                    }
                }
            });
        }
    };

    $(document).ready(function () {
        $("input[data-type='date']").each(function(){
            $(this).datetimepicker({
                timepicker:false,
                format:'Y-m-d'
            });
        });

        $("input[data-type='dateTime']").datetimepicker({
            timepicker:true,
            minDate : new Date(),
            format:'Y-m-d H:i:s'
        });

        $scope.getAlterAtionOrder();

    });
}]);

kirikaeOrderAddOrEditApp.filter('attrFilter', function() {
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
angular.bootstrap(document, [ 'kirikaeOrderAddOrEdit' ]);