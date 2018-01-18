package com.takata.kirikae.order.dao;

import com.takata.kirikae.order.domain.KirikaeOrderPartsNumber;
import com.takata.kirikae.order.query.KirikaeOrderPartsNumberQuery;
import com.takata.common.dao.BaseDao;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author lzf
 **/
@Repository
public class KirikaeOrderPartsNumberDao extends BaseDao {

    /**
     * 新增品号变更
     * @param alterationKirikaeOrderPartsNumber 品号变更实体
     * @return 返回结果
     */
    public Integer insertSelective(KirikaeOrderPartsNumber alterationKirikaeOrderPartsNumber){
        return this.writerSqlSession.insert("KirikaeOrderPartsNumberMapper.insertSelective", alterationKirikaeOrderPartsNumber);
    }

    /**
     * 修改品号变更
     * @param alterationKirikaeOrderPartsNumber 品号变更实体
     * @return 返回结果
     */
    public Integer updateByPrimaryKeySelective(KirikaeOrderPartsNumber alterationKirikaeOrderPartsNumber){
        return this.writerSqlSession.update("KirikaeOrderPartsNumberMapper.updateByPrimaryKeySelective", alterationKirikaeOrderPartsNumber);
    }

    /**
     * 查询品号变更列表
     * @param kirikaeOrderPartsNumberQuery 查询条件
     * @return 返回结果
     */
    public List<KirikaeOrderPartsNumber> selectKirikaeOrderPartsNumberList(KirikaeOrderPartsNumberQuery kirikaeOrderPartsNumberQuery){
        return this.readSqlSession.selectList("KirikaeOrderPartsNumberMapper.selectKirikaeOrderPartsNumberList", kirikaeOrderPartsNumberQuery);
    }
}
