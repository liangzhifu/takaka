package com.takata.alteration.order.service;

import com.takata.alteration.order.domain.AlterationFourOrder;

/**
 * @author lzf
 **/

public interface AlterationFourOrderService {

    /**
     * 获取4M变更单信息
     * @param alterationFourOrder 4M变更单实体信息
     * @return 返回结果
     * @throws Exception 异常
     */
    AlterationFourOrder getAlterationFourOrder(AlterationFourOrder alterationFourOrder) throws Exception;

    /**
     * 获取4M变更单信息--根据变更单ID
     * @param orderId 变更单ID
     * @return 返回结果
     * @throws Exception 异常
     */
    AlterationFourOrder getAlterationFourOrderByAlterationOrderId(Integer orderId) throws Exception;

    /**
     * 新增4M变更单
     * @param alterationFourOrder 4M变更单实体信息
     * @throws Exception 异常
     */
    void addAlterationFourOrder(AlterationFourOrder alterationFourOrder) throws Exception;

    /**
     * 修改4M变更单
     * @param alterationFourOrder 4M变更单实体信息
     * @throws Exception 异常
     */
    void editAlterationFourOrder(AlterationFourOrder alterationFourOrder) throws Exception;

}
