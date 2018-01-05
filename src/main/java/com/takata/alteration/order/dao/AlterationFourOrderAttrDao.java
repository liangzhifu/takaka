package com.takata.alteration.order.dao;

import com.takata.alteration.order.domain.AlterationFourOrderAttr;
import com.takata.common.dao.BaseDao;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author lzf
 **/
@Repository
public class AlterationFourOrderAttrDao extends BaseDao {

    /**
     * 新增4M订单多选框
     * @param alterationFourOrderAttr 4M订单多选框实体
     * @return 返回结果
     */
    public Integer insertAlterationFourOrderAttr(AlterationFourOrderAttr alterationFourOrderAttr){
        return this.writerSqlSession.insert("AlterationFourOrderAttrMapper.insertAlterationFourOrderAttr", alterationFourOrderAttr);
    }

    /**
     * 更新M订单多选框
     * @param alterationFourOrderAttr 4M订单多选框实体
     * @return 返回结果
     */
    public Integer updateAlterationFourOrderAttr(AlterationFourOrderAttr alterationFourOrderAttr){
        return this.writerSqlSession.update("AlterationFourOrderAttrMapper.updateByPrimaryKey", alterationFourOrderAttr);
    }

    /**
     * 查询M订单多选框-根据4M订单ID
     * @param fourOrderId 4M订单ID
     * @return 返回结果
     */
    public List<AlterationFourOrderAttr> selectAlterationFourOrderAttrList(Integer fourOrderId){
        return this.readSqlSession.selectList("AlterationFourOrderAttrMapper.selectAlterationFourOrderAttrList", fourOrderId);
    }

}
