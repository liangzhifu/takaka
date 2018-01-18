package com.takata.kirikae.order.service;

import com.takata.kirikae.order.domain.KirikaeOrder;
import com.takata.kirikae.order.query.KirikaeOrderQuery;

import java.util.List;
import java.util.Map;

public interface KirikaeOrderService {

    /**
     * 新增切替变更单
     * @param kirikaeOrder 切替变更单实体
     * @throws Exception 返回异常
     */
    void addKirikaeOrder(KirikaeOrder kirikaeOrder) throws Exception;

    /**
     * 修改切替变更单
     * @param kirikaeOrder 切替变更单实体
     * @throws Exception 返回异常
     */
    void editKirikaeOrder(KirikaeOrder kirikaeOrder) throws Exception;

    /**
     * 获取切替变更单
     * @param kirikaeOrder 切替变更单实体
     * @return 返回结果
     * @throws Exception 异常
     */
    KirikaeOrder getKirikaeOrder(KirikaeOrder kirikaeOrder) throws Exception;

    /**
     * 获取切替变更单--通过变更单ID
     * @param orderId 变更单ID
     * @return 返回结果
     * @throws Exception 异常
     */
    KirikaeOrder getKirikaeOrderByAlterationOrderId(Integer orderId) throws Exception;

    /**
     * 获取切替单列表--分页
     * @param kirikaeOrderQuery 查询条件
     * @return 返回结果
     * @throws Exception 异常
     */
    List<Map<String, Object>> listKirikaeOrderPage(KirikaeOrderQuery kirikaeOrderQuery) throws Exception;

    /**
     * 获取切替单数量
     * @param kirikaeOrderQuery 查询条件
     * @return 返回结果
     * @throws Exception 异常
     */
    Integer countKirikaeOrder(KirikaeOrderQuery kirikaeOrderQuery) throws Exception;

}
