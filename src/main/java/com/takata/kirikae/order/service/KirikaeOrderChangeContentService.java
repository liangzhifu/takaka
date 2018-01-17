package com.takata.kirikae.order.service;

import com.takata.kirikae.order.domain.KirikaeOrderChangeContent;
import com.takata.kirikae.order.query.KirikaeOrderChangeContentQuery;

import java.util.List;

public interface KirikaeOrderChangeContentService {

    /**
     * 添加多个变更内容
     * @param alterationKirikaeOrderChangeContentList 变更内容实体列表
     * @throws Exception 异常
     */
    void addAlterationKirikaeOrderChangeContentList(List<KirikaeOrderChangeContent> alterationKirikaeOrderChangeContentList) throws Exception;

    /**
     * 删除切替单的所有变更内容
     * @param kirikaeOrderId 切替单ID
     * @throws Exception 异常
     */
    void deleteAlterationKirikaeOrderChangeContentByKirikaeOrderId(Integer kirikaeOrderId) throws Exception;

    /**
     * 查询变更内容列表
     * @param kirikaeOrderChangeContentQuery 查询条件
     * @return 返回结果
     * @throws Exception 异常
     */
    List<KirikaeOrderChangeContent> listAlterationKirikaeOrderChangeContent(KirikaeOrderChangeContentQuery kirikaeOrderChangeContentQuery) throws Exception;

}
