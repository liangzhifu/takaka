package com.takata.kirikae.procedure.dao;

import com.takata.common.dao.BaseDao;
import com.takata.kirikae.procedure.domain.KirikaeProcedure;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author lzf
 **/
@Repository
public class KirikaeProcedureDao extends BaseDao {

    /**
     * 查询切替流程
     * @param templateId 模板ID
     * @return 返回结果
     */
    public List<KirikaeProcedure> selectKirikaeProcedureList(Integer templateId){
        return this.readSqlSession.selectList("KirikaeProcedureMapper.selectKirikaeProcedureList", templateId);
    }

}
