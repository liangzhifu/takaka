package com.takata.alteration.order.service;

import com.takata.alteration.order.domain.AlterationKirikaeOrder;

public interface AlterationKirikaeOrderService {

    /**
     * 新增切替变更单
     * @param alterationKirikaeOrder 切替变更单实体
     * @throws Exception 返回异常
     */
    void addAlterationKirikaeOrder(AlterationKirikaeOrder alterationKirikaeOrder) throws Exception;

    /**
     * 修改切替变更单
     * @param alterationKirikaeOrder 切替变更单实体
     * @throws Exception 返回异常
     */
    void editAlterationKirikaeOrder(AlterationKirikaeOrder alterationKirikaeOrder) throws Exception;

    /**
     * 获取切替变更单
     * @param alterationKirikaeOrder 切替变更单实体
     * @return 返回结果
     * @throws Exception 异常
     */
    AlterationKirikaeOrder getAlterationKirikaeOrder(AlterationKirikaeOrder alterationKirikaeOrder) throws Exception;

    /**
     * 获取切替变更单--通过变更单ID
     * @param orderId 变更单ID
     * @return 返回结果
     * @throws Exception 异常
     */
    AlterationKirikaeOrder getAlterationKirikaeOrderByAlterationOrderId(Integer orderId) throws Exception;

}
