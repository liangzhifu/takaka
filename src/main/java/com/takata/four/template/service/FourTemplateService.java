package com.takata.four.template.service;

import com.takata.four.template.domain.FourTemplate;

public interface FourTemplateService {

    /**
     * 获取4M模板
     * @return 返回结果
     * @throws Exception 异常
     */
    FourTemplate getFourTemplate() throws Exception;

}
