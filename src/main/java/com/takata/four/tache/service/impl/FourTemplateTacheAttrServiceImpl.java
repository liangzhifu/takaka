package com.takata.four.tache.service.impl;

import com.takata.four.tache.dao.FourTemplateTacheAttrDao;
import com.takata.four.tache.domain.FourTemplateTacheAttr;
import com.takata.four.tache.service.FourTemplateTacheAttrService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author lzf
 **/
@Service("fourTemplateTacheAttrService")
public class FourTemplateTacheAttrServiceImpl implements FourTemplateTacheAttrService {

    @Resource(name = "fourTemplateTacheAttrDao")
    private FourTemplateTacheAttrDao fourTemplateTacheAttrDao;

    @Override
    public List<FourTemplateTacheAttr> listFourTemplateTacheAttr(Integer templateId) throws Exception {
        return this.fourTemplateTacheAttrDao.selectFourTemplateTacheAttrList(templateId);
    }
}
