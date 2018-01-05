package com.takata.alteration.order.service.impl;

import com.takata.alteration.order.dao.AlterationFourOrderAttrDao;
import com.takata.alteration.order.dao.AlterationFourOrderDao;
import com.takata.alteration.order.domain.AlterationFourOrder;
import com.takata.alteration.order.domain.AlterationFourOrderAttr;
import com.takata.alteration.order.service.AlterationFourOrderService;
import com.takata.four.template.domain.FourTemplate;
import com.takata.four.template.service.FourTemplateService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author lzf
 **/
@Service("alterationFourOrderService")
    public class AlterationFourOrderServiceImpl implements AlterationFourOrderService {

    @Resource(name = "alterationFourOrderAttrDao")
    private AlterationFourOrderAttrDao alterationFourOrderAttrDao;

    @Resource(name = "alterationFourOrderDao")
    private AlterationFourOrderDao alterationFourOrderDao;

    @Resource(name = "fourTemplateService")
    private FourTemplateService fourTemplateService;

    @Override
    public AlterationFourOrder getAlterationFourOrder(AlterationFourOrder alterationFourOrder) throws Exception {
        alterationFourOrder = this.alterationFourOrderDao.selectAlterationFourOrder(alterationFourOrder);
        List<AlterationFourOrderAttr> alterationFourOrderAttrList = this.alterationFourOrderAttrDao.selectAlterationFourOrderAttrList(alterationFourOrder.getId());
        alterationFourOrder.setAlterationFourOrderAttrList(alterationFourOrderAttrList);
        return alterationFourOrder;
    }

    @Override
    public AlterationFourOrder getAlterationFourOrder(Integer orderId) throws Exception {
        AlterationFourOrder alterationFourOrder = this.alterationFourOrderDao.selectAlterationFourOrder(orderId);
        List<AlterationFourOrderAttr> alterationFourOrderAttrList = this.alterationFourOrderAttrDao.selectAlterationFourOrderAttrList(alterationFourOrder.getId());
        alterationFourOrder.setAlterationFourOrderAttrList(alterationFourOrderAttrList);
        return alterationFourOrder;
    }

    @Override
    public void AddAlterationFourOrder(AlterationFourOrder alterationFourOrder) throws Exception {
        FourTemplate fourTemplate = this.fourTemplateService.getFourTemplate();
        alterationFourOrder.setTemplateId(fourTemplate.getId());
        alterationFourOrder.setTemplateVersion(fourTemplate.getTemplateVersion());
        Integer num = this.alterationFourOrderDao.insertAlterationFourOrder(alterationFourOrder);
        if(num != 1){
            throw new Exception("新增4M变更单异常！");
        }
    }
}
