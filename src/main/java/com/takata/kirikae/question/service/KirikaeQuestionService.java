package com.takata.kirikae.question.service;

import com.takata.kirikae.question.domain.KirikaeQuestion;
import com.takata.kirikae.question.query.KirikaeQuestionQuery;

import java.util.List;
import java.util.Map;

public interface KirikaeQuestionService {

    /**
     * 新增切替问题点
     * @param kirikaeQuestion 切替问题点实体
     * @throws Exception 异常
     */
    void addKirikaeQuestion(KirikaeQuestion kirikaeQuestion) throws Exception;

    /**
     * 删除切替问题点
     * @param kirikaeQuestion 切替问题点实体
     * @throws Exception 异常
     */
    void deleteKirikaeQuestion(KirikaeQuestion kirikaeQuestion) throws Exception;

    /**
     * 查询切替问题点列表-分页
     * @param kirikaeQuestionQuery 查询条件
     * @return 返回结果
     * @throws Exception 异常
     */
    List<Map<String, Object>> listKirikaeQuestionPage(KirikaeQuestionQuery kirikaeQuestionQuery) throws Exception;

    /**
     * 查询切替问题点数量
     * @param kirikaeQuestionQuery 查询条件
     * @return 返回结果
     * @throws Exception 异常
     */
    Integer countKirikaeQuestion(KirikaeQuestionQuery kirikaeQuestionQuery) throws Exception;

}
