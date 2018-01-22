package com.takata.kirikae.order.dao;

import com.takata.kirikae.order.domain.KirikaeOrder;
import com.takata.common.dao.BaseDao;
import com.takata.kirikae.order.query.KirikaeOrderQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

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
        return this.writerSqlSession.insert("KirikaeOrderMapper.insertSelective", alterationKirikaeOrder);
    }

    /**
     * 更新切替变更单
     * @param alterationKirikaeOrder 切替变更单实体
     * @return 返回结果
     */
    public Integer updateByPrimaryKeySelective(KirikaeOrder alterationKirikaeOrder){
        return this.writerSqlSession.update("KirikaeOrderMapper.updateByPrimaryKeySelective", alterationKirikaeOrder);
    }

    /**
     * 更新切替变更单
     * @param alterationKirikaeOrder 切替变更单实体
     * @return 返回结果
     */
    public Integer updateByPrimaryKey(KirikaeOrder alterationKirikaeOrder){
        return this.writerSqlSession.update("KirikaeOrderMapper.updateByPrimaryKeySelective", alterationKirikaeOrder);
    }

    /**
     * 获取单个切替变更单
     * @param alterationKirikaeOrder 切替变更单实体
     * @return 返回结果
     */
    public KirikaeOrder selectByPrimaryKey(KirikaeOrder alterationKirikaeOrder){
        return this.readSqlSession.selectOne("KirikaeOrderMapper.selectByPrimaryKey", alterationKirikaeOrder);
    }

    /**
     * 获取单个切替变更单
     * @param alterationOrderId 变更单ID
     * @return 返回结果
     */
    public KirikaeOrder selectByAlterationOrderId(Integer alterationOrderId){
        return this.readSqlSession.selectOne("KirikaeOrderMapper.selectByAlterationOrderId", alterationOrderId);
    }

    /**
     * 查询切替单列表--分页
     * @param kirikaeOrderQuery 查询条件
     * @return 返回结果
     */
    public List<Map<String, Object>> selectKirikaeOrderPageList(KirikaeOrderQuery kirikaeOrderQuery){
        return this.readSqlSession.selectList("KirikaeOrderMapper.selectKirikaeOrderPageList", kirikaeOrderQuery);
    }

    /**
     * 查询切替单数量
     * @param kirikaeOrderQuery 查询条件
     * @return 返回结果
     */
    public Integer selectKirikaeOrderCount(KirikaeOrderQuery kirikaeOrderQuery){
        return this.readSqlSession.selectOne("KirikaeOrderMapper.selectKirikaeOrderCount", kirikaeOrderQuery);
    }
}
