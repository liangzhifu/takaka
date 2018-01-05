package com.takata.alteration.order.service.impl;

import com.takata.alteration.order.dao.AlterationFourOrderAttrDao;
import com.takata.alteration.order.domain.AlterationFourOrderAttr;
import com.takata.alteration.order.service.AlterationFourOrderAttrService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author lzf
 **/

public class AlterationFourOrderAttrServiceImpl implements AlterationFourOrderAttrService {

    @Resource(name = "alterationFourOrderAttrDao")
    private AlterationFourOrderAttrDao alterationFourOrderAttrDao;

    @Override
    public void addAlterationFourOrderAttr(AlterationFourOrderAttr alterationFourOrderAttr) throws Exception {
        Integer num = this.alterationFourOrderAttrDao.insertAlterationFourOrderAttr(alterationFourOrderAttr);
        if(num != 1){
            throw new Exception("新增4M变更单属性异常！");
        }
    }

    @Override
    public void addAlterationFourOrderAttrList(List<AlterationFourOrderAttr> alterationFourOrderAttrList) throws Exception {
        for (AlterationFourOrderAttr alterationFourOrderAttr : alterationFourOrderAttrList){
            this.addAlterationFourOrderAttr(alterationFourOrderAttr);
        }
    }
}
