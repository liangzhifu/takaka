package com.takata.kirikae.org.service.impl;

import com.takata.common.constant.CommonEnum;
import com.takata.common.shiro.Principal;
import com.takata.common.shiro.PrincipalUtils;
import com.takata.kirikae.org.dao.KirikaeOrgQuestionDao;
import com.takata.kirikae.org.domain.KirikaeOrgQuestion;
import com.takata.kirikae.org.query.KirikaeOrgQuestionQuery;
import com.takata.kirikae.org.service.KirikaeOrgQuestionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author lzf
 **/
@Service("kirikaeOrgQuestionService")
public class KirikaeOrgQuestionServiceImpl implements KirikaeOrgQuestionService {

    @Resource(name = "kirikaeOrgQuestionDao")
    private KirikaeOrgQuestionDao kirikaeOrgQuestionDao;
    
    @Override
    public void addKirikaeOrgQuestion(Integer orgId, String[] questionIds) throws Exception {
        Principal principal = PrincipalUtils.getPrincipal();
        KirikaeOrgQuestion kirikaeOrgQuestion = new KirikaeOrgQuestion();
        kirikaeOrgQuestion.setCreateBy(principal.getId());
        kirikaeOrgQuestion.setCreateTime(new Date());
        kirikaeOrgQuestion.setUpdateBy(principal.getId());
        kirikaeOrgQuestion.setUpdateTime(new Date());
        kirikaeOrgQuestion.setDeleteState(CommonEnum.DeleteStateEnum.DELETE_STATE_NO.getCode());
        kirikaeOrgQuestion.setOrgId(orgId);
        for(String questionId : questionIds) {
            kirikaeOrgQuestion.setQuestionId(Integer.valueOf(questionId));
            kirikaeOrgQuestion.setId(null);
            Integer count = this.kirikaeOrgQuestionDao.insertKirikaeOrgQuestion(kirikaeOrgQuestion);
            if (count != 1) {
                throw new Exception("添加组织切替问题点关联异常！");
            }
        }
    }

    @Override
    public void deleteKirikaeOrgQuestion(KirikaeOrgQuestion kirikaeOrgQuestion) throws Exception {
        Principal principal = PrincipalUtils.getPrincipal();
        kirikaeOrgQuestion.setUpdateBy(principal.getId());
        kirikaeOrgQuestion.setUpdateTime(new Date());
        kirikaeOrgQuestion.setDeleteState(CommonEnum.DeleteStateEnum.DELETE_STATE_YES.getCode());
        Integer count = this.kirikaeOrgQuestionDao.updateKirikaeOrgQuestion(kirikaeOrgQuestion);
        if (count != 1){
            throw new Exception("添加组织切替问题点关联异常！");
        }
    }

    @Override
    public void deleteKirikaeOrgQuestionByOrg(KirikaeOrgQuestionQuery kirikaeOrgQuestionQuery) throws Exception {
        List<Map<String, Object>> mapList = this.kirikaeOrgQuestionDao.selectKirikaeOrgQuestionList(kirikaeOrgQuestionQuery);
        for (Map<String, Object> map : mapList){
            KirikaeOrgQuestion kirikaeOrgQuestion = new KirikaeOrgQuestion();
            Integer id = (Integer) map.get("id");
            kirikaeOrgQuestion.setId(id);
            this.deleteKirikaeOrgQuestion(kirikaeOrgQuestion);
        }
    }

    @Override
    public void deleteKirikaeOrgQuestionByQuestion(KirikaeOrgQuestionQuery kirikaeOrgQuestionQuery) throws Exception {
        List<Map<String, Object>> mapList = this.kirikaeOrgQuestionDao.selectKirikaeOrgQuestionList(kirikaeOrgQuestionQuery);
        for (Map<String, Object> map : mapList){
            KirikaeOrgQuestion kirikaeOrgQuestion = new KirikaeOrgQuestion();
            Integer id = (Integer) map.get("id");
            kirikaeOrgQuestion.setId(id);
            this.deleteKirikaeOrgQuestion(kirikaeOrgQuestion);
        }
    }

    @Override
    public List<Map<String, Object>> listKirikaeOrgQuestion(KirikaeOrgQuestionQuery kirikaeOrgQuestionQuery) throws Exception {
        return this.kirikaeOrgQuestionDao.selectKirikaeOrgQuestionList(kirikaeOrgQuestionQuery);
    }

    @Override
    public List<Map<String, Object>> listAddQuestion(KirikaeOrgQuestionQuery kirikaeOrgQuestionQuery) throws Exception {
        return this.kirikaeOrgQuestionDao.selectAddQuestionList(kirikaeOrgQuestionQuery);
    }
}
