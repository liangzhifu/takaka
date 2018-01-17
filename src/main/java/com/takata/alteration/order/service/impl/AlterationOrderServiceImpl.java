package com.takata.alteration.order.service.impl;

import com.takata.alteration.order.constant.AlterationOrderEnum;
import com.takata.alteration.order.dao.AlterationOrderDao;
import com.takata.alteration.order.domain.AlterationFourOrder;
import com.takata.kirikae.order.domain.KirikaeOrder;
import com.takata.alteration.order.domain.AlterationOrder;
import com.takata.alteration.order.service.AlterationFourOrderService;
import com.takata.kirikae.order.service.KirikaeOrderService;
import com.takata.alteration.order.service.AlterationOrderService;
import com.takata.common.constant.CommonEnum;
import com.takata.common.shiro.Principal;
import com.takata.common.shiro.PrincipalUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author lzf
 **/
@Service("alterationOrderService")
public class AlterationOrderServiceImpl implements AlterationOrderService {

    @Resource(name = "alterationOrderDao")
    private AlterationOrderDao alterationOrderDao;

    @Resource(name = "alterationFourOrderService")
    private AlterationFourOrderService alterationFourOrderService;

    @Resource(name = "kirikaeOrderService")
    private KirikaeOrderService kirikaeOrderService;

    @Override
    public AlterationOrder getAlterationOrder(AlterationOrder alterationOrder) throws Exception {
        alterationOrder = this.alterationOrderDao.selectAlterationOrder(alterationOrder);
        AlterationFourOrder alterationFourOrder = this.alterationFourOrderService.getAlterationFourOrderByAlterationOrderId(alterationOrder.getId());
        alterationOrder.setAlterationFourOrder(alterationFourOrder);
        KirikaeOrder alterationKirikaeOrder = this.kirikaeOrderService.getAlterationKirikaeOrderByAlterationOrderId(alterationOrder.getId());
        alterationOrder.setAlterationKirikaeOrder(alterationKirikaeOrder);
        return alterationOrder;
    }

    @Override
    public void addAlterationOrder(AlterationOrder alterationOrder) throws Exception {
        Principal principal = PrincipalUtils.getPrincipal();
        alterationOrder.setDeleteState(CommonEnum.DeleteStateEnum.DELETE_STATE_NO.getCode());
        alterationOrder.setCreateBy(principal.getId());
        alterationOrder.setCreateTime(new Date());
        alterationOrder.setUpdateBy(principal.getId());
        alterationOrder.setUpdateTime(new Date());
        alterationOrder.setOrderState(AlterationOrderEnum.OrderStateEnum.ORDER_STATE_INITIALIZATION.getCode());
        Integer num = this.alterationOrderDao.insertAlterationOrder(alterationOrder);
        if(num != 1){
            throw new Exception("新增变更单异常！");
        }

        //新增4M变更单
        AlterationFourOrder alterationFourOrder = alterationOrder.getAlterationFourOrder();
        alterationFourOrder.setOrderId(alterationOrder.getId());
        this.alterationFourOrderService.addAlterationFourOrder(alterationFourOrder);

        //新增切替变更单
        KirikaeOrder alterationKirikaeOrder = alterationOrder.getAlterationKirikaeOrder();
        alterationKirikaeOrder.setOrderId(alterationOrder.getId());
        this.kirikaeOrderService.addAlterationKirikaeOrder(alterationKirikaeOrder);
    }

    @Override
    public void editAlterationOrder(AlterationOrder alterationOrder) throws Exception {
        //修改4M变更单
        AlterationFourOrder alterationFourOrder = alterationOrder.getAlterationFourOrder();
        alterationFourOrder.setOrderId(alterationOrder.getId());
        this.alterationFourOrderService.editAlterationFourOrder(alterationFourOrder);

        //修改切替变更单
        KirikaeOrder alterationKirikaeOrder = alterationOrder.getAlterationKirikaeOrder();
        alterationKirikaeOrder.setOrderId(alterationOrder.getId());
        this.kirikaeOrderService.editAlterationKirikaeOrder(alterationKirikaeOrder);
    }
}
