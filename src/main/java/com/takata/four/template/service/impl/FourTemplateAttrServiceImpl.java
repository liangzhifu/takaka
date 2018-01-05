package com.takata.four.template.service.impl;

import com.takata.four.template.dao.FourTemplateAttrDao;
import com.takata.four.template.domain.FourTemplateAttr;
import com.takata.four.template.service.FourTemplateAttrService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author lzf
 **/
@Service("fourTemplateAttrService")
public class FourTemplateAttrServiceImpl implements FourTemplateAttrService {

    @Resource(name = "fourTemplateAttrDao")
    private FourTemplateAttrDao fourTemplateAttrDao;

    @Override
    public List<FourTemplateAttr> listFourTemplateAttr(Integer templateId) throws Exception {
        return this.fourTemplateAttrDao.selectFourTemplateAttrList(templateId);
    }
}
