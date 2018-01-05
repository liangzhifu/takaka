package com.takata.kirikae.question.controller;

import com.takata.kirikae.constant.Url;
import com.takata.kirikae.question.domain.KirikaeQuestion;
import com.takata.kirikae.question.query.KirikaeQuestionQuery;
import com.takata.kirikae.question.service.KirikaeQuestionService;
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
public class KirikaeQuestionController {

    @Resource(name = "kirikaeQuestionService")
    private KirikaeQuestionService kirikaeQuestionService;

    /**
     * 返回确认内容管理页面
     * @return 返回结果
     */
    @RequestMapping(value = Url.QUESTION_DIALOG)
    private String getDialog(){
        return "kirikae/question/kirikaeQuestionList";
    }

    /**
     * 查询确认内容列表-分页页面信息
     * @param kirikaeQuestionQuery 查询条件
     * @return 返回分页列表信息和总数
     */
    @RequestMapping(value = Url.QUESTION_PAGEINFO)
    @ResponseBody
    private Object queryPageList(KirikaeQuestionQuery kirikaeQuestionQuery){
        Map<String, Object> map = new HashMap<String, Object>(4);
        try{
            List<Map<String, Object>> dataMapList = this.kirikaeQuestionService.listKirikaeQuestionPage(kirikaeQuestionQuery);
            Integer totalCount = this.kirikaeQuestionService.countKirikaeQuestion(kirikaeQuestionQuery);
            Integer totalPage = totalCount / kirikaeQuestionQuery.getSize() + (totalCount % kirikaeQuestionQuery.getSize() > 0 ? 1 : 0);
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
     * 新增确认内容
     * @param kirikaeQuestion 确认内容实体信息
     * @return 返回结果
     */
    @RequestMapping(value = Url.QUESTION_ADD)
    @ResponseBody
    private Object addKirikaeQuestion(KirikaeQuestion kirikaeQuestion){
        Map<String, Object> map = new HashMap<String, Object>(2);
        try{
            this.kirikaeQuestionService.addKirikaeQuestion(kirikaeQuestion);
            map.put("success", true);
        }catch (Exception e){
            log.error(e.getMessage());
            map.put("success", false);
            map.put("message", e.getMessage());
        }
        return map;
    }

    /**
     * 删除确认内容
     * @param kirikaeQuestion 确认内容实体信息
     * @return 返回结果
     */
    @RequestMapping(value = Url.QUESTION_DELETE)
    @ResponseBody
    private Object deleteKirikaeQuestion(KirikaeQuestion kirikaeQuestion){
        Map<String, Object> map = new HashMap<String, Object>(2);
        try{
            this.kirikaeQuestionService.deleteKirikaeQuestion(kirikaeQuestion);
            map.put("success", true);
        }catch (Exception e){
            log.error(e.getMessage());
            map.put("success", false);
            map.put("message", e.getMessage());
        }
        return map;
    }

}
