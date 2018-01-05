package com.takata.four.tache.service;

import com.takata.four.tache.domain.FourTemplateTacheAttr;

import java.util.List;

public interface FourTemplateTacheAttrService {

    /**
     * 获取模板工单的多选框列表
     * @param templateId 模板ID
     * @return 返回结果
     * @throws Exception 异常
     */
    List<FourTemplateTacheAttr> listFourTemplateTacheAttr(Integer templateId) throws Exception;

}
