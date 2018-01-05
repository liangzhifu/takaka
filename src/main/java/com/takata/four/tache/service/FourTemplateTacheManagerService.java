package com.takata.four.tache.service;

import com.takata.four.tache.domain.FourTemplateTacheManager;
import com.takata.four.tache.query.FourTemplateTacheManagerQuery;

import java.util.List;
import java.util.Map;

public interface FourTemplateTacheManagerService {

    /**
     * 新增模板工单管理者
     * @param tacheId 模板工单ID
     * @param userIds 用户ID数组
     * @throws Exception 异常
     */
    void addFourTemplateTacheManager(Integer tacheId, String[] userIds) throws Exception;

    /**
     * 删除模板工单管理
     * @param fourTemplateTacheManager 模板工单管理者实体
     * @throws Exception
     */
    void deleteFourTemplateTacheManager(FourTemplateTacheManager fourTemplateTacheManager) throws Exception;

    /**
     * 删除模板工单管理者--删除用户
     * @param userId 用户ID
     * @throws Exception 异常
     */
    void deleteFourTemplateTacheManagerByUser(Integer userId) throws Exception;

    /**
     * 查询模板工单管理列表
     * @param fourTemplateTacheManagerQuery 查询条件
     * @return 返回结果
     * @throws Exception 异常
     */
    List<Map<String, Object>> listFourTemplateTacheManager(FourTemplateTacheManagerQuery fourTemplateTacheManagerQuery) throws Exception;

}
