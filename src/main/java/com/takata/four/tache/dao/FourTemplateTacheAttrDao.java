package com.takata.four.tache.dao;

import com.takata.common.dao.BaseDao;
import com.takata.four.tache.domain.FourTemplateTacheAttr;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author lzf
 **/
@Repository
public class FourTemplateTacheAttrDao extends BaseDao {

    /**
     * 查询4M工单多选框列表--根据模板ID
     * @param templateId 模板ID
     * @return 返回结果
     */
    public List<FourTemplateTacheAttr> selectFourTemplateTacheAttrList(Integer templateId){
        return this.readSqlSession.selectList("FourTemplateTacheAttrMapper.selectFourTemplateTacheAttrList", templateId);
    }

}
