package com.takata.alteration.woorder.dao;

import com.takata.alteration.woorder.domain.AlterationFourWoOrderAttr;
import com.takata.common.dao.BaseDao;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author lzf
 **/
@Repository
public class AlterationFourWoOrderAttrDao extends BaseDao {

    /**
     * 新增4M工单多选框
     * @param alterationFourWoOrderAttr 4M工单多选框实体
     * @return 返回结果
     */
    private Integer insertAlterationFourWoOrderAttr(AlterationFourWoOrderAttr alterationFourWoOrderAttr){
        return this.writerSqlSession.insert("", alterationFourWoOrderAttr);
    }

    /**
     * 更新M工单多选框
     * @param alterationFourWoOrderAttr 4M工单多选框实体
     * @return 返回结果
     */
    private Integer updateAlterationFourWoOrderAttr(AlterationFourWoOrderAttr alterationFourWoOrderAttr){
        return this.writerSqlSession.update("", alterationFourWoOrderAttr);
    }

    /**
     * 查询M工单多选框-根据4M工单ID
     * @param fourWoOrderId 4M工单ID
     * @return 返回结果
     */
    public List<AlterationFourWoOrderAttr> selectAlterationFourWoOrderAttrList(Integer fourWoOrderId){
        return this.readSqlSession.selectList("", fourWoOrderId);
    }
}
