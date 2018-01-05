package com.takata.alteration.order.service;

import com.takata.alteration.order.domain.AlterationKirikaeOrder;

public interface AlterationKirikaeOrderService {

    /**
     * 新增切替变更单
     * @param alterationKirikaeOrder 切替变更单实体
     * @throws Exception 返回异常
     */
    void addAlterationKirikaeOrder(AlterationKirikaeOrder alterationKirikaeOrder) throws Exception;

}
