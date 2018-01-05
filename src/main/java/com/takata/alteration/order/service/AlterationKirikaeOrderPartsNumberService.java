package com.takata.alteration.order.service;

import com.takata.alteration.order.domain.AlterationKirikaeOrderPartsNumber;
import com.takata.alteration.order.query.AlterationKirikaeOrderPartsNumberQuery;

import java.util.List;

public interface AlterationKirikaeOrderPartsNumberService {
    
    /**
     * 添加多个品号变更
     * @param alterationKirikaeOrderPartsNumberList 品号变更实体列表
     * @throws Exception 异常
     */
    void addAlterationKirikaeOrderPartsNumberList(List<AlterationKirikaeOrderPartsNumber> alterationKirikaeOrderPartsNumberList) throws Exception;

    /**
     * 删除切替单的所有品号变更
     * @param kirikaeOrderId 切替单ID
     * @throws Exception 异常
     */
    void deleteAlterationKirikaeOrderPartsNumberByKirikaeOrderId(Integer kirikaeOrderId) throws Exception;

    /**
     * 查询品号变更列表
     * @param alterationKirikaeOrderPartsNumberQuery 查询条件
     * @return 返回结果
     * @throws Exception 异常
     */
    List<AlterationKirikaeOrderPartsNumber> listAlterationKirikaeOrderPartsNumber(AlterationKirikaeOrderPartsNumberQuery alterationKirikaeOrderPartsNumberQuery) throws Exception;

}
