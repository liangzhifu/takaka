package com.takata.alteration.order.service;

import com.takata.alteration.order.domain.AlterationKirikaeOrderChangeContent;
import com.takata.alteration.order.query.AlterationKirikaeOrderChangeContentQuery;

import java.util.List;

public interface AlterationKirikaeOrderChangeContentService {

    /**
     * 添加多个变更内容
     * @param alterationKirikaeOrderChangeContentList 变更内容实体列表
     * @throws Exception 异常
     */
    void addAlterationKirikaeOrderChangeContentList(List<AlterationKirikaeOrderChangeContent> alterationKirikaeOrderChangeContentList) throws Exception;

    /**
     * 删除切替单的所有变更内容
     * @param kirikaeOrderId 切替单ID
     * @throws Exception 异常
     */
    void deleteAlterationKirikaeOrderChangeContentByKirikaeOrderId(Integer kirikaeOrderId) throws Exception;

    /**
     * 查询变更内容列表
     * @param alterationKirikaeOrderChangeContentQuery 查询条件
     * @return 返回结果
     * @throws Exception 异常
     */
    List<AlterationKirikaeOrderChangeContent> listAlterationKirikaeOrderChangeContent(AlterationKirikaeOrderChangeContentQuery alterationKirikaeOrderChangeContentQuery) throws Exception;

}
