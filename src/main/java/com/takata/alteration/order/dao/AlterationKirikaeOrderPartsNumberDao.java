package com.takata.alteration.order.dao;

import com.takata.alteration.order.domain.AlterationKirikaeOrderPartsNumber;
import com.takata.alteration.order.query.AlterationKirikaeOrderPartsNumberQuery;
import com.takata.common.dao.BaseDao;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author lzf
 **/
@Repository
public class AlterationKirikaeOrderPartsNumberDao extends BaseDao {

    /**
     * 新增品号变更
     * @param alterationKirikaeOrderPartsNumber 品号变更实体
     * @return 返回结果
     */
    public Integer insertSelective(AlterationKirikaeOrderPartsNumber alterationKirikaeOrderPartsNumber){
        return this.writerSqlSession.insert("AlterationKirikaeOrderPartsNumberMapper.insertSelective", alterationKirikaeOrderPartsNumber);
    }

    /**
     * 修改品号变更
     * @param alterationKirikaeOrderPartsNumber 品号变更实体
     * @return 返回结果
     */
    public Integer updateByPrimaryKeySelective(AlterationKirikaeOrderPartsNumber alterationKirikaeOrderPartsNumber){
        return this.writerSqlSession.update("AlterationKirikaeOrderPartsNumberMapper.updateByPrimaryKeySelective", alterationKirikaeOrderPartsNumber);
    }

    /**
     * 查询品号变更列表
     * @param alterationKirikaeOrderPartsNumberQuery 查询条件
     * @return 返回结果
     */
    public List<AlterationKirikaeOrderPartsNumber> selectAlterationKirikaeOrderPartsNumberList(AlterationKirikaeOrderPartsNumberQuery alterationKirikaeOrderPartsNumberQuery){
        return this.readSqlSession.selectList("AlterationKirikaeOrderPartsNumberMapper.selectAlterationKirikaeOrderPartsNumberList", alterationKirikaeOrderPartsNumberQuery);
    }
}
