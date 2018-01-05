<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>切替变更单管理页面</title>
    <%@include file="../common/css.jsp"%>
    <%@include file="../common/js.jsp"%>
</head>
<body ng-controller="alterationKirikaeOrderListController" ng-cloak>
<form class="form-inline">
    <div class="main-container container-fluid">
        <div class="main-content" >
            <div class="page-content" >

                <div class="modal-body" id="searchTable">
                    <div class="row">
                        <div class="col-md-2">
                            <label class="control-label" title="">发行编号：</label>
                            <input class="form-control-order form-control clean" ng-model="pageTool.searchForm.tkNo">
                        </div>
                        <div class="col-md-2">
                            <label class="control-label" title="">变更日期：</label>
                            <input class="form-control-order form-control clean" ng-model="pageTool.searchForm.designChangeNo">
                        </div>
                        <div class="col-md-2">
                            <label class="control-label" title="">至：</label>
                            <input class="form-control-order form-control clean" id="designChangeTimingFrom" data-type="date">
                        </div>
                        <div class="col-md-2">
                            <label class="control-label" title="">创建人：</label>
                            <input class="form-control-order form-control clean" id="designChangeTimingTo"  data-type="date">
                        </div>
                        <div class="col-md-2">
                            <label class="control-label" title="">创建日期：</label>
                            <input class="form-control-order form-control clean" ng-model="pageTool.searchForm.designChangeNo">
                        </div>
                        <div class="col-md-2">
                            <label class="control-label" title="">至：</label>
                            <input class="form-control-order form-control clean" id="designChangeTimingFrom" data-type="date">
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-2">
                            <label class="control-label" title="">所属部门：</label>
                            <input class="form-control-order form-control clean" ng-model="pageTool.searchForm.tkNo">
                        </div>
                        <div class="col-md-2">
                            <label class="control-label" title="">变更单状态：</label>
                            <input class="form-control-order form-control clean" ng-model="pageTool.searchForm.designChangeNo">
                        </div>
                        <div class="col-md-2">
                            <label class="control-label" title="">是否超时：</label>
                            <input class="form-control-order form-control clean" id="designChangeTimingFrom" data-type="date">
                        </div>
                        <div class="col-md-2">
                            <label class="control-label" title="">发行日期：</label>
                            <input class="form-control-order form-control clean" id="designChangeTimingTo"  data-type="date">
                        </div>
                        <div class="col-md-2">
                            <label class="control-label" title="">生产线：</label>
                            <input class="form-control-order form-control clean" ng-model="pageTool.searchForm.designChangeNo">
                        </div>
                        <div class="col-md-2">
                            <label class="control-label" title="">车种名：</label>
                            <input class="form-control-order form-control clean" id="designChangeTimingFrom" data-type="date">
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-2">
                            <label class="control-label" title="">安装席：</label>
                            <input class="form-control-order form-control clean" id="designChangeTimingFrom" data-type="date">
                        </div>
                        <div class="col-md-2">
                            <label class="control-label" title="">变更内容：</label>
                            <input class="form-control-order form-control clean" id="designChangeTimingFrom" data-type="date">
                        </div>
                        <div class="col-md-8">
                        </div>
                        <div class="col-md-4">
                            <button class="btn btn-small btn-purple" type="button" ng-click="pageTool.search()">
                                <i class="icon-search icon-on-right bigger-110"></i>查找
                            </button>
                            <button class="btn btn-small btn-success" type="button" ng-click="addAlterationKirikaeOrder()">
                                <i class="icon-plus-sign icon-on-right bigger-110"></i>新增
                            </button>
                            <button class="btn btn-small btn-info" type="button" ng-click="editAlterationKirikaeOrder()">
                                <i class="icon-edit icon-on-right bigger-110"></i>修改
                            </button>
                            <button class="btn btn-small btn-danger" type="button" ng-click="voidAlterationKirikaeOrder()">
                                <i class="icon-remove icon-on-right bigger-110"></i>作废
                            </button>
                            <button class="btn btn-small btn-danger" type="button" ng-click="voidAlterationKirikaeOrder()">
                                <i class="icon-file icon-on-right bigger-110"></i>导出PDF
                            </button>
                        </div>
                    </div>
                </div>

                <div class="common-table-header">
                    <span>详细数据</span>
                </div>

                <div id="listTable" style="overflow:auto;">
                    <table class="table table-striped table-bordered table-hover">
                        <thead>
                        <tr>
                            <td width="20px" class="common-table-td"></td>
                            <td width="40px" class="common-table-td">变更内容</td>
                            <td width="60px" class="common-table-td">预计变更时间</td>
                            <td width="60px" class="common-table-td">实际变更时间</td>
                            <td width="60px" class="common-table-td">发行日期</td>
                            <td width="60px" class="common-table-td">发行编号</td>
                            <td width="60px" class="common-table-td">立合编号</td>
                            <td width="60px" class="common-table-td">生产线</td>
                            <td width="60px" class="common-table-td">车种名</td>
                            <td width="60px" class="common-table-td">安装席</td>
                            <td width="60px" class="common-table-td">变更前品号</td>
                            <td width="60px" class="common-table-td">变更后品号</td>
                            <td width="60px" class="common-table-td">定单状态</td>
                            <td width="60px" class="common-table-td">立合状态</td>
                            <td width="60px" class="common-table-td">所属部门</td>
                            <td width="60px" class="common-table-td">创建人</td>
                            <td width="60px" class="common-table-td">创建时间</td>
                            <td width="60px" class="common-table-td">完成时间</td>
                            <td width="60px" class="common-table-td">是否超时</td>
                            <td width="60px" class="common-table-td">作废原因</td>
                        </tr>
                        </thead>
                        <tbody>
                        <tr ng-repeat="data in alterationKirikaeOrderList">
                            <td>
                                <input type="checkbox" class="form-control-order form-checkbox-mypage" name="alterationKirikaeOrderCheck" value={{data.alterationOrderId}} />
                            </td>
                            <td>
                                <span ng-if="data.kirikaeOrderType == 1">量产前</span>
                                <span ng-if="data.kirikaeOrderType == 1">量产后</span>
                            </td>
                            <td>{{data.tkNo}}</td>
                            <td>{{data.designChangeNo}}</td>
                            <td>{{data.customer}}</td>
                            <td>{{data.vehicleName}}</td>
                            <td>{{data.destination}}</td>
                            <td>{{data.designChangeTiming}}</td>
                            <td>
                                <span ng-if="data.orderState == '10A'">初始化</span>
                                <span ng-if="data.orderState == '10B'">处理中</span>
                                <span ng-if="data.orderState == '10C'">已完成</span>
                                <span ng-if="data.orderState == '10X'">已作废</span>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>

                <div class = "tfoot" id="footTable">
                    <div class="table-foot-center">
                        <button class="" ng-disabled="pageTool.firstPageDisabled" ng-click="pageTool.firstPage()">
                            <span class="glyphicon glyphicon-step-backward "></span>
                        </button>
                        <button class="" ng-disabled="pageTool.prevPageDisabled" ng-click="pageTool.prevPage()">
                            <span class="glyphicon glyphicon-backward"></span>
                        </button>
                        <span class="separator"></span>
                        <span class="page">{{pageTool.page}}&nbsp;/&nbsp;{{pageTool.totalPage}}&nbsp; </span>
                        <span class="separator"></span>
                        <button class="" ng-disabled="pageTool.nextPageDisabled" ng-click="pageTool.nextPage()">
                            <span class="glyphicon glyphicon-forward "></span>
                        </button>
                        <button class="" ng-disabled="pageTool.lastPageDisabled" ng-click="pageTool.lastPage()">
                            <span class="glyphicon glyphicon-step-forward  "></span>
                        </button>
                        <span class="separator"></span> <span>共{{pageTool.totalCount}}条</span>
                    </div>
                </div>
            </div>
        </div>
    </div>
</form>
</body>
<script src="<%=request.getContextPath()%>/static/js/alteration/alterationKirikaeOrderList.js"></script>
</html>