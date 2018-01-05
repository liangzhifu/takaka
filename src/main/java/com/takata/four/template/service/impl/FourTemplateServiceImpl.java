package com.takata.four.template.service.impl;

import com.takata.four.template.dao.FourTemplateDao;
import com.takata.four.template.domain.FourTemplate;
import com.takata.four.template.service.FourTemplateService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author lzf
 **/
@Service("fourTemplateService")
public class FourTemplateServiceImpl implements FourTemplateService {

    @Resource(name = "fourTemplateDao")
    private FourTemplateDao fourTemplateDao;

    @Override
    public FourTemplate getFourTemplate() throws Exception {
        return this.fourTemplateDao.selectFourTemplate();
    }
}
