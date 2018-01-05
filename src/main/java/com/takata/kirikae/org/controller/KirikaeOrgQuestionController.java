package com.takata.kirikae.org.controller;

import com.takata.kirikae.constant.Url;
import com.takata.kirikae.org.domain.KirikaeOrgQuestion;
import com.takata.kirikae.org.query.KirikaeOrgQuestionQuery;
import com.takata.kirikae.org.service.KirikaeOrgQuestionService;
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
public class KirikaeOrgQuestionController {

    @Resource(name = "kirikaeOrgQuestionService")
    private KirikaeOrgQuestionService kirikaeOrgQuestionService;

    /**
     * 返回组织确认内容管理页面
     * @return 返回结果
     */
    @RequestMapping(value = Url.ORGQUESTION_DIALOG)
    private String getDialog(){
        return "kirikae/org/kirikaeOrgQuestionList";
    }

    /**
     * 查询组织确认内容关联列表
     * @param kirikaeOrgQuestionQuery 查询条件
     * @return 返回结果
     */
    @RequestMapping(value = Url.ORGQUESTION_LIST)
    @ResponseBody
    private Object queryList(KirikaeOrgQuestionQuery kirikaeOrgQuestionQuery){
        Map<String, Object> map = new HashMap<String, Object>(2);
        try{
            List<Map<String, Object>> dataMapList = this.kirikaeOrgQuestionService.listKirikaeOrgQuestion(kirikaeOrgQuestionQuery);
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
     * 删除组织确认内容关联
     * @param kirikaeOrgQuestion 组织确认内容关联实体信息
     * @return 返回结果
     */
    @RequestMapping(value = Url.ORGQUESTION_DELETE)
    @ResponseBody
    private Object deleteKirikaeOrgQuestion(KirikaeOrgQuestion kirikaeOrgQuestion){
        Map<String, Object> map = new HashMap<String, Object>(2);
        try{
            this.kirikaeOrgQuestionService.deleteKirikaeOrgQuestion(kirikaeOrgQuestion);
            map.put("success", true);
        }catch (Exception e){
            log.error(e.getMessage());
            map.put("success", false);
            map.put("message", e.getMessage());
        }
        return map;
    }

    /**
     * 查询可以添加的确认内容列表
     * @param kirikaeOrgQuestionQuery 查询条件
     * @return 返回结果
     */
    @RequestMapping(value = Url.ORGQUESTION_ADDLIST)
    @ResponseBody
    private Object queryAddList(KirikaeOrgQuestionQuery kirikaeOrgQuestionQuery){
        Map<String, Object> map = new HashMap<String, Object>(2);
        try{
            List<Map<String, Object>> dataMapList = this.kirikaeOrgQuestionService.listKirikaeOrgQuestion(kirikaeOrgQuestionQuery);
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
     * 增加组织确认内容关联
     * @param orgId 组织ID
     * @param questionIdStr 确认内容ID字符串
     * @return 返回结果
     */
    @RequestMapping(value = Url.ORGQUESTION_ADD)
    @ResponseBody
    private Object addKirikaeOrgQuestion(Integer orgId, String questionIdStr){
        Map<String, Object> map = new HashMap<String, Object>(2);
        try{
            String[] questionIds = null;
            if(!(questionIdStr == null || "".equals(questionIdStr))){
                questionIds = questionIdStr.split(",");
            }
            this.kirikaeOrgQuestionService.addKirikaeOrgQuestion(orgId, questionIds);
            map.put("success", true);
        }catch (Exception e){
            log.error(e.getMessage());
            map.put("success", false);
            map.put("message", e.getMessage());
        }
        return map;
    }
}
