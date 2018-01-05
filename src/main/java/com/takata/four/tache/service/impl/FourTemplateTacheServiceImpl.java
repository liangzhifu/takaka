package com.takata.four.tache.service.impl;

import com.takata.four.tache.dao.FourTemplateTacheDao;
import com.takata.four.tache.domain.FourTemplateTache;
import com.takata.four.tache.service.FourTemplateTacheService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author lzf
 **/
@Service("fourTemplateTacheService")
public class FourTemplateTacheServiceImpl implements FourTemplateTacheService {

    @Resource(name = "fourTemplateTacheDao")
    private FourTemplateTacheDao fourTemplateTacheDao;

    @Override
    public List<FourTemplateTache> listFourTemplateTache(Integer templateId) throws Exception {
        return this.fourTemplateTacheDao.selectFourTemplateTacheList(templateId);
    }
}
