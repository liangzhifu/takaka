package com.takata.alteration.order.dao;

import com.takata.alteration.order.domain.AlterationFourOrder;
import com.takata.common.dao.BaseDao;
import org.springframework.stereotype.Repository;

/**
 * @author lzf
 **/
@Repository
public class AlterationFourOrderDao extends BaseDao {

    /**
     * 新增4M变更单
     * @param alterationFourOrder 4M变更单实体
     * @return 返回结果
     */
    public Integer insertAlterationFourOrder(AlterationFourOrder alterationFourOrder){
        return this.writerSqlSession.insert("AlterationFourOrderMapper.insertSelective", alterationFourOrder);
    }

    /**
     * 更新4M变更单
     * @param alterationFourOrder 4M变更单实体
     * @return 返回结果
     */
    public Integer updateAlterationFourOrder(AlterationFourOrder alterationFourOrder){
        return this.writerSqlSession.update("AlterationFourOrderMapper.updateByPrimaryKeySelective", alterationFourOrder);
    }

    /**
     * 获取单个4M变更单
     * @param alterationFourOrder 4M变更单实体
     * @return 返回结果
     */
    public AlterationFourOrder selectAlterationFourOrder(AlterationFourOrder alterationFourOrder){
        return this.readSqlSession.selectOne("AlterationFourOrderMapper.selectByPrimaryKey", alterationFourOrder);
    }

    /**
     * 获取单个4M变更单-根据变更ID
     * @param orderId 变更单ID
     * @return 返回结果
     */
    public AlterationFourOrder selectAlterationFourOrder(Integer orderId){
        return this.readSqlSession.selectOne("AlterationFourOrderMapper.selectAlterationFourOrderByorderId", orderId);
    }
}
