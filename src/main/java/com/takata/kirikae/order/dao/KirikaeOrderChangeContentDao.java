package com.takata.kirikae.order.dao;

import com.takata.kirikae.order.domain.KirikaeOrderChangeContent;
import com.takata.kirikae.order.query.KirikaeOrderChangeContentQuery;
import com.takata.common.dao.BaseDao;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author lzf
 **/
@Repository
public class KirikaeOrderChangeContentDao extends BaseDao {

    /**
     * 新增设变内容
     * @param alterationKirikaeOrderChangeContent 设变内容实体
     * @return 返回结果
     */
    public Integer insertSelective(KirikaeOrderChangeContent alterationKirikaeOrderChangeContent){
        return this.writerSqlSession.insert("AlterationKirikaeOrderChangeContentMapper.insertSelective", alterationKirikaeOrderChangeContent);
    }

    /**
     * 修改设变内容
     * @param alterationKirikaeOrderChangeContent 设变内容实体
     * @return 返回结果
     */
    public Integer updateByPrimaryKeySelective(KirikaeOrderChangeContent alterationKirikaeOrderChangeContent){
        return this.writerSqlSession.update("AlterationKirikaeOrderChangeContentMapper.updateByPrimaryKeySelective", alterationKirikaeOrderChangeContent);
    }

    /**
     * 查询设变内容列表
     * @param kirikaeOrderChangeContentQuery 查询条件
     * @return 返回结果
     */
    public List<KirikaeOrderChangeContent> selectAlterationKirikaeOrderChangeContentList(KirikaeOrderChangeContentQuery kirikaeOrderChangeContentQuery){
        return this.readSqlSession.selectList("AlterationKirikaeOrderChangeContentMapper.selectAlterationKirikaeOrderChangeContentList", kirikaeOrderChangeContentQuery);
    }

}
