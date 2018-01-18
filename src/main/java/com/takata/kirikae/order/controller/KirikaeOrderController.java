package com.takata.kirikae.order.controller;

import com.takata.alteration.order.domain.AlterationOrder;
import com.takata.alteration.order.service.AlterationOrderService;
import com.takata.kirikae.constant.Url;
import com.takata.kirikae.order.query.KirikaeOrderQuery;
import com.takata.kirikae.order.service.KirikaeOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lzf
 **/
@Slf4j
@Controller
public class KirikaeOrderController {

    @Resource(name = "kirikaeOrderService")
    private KirikaeOrderService kirikaeOrderService;

    @Resource(name = "alterationOrderService")
    private AlterationOrderService alterationOrderService;

    /**
     * 获取切替单列表页面
     * @return 返回结果
     */
    @RequestMapping(value = Url.ORDER_PAGEINOF_DIALOG)
    private String getPageInfoDialog(){
        return "kirikae/order/kirikaeOrderList";
    }


    /**
     * 获取切替单列表页面信息
     * @param kirikaeOrderQuery 查询条件
     * @return 返回结果
     */
    @RequestMapping(value = Url.ORDER_PAGEINOF)
    @ResponseBody
    private Object getPageInfo(KirikaeOrderQuery kirikaeOrderQuery){
        Map<String, Object> map = new HashMap<String, Object>(4);
        try{
            List<Map<String, Object>> dataMapList = this.kirikaeOrderService.listKirikaeOrderPage(kirikaeOrderQuery);
            Integer totalCount = this.kirikaeOrderService.countKirikaeOrder(kirikaeOrderQuery);
            Integer totalPage = totalCount / kirikaeOrderQuery.getSize() + (totalCount % kirikaeOrderQuery.getSize() > 0 ? 1 : 0);
            map.put("dataMapList", dataMapList);
            map.put("totalCount", totalCount);
            map.put("totalPage", totalPage);
            map.put("success", true);
        }catch (Exception e){
            log.error(e.getMessage());
            map.put("success", false);
            map.put("message", e.getMessage());
        }
        return map;
    }

    /**
     * 获取切替单新增修改页面
     * @return 返回结果
     */
    @RequestMapping(value = Url.ORDER_ADD_DIALOG)
    private String getAddDialog(){
        return "kirikae/order/kirikaeOrderAddOrEdit";
    }

    /**
     * 新增变更单
     * @param alterationOrder 变更单实体
     * @httpServletRequest 请求参数
     * @return 返回结果
     */
    @RequestMapping(value = Url.ORDER_ADD)
    @ResponseBody
    private Object addOrder(AlterationOrder alterationOrder){
        Map<String, Object> map = new HashMap<String, Object>(2);
        try{
            this.alterationOrderService.addAlterationOrder(alterationOrder);
            map.put("success", true);
        }catch (Exception e){
            log.error(e.getMessage());
            map.put("success", false);
            map.put("message", e.getMessage());
        }
        return map;
    }

    /**
     * 修改变更单
     * @param alterationOrder 变更单实体
     * @return 返回结果
     */
    @RequestMapping(value = Url.ORDER_EDIT)
    @ResponseBody
    private Object editOrder(AlterationOrder alterationOrder){
        Map<String, Object> map = new HashMap<String, Object>(2);
        try{

            map.put("success", true);
        }catch (Exception e){
            log.error(e.getMessage());
            map.put("success", false);
            map.put("message", e.getMessage());
        }
        return map;
    }

    /**
     * 获取变更单
     * @param orderId 变更单ID
     * @return 返回结果
     */
    @RequestMapping(value = Url.ORDER_DETAIL)
    @ResponseBody
    private Object gerOrderDetail(Integer orderId){
        Map<String, Object> map = new HashMap<String, Object>(2);
        try{
            AlterationOrder alterationOrder = new AlterationOrder();
            alterationOrder.setId(orderId);
            alterationOrder = this.alterationOrderService.getAlterationOrder(alterationOrder);
            map.put("alterationOrder", alterationOrder);
            map.put("success", true);
        }catch (Exception e){
            log.error(e.getMessage());
            map.put("success", false);
            map.put("message", e.getMessage());
        }
        return map;
    }
}
