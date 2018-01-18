package com.takata.kirikae.order.service;

import com.takata.kirikae.order.domain.KirikaeOrderPartsNumber;
import com.takata.kirikae.order.query.KirikaeOrderPartsNumberQuery;

import java.util.List;

public interface KirikaeOrderPartsNumberService {
    
    /**
     * 添加多个品号变更
     * @param alterationKirikaeOrderPartsNumberList 品号变更实体列表
     * @throws Exception 异常
     */
    void addKirikaeOrderPartsNumberList(List<KirikaeOrderPartsNumber> alterationKirikaeOrderPartsNumberList) throws Exception;

    /**
     * 删除切替单的所有品号变更
     * @param kirikaeOrderId 切替单ID
     * @throws Exception 异常
     */
    void deleteKirikaeOrderPartsNumberByKirikaeOrderId(Integer kirikaeOrderId) throws Exception;

    /**
     * 查询品号变更列表
     * @param kirikaeOrderPartsNumberQuery 查询条件
     * @return 返回结果
     * @throws Exception 异常
     */
    List<KirikaeOrderPartsNumber> listKirikaeOrderPartsNumber(KirikaeOrderPartsNumberQuery kirikaeOrderPartsNumberQuery) throws Exception;

}
