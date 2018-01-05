package com.takata.four.tache.dao;

import com.takata.common.dao.BaseDao;
import com.takata.four.tache.domain.FourTemplateTacheUser;
import com.takata.four.tache.query.FourTemplateTacheUserQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author lzf
 **/
@Repository
public class FourTemplateTacheUserDao extends BaseDao {

    /**
     * 新增模板工单处理者
     * @param fourTemplateTacheUser 模板工单处理者实体
     * @return 返回结果
     */
    public Integer insertFourTemplateTacheUser(FourTemplateTacheUser fourTemplateTacheUser){
        return this.writerSqlSession.insert("", fourTemplateTacheUser);
    }

    /**
     * 更新模板工单处理者
     * @param fourTemplateTacheUser 模板工单处理者实体
     * @return 返回结果
     */
    public Integer updateFourTemplateTacheUser(FourTemplateTacheUser fourTemplateTacheUser){
        return this.writerSqlSession.update("", fourTemplateTacheUser);
    }

    /**
     * 查询模板工单处理者列表
     * @param fourTemplateTacheUserQuery 查询条件
     * @return 返回结果
     */
    public List<Map<String, Object>> selectFourTemplateTacheUserList(FourTemplateTacheUserQuery fourTemplateTacheUserQuery){
        return this.readSqlSession.selectList("", fourTemplateTacheUserQuery);
    }
}
