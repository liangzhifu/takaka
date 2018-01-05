package com.takata.alteration.order.dao;

import com.takata.alteration.order.domain.AlterationOrder;
import com.takata.common.dao.BaseDao;
import org.springframework.stereotype.Repository;

/**
 * @author lzf
 **/
@Repository
public class AlterationOrderDao extends BaseDao {

    /**
     * 新增变更单
     * @param alterationOrder 变更单实体
     * @return 返回结果
     */
    public Integer insertAlterationOrder(AlterationOrder alterationOrder){
        return this.writerSqlSession.insert("AlterationOrderMapper.insertSelective", alterationOrder);
    }

    /**
     * 更新变更单
     * @param alterationOrder 变更单实体
     * @return 返回结果
     */
    public Integer updateAlterationOrder(AlterationOrder alterationOrder){
        return this.writerSqlSession.update("", alterationOrder);
    }

    /**
     * 获取单个变更单
     * @param alterationOrder 变更单实体
     * @return 返回结果
     */
    public AlterationOrder selectAlterationOrder(AlterationOrder alterationOrder){
        return this.readSqlSession.selectOne("AlterationOrderMapper.selectByPrimaryKey", alterationOrder);
    }
}
