package com.takata.kirikae.question.service.impl;

import com.takata.common.constant.CommonEnum;
import com.takata.common.shiro.Principal;
import com.takata.common.shiro.PrincipalUtils;
import com.takata.kirikae.org.query.KirikaeOrgQuestionQuery;
import com.takata.kirikae.org.service.KirikaeOrgQuestionService;
import com.takata.kirikae.question.dao.KirikaeQuestionDao;
import com.takata.kirikae.question.domain.KirikaeQuestion;
import com.takata.kirikae.question.query.KirikaeQuestionQuery;
import com.takata.kirikae.question.service.KirikaeQuestionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author lzf
 **/
@Service("kirikaeQuestionService")
public class KirikaeQuestionServiceImpl implements KirikaeQuestionService {

    @Resource(name = "kirikaeQuestionDao")
    private KirikaeQuestionDao kirikaeQuestionDao;

    @Resource(name = "kirikaeOrgQuestionService")
    private KirikaeOrgQuestionService kirikaeOrgQuestionService;

    @Override
    public void addKirikaeQuestion(KirikaeQuestion kirikaeQuestion) throws Exception {
        KirikaeQuestion oldKirikaeQuestion = this.kirikaeQuestionDao.selectKirikaeQuestionByConfirm(kirikaeQuestion);
        if (oldKirikaeQuestion != null){
            throw new Exception("已存在相同切替问题点，不能添加！");
        }
        Principal principal = PrincipalUtils.getPrincipal();
        kirikaeQuestion.setCreateBy(principal.getId());
        kirikaeQuestion.setCreateTime(new Date());
        kirikaeQuestion.setUpdateBy(principal.getId());
        kirikaeQuestion.setUpdateTime(new Date());
        kirikaeQuestion.setDeleteState(CommonEnum.DeleteStateEnum.DELETE_STATE_NO.getCode());
        Integer count = this.kirikaeQuestionDao.insertKirikaeQuestion(kirikaeQuestion);
        if (count != 1){
            throw new Exception("添加切替问题点异常！");
        }
    }

    @Override
    public void deleteKirikaeQuestion(KirikaeQuestion kirikaeQuestion) throws Exception {
        Principal principal = PrincipalUtils.getPrincipal();
        kirikaeQuestion.setUpdateBy(principal.getId());
        kirikaeQuestion.setUpdateTime(new Date());
        kirikaeQuestion.setDeleteState(CommonEnum.DeleteStateEnum.DELETE_STATE_YES.getCode());

        //删除组织关联的切替问题点
        KirikaeOrgQuestionQuery kirikaeOrgQuestionQuery = new KirikaeOrgQuestionQuery();
        kirikaeOrgQuestionQuery.setQuestionId(kirikaeQuestion.getId());
        this.kirikaeOrgQuestionService.deleteKirikaeOrgQuestionByQuestion(kirikaeOrgQuestionQuery);

        Integer count = this.kirikaeQuestionDao.updateKirikaeQuestion(kirikaeQuestion);
        if (count != 1){
            throw new Exception("删除切替问题点异常！");
        }
    }

    @Override
    public List<Map<String, Object>> listKirikaeQuestionPage(KirikaeQuestionQuery kirikaeQuestionQuery) throws Exception {
        return this.kirikaeQuestionDao.selectKirikaeQuestionPageList(kirikaeQuestionQuery);
    }

    @Override
    public Integer countKirikaeQuestion(KirikaeQuestionQuery kirikaeQuestionQuery) throws Exception {
        return this.kirikaeQuestionDao.selectKirikaeQuestionCount(kirikaeQuestionQuery);
    }
}
