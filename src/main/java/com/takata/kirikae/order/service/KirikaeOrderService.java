package com.takata.kirikae.order.service;

import com.takata.kirikae.order.domain.KirikaeOrder;

public interface KirikaeOrderService {

    /**
     * 新增切替变更单
     * @param alterationKirikaeOrder 切替变更单实体
     * @throws Exception 返回异常
     */
    void addAlterationKirikaeOrder(KirikaeOrder alterationKirikaeOrder) throws Exception;

    /**
     * 修改切替变更单
     * @param alterationKirikaeOrder 切替变更单实体
     * @throws Exception 返回异常
     */
    void editAlterationKirikaeOrder(KirikaeOrder alterationKirikaeOrder) throws Exception;

    /**
     * 获取切替变更单
     * @param alterationKirikaeOrder 切替变更单实体
     * @return 返回结果
     * @throws Exception 异常
     */
    KirikaeOrder getAlterationKirikaeOrder(KirikaeOrder alterationKirikaeOrder) throws Exception;

    /**
     * 获取切替变更单--通过变更单ID
     * @param orderId 变更单ID
     * @return 返回结果
     * @throws Exception 异常
     */
    KirikaeOrder getAlterationKirikaeOrderByAlterationOrderId(Integer orderId) throws Exception;

}
