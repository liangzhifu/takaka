package com.takata.alteration.order.controller;

import com.takata.alteration.constant.Url;
import com.takata.alteration.order.domain.AlterationOrder;
import com.takata.alteration.order.service.AlterationOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lzf
 **/
@Slf4j
@Controller
public class AlterationOrderController {

    @Resource(name = "alterationOrderService")
    private AlterationOrderService alterationOrderService;

    /**
     * 获取变更单新增或修改页面
     * @return 返回结果
     */
    @RequestMapping(value = Url.ORDER_ADDOREDITDIALOG)
    private String getAddOrEditDialog(){
        return "alteration/alterationOrderAddOrEdit";
    }

    /**
     * 获取变更单详情页面
     * @return 返回结果
     */
    @RequestMapping(value = Url.ORDER_DETAILDIALOG)
    private String getDetailDialog(){
        return "alteration/alterationOrderDetail";
    }

    /**
     * 获取变更单
     * @param orderId 变更单ID
     * @return 返回结果
     */
    @RequestMapping(value = Url.ORDER_GET)
    @ResponseBody
    private Object gerOrder(Integer orderId){
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

    /**
     * 新增变更单
     * @param alterationOrder 变更单实体
     * @httpServletRequest 请求参数
     * @return 返回结果
     */
    @RequestMapping(value = Url.ORDER_ADD)
    @ResponseBody
    private Object addOrder(AlterationOrder alterationOrder, HttpServletRequest httpServletRequest){
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
     * 获取变更单待办页面
     * @return 返回结果
     */
    @RequestMapping(value = Url.ORDER_TODODIALOG)
    private String getTodoDialog(){
        return "alteration/todoList";
    }

    /**
     * 获取待办页面信息
     * @return 返回结果
     */
    @RequestMapping(value = Url.ORDER_TODOPAGEINFO)
    @ResponseBody
    private Object getTodoPageInfo(){
        Map<String, Object> map = new HashMap<String, Object>(4);
        try{
            map.put("dataMapList", null);
            map.put("totalCount", 0);
            map.put("totalPage", 0);
            map.put("success", true);
        }catch (Exception e){
            log.error(e.getMessage());
            map.put("success", false);
            map.put("message", e.getMessage());
        }
        return map;
    }
}
