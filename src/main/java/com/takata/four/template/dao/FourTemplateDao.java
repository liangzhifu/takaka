package com.takata.four.template.dao;

import com.takata.common.dao.BaseDao;
import com.takata.four.template.domain.FourTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author lzf
 **/
@Repository
public class FourTemplateDao extends BaseDao {

    /**
     * 查询当前4M模板
     * @return 返回结果
     */
    public FourTemplate selectFourTemplate(){
        return this.readSqlSession.selectOne("FourTemplateMapper.selectFourTemplate");
    }

}
