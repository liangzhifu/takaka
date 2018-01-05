<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>变更单详情</title>
    <%@include file="../common/js.jsp"%>
    <%@include file="../common/css.jsp"%>
</head>
<body ng-controller="orderDetailController" ng-cloak>
    <div class="ain-content">
        <div class="page-content">
            <div class="row-fluid">
                <div class="span12">
                    <div class="block">
                        <div class="modal-body">
                            <div class="row" style="margin-bottom: 0px;">
                                <div class="col-md-3">
                                    <label class="control-label" title="">发行日期：</label>
                                    <div style="display: inline">{{alterationOrder.alterationFourOrder.releaseDate}}</div>
                                </div>
                                <div class="col-md-3">
                                    <label class="control-label" title="">发行编号：</label>
                                    <div style="display: inline">{{alterationOrder.alterationFourOrder.issueNumber}}</div>
                                </div>
                                <div class="col-md-3">
                                    <label class="control-label" title="">生产线：</label>
                                    <div style="display: inline">{{alterationOrder.alterationFourOrder.productLine}}</div>
                                </div>
                                <div class="col-md-3">
                                    <label class="control-label" title="">变更前品号：</label>
                                    <div style="display: inline">{{alterationOrder.alterationFourOrder.changeBeforProductNo}}</div>
                                </div>
                            </div>
                            <div class="row" style="margin-bottom: 0px;">
                                <div class="col-md-3">
                                    <label class="control-label" title="">变更后品号：</label>
                                    <div style="display: inline">{{alterationOrder.alterationFourOrder.changeAfterProductNo}}</div>
                                </div>
                                <div class="col-md-3">
                                    <label class="control-label" title="">车种名：</label>
                                    <div style="display: inline">{{alterationOrder.alterationFourOrder.carName}}</div>
                                </div>
                                <div class="col-md-3">
                                    <label class="control-label" title="">安装席：</label>
                                    <div style="display: inline">{{alterationOrder.alterationFourOrder.installationMat}}</div>
                                </div>
                                <div class="col-md-3">
                                    <label class="control-label" title="">变更时间：</label>
                                    <div style="display: inline">{{alterationOrder.alterationFourOrder.estimateChangeTime}}</div>
                                </div>
                            </div>
                            <div class="row" style="margin-bottom: 0px;">
                                <div class="col-md-12">
                                    <label title="">制造部：</label>
                                    <div style="display: inline">
                                        <div ng-repeat="data in templateAttrList | attrFilter:6" style="display: inline">
                                            <input type="checkbox" class="form-checkbox-mypage" id="order_attr_checkbox_6_{{data.id}}" disabled>{{data.attrName}}
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="row" style="margin-bottom: 0px;">
                                <div class="col-md-6">
                                    <label title="">生产管理部：</label>
                                    <div style="display: inline">
                                        <div ng-repeat="data in templateAttrList | attrFilter:5" style="display: inline">
                                            <input type="checkbox" class="form-checkbox-mypage" id="order_attr_checkbox_5_{{data.id}}" disabled>{{data.attrName}}
                                        </div>
                                    </div>
                                </div>
                                </div>
                                <div class="col-md-3">
                                    <label title="">品质部：</label>
                                    <div style="display: inline">
                                        <div ng-repeat="data in templateAttrList | attrFilter:7" style="display: inline">
                                            <input type="checkbox" class="form-checkbox-mypage" id="order_attr_checkbox_7_{{data.id}}" disabled>{{data.attrName}}
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-3">
                                    <label title="">其他：</label>
                                    <div style="display: inline">
                                        <div ng-repeat="data in templateAttrList | attrFilter:8" style="display: inline">
                                            <input type="checkbox" class="form-checkbox-mypage" id="order_attr_checkbox_8_{{data.id}}" disabled>{{data.attrName}}
                                            (<div id="order_attr_checkbox_8_{{data.id}}_div" style="display: inline"></div>)
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="row" style="margin-bottom: 0px;">
                                <div class="col-md-12">
                                    <label class="control-label" title="">变更内容：</label>
                                    <div style="display: inline">{{alterationOrder.alterationFourOrder.changeContent}}</div>
                                </div>
                            </div>
                            <div class="row" style="margin-bottom: 0px;">
                                <div class="col-md-3">
                                    <label class="control-label" title="">实际变更时间：</label>
                                    <div style="display: inline">{{alterationOrder.alterationFourOrder.realChangeTime}}</div>
                                </div>
                                <div class="col-md-3">
                                    <label class="control-label" title="">承认：</label>
                                    <label></label>
                                </div>
                                <div class="col-md-3">
                                    <label class="control-label" title="">确认：</label>
                                    <label></label>
                                </div>
                                <div class="col-md-3">
                                    <label class="control-label" title="">做成：</label>
                                    <label></label>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
<script src="<%=request.getContextPath()%>/static/js/alteration/alterationOrderDetail.js"></script>
</html>
