<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../common/css.jsp"%>
<%@include file="../common/js.jsp"%>
<div class="main-content">
    <div class="page-content">
        <div class="row-fluid">
            <div class="span12">
                <div class="block" style="margin-top: 0px; margin-bottom: 0px;">
                    <div class="block-header">
                        <div>
                            <i class="icon-edit"></i>4M信息
                        </div>
                    </div>
                    <div class="modal-body" style="width: 100%; height: 35%; overflow-y: scroll;padding-top: 0px; padding-bottom: 0px;">
                        <div class="row">
                            <div class="col-md-3">
                                <label class="control-label" title="">发行日期：</label>
                                <input class="form-control-order form-control" type="text" data-type="date"
                                       id="alterationOrder.alterationFourOrder.releaseDate" name="alterationFourOrder.releaseDate"
                                       ng-model="alterationOrder.alterationFourOrder.releaseDate">
                            </div>
                            <div class="col-md-3">
                                <label class="control-label" title="">发行编号：</label>
                                <input class="form-control-order form-control" type="text" disabled="disabled"
                                       id="alterationOrder.alterationFourOrder.issueNumber" name="alterationFourOrder.issueNumber"
                                       ng-model="alterationOrder.alterationFourOrder.issueNumber">
                            </div>
                            <div class="col-md-3">
                                <label class="control-label" title="">生产线：</label>
                                <input class="form-control-order form-control" type="text" required="required"
                                       id="alterationOrder.alterationFourOrder.productLine" name="alterationFourOrder.productLine"
                                       ng-model="alterationOrder.alterationFourOrder.productLine">
                            </div>
                            <div class="col-md-3">
                                <label class="control-label" title="">变更前品号：</label>
                                <input class="form-control-order form-control" type="text"
                                       id="alterationOrder.alterationFourOrder.changeBeforProductNo" name="alterationFourOrder.changeBeforProductNo"
                                       ng-model="alterationOrder.alterationFourOrder.changeBeforProductNo">
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-3">
                                <label class="control-label" title="">变更后品号：</label>
                                <input class="form-control-order form-control" type="text"
                                       id="alterationOrder.alterationFourOrder.changeAfterProductNo" name="alterationFourOrder.changeAfterProductNo"
                                       ng-model="alterationOrder.alterationFourOrder.changeAfterProductNo">
                            </div>
                            <div class="col-md-3">
                                <label class="control-label" title="">车种名：</label>
                                <input class="form-control-order form-control" type="text" required="required"
                                       id="alterationOrder.alterationFourOrder.carName" name="alterationFourOrder.carName"
                                       ng-model="alterationOrder.alterationFourOrder.carName">
                            </div>
                            <div class="col-md-3">
                                <label class="control-label" title="">安装席：</label>
                                <input class="form-control-order form-control" type="text" required="required"
                                       id="alterationOrder.alterationFourOrder.installationMat" name="alterationFourOrder.installationMat"
                                       ng-model="alterationOrder.alterationFourOrder.installationMat">
                            </div>
                            <div class="col-md-3">
                                <label class="control-label" title="">变更时间：</label>
                                <input class="form-control-order form-control" type="text" required="required"
                                       id="alterationOrder.alterationFourOrder.estimateChangeTime" name="alterationFourOrder.estimateChangeTime"
                                       ng-model="alterationOrder.alterationFourOrder.estimateChangeTime">
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-12">
                                <label class="control-label" title="">制造部：</label>
                                <div style="display: inline">
                                    <div ng-repeat="data in templateAttrList | attrFilter:6" style="display: inline">
                                        <input type="checkbox" class="form-checkbox-mypage" name="order_attr_checkbox_6_{{data.id}}"
                                               id="order_attr_checkbox_6_{{data.id}}" value="1">{{data.attrName}}
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <label class="control-label" title="">生产管理部：</label>
                                <div style="display: inline">
                                    <div ng-repeat="data in templateAttrList | attrFilter:5" style="display: inline">
                                        <input type="checkbox" class="form-checkbox-mypage" name="order_attr_checkbox_5_{{data.id}}"
                                               id="order_attr_checkbox_5_{{data.id}}" value="1">{{data.attrName}}
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-3">
                                <label class="control-label" title="">品质部：</label>
                                <div ng-repeat="data in templateAttrList | attrFilter:7" style="display: inline">
                                    <input type="checkbox" class="form-checkbox-mypage" name="order_attr_checkbox_7_{{data.id}}"
                                           id="order_attr_checkbox_7_{{data.id}}" value="1">{{data.attrName}}
                                </div>
                            </div>
                            <div class="col-md-3">
                                <label class="control-label" title="">其他：</label>
                                <div ng-repeat="data in templateAttrList | attrFilter:8" style="display: inline">
                                    <input type="checkbox" class="form-checkbox-mypage" name="order_attr_checkbox_8_{{data.id}}"
                                           id="order_attr_checkbox_8_{{data.id}}" value="1">{{data.attrName}}
                                    (<div style="display: inline">
                                    <input id="order_attr_checkbox_8_{{data.id}}_value" name="order_attr_checkbox_8_{{data.id}}_value">
                                </div>)
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-12">
                                <label class="control-label" title="">变更内容：</label>
                                <textarea class="form-control-order form-control clean" style="width: 90%" required="required"
                                          rows="2" id="alterationOrder.alterationFourOrder.changeContent" name="alterationFourOrder.changeContent"
                                          ng-model="alterationOrder.alterationFourOrder.changeContent"></textarea>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-3">
                                <label class="control-label" title="">实际变更时间：</label>
                                <input class="form-control-order form-control" type="text" disabled="disabled"
                                       id="alterationOrder.alterationFourOrder.realChangeTime" name="alterationFourOrder.realChangeTime"
                                       ng-model="alterationOrder.alterationFourOrder.realChangeTime">
                            </div>
                            <div class="col-md-3">
                                <label class="control-label" title="">承认：</label>
                                <select id="four_order_approved" class="form-control-order form-control clean chosen-select chosen" required="required">
                                    <option value="">请选择</option>
                                    <option ng-repeat="data in systemUserList" value="{{data.id}}">{{data.userName}}</option>
                                </select>
                            </div>
                            <div class="col-md-3">
                                <label class="control-label" title="">确认：</label>
                                <select id="four_order_checked" class="form-control-order form-control clean chosen-select chosen" required="required">
                                    <option value="">请选择</option>
                                    <option ng-repeat="data in systemUserList" value="{{data.id}}">{{data.userName}}</option>
                                </select>
                            </div>
                            <div class="col-md-3">
                                <label class="control-label" title="">做成：</label>
                                <select id="four_order_prepared" class="form-control-order form-control clean chosen-select chosen">
                                    <option value="">请选择</option>
                                    <option ng-repeat="data in systemUserList" value="{{data.id}}">{{data.userName}}</option>
                                </select>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="row-fluid">
            <div class="span12">
                <div class="block" style="margin-top: 0px; margin-bottom: 0px;">
                    <div class="block-header">
                        <div>
                            <i class="icon-edit"></i>切替信息
                        </div>
                    </div>
                    <div class="modal-body" style="width: 100%; height: 35%; overflow-y: scroll;padding-top: 0px; padding-bottom: 0px;">
                        <div class="row">
                            <div class="col-md-3">
                                <label class="control-label" title="">切替单类型：</label>
                                <select id="alterationOrder.alterationKirikaeOrder.kirikaeOrderType" name="alterationOrder.alterationKirikaeOrder.kirikaeOrderType"
                                        class="form-control-order form-control clean" ng-model="alterationOrder.alterationKirikaeOrder.kirikaeOrderType">
                                    <option value="">请选择</option>
                                    <option value="1">量产前</option>
                                    <option value="2">量产后</option>
                                </select>
                            </div>
                            <div class="col-md-3">
                                <label class="control-label" title="">切替号：</label>
                                <input id="alterationOrder.alterationKirikaeOrder.tkNo" name="alterationOrder.alterationKirikaeOrder.tkNo"
                                       ng-model="alterationOrder.alterationKirikaeOrder.tkNo" class="form-control-order form-control clean">
                            </div>
                            <div class="col-md-3">
                                <label class="control-label" title="">设变号：</label>
                                <input id="alterationOrder.alterationKirikaeOrder.designChangeNo" name="alterationOrder.alterationKirikaeOrder.designChangeNo"
                                       ng-model="alterationOrder.alterationKirikaeOrder.designChangeNo" class="form-control-order form-control clean">
                            </div>
                            <div class="col-md-3">
                                <label class="control-label" title="">客户协议：</label>
                                <select id="alterationOrder.alterationKirikaeOrder.salesCustomerProtocal" name="alterationOrder.alterationKirikaeOrder.salesCustomerProtocal"
                                        class="form-control-order form-control clean" ng-model="alterationOrder.alterationKirikaeOrder.salesCustomerProtocal">
                                    <option value="">请选择</option>
                                    <option value="0">否</option>
                                    <option value="1">是</option>
                                </select>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-3">
                                <label class="control-label" title="">营业-日期：</label>
                                <input id="alterationOrder.alterationKirikaeOrder.salesDate" name="alterationOrder.alterationKirikaeOrder.salesDate" data-type="date"
                                       ng-model="alterationOrder.alterationKirikaeOrder.salesDate" class="form-control-order form-control clean">
                            </div>
                            <div class="col-md-3">
                                <label class="control-label" title="">营业-承认：</label>
                                <input id="alterationOrder.alterationKirikaeOrder.salesApproved" name="alterationOrder.alterationKirikaeOrder.salesApproved"
                                       ng-model="alterationOrder.alterationKirikaeOrder.salesApproved" class="form-control-order form-control clean">
                            </div>
                            <div class="col-md-3">
                                <label class="control-label" title="">营业-确认：</label>
                                <input id="alterationOrder.alterationKirikaeOrder.salesChecked" name="alterationOrder.alterationKirikaeOrder.salesChecked"
                                       ng-model="alterationOrder.alterationKirikaeOrder.salesChecked" class="form-control-order form-control clean">
                            </div>
                            <div class="col-md-3">
                                <label class="control-label" title="">营业-担当：</label>
                                <input id="alterationOrder.alterationKirikaeOrder.salesPrepared" name="alterationOrder.alterationKirikaeOrder.salesPrepared"
                                       ng-model="alterationOrder.alterationKirikaeOrder.salesPrepared" class="form-control-order form-control clean">
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-3">
                                <label class="control-label" title="">设计-日期：</label>
                                <input id="alterationOrder.alterationKirikaeOrder.engineeringData" name="alterationOrder.alterationKirikaeOrder.engineeringData" data-type="date"
                                       ng-model="alterationOrder.alterationKirikaeOrder.engineeringData" class="form-control-order form-control clean">
                            </div>
                            <div class="col-md-3">
                                <label class="control-label" title="">设计-承认：</label>
                                <input id="alterationOrder.alterationKirikaeOrder.engineeringApproved" name="alterationOrder.alterationKirikaeOrder.engineeringApproved"
                                       ng-model="alterationOrder.alterationKirikaeOrder.engineeringApproved" class="form-control-order form-control clean">
                            </div>
                            <div class="col-md-3">
                                <label class="control-label" title="">设计-确认：</label>
                                <input id="alterationOrder.alterationKirikaeOrder.engineeringChecked" name="alterationOrder.alterationKirikaeOrder.engineeringChecked"
                                       ng-model="alterationOrder.alterationKirikaeOrder.engineeringChecked" class="form-control-order form-control clean">
                            </div>
                            <div class="col-md-3">
                                <label class="control-label" title="">设计-担当：</label>
                                <input id="alterationOrder.alterationKirikaeOrder.engineeringPrepared" name="alterationOrder.alterationKirikaeOrder.engineeringPrepared"
                                       ng-model="alterationOrder.alterationKirikaeOrder.engineeringPrepared" class="form-control-order form-control clean">
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-3">
                                <label class="control-label" title="">客户：</label>
                                <input id="alterationOrder.alterationKirikaeOrder.customer" name="alterationOrder.alterationKirikaeOrder.customer"
                                       ng-model="alterationOrder.alterationKirikaeOrder.customer" class="form-control-order form-control clean">
                            </div>
                            <div class="col-md-3">
                                <label class="control-label" title="">车种名：</label>
                                <input id="alterationOrder.alterationKirikaeOrder.vehicleName" name="alterationOrder.alterationKirikaeOrder.vehicleName"
                                       ng-model="alterationOrder.alterationKirikaeOrder.vehicleName" class="form-control-order form-control clean">
                            </div>
                            <div class="col-md-3">
                                <label class="control-label" title="">销售地：</label>
                                <input id="alterationOrder.alterationKirikaeOrder.destination" name="alterationOrder.alterationKirikaeOrder.destination"
                                       ng-model="alterationOrder.alterationKirikaeOrder.destination" class="form-control-order form-control clean">
                            </div>
                            <div class="col-md-3">
                                <label class="control-label" title="">初回品处理：</label>
                                <select id="alterationOrder.alterationKirikaeOrder.isirProcessing" name="alterationOrder.alterationKirikaeOrder.isirProcessing"
                                        class="form-control-order form-control clean" ng-model="alterationOrder.alterationKirikaeOrder.isirProcessing">
                                    <option value="">请选择</option>
                                    <option value="1">要</option>
                                    <option value="2">不要</option>
                                </select>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-3">
                                <label class="control-label" title="">客户技术承认：</label>
                                <select id="alterationOrder.alterationKirikaeOrder.customerEngineering" name="alterationOrder.alterationKirikaeOrder.customerEngineering"
                                        class="form-control-order form-control clean" ng-model="alterationOrder.alterationKirikaeOrder.customerEngineering">
                                    <option value="">请选择</option>
                                    <option value="1">要</option>
                                    <option value="2">不要</option>
                                </select>
                            </div>
                            <div class="col-md-3">
                                <label class="control-label" title="">需要承认：</label>
                                <select id="alterationOrder.alterationKirikaeOrder.customerEngineeringApproval" name="alterationOrder.alterationKirikaeOrder.customerEngineeringApproval"
                                        class="form-control-order form-control clean" ng-model="alterationOrder.alterationKirikaeOrder.customerEngineeringApproval">
                                    <option value="">请选择</option>
                                    <option value="1">承认</option>
                                    <option value="2">未承认</option>
                                </select>
                            </div>
                            <div class="col-md-3">
                                <label class="control-label" title="">法规关系：</label>
                                <select id="alterationOrder.alterationKirikaeOrder.regulation" name="alterationOrder.alterationKirikaeOrder.regulation"
                                        class="form-control-order form-control clean" ng-model="alterationOrder.alterationKirikaeOrder.regulation">
                                    <option value="">请选择</option>
                                    <option value="1">有</option>
                                    <option value="2">无</option>
                                </select>
                            </div>
                            <div class="col-md-3">
                                <label class="control-label" title="">有关系：</label>
                                <select id="alterationOrder.alterationKirikaeOrder.regulationApproval" name="alterationOrder.alterationKirikaeOrder.regulationApproval"
                                        class="form-control-order form-control clean" ng-model="alterationOrder.alterationKirikaeOrder.regulationApproval">
                                    <option value="">请选择</option>
                                    <option value="1">认可</option>
                                    <option value="2">不认可</option>
                                </select>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-3">
                                <label class="control-label" title="">互换性-旧：</label>
                                <select id="alterationOrder.alterationKirikaeOrder.interchangeabilityOld" name="alterationOrder.alterationKirikaeOrder.interchangeabilityOld"
                                        class="form-control-order form-control clean" ng-model="alterationOrder.alterationKirikaeOrder.interchangeabilityOld">
                                    <option value="">请选择</option>
                                    <option value="A">A</option>
                                    <option value="B">B</option>
                                </select>
                            </div>
                            <div class="col-md-3">
                                <label class="control-label" title="">互换性-新：</label>
                                <select id="alterationOrder.alterationKirikaeOrder.interchangeabilityNew" name="alterationOrder.alterationKirikaeOrder.interchangeabilityNew"
                                        class="form-control-order form-control clean" ng-model="alterationOrder.alterationKirikaeOrder.interchangeabilityNew">
                                    <option value="">请选择</option>
                                    <option value="C">C</option>
                                    <option value="D">D</option>
                                </select>
                            </div>
                            <div class="col-md-3">
                                <label class="control-label" title="">售后服务：</label>
                                <select id="alterationOrder.alterationKirikaeOrder.serviceSuplied" name="alterationOrder.alterationKirikaeOrder.serviceSuplied"
                                        class="form-control-order form-control clean" ng-model="alterationOrder.alterationKirikaeOrder.serviceSuplied">
                                    <option value="">请选择</option>
                                    <option value="1">有</option>
                                    <option value="2">无</option>
                                </select>
                            </div>
                            <div class="col-md-3">
                                <label class="control-label" title="">模具设变费：</label>
                                <select id="alterationOrder.alterationKirikaeOrder.designCosts" name="alterationOrder.alterationKirikaeOrder.designCosts"
                                        class="form-control-order form-control clean" ng-model="alterationOrder.alterationKirikaeOrder.designCosts">
                                    <option value="">请选择</option>
                                    <option value="1">有</option>
                                    <option value="2">无</option>
                                </select>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-3">
                                <label class="control-label" title="">模具费承担：</label>
                                <select id="alterationOrder.alterationKirikaeOrder.designCostsPay" name="alterationOrder.alterationKirikaeOrder.designCostsPay"
                                        class="form-control-order form-control clean" ng-model="alterationOrder.alterationKirikaeOrder.designCostsPay">
                                    <option value="">请选择</option>
                                    <option value="1">客户</option>
                                    <option value="2">高田</option>
                                    <option value="3">供应商</option>
                                </select>
                            </div>
                            <div class="col-md-3">
                                <label class="control-label" title="">客户手配书：</label>
                                <input id="alterationOrder.alterationKirikaeOrder.customerEo" name="alterationOrder.alterationKirikaeOrder.customerEo"
                                       ng-model="alterationOrder.alterationKirikaeOrder.customerEo" class="form-control-order form-control clean">
                            </div>
                            <div class="col-md-3">
                                <label class="control-label" title="">品号变更：</label>
                                <select id="alterationOrder.alterationKirikaeOrder.partsNumberChange" name="alterationOrder.alterationKirikaeOrder.partsNumberChange"
                                        class="form-control-order form-control clean" ng-model="alterationOrder.alterationKirikaeOrder.partsNumberChange">
                                    <option value="">请选择</option>
                                    <option value="1">有</option>
                                    <option value="2">无</option>
                                </select>
                            </div>
                            <div class="col-md-3">
                                <label class="control-label" title="">切替现场确认：</label>
                                <select id="alterationOrder.alterationKirikaeOrder.presenceRequired" name="alterationOrder.alterationKirikaeOrder.presenceRequired"
                                        class="form-control-order form-control clean" ng-model="alterationOrder.alterationKirikaeOrder.presenceRequired">
                                    <option value="">请选择</option>
                                    <option value="1">需要</option>
                                    <option value="2">不需要</option>
                                </select>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-3">
                                <label class="control-label" title="">切替时间：</label>
                                <input id="alterationOrder.alterationKirikaeOrder.designChangeTiming" name="alterationOrder.alterationKirikaeOrder.designChangeTiming" data-type="date"
                                       ng-model="alterationOrder.alterationKirikaeOrder.designChangeTiming" class="form-control-order form-control clean">
                            </div>
                            <div class="col-md-3">
                                <label class="control-label" title="">切替类型：</label>
                                <select id="alterationOrder.alterationKirikaeOrder.desingChangeType" name="alterationOrder.alterationKirikaeOrder.desingChangeType"
                                        class="form-control-order form-control clean" ng-model="alterationOrder.alterationKirikaeOrder.desingChangeType">
                                    <option value="">请选择</option>
                                    <option value="1">高田</option>
                                    <option value="2">客户</option>
                                </select>
                            </div>
                            <div class="col-md-3">
                                <label class="control-label" title="">制造内线：</label>
                                <input id="alterationOrder.alterationKirikaeOrder.manufactureInternal" name="alterationOrder.alterationKirikaeOrder.manufactureInternal"
                                       ng-model="alterationOrder.alterationKirikaeOrder.manufactureInternal" class="form-control-order form-control clean">
                            </div>
                            <div class="col-md-3">
                                <label class="control-label" title="">制造担当：</label>
                                <input id="alterationOrder.alterationKirikaeOrder.manufacturePrepared" name="alterationOrder.alterationKirikaeOrder.manufacturePrepared"
                                       ng-model="alterationOrder.alterationKirikaeOrder.manufacturePrepared" class="form-control-order form-control clean">
                            </div>
                        </div>
                        <div class="common-table-header">
                            <button class="btn btn-small btn-success" type="button" style="padding-top: 0px;" ng-click="addKirikaeOrderDialog()">
                                <i class="icon-plus-sign icon-on-right bigger-110"></i>新增
                            </button>
                            <span>设变内容</span>
                        </div>
                        <div>
                            <table class="table table-striped table-bordered table-hover">
                                <thead>
                                <tr>
                                    <th class="common-table-td" width="30%">变更前</th>
                                    <th class="common-table-td" width="15%">附件</th>
                                    <th class="common-table-td" width="30%">变更后</th>
                                    <th class="common-table-td" width="15">附件</th>
                                    <th class="common-table-td" width="10%">操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr ng-repeat="data in alterationOrder.alterationFourOrder.alterationKirikaeOrderChangeContentList">
                                </tr>
                                </tbody>
                            </table>
                        </div>
                        <hr>
                        <div class="common-table-header">
                            <button class="btn btn-small btn-success" type="button" style="padding-top: 0px;" ng-click="addKirikaeOrderDialog()">
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
                                <tr ng-repeat="data in alterationOrder.alterationFourOrder.alterationKirikaeOrderPartsNumberList">
                                </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="modal-body" style="padding-top: 0px; padding-bottom: 0px;">
            <div class="modal-footer" style="padding-top: 5px; padding-bottom: 5px;">
                <button type="button" ng-click="addKirikaeOrder()"
                        class="btn btn-small btn-primary">确定</button>
                <button type="button"
                        class="btn btn-small btn-primary" data-dismiss="modal">取消
                </button>
            </div>
        </div>
    </div>
</div>
