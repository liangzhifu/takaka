package com.takata.four.tache.service;

import com.takata.four.tache.domain.FourTemplateTache;

import java.util.List;

public interface FourTemplateTacheService {

    /**
     * 获取模板的工单列表
     * @param templateId 模板ID
     * @return 返回结果
     * @throws Exception 异常
     */
    List<FourTemplateTache> listFourTemplateTache(Integer templateId) throws Exception;

}
