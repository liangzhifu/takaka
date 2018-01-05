package com.takata.kirikae.org.dao;

import com.takata.common.dao.BaseDao;
import com.takata.kirikae.org.domain.KirikaeOrgQuestion;
import com.takata.kirikae.org.query.KirikaeOrgQuestionQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author lzf
 **/
@Repository
public class KirikaeOrgQuestionDao extends BaseDao {

    /**
     * 新增组织切替问题点关联
     * @param kirikaeOrgQuestion 组织切替问题点关联实体
     * @return 返回结果
     */
    public Integer insertKirikaeOrgQuestion(KirikaeOrgQuestion kirikaeOrgQuestion){
        return this.writerSqlSession.insert("KirikaeOrgQuestionMapper.insertSelective", kirikaeOrgQuestion);
    }

    /**
     * 更新组织切替问题点关联
     * @param kirikaeOrgQuestion 组织切替问题点关联实体
     * @return 返回结果
     */
    public Integer updateKirikaeOrgQuestion(KirikaeOrgQuestion kirikaeOrgQuestion){
        return this.writerSqlSession.update("KirikaeOrgQuestionMapper.updateByPrimaryKeySelective", kirikaeOrgQuestion);
    }

    /**
     * 查询组织关联的切替问题点关联
     * @param kirikaeOrgQuestionQuery 查询条件
     * @return 返回结果
     */
    public List<Map<String, Object>> selectKirikaeOrgQuestionList(KirikaeOrgQuestionQuery kirikaeOrgQuestionQuery){
        return this.readSqlSession.selectList("KirikaeOrgQuestionMapper.selectKirikaeOrgQuestionList", kirikaeOrgQuestionQuery);
    }

    /**
     * 查询可以添加的确认内容列表
     * @param kirikaeOrgQuestionQuery 查询条件
     * @return 返回结果
     */
    public List<Map<String, Object>> selectAddQuestionList(KirikaeOrgQuestionQuery kirikaeOrgQuestionQuery){
        return this.readSqlSession.selectList("KirikaeOrgQuestionMapper.selectAddQuestionList", kirikaeOrgQuestionQuery);
    }
}
