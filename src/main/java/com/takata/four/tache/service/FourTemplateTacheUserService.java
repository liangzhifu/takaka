package com.takata.four.tache.service;

import com.takata.four.tache.domain.FourTemplateTacheUser;
import com.takata.four.tache.query.FourTemplateTacheUserQuery;

import java.util.List;
import java.util.Map;

public interface FourTemplateTacheUserService {

    /**
     * 新增模板工单处理者
     * @param tacheId 模板工单ID
     * @param userIds 用户ID数组
     * @throws Exception 异常
     */
    void addFourTemplateTacheUser(Integer tacheId, String[] userIds) throws Exception;

    /**
     * 删除模板工单处理者
     * @param fourTemplateTacheUser 模板工单处理者实体
     * @throws Exception 异常
     */
    void deleteFourTemplateTacheUser(FourTemplateTacheUser fourTemplateTacheUser) throws Exception;

    /**
     * 删除模板工单处理者--删除用户
     * @param userId 用户ID
     * @throws Exception 异常
     */
    void deleteFourTemplateTacheUserByUser(Integer userId) throws Exception;

    /**
     *
     * @param fourTemplateTacheUserQuery 查询条件
     * @return
     * @throws Exception 异常
     */
    List<Map<String, Object>> listFourTemplateTacheUser(FourTemplateTacheUserQuery fourTemplateTacheUserQuery) throws Exception;

}
