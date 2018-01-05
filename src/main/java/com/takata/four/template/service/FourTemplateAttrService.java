package com.takata.four.template.service;

import com.takata.four.template.domain.FourTemplateAttr;

import java.util.List;

public interface FourTemplateAttrService {

    /**
     * 获取模板多选框列表
     * @param templateId 模板ID
     * @return 返回结果
     * @throws Exception 异常
     */
    List<FourTemplateAttr> listFourTemplateAttr(Integer templateId) throws Exception;

}
