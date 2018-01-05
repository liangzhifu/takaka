package com.takata.four.template.dao;

import com.takata.common.dao.BaseDao;
import com.takata.four.template.domain.FourTemplateAttr;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author lzf
 **/
@Repository
public class FourTemplateAttrDao extends BaseDao {

    /**
     * 获取模板多选框列表-根据模板ID
     * @param templateId 模板ID
     * @return 返回结果
     */
    public List<FourTemplateAttr> selectFourTemplateAttrList(Integer templateId){
        return this.writerSqlSession.selectList("FourTemplateAttrMapper.selectFourTemplateAttrList", templateId);
    }
}
