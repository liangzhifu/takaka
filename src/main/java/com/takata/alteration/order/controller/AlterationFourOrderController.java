package com.takata.alteration.order.controller;

import com.takata.alteration.constant.Url;
import com.takata.alteration.order.query.AlterationFourOrderQuery;
import com.takata.alteration.order.service.AlterationOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lzf
 **/
@Slf4j
@Controller
public class AlterationFourOrderController {

    @Resource(name = "alterationOrderService")
    private AlterationOrderService alterationOrderService;

    /**
     * 获取4M变更单列表页面
     * @return 返回结果
     */
    @RequestMapping(value = Url.FOURORDER_DIALOG)
    private String getDialog(){
        return "alteration/alterationFourOrderList";
    }

    /**
     * 获取4M变更单列表页面信息
     * @param alterationFourOrderQuery 查询条件
     * @return 返回结果
     */
    @RequestMapping(value = Url.FOURORDER_PAGEINFO)
    @ResponseBody
    private Object getPageInfo(AlterationFourOrderQuery alterationFourOrderQuery){
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
