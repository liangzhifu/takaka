package com.takata.four.tache.dao;

import com.takata.common.dao.BaseDao;
import com.takata.four.tache.domain.FourTemplateTacheManager;
import com.takata.four.tache.query.FourTemplateTacheManagerQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author lzf
 **/
@Repository
public class FourTemplateTacheManagerDao extends BaseDao {

    /**
     * 新增工单管理者
     * @param fourTemplateTacheManager 工单管理者实体
     * @return 返回结果
     */
    public Integer insertFourTemplateTacheManager(FourTemplateTacheManager fourTemplateTacheManager){
        return this.writerSqlSession.insert("", fourTemplateTacheManager);
    }

    /**
     * 删除工单管理者
     * @param fourTemplateTacheManager 工单管理者实体
     * @return 返回结果
     */
    public Integer deleteFourTemplateTacheManager(FourTemplateTacheManager fourTemplateTacheManager){
        return this.writerSqlSession.delete("", fourTemplateTacheManager);
    }

    /**
     * 查询工单管理者列表
     * @param fourTemplateTacheManagerQuery 查询条件
     * @return 返回结果
     */
    public List<Map<String, Object>> selectFourTemplateTacheManagerList(FourTemplateTacheManagerQuery fourTemplateTacheManagerQuery){
        return this.readSqlSession.selectList("", fourTemplateTacheManagerQuery);
    }

}
