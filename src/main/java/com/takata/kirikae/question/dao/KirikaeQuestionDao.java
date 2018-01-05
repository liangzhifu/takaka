package com.takata.kirikae.question.dao;

import com.takata.common.dao.BaseDao;
import com.takata.kirikae.question.domain.KirikaeQuestion;
import com.takata.kirikae.question.query.KirikaeQuestionQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author lzf
 **/
@Repository
public class KirikaeQuestionDao extends BaseDao {

    /**
     * 查询切替问题点-通过名称
     * @param kirikaeQuestion 切替问题点实体
     * @return 返回结果
     */
    public KirikaeQuestion selectKirikaeQuestionByConfirm(KirikaeQuestion kirikaeQuestion){
        return this.readSqlSession.selectOne("KirikaeQuestionMapper.selectKirikaeQuestionByConfirm", kirikaeQuestion);
    }

    /**
     * 新增切替问题点
     * @param kirikaeQuestion 切替问题点实体
     * @return 返回结果
     */
    public Integer insertKirikaeQuestion(KirikaeQuestion kirikaeQuestion){
        return this.writerSqlSession.insert("KirikaeQuestionMapper.insertSelective", kirikaeQuestion);
    }

    /**
     * 更新切替问题点
     * @param kirikaeQuestion
     * @return 返回结果
     */
    public Integer updateKirikaeQuestion(KirikaeQuestion kirikaeQuestion){
        return this.writerSqlSession.update("KirikaeQuestionMapper.updateByPrimaryKeySelective", kirikaeQuestion);
    }

    /**
     * 查询切替问题点列表-分页
     * @param kirikaeQuestionQuery 查询条件
     * @return 返回结果
     */
    public List<Map<String, Object>> selectKirikaeQuestionPageList(KirikaeQuestionQuery kirikaeQuestionQuery){
        return this.readSqlSession.selectList("KirikaeQuestionMapper.selectKirikaeQuestionPageList", kirikaeQuestionQuery);
    }

    /**
     * 查询切替问题点数量
     * @param kirikaeQuestionQuery 查询条件
     * @return 返回结果
     */
    public Integer selectKirikaeQuestionCount(KirikaeQuestionQuery kirikaeQuestionQuery){
        return this.readSqlSession.selectOne("KirikaeQuestionMapper.selectKirikaeQuestionCount", kirikaeQuestionQuery);
    }

}
