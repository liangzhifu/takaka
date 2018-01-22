package com.takata.kirikae.order.service.impl;

import com.takata.kirikae.order.dao.KirikaeOrderDao;
import com.takata.kirikae.order.domain.KirikaeOrder;
import com.takata.kirikae.order.domain.KirikaeOrderChangeContent;
import com.takata.kirikae.order.domain.KirikaeOrderPartsNumber;
import com.takata.kirikae.order.query.KirikaeOrderChangeContentQuery;
import com.takata.kirikae.order.query.KirikaeOrderPartsNumberQuery;
import com.takata.kirikae.order.query.KirikaeOrderQuery;
import com.takata.kirikae.order.service.KirikaeOrderChangeContentService;
import com.takata.kirikae.order.service.KirikaeOrderPartsNumberService;
import com.takata.kirikae.order.service.KirikaeOrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

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
    public void addKirikaeOrder(KirikaeOrder kirikaeOrder) throws Exception {
        Integer num = this.kirikaeOrderDao.insertSelective(kirikaeOrder);
        if(num == 0){
            throw new Exception("新增切替变更单异常！");
        }

        List<KirikaeOrderChangeContent> kirikaeOrderChangeContentList = kirikaeOrder.getKirikaeOrderChangeContentList();
        for(KirikaeOrderChangeContent kirikaeOrderChangeContent : kirikaeOrderChangeContentList){
            kirikaeOrderChangeContent.setKirikaeOrderId(kirikaeOrder.getId());
        }
        this.kirikaeOrderChangeContentService.addKirikaeOrderChangeContentList(kirikaeOrderChangeContentList);

        List<KirikaeOrderPartsNumber> kirikaeOrderPartsNumberList = kirikaeOrder.getKirikaeOrderPartsNumberList();
        for(KirikaeOrderPartsNumber kirikaeOrderPartsNumber : kirikaeOrderPartsNumberList){
            kirikaeOrderPartsNumber.setKirikaeOrderId(kirikaeOrder.getId());
        }
        this.kirikaeOrderPartsNumberService.addKirikaeOrderPartsNumberList(kirikaeOrderPartsNumberList);
    }

    @Override
    public void editKirikaeOrder(KirikaeOrder kirikaeOrder) throws Exception {
        this.kirikaeOrderDao.updateByPrimaryKeySelective(kirikaeOrder);

        this.kirikaeOrderChangeContentService.deleteKirikaeOrderChangeContentByKirikaeOrderId(kirikaeOrder.getId());
        List<KirikaeOrderChangeContent> kirikaeOrderChangeContentList = kirikaeOrder.getKirikaeOrderChangeContentList();
        for(KirikaeOrderChangeContent kirikaeOrderChangeContent : kirikaeOrderChangeContentList){
            kirikaeOrderChangeContent.setKirikaeOrderId(kirikaeOrder.getId());
        }
        this.kirikaeOrderChangeContentService.addKirikaeOrderChangeContentList(kirikaeOrderChangeContentList);

        this.kirikaeOrderPartsNumberService.deleteKirikaeOrderPartsNumberByKirikaeOrderId(kirikaeOrder.getId());
        List<KirikaeOrderPartsNumber> kirikaeOrderPartsNumberList = kirikaeOrder.getKirikaeOrderPartsNumberList();
        for(KirikaeOrderPartsNumber kirikaeOrderPartsNumber : kirikaeOrderPartsNumberList){
            kirikaeOrderPartsNumber.setKirikaeOrderId(kirikaeOrder.getId());
        }
        this.kirikaeOrderPartsNumberService.addKirikaeOrderPartsNumberList(kirikaeOrderPartsNumberList);
    }

    @Override
    public KirikaeOrder getKirikaeOrder(KirikaeOrder kirikaeOrder) throws Exception {
        return this.kirikaeOrderDao.selectByPrimaryKey(kirikaeOrder);
    }

    @Override
    public KirikaeOrder getKirikaeOrderByAlterationOrderId(Integer alterationOrderId) throws Exception {
        KirikaeOrder kirikaeOrder = this.kirikaeOrderDao.selectByAlterationOrderId(alterationOrderId);
        KirikaeOrderChangeContentQuery kirikaeOrderChangeContentQuery = new KirikaeOrderChangeContentQuery();
        kirikaeOrderChangeContentQuery.setKirikaeOrderId(kirikaeOrder.getId());
        List<KirikaeOrderChangeContent> kirikaeOrderChangeContentList = this.kirikaeOrderChangeContentService.listKirikaeOrderChangeContent(kirikaeOrderChangeContentQuery);
        kirikaeOrder.setKirikaeOrderChangeContentList(kirikaeOrderChangeContentList);
        KirikaeOrderPartsNumberQuery kirikaeOrderPartsNumberQuery = new KirikaeOrderPartsNumberQuery();
        kirikaeOrderPartsNumberQuery.setKirikaeOrderId(kirikaeOrder.getId());
        List<KirikaeOrderPartsNumber> kirikaeOrderPartsNumberList = this.kirikaeOrderPartsNumberService.listKirikaeOrderPartsNumber(kirikaeOrderPartsNumberQuery);
        kirikaeOrder.setKirikaeOrderPartsNumberList(kirikaeOrderPartsNumberList);
        return kirikaeOrder;
    }

    @Override
    public List<Map<String, Object>> listKirikaeOrderPage(KirikaeOrderQuery kirikaeOrderQuery) throws Exception {
        return this.kirikaeOrderDao.selectKirikaeOrderPageList(kirikaeOrderQuery);
    }

    @Override
    public Integer countKirikaeOrder(KirikaeOrderQuery kirikaeOrderQuery) throws Exception {
        return this.kirikaeOrderDao.selectKirikaeOrderCount(kirikaeOrderQuery);
    }
}
