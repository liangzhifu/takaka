package com.takata.alteration.order.dao;

import com.takata.alteration.order.domain.AlterationKirikaeOrderChangeContent;
import com.takata.alteration.order.query.AlterationKirikaeOrderChangeContentQuery;
import com.takata.common.dao.BaseDao;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author lzf
 **/
@Repository
public class AlterationKirikaeOrderChangeContentDao extends BaseDao {

    /**
     * 新增设变内容
     * @param alterationKirikaeOrderChangeContent 设变内容实体
     * @return 返回结果
     */
    public Integer insertSelective(AlterationKirikaeOrderChangeContent alterationKirikaeOrderChangeContent){
        return this.writerSqlSession.insert("AlterationKirikaeOrderChangeContentMapper.insertSelective", alterationKirikaeOrderChangeContent);
    }

    /**
     * 修改设变内容
     * @param alterationKirikaeOrderChangeContent 设变内容实体
     * @return 返回结果
     */
    public Integer updateByPrimaryKeySelective(AlterationKirikaeOrderChangeContent alterationKirikaeOrderChangeContent){
        return this.writerSqlSession.update("AlterationKirikaeOrderChangeContentMapper.updateByPrimaryKeySelective", alterationKirikaeOrderChangeContent);
    }

    /**
     * 查询设变内容列表
     * @param alterationKirikaeOrderChangeContentQuery 查询条件
     * @return 返回结果
     */
    public List<AlterationKirikaeOrderChangeContent> selectAlterationKirikaeOrderChangeContentList(AlterationKirikaeOrderChangeContentQuery alterationKirikaeOrderChangeContentQuery){
        return this.readSqlSession.selectList("AlterationKirikaeOrderChangeContentMapper.selectAlterationKirikaeOrderChangeContentList", alterationKirikaeOrderChangeContentQuery);
    }

}
