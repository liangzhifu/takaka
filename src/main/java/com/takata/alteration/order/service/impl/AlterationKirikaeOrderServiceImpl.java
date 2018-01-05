package com.takata.alteration.order.service.impl;

import com.takata.alteration.order.dao.AlterationKirikaeOrderDao;
import com.takata.alteration.order.domain.AlterationKirikaeOrder;
import com.takata.alteration.order.service.AlterationKirikaeOrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author lzf
 **/
@Service("alterationKirikaeOrderService")
public class AlterationKirikaeOrderServiceImpl implements AlterationKirikaeOrderService {

    @Resource(name = "alterationKirikaeOrderDao")
    private AlterationKirikaeOrderDao alterationKirikaeOrderDao;

    @Override
    public void addAlterationKirikaeOrder(AlterationKirikaeOrder alterationKirikaeOrder) throws Exception {
        Integer num = this.alterationKirikaeOrderDao.insertSelective(alterationKirikaeOrder);
        if(num == 0){
            throw new Exception("新增切替变更单异常！");
        }
    }

    @Override
    public void editAlterationKirikaeOrder(AlterationKirikaeOrder alterationKirikaeOrder) throws Exception {

    }

    @Override
    public AlterationKirikaeOrder getAlterationKirikaeOrder(AlterationKirikaeOrder alterationKirikaeOrder) throws Exception {
        return null;
    }

    @Override
    public AlterationKirikaeOrder getAlterationKirikaeOrderByAlterationOrderId(Integer orderId) throws Exception {
        return null;
    }
}
