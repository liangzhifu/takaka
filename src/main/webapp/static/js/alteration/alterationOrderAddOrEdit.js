var alterationOrderAddOrEditApp = angular.module("alterationOrderAddOrEdit", []);
alterationOrderAddOrEditApp.controller("alterationOrderAddOrEditController", ["$scope", "$location", function ($scope, $location) {
    if(!($location.search().id == undefined || $location.search().id == null)){
        $("#id").val(id);
    }
    if(!($location.search().orderChannel == undefined || $location.search().orderChannel == null)){
        $("#orderChannel").val(orderChannel);
    }

    $scope.fourOrderAttrIndex = 0;
    $scope.templateAttrList = [];
    $scope.systemUserList = [];
    $scope.alterationOrder = {
        "alterationFourOrder" : {
            "alterationFourOrderAttrList" : []
        },
        "alterationKirikaeOrder" : {}
    };

    $scope.validFourOrder = function () {
        var reg = /^[-,a-zA-Z0-9]*$/;
        var changeBeforProductNo = $("#alterationOrder\\.alterationFourOrder\\.changeBeforProductNo").val();
        if(!reg.test(changeBeforProductNo)){
            alert("变更前品号不正确，请检查！");
            return false;
        }
        var changeAfterProductNo = $("#alterationOrder\\.alterationFourOrder\\.changeAfterProductNo").val();
        if(!reg.test(changeAfterProductNo)){
            alert("变更后品号不正确，请检查！");
            return false;
        }
        var approved = $("#four_order_approved").val();
        if(approved == null || approved == ""){
            alert("请选择承认人!");
            return false;
        }
        var checked = $("#four_order_checked").val();
        if(checked == null || checked == ""){
            alert("请选择确认人!");
            return false;
        }
        if(!$.html5Validate.isAllpass($("#alterationOrder\\.alterationFourOrder\\.productLine"))){
            return false;
        }
        if(!$.html5Validate.isAllpass($("#alterationOrder\\.alterationFourOrder\\.carName"))){
            return false;
        }
        if(!$.html5Validate.isAllpass($("#alterationOrder\\.alterationFourOrder\\.installationMat"))){
            return false;
        }
        if(!$.html5Validate.isAllpass($("#alterationOrder\\.alterationFourOrder\\.changeContent"))){
            return false;
        }
        if(!$.html5Validate.isAllpass($("#alterationOrder\\.alterationFourOrder\\.estimateChangeTime"))){
            return false;
        }
        var flag = true;
        for(var i = 0; i < $scope.templateAttrList.length; i++){
            var data = $scope.templateAttrList[i];
            if($("#order_attr_checkbox_"+data.attrType+"_"+data.id).is(":checked")){
                flag = false;
                if(data.attrOther == 1){
                    var otherValue = $("#order_attr_checkbox_"+data.attrType+"_"+data.id+"_value").val();
                    if(otherValue == null || otherValue == ""){
                        alert("您选择了其他，输入框不能为空！");
                        return false;
                    }
                }
            }
        }
        if(flag){
            alert("必须选择一个复选框！");
            return false;
        }
        return true;
    };

    $scope.validKirikaeOrder = function () {
        return true;
    };

    $scope.addAlterationOrder = function () {
        if(!$scope.validFourOrder()){
            return;
        }
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
            $("#alterationOrderAddOrEditForm").ajaxSubmit({
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

    //获取4m模板属性
    $scope.getTemplateAttr = function () {
        $.ajax({
            method: 'post',
            url: BASE_URL + "/four/template/queryTemplateAttrList.do",
            async: false,
            success: function (resultJson) {
                var result = angular.fromJson(resultJson);
                if (result.success) {
                    $scope.templateAttrList = result.dataMapList;
                    $scope.$apply();
                    $scope.getAllUser();
                }else {
                    alert("请联系系统管理员！");
                }
            }
        });
    };

    //获取所有用户
    $scope.getAllUser = function () {
        $.ajax({
            method: 'post',
            url: BASE_URL + "/system/user/queryAllUser.do",
            async: false,
            success: function (resultJson) {
                var result = angular.fromJson(resultJson);
                if (result.success) {
                    $scope.systemUserList = result.dataMapList;
                    $scope.$apply();
                    $(".chosen").chosen({
                        no_results_text : "没有找到结果！",//搜索无结果时显示的提示
                        search_contains : true,   //关键字模糊搜索，设置为false，则只从开头开始匹配
                        allow_single_deselect : true, //是否允许取消选择
                        max_selected_options : 5,  //当select为多选时，最多选择个数
                        placeholder_text_multiple : "请选择",
                        max_shown_results : 5,
                        width : "70%"
                    });
                }else {
                    alert("请联系系统管理员！");
                }
            }
        });
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

        $scope.getTemplateAttr();

    });
}]);

alterationOrderAddOrEditApp.filter('attrFilter', function() {
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
angular.bootstrap(document, [ 'alterationOrderAddOrEdit' ]);