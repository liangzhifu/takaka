<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>切替变更单管理页面</title>
    <%@include file="../../common/css.jsp"%>
    <%@include file="../../common/js.jsp"%>
</head>
<body ng-controller="alterationKirikaeOrderListController" ng-cloak>
    <form class="form-inline">
        <div class="main-container container-fluid">
            <div class="main-content" >
                <div class="page-content" >

                    <div class="modal-body" id="searchTable">
                        <div class="row">
                            <div class="col-md-2">
                                <label class="control-label" title="">切替号：</label>
                                <input class="form-control-order form-control clean" ng-model="pageTool.searchForm.tkNo">
                            </div>
                            <div class="col-md-2">
                                <label class="control-label" title="">设变号：</label>
                                <input class="form-control-order form-control clean" ng-model="pageTool.searchForm.designChangeNo">
                            </div>
                            <div class="col-md-2">
                                <label class="control-label" title="">切替时间：</label>
                                <input class="form-control-order form-control clean" id="designChangeTimingFrom" data-type="date">
                            </div>
                            <div class="col-md-2">
                                <label class="control-label" title="">至：</label>
                                <input class="form-control-order form-control clean" id="designChangeTimingTo"  data-type="date">
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-8">
                            </div>
                            <div class="col-md-4">
                                <button class="btn btn-small btn-purple" type="button" ng-click="pageTool.search()">
                                    <i class="icon-search icon-on-right bigger-110"></i>查找
                                </button>
                                <button class="btn btn-small btn-success" type="button" ng-click="addKirikaeOrder()">
                                    <i class="icon-plus-sign icon-on-right bigger-110"></i>新增
                                </button>
                                <button class="btn btn-small btn-info" type="button" ng-click="editKirikaeOrder()">
                                    <i class="icon-edit icon-on-right bigger-110"></i>修改
                                </button>
                                <button class="btn btn-small btn-danger" type="button" ng-click="voidKirikaeOrder()">
                                    <i class="icon-remove icon-on-right bigger-110"></i>作废
                                </button>
                                <button class="btn btn-small btn-purple" type="button" ng-click="exportKirikaeOrderPDF()">
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
                                <td width="40px" class="common-table-td">类型</td>
                                <td width="60px" class="common-table-td">切替号</td>
                                <td width="60px" class="common-table-td">设变号</td>
                                <td width="60px" class="common-table-td">客户</td>
                                <td width="60px" class="common-table-td">车种名</td>
                                <td width="60px" class="common-table-td">销售地</td>
                                <td width="60px" class="common-table-td">切替时间</td>
                                <td width="60px" class="common-table-td">状态</td>
                            </tr>
                            </thead>
                            <tbody>
                            <tr ng-repeat="data in alterationKirikaeOrderList">
                                <td>
                                    <input type="checkbox" class="form-control-order form-checkbox-mypage" name="alterationKirikaeOrderCheck" value={{data.alterationOrderId}} />
                                </td>
                                <td>
                                    <span ng-if="data.kirikaeOrderType == 1">量产前</span>
                                    <span ng-if="data.kirikaeOrderType == 2">量产后</span>
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
<script src="<%=request.getContextPath()%>/static/js/kirikae/order/kirikaeOrderList.js"></script>
</html>