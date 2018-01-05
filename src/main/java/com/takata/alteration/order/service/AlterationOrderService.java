package com.takata.alteration.order.service;

import com.takata.alteration.order.domain.AlterationOrder;

public interface AlterationOrderService {

    /**
     * 获取变更单信息
     * @param alterationOrder 变更单实体信息
     * @return 返回结果
     * @throws Exception 异常
     */
    AlterationOrder getAlterationOrder(AlterationOrder alterationOrder) throws Exception;

    /**
     * 新增变更单
     * @param alterationOrder 变更单实体信息
     * @throws Exception 异常
     */
    void addAlterationOrder(AlterationOrder alterationOrder) throws Exception;

    /**
     * 修改变更单
     * @param alterationOrder 变更单实体信息
     * @throws Exception 异常
     */
    void editAlterationOrder(AlterationOrder alterationOrder) throws Exception;

}
