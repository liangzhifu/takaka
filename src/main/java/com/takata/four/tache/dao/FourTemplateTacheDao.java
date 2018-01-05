package com.takata.four.tache.dao;

import com.takata.common.dao.BaseDao;
import com.takata.four.tache.domain.FourTemplateTache;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author lzf
 **/
@Repository
public class FourTemplateTacheDao extends BaseDao {

    /**
     * 查询模板的工单列表
     * @param templateId 模板ID
     * @return 返回结果
     */
    public List<FourTemplateTache> selectFourTemplateTacheList(Integer templateId){
        return this.readSqlSession.selectList("FourTemplateTacheMapper.selectFourTemplateTacheList", templateId);
    }
}
