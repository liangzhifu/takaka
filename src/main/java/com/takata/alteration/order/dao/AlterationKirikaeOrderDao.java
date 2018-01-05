package com.takata.alteration.order.dao;

import com.takata.alteration.order.domain.AlterationKirikaeOrder;
import com.takata.common.dao.BaseDao;
import org.springframework.stereotype.Repository;

/**
 * @author lzf
 **/
@Repository
public class AlterationKirikaeOrderDao extends BaseDao {

    /**
     * 新增切替变更单
     * @param alterationKirikaeOrder 切替变更单实体
     * @return 返回结果
     */
    public Integer insertAlterationKirikaeOrder(AlterationKirikaeOrder alterationKirikaeOrder){
        return this.writerSqlSession.insert("", alterationKirikaeOrder);
    }

    /**
     * 更新切替变更单
     * @param alterationKirikaeOrder 切替变更单实体
     * @return 返回结果
     */
    public Integer updateAlterationKirikaeOrder(AlterationKirikaeOrder alterationKirikaeOrder){
        return this.writerSqlSession.update("", alterationKirikaeOrder);
    }

    /**
     * 获取单个切替变更单
     * @param alterationKirikaeOrder 切替变更单实体
     * @return 返回结果
     */
    public AlterationKirikaeOrder selectAlterationKirikaeOrder(AlterationKirikaeOrder alterationKirikaeOrder){
        return this.readSqlSession.selectOne("", alterationKirikaeOrder);
    }
    
}
