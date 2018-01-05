package com.takata.four.tache.controller;

import com.takata.four.constant.Url;
import com.takata.four.tache.domain.FourTemplateTacheUser;
import com.takata.four.tache.query.FourTemplateTacheUserQuery;
import com.takata.four.tache.service.FourTemplateTacheUserService;
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
public class FourTemplateTacheUserController {

    @Resource(name = "fourTemplateTacheUserService")
    private FourTemplateTacheUserService fourTemplateTacheUserService;

    /**
     * 模板工单处理者列表
     * @param fourTemplateTacheUserQuery 查询条件
     * @return 返回结果
     */
    @RequestMapping(value = Url.TACHE_USERLIST)
    @ResponseBody
    private Object queryUserList(FourTemplateTacheUserQuery fourTemplateTacheUserQuery){
        Map<String, Object> map = new HashMap<String, Object>(2);
        try{
            List<Map<String, Object>> dataMapList = this.fourTemplateTacheUserService.listFourTemplateTacheUser(fourTemplateTacheUserQuery);
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
     * 新增模板工单处理者
     * @param tacheId 模板工单ID
     * @param userIdStr 用户ID字符串
     * @return 返回结果
     */
    @RequestMapping(value = Url.TACHE_USERADD)
    @ResponseBody
    private Object userAdd(Integer tacheId, String userIdStr){
        Map<String, Object> map = new HashMap<String, Object>(2);
        try{
            String[] userIds = userIdStr.split(userIdStr);
            this.fourTemplateTacheUserService.addFourTemplateTacheUser(tacheId, userIds);
            map.put("success", true);
        }catch (Exception e){
            log.error(e.getMessage());
            map.put("success", false);
            map.put("message", e.getMessage());
        }
        return map;
    }

    /**
     * 删除模板工单处理者
     * @param fourTemplateTacheUser 模板工单处理者实体
     * @return 返回结果
     */
    @RequestMapping(value = Url.TACHE_USERDELETE)
    @ResponseBody
    private Object userDelete(FourTemplateTacheUser fourTemplateTacheUser){
        Map<String, Object> map = new HashMap<String, Object>(2);
        try{
            this.fourTemplateTacheUserService.deleteFourTemplateTacheUser(fourTemplateTacheUser);
            map.put("success", true);
        }catch (Exception e){
            log.error(e.getMessage());
            map.put("success", false);
            map.put("message", e.getMessage());
        }
        return map;
    }

}
