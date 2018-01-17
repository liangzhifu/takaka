package com.takata.kirikae.order.service.impl;

import com.takata.kirikae.order.dao.KirikaeOrderDao;
import com.takata.kirikae.order.domain.KirikaeOrder;
import com.takata.kirikae.order.service.KirikaeOrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author lzf
 **/
@Service("alterationKirikaeOrderService")
public class KirikaeOrderServiceImpl implements KirikaeOrderService {

    @Resource(name = "alterationKirikaeOrderDao")
    private KirikaeOrderDao kirikaeOrderDao;

    @Override
    public void addAlterationKirikaeOrder(KirikaeOrder alterationKirikaeOrder) throws Exception {
        Integer num = this.kirikaeOrderDao.insertSelective(alterationKirikaeOrder);
        if(num == 0){
            throw new Exception("新增切替变更单异常！");
        }
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
