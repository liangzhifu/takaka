<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>切替变更单管理页面</title>
    <%@include file="../../common/css.jsp"%>
    <%@include file="../../common/js.jsp"%>
</head>
<body ng-controller="kirikaeOrderAddOrEditController" ng-cloak>
<form class="form-inline" id="kirikaeOrderAddOrEditForm">
    <input type="hidden" name="id">
    <input type="hidden" name="orderChannel">
    <input type="hidden" name="alterationKirikaeOrder.id">
    <div class="main-container container-fluid">
        <div class="main-content">
            <div class="page-content">
                <div class="row-fluid">
                    <div class="span12">
                        <div class="block" style="margin-top: 0px; margin-bottom: 0px;">
                            <div class="block-header">
                                <div>
                                    <i class="icon-edit"></i>切替信息
                                </div>
                            </div>
                            <div class="modal-body" style="padding-top: 0px; padding-bottom: 0px;">
                                <div class="row">
                                    <div class="col-md-3">
                                        <label class="control-label" title="">切替单类型：</label>
                                        <select title="" id="alterationOrder.kirikaeOrder.kirikaeOrderType" name="alterationOrder.kirikaeOrder.kirikaeOrderType"
                                                class="form-control-order form-control clean" ng-model="alterationOrder.kirikaeOrder.kirikaeOrderType">
                                            <option value="">请选择</option>
                                            <option value="1">量产前</option>
                                            <option value="2">量产后</option>
                                        </select>
                                    </div>
                                    <div class="col-md-3">
                                        <label class="control-label" title="">切替号：</label>
                                        <input title="" id="alterationOrder.kirikaeOrder.tkNo" name="alterationOrder.kirikaeOrder.tkNo"
                                               ng-model="alterationOrder.kirikaeOrder.tkNo" class="form-control-order form-control clean">
                                    </div>
                                    <div class="col-md-3">
                                        <label class="control-label" title="">设变号：</label>
                                        <input title="" id="alterationOrder.kirikaeOrder.designChangeNo" name="alterationOrder.kirikaeOrder.designChangeNo"
                                               ng-model="alterationOrder.kirikaeOrder.designChangeNo" class="form-control-order form-control clean">
                                    </div>
                                    <div class="col-md-3">
                                        <label class="control-label" title="">客户协议：</label>
                                        <select title="" id="alterationOrder.kirikaeOrder.salesCustomerProtocal" name="alterationOrder.kirikaeOrder.salesCustomerProtocal"
                                                class="form-control-order form-control clean" ng-model="alterationOrder.kirikaeOrder.salesCustomerProtocal">
                                            <option value="">请选择</option>
                                            <option value="0">否</option>
                                            <option value="1">是</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-3">
                                        <label class="control-label" title="">营业-日期：</label>
                                        <input title="" id="alterationOrder.kirikaeOrder.salesDate" name="alterationOrder.kirikaeOrder.salesDate" data-type="date"
                                               ng-model="alterationOrder.kirikaeOrder.salesDate" class="form-control-order form-control clean">
                                    </div>
                                    <div class="col-md-3">
                                        <label class="control-label" title="">营业-承认：</label>
                                        <input title="" id="alterationOrder.kirikaeOrder.salesApproved" name="alterationOrder.kirikaeOrder.salesApproved"
                                               ng-model="alterationOrder.kirikaeOrder.salesApproved" class="form-control-order form-control clean">
                                    </div>
                                    <div class="col-md-3">
                                        <label class="control-label" title="">营业-确认：</label>
                                        <input title="" id="alterationOrder.kirikaeOrder.salesChecked" name="alterationOrder.kirikaeOrder.salesChecked"
                                               ng-model="alterationOrder.kirikaeOrder.salesChecked" class="form-control-order form-control clean">
                                    </div>
                                    <div class="col-md-3">
                                        <label class="control-label" title="">营业-担当：</label>
                                        <input title="" id="alterationOrder.kirikaeOrder.salesPrepared" name="alterationOrder.kirikaeOrder.salesPrepared"
                                               ng-model="alterationOrder.kirikaeOrder.salesPrepared" class="form-control-order form-control clean">
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-3">
                                        <label class="control-label" title="">设计-日期：</label>
                                        <input title="" id="alterationOrder.kirikaeOrder.engineeringData" name="alterationOrder.kirikaeOrder.engineeringData" data-type="date"
                                               ng-model="alterationOrder.kirikaeOrder.engineeringData" class="form-control-order form-control clean">
                                    </div>
                                    <div class="col-md-3">
                                        <label class="control-label" title="">设计-承认：</label>
                                        <input title="" id="alterationOrder.kirikaeOrder.engineeringApproved" name="alterationOrder.kirikaeOrder.engineeringApproved"
                                               ng-model="alterationOrder.kirikaeOrder.engineeringApproved" class="form-control-order form-control clean">
                                    </div>
                                    <div class="col-md-3">
                                        <label class="control-label" title="">设计-确认：</label>
                                        <input title="" id="alterationOrder.kirikaeOrder.engineeringChecked" name="alterationOrder.kirikaeOrder.engineeringChecked"
                                               ng-model="alterationOrder.kirikaeOrder.engineeringChecked" class="form-control-order form-control clean">
                                    </div>
                                    <div class="col-md-3">
                                        <label class="control-label" title="">设计-担当：</label>
                                        <input title="" id="alterationOrder.kirikaeOrder.engineeringPrepared" name="alterationOrder.kirikaeOrder.engineeringPrepared"
                                               ng-model="alterationOrder.kirikaeOrder.engineeringPrepared" class="form-control-order form-control clean">
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-3">
                                        <label class="control-label" title="">客户：</label>
                                        <input title="" id="alterationOrder.kirikaeOrder.customer" name="alterationOrder.kirikaeOrder.customer"
                                               ng-model="alterationOrder.kirikaeOrder.customer" class="form-control-order form-control clean">
                                    </div>
                                    <div class="col-md-3">
                                        <label class="control-label" title="">车种名：</label>
                                        <input title="" id="alterationOrder.kirikaeOrder.vehicleName" name="alterationOrder.kirikaeOrder.vehicleName"
                                               ng-model="alterationOrder.kirikaeOrder.vehicleName" class="form-control-order form-control clean">
                                    </div>
                                    <div class="col-md-3">
                                        <label class="control-label" title="">销售地：</label>
                                        <input title="" id="alterationOrder.kirikaeOrder.destination" name="alterationOrder.kirikaeOrder.destination"
                                               ng-model="alterationOrder.kirikaeOrder.destination" class="form-control-order form-control clean">
                                    </div>
                                    <div class="col-md-3">
                                        <label class="control-label" title="">初回品处理：</label>
                                        <select title="" id="alterationOrder.kirikaeOrder.isirProcessing" name="alterationOrder.kirikaeOrder.isirProcessing"
                                                class="form-control-order form-control clean" ng-model="alterationOrder.kirikaeOrder.isirProcessing">
                                            <option value="">请选择</option>
                                            <option value="1">要</option>
                                            <option value="2">不要</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-3">
                                        <label class="control-label" title="">客户技术承认：</label>
                                        <select title="" id="alterationOrder.kirikaeOrder.customerEngineering" name="alterationOrder.kirikaeOrder.customerEngineering"
                                                class="form-control-order form-control clean" ng-model="alterationOrder.kirikaeOrder.customerEngineering">
                                            <option value="">请选择</option>
                                            <option value="1">要</option>
                                            <option value="2">不要</option>
                                        </select>
                                    </div>
                                    <div class="col-md-3">
                                        <label class="control-label" title="">需要承认：</label>
                                        <select title="" id="alterationOrder.kirikaeOrder.customerEngineeringApproval" name="alterationOrder.kirikaeOrder.customerEngineeringApproval"
                                                class="form-control-order form-control clean" ng-model="alterationOrder.kirikaeOrder.customerEngineeringApproval">
                                            <option value="">请选择</option>
                                            <option value="1">承认</option>
                                            <option value="2">未承认</option>
                                        </select>
                                    </div>
                                    <div class="col-md-3">
                                        <label class="control-label" title="">法规关系：</label>
                                        <select title="" id="alterationOrder.kirikaeOrder.regulation" name="alterationOrder.kirikaeOrder.regulation"
                                                class="form-control-order form-control clean" ng-model="alterationOrder.kirikaeOrder.regulation">
                                            <option value="">请选择</option>
                                            <option value="1">有</option>
                                            <option value="2">无</option>
                                        </select>
                                    </div>
                                    <div class="col-md-3">
                                        <label class="control-label" title="">有关系：</label>
                                        <select title="" id="alterationOrder.kirikaeOrder.regulationApproval" name="alterationOrder.kirikaeOrder.regulationApproval"
                                                class="form-control-order form-control clean" ng-model="alterationOrder.kirikaeOrder.regulationApproval">
                                            <option value="">请选择</option>
                                            <option value="1">认可</option>
                                            <option value="2">不认可</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-3">
                                        <label class="control-label" title="">互换性-旧：</label>
                                        <select title="" id="alterationOrder.kirikaeOrder.interchangeabilityOld" name="alterationOrder.kirikaeOrder.interchangeabilityOld"
                                                class="form-control-order form-control clean" ng-model="alterationOrder.kirikaeOrder.interchangeabilityOld">
                                            <option value="">请选择</option>
                                            <option value="A">A</option>
                                            <option value="B">B</option>
                                        </select>
                                    </div>
                                    <div class="col-md-3">
                                        <label class="control-label" title="">互换性-新：</label>
                                        <select title="" id="alterationOrder.kirikaeOrder.interchangeabilityNew" name="alterationOrder.kirikaeOrder.interchangeabilityNew"
                                                class="form-control-order form-control clean" ng-model="alterationOrder.kirikaeOrder.interchangeabilityNew">
                                            <option value="">请选择</option>
                                            <option value="C">C</option>
                                            <option value="D">D</option>
                                        </select>
                                    </div>
                                    <div class="col-md-3">
                                        <label class="control-label" title="">售后服务：</label>
                                        <select title="" id="alterationOrder.kirikaeOrder.serviceSuplied" name="alterationOrder.kirikaeOrder.serviceSuplied"
                                                class="form-control-order form-control clean" ng-model="alterationOrder.kirikaeOrder.serviceSuplied">
                                            <option value="">请选择</option>
                                            <option value="1">有</option>
                                            <option value="2">无</option>
                                        </select>
                                    </div>
                                    <div class="col-md-3">
                                        <label class="control-label" title="">模具设变费：</label>
                                        <select title="" id="alterationOrder.kirikaeOrder.designCosts" name="alterationOrder.kirikaeOrder.designCosts"
                                                class="form-control-order form-control clean" ng-model="alterationOrder.kirikaeOrder.designCosts">
                                            <option value="">请选择</option>
                                            <option value="1">有</option>
                                            <option value="2">无</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-3">
                                        <label class="control-label" title="">模具费承担：</label>
                                        <select title="" id="alterationOrder.kirikaeOrder.designCostsPay" name="alterationOrder.kirikaeOrder.designCostsPay"
                                                class="form-control-order form-control clean" ng-model="alterationOrder.kirikaeOrder.designCostsPay">
                                            <option value="">请选择</option>
                                            <option value="1">客户</option>
                                            <option value="2">高田</option>
                                            <option value="3">供应商</option>
                                        </select>
                                    </div>
                                    <div class="col-md-3">
                                        <label class="control-label" title="">客户手配书：</label>
                                        <input title="" id="alterationOrder.kirikaeOrder.customerEo" name="alterationOrder.kirikaeOrder.customerEo"
                                               ng-model="alterationOrder.kirikaeOrder.customerEo" class="form-control-order form-control clean">
                                    </div>
                                    <div class="col-md-3">
                                        <label class="control-label" title="">品号变更：</label>
                                        <select title="" id="alterationOrder.kirikaeOrder.partsNumberChange" name="alterationOrder.kirikaeOrder.partsNumberChange"
                                                class="form-control-order form-control clean" ng-model="alterationOrder.kirikaeOrder.partsNumberChange">
                                            <option value="">请选择</option>
                                            <option value="1">有</option>
                                            <option value="2">无</option>
                                        </select>
                                    </div>
                                    <div class="col-md-3">
                                        <label class="control-label" title="">切替现场确认：</label>
                                        <select title="" id="alterationOrder.kirikaeOrder.presenceRequired" name="alterationOrder.kirikaeOrder.presenceRequired"
                                                class="form-control-order form-control clean" ng-model="alterationOrder.kirikaeOrder.presenceRequired">
                                            <option value="">请选择</option>
                                            <option value="1">需要</option>
                                            <option value="2">不需要</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-3">
                                        <label class="control-label" title="">切替时间：</label>
                                        <input title="" id="alterationOrder.kirikaeOrder.designChangeTiming" name="alterationOrder.kirikaeOrder.designChangeTiming" data-type="date"
                                               ng-model="alterationOrder.kirikaeOrder.designChangeTiming" class="form-control-order form-control clean">
                                    </div>
                                    <div class="col-md-3">
                                        <label class="control-label" title="">切替类型：</label>
                                        <select title="" id="alterationOrder.kirikaeOrder.desingChangeType" name="alterationOrder.kirikaeOrder.desingChangeType"
                                                class="form-control-order form-control clean" ng-model="alterationOrder.kirikaeOrder.desingChangeType">
                                            <option value="">请选择</option>
                                            <option value="1">高田</option>
                                            <option value="2">客户</option>
                                        </select>
                                    </div>
                                    <div class="col-md-3">
                                        <label class="control-label" title="">制造内线：</label>
                                        <input title="" id="alterationOrder.kirikaeOrder.manufactureInternal" name="alterationOrder.kirikaeOrder.manufactureInternal"
                                               ng-model="alterationOrder.kirikaeOrder.manufactureInternal" class="form-control-order form-control clean">
                                    </div>
                                    <div class="col-md-3">
                                        <label class="control-label" title="">制造担当：</label>
                                        <input title="" id="alterationOrder.kirikaeOrder.manufacturePrepared" name="alterationOrder.kirikaeOrder.manufacturePrepared"
                                               ng-model="alterationOrder.kirikaeOrder.manufacturePrepared" class="form-control-order form-control clean">
                                    </div>
                                </div>
                                <div class="common-table-header">
                                    <button class="btn btn-small btn-success" type="button" style="padding-top: 0px;" ng-click="addKirikaeOrderChangeContent()">
                                        <i class="icon-plus-sign icon-on-right bigger-110"></i>新增
                                    </button>
                                    <span>设变内容</span>
                                </div>
                                <div>
                                    <table class="table table-striped table-bordered table-hover">
                                        <thead>
                                            <tr>
                                                <th class="common-table-td" width="20%">变更前</th>
                                                <th class="common-table-td" width="25%">附件</th>
                                                <th class="common-table-td" width="20%">变更后</th>
                                                <th class="common-table-td" width="25">附件</th>
                                                <th class="common-table-td" width="10%">操作</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr ng-repeat="data in alterationOrder.kirikaeOrder.kirikaeOrderChangeContentList">
                                                <td>
                                                    <input title="" id="alterationOrder.kirikaeOrder.kirikaeOrderChangeContentList[{{$index}}].beforeChange" name="alterationOrder.kirikaeOrder.kirikaeOrderChangeContentList[{{$index}}].beforeChange"
                                                           ng-model="alterationOrder.kirikaeOrder.kirikaeOrderChangeContentList[$index].beforeChange" class="form-control-order form-control clean" style="width: 95%" />
                                                </td>
                                                <td>
                                                    <input type="hidden" id="alterationOrder.kirikaeOrder.kirikaeOrderChangeContentList[{{$index}}].beforeFileId" name="alterationOrder.kirikaeOrder.kirikaeOrderChangeContentList[{{$index}}].beforeFileId"
                                                           ng-model="alterationOrder.kirikaeOrder.kirikaeOrderChangeContentList[$index].beforeFileId" class="form-control-order form-control clean" />
                                                    <button class="btn btn-small btn-purple" type="button" ng-click="uploadBeforeFile($index)">
                                                        <i class="icon-edit icon-on-right bigger-110"></i>上传
                                                    </button>
                                                    {{data.beforeFileName}}
                                                </td>
                                                <td>
                                                    <input title="" id="alterationOrder.kirikaeOrder.kirikaeOrderChangeContentList[{{$index}}].afterChange" name="alterationOrder.kirikaeOrder.kirikaeOrderChangeContentList[{{$index}}].afterChange"
                                                           ng-model="alterationOrder.kirikaeOrder.kirikaeOrderChangeContentList[$index].afterChange" class="form-control-order form-control clean" style="width: 95%" />
                                                </td>
                                                <td>
                                                    <input type="hidden" id="alterationOrder.kirikaeOrder.kirikaeOrderChangeContentList[{{$index}}].newFileId" name="alterationOrder.kirikaeOrder.kirikaeOrderChangeContentList[{{$index}}].newFileId"
                                                           ng-model="alterationOrder.kirikaeOrder.kirikaeOrderChangeContentList[$index].newFileId" class="form-control-order form-control clean" />
                                                    <button class="btn btn-small btn-purple" type="button" ng-click="uploadNewFile($index)">
                                                        <i class="icon-edit icon-on-right bigger-110"></i>上传
                                                    </button>
                                                    {{data.newFileName}}
                                                </td>
                                                <td>
                                                    <button class="btn btn-small btn-purple" type="button" ng-click="delKirikaeOrderChangeContent($index)">
                                                        <i class="icon-edit icon-on-right bigger-110"></i>删除
                                                    </button>
                                                </td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </div>
                                <div style="height: 10px;"></div>
                                <div class="common-table-header">
                                    <button class="btn btn-small btn-success" type="button" style="padding-top: 0px;" ng-click="addKirikaeOrderPartsNumber()">
                                        <i class="icon-plus-sign icon-on-right bigger-110"></i>新增
                                    </button>
                                    <span>对象部品及品号</span>
                                </div>
                                <div>
                                    <table class="table table-striped table-bordered table-hover">
                                        <thead>
                                            <tr>
                                                <th class="common-table-td" width="45%">变更前</th>
                                                <th class="common-table-td" width="45%">变更后</th>
                                                <th class="common-table-td" width="10%">操作</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr ng-repeat="data in alterationOrder.kirikaeOrder.kirikaeOrderPartsNumberList">
                                                <td>
                                                    <input title="" id="alterationOrder.kirikaeOrder.kirikaeOrderPartsNumberList[{{$index}}].oldPartsNumber" name="alterationOrder.kirikaeOrder.kirikaeOrderPartsNumberList[{{$index}}].oldPartsNumber"
                                                           ng-model="alterationOrder.kirikaeOrder.kirikaeOrderPartsNumberList[$index].oldPartsNumber" class="form-control-order form-control clean" style="width: 95%" />
                                                </td>
                                                <td>
                                                    <input title="" id="alterationOrder.kirikaeOrder.kirikaeOrderPartsNumberList[{{$index}}].newPattsNumber" name="alterationOrder.kirikaeOrder.kirikaeOrderPartsNumberList[{{$index}}].newPattsNumber"
                                                           ng-model="alterationOrder.kirikaeOrder.kirikaeOrderPartsNumberList[$index].newPattsNumber" class="form-control-order form-control clean" style="width: 95%" />
                                                </td>
                                                <td>
                                                    <button class="btn btn-small btn-purple" type="button" ng-click="delKirikaeOrderPartsNumber($index)">
                                                        <i class="icon-edit icon-on-right bigger-110"></i>删除
                                                    </button>
                                                </td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="modal-body">
                    <div class="modal-footer">
                        <button type="button" ng-click="addKirikaeOrder()"
                                class="btn btn-small btn-primary">确定</button>
                        <button type="button"
                                class="btn btn-small btn-primary" data-dismiss="modal">取消
                        </button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</form>
<!--文件上传-->
<div id="fileUploadModal" class="modal fade" tabindex="-1"
     role="dialog" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-body">
            <form class="form-inline" method='post' id='excelForm' enctype='multipart/form-data' action='<%=request.getContextPath()%>/system/file/fileUpload.do'>
                <input class="form-control-order form-control clean" style="width: 90%;" type='file' name='uploadFile' id='uploadFile'/>
                <button class="btn btn-small btn-purple" type="button" ng-click="uplodFile()">
                    <i class="icon-on-right bigger-110"></i>提交
                </button>
            </form>
        </div>
    </div>
</div>
<!--文件上传-->
</body>
<script src="<%=request.getContextPath()%>/static/js/kirikae/order/kirikaeOrderAddOrEdit.js"></script>
</html>
