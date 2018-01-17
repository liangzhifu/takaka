package com.takata.kirikae.order.dao;

import com.takata.kirikae.order.domain.KirikaeOrder;
import com.takata.common.dao.BaseDao;
import org.springframework.stereotype.Repository;

/**
 * @author lzf
 **/
@Repository
public class KirikaeOrderDao extends BaseDao {

    /**
     * 新增切替变更单
     * @param alterationKirikaeOrder 切替变更单实体
     * @return 返回结果
     */
    public Integer insertSelective(KirikaeOrder alterationKirikaeOrder){
        return this.writerSqlSession.insert("AlterationKirikaeOrderMapper.insertSelective", alterationKirikaeOrder);
    }

    /**
     * 更新切替变更单
     * @param alterationKirikaeOrder 切替变更单实体
     * @return 返回结果
     */
    public Integer updateByPrimaryKeySelective(KirikaeOrder alterationKirikaeOrder){
        return this.writerSqlSession.update("AlterationKirikaeOrderMapper.updateByPrimaryKeySelective", alterationKirikaeOrder);
    }

    /**
     * 更新切替变更单
     * @param alterationKirikaeOrder 切替变更单实体
     * @return 返回结果
     */
    public Integer updateByPrimaryKey(KirikaeOrder alterationKirikaeOrder){
        return this.writerSqlSession.update("AlterationKirikaeOrderMapper.updateByPrimaryKeySelective", alterationKirikaeOrder);
    }

    /**
     * 获取单个切替变更单
     * @param alterationKirikaeOrder 切替变更单实体
     * @return 返回结果
     */
    public KirikaeOrder selectByPrimaryKey(KirikaeOrder alterationKirikaeOrder){
        return this.readSqlSession.selectOne("AlterationKirikaeOrderMapper.selectByPrimaryKey", alterationKirikaeOrder);
    }
    
}
