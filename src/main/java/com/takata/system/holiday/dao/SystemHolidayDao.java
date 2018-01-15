package com.takata.system.holiday.dao;

import com.takata.common.dao.BaseDao;
import com.takata.system.holiday.domain.SystemHoliday;
import com.takata.system.holiday.query.SystemHolidayQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author lzf
 **/
@Repository
public class SystemHolidayDao extends BaseDao {

    /**
     * 插入一个节假日
     * @param systemHoliday 订单数据
     * @return 1成功，0不成功
     */
    public Integer insertSystemHoliday(SystemHoliday systemHoliday){
        return this.writerSqlSession.insert("SystemHolidayMapper.insertSelective", systemHoliday);
    }

    /**
     * 删除一个节假日
     * @param systemHoliday 订单数据
     * @return 1成功，0不成功
     */
    public Integer deleteSystemHoliday(SystemHoliday systemHoliday){
        return this.writerSqlSession.delete("SystemHolidayMapper.deleteByPrimaryKey", systemHoliday);
    }


    /**
     * 获取节假日数量
     * @param systemHolidayQuery 查询条件
     * @return 返回结果
     */
    public Integer selectSystemHolidayCount(SystemHolidayQuery systemHolidayQuery){
        return this.readSqlSession.selectOne("SystemHolidayMapper.selectSystemHolidayCount", systemHolidayQuery);
    }

    /**
     * 获取节假日列表--分页
     * @param systemHolidayQuery 查询条件
     * @return 返回结果
     */
    public List<SystemHoliday> selectSystemHolidayPageList(SystemHolidayQuery systemHolidayQuery){
        return this.readSqlSession.selectList("SystemHolidayMapper.selectSystemHolidayListPage", systemHolidayQuery);
    }

    /**
     * 获取节假日列表
     * @param systemHolidayQuery 查询条件
     * @return 返回结果
     */
    public List<SystemHoliday> selectSystemHolidayList(SystemHolidayQuery systemHolidayQuery){
        return this.readSqlSession.selectList("SystemHolidayMapper.selectSystemHolidayList", systemHolidayQuery);
    }

}
