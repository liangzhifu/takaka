package com.takata.four.tache.controller;

import com.takata.four.constant.Url;
import com.takata.four.tache.domain.FourTemplateTacheManager;
import com.takata.four.tache.query.FourTemplateTacheManagerQuery;
import com.takata.four.tache.service.FourTemplateTacheManagerService;
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
public class FourTemplateTacheManagerController {

    @Resource(name = "fourTemplateTacheManagerService")
    private FourTemplateTacheManagerService fourTemplateTacheManagerService;

    /**
     * 模板工单管理者列表
     * @param fourTemplateTacheManagerQuery 查询条件
     * @return 返回结果
     */
    @RequestMapping(value = Url.TACHE_MANAGERLIST)
    @ResponseBody
    private Object queryManagerList(FourTemplateTacheManagerQuery fourTemplateTacheManagerQuery){
        Map<String, Object> map = new HashMap<String, Object>(2);
        try{
            List<Map<String, Object>> dataMapList = this.fourTemplateTacheManagerService.listFourTemplateTacheManager(fourTemplateTacheManagerQuery);
            map.put("dataMapList", dataMapList);
            map.put("success", true);
        }catch (Exception e){
            log.error(e.getMessage());
            map.put("success", false);
            map.put("message", e.getMessage());
        }
        return map;
    }

    /**
     * 新增模板工单管理者
     * @param tacheId 模板工单ID
     * @param userIdStr 用户ID字符串
     * @return 返回结果
     */
    @RequestMapping(value = Url.TACHE_MANAGERADD)
    @ResponseBody
    private Object managerAdd(Integer tacheId, String userIdStr){
        Map<String, Object> map = new HashMap<String, Object>(2);
        try{
            String[] userIds = userIdStr.split(userIdStr);
            this.fourTemplateTacheManagerService.addFourTemplateTacheManager(tacheId, userIds);
            map.put("success", true);
        }catch (Exception e){
            log.error(e.getMessage());
            map.put("success", false);
            map.put("message", e.getMessage());
        }
        return map;
    }

    /**
     * 删除模板工单管理者
     * @param fourTemplateTacheManager 模板工单管理者实体
     * @return 返回结果
     */
    @RequestMapping(value = Url.TACHE_MANAGERDELETE)
    @ResponseBody
    private Object managerDelete(FourTemplateTacheManager fourTemplateTacheManager){
        Map<String, Object> map = new HashMap<String, Object>(2);
        try{
            this.fourTemplateTacheManagerService.deleteFourTemplateTacheManager(fourTemplateTacheManager);
            map.put("success", true);
        }catch (Exception e){
            log.error(e.getMessage());
            map.put("success", false);
            map.put("message", e.getMessage());
        }
        return map;
    }

}
