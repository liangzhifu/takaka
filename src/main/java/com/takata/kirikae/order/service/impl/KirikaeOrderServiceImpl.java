package com.takata.kirikae.order.service.impl;

import com.takata.kirikae.order.dao.KirikaeOrderDao;
import com.takata.kirikae.order.domain.KirikaeOrder;
import com.takata.kirikae.order.domain.KirikaeOrderChangeContent;
import com.takata.kirikae.order.domain.KirikaeOrderPartsNumber;
import com.takata.kirikae.order.service.KirikaeOrderChangeContentService;
import com.takata.kirikae.order.service.KirikaeOrderPartsNumberService;
import com.takata.kirikae.order.service.KirikaeOrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author lzf
 **/
@Service("kirikaeOrderService")
public class KirikaeOrderServiceImpl implements KirikaeOrderService {

    @Resource(name = "kirikaeOrderDao")
    private KirikaeOrderDao kirikaeOrderDao;

    @Resource(name = "kirikaeOrderChangeContentService")
    private KirikaeOrderChangeContentService kirikaeOrderChangeContentService;

    @Resource(name = "kirikaeOrderPartsNumberService")
    private KirikaeOrderPartsNumberService kirikaeOrderPartsNumberService;

    @Override
    public void addAlterationKirikaeOrder(KirikaeOrder kirikaeOrder) throws Exception {
        Integer num = this.kirikaeOrderDao.insertSelective(kirikaeOrder);
        if(num == 0){
            throw new Exception("新增切替变更单异常！");
        }

        List<KirikaeOrderChangeContent> kirikaeOrderChangeContentList = kirikaeOrder.getKirikaeOrderChangeContentList();
        for(KirikaeOrderChangeContent kirikaeOrderChangeContent : kirikaeOrderChangeContentList){
            kirikaeOrderChangeContent.setKirikaeOrderId(kirikaeOrder.getOrderId());
        }
        this.kirikaeOrderChangeContentService.addKirikaeOrderChangeContentList(kirikaeOrderChangeContentList);

        List<KirikaeOrderPartsNumber> kirikaeOrderPartsNumberList = kirikaeOrder.getKirikaeOrderPartsNumberList();
        for(KirikaeOrderPartsNumber kirikaeOrderPartsNumber : kirikaeOrderPartsNumberList){
            kirikaeOrderPartsNumber.setKirikaeOrderId(kirikaeOrder.getId());
        }
        this.kirikaeOrderPartsNumberService.addAlterationKirikaeOrderPartsNumberList(kirikaeOrderPartsNumberList);
    }

    @Override
    public void editAlterationKirikaeOrder(KirikaeOrder alterationKirikaeOrder) throws Exception {

    }

    @Override
    public KirikaeOrder getAlterationKirikaeOrder(KirikaeOrder alterationKirikaeOrder) throws Exception {
        return null;
    }

    @Override
    public KirikaeOrder getAlterationKirikaeOrderByAlterationOrderId(Integer orderId) throws Exception {
        return null;
    }
}
