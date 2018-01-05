package com.takata.system.holiday.service;

import com.takata.system.holiday.domain.SystemHoliday;
import com.takata.system.holiday.query.SystemHolidayQuery;

import java.util.List;
import java.util.Map;

/**
 * @author lzf
 **/

public interface SystemHolidayService {

    /**
     * 删除节假日
     * @param systemHoliday 节假日
     * @return 返回结果
     */
    Integer deleteSystemHoliday(SystemHoliday systemHoliday);

    /**
     * 添加节假日
     * @param systemHoliday 节假日
     * @return 返回结果
     */
    Integer addSystemHoliday(SystemHoliday systemHoliday);

    /**
     * 获取节假日列表--分页
     * @param systemHolidayQuery 查询条件
     * @return 返回结果
     * @throws Exception 异常
     */
    public List<Map<String, Object>> querySystemHolidayListPage(SystemHolidayQuery systemHolidayQuery) throws Exception;

    /**
     * 获取节假日数量
     * @param systemHolidayQuery 查询条件
     * @return 返回结果
     * @throws Exception 异常
     */
    public Integer querySystemHolidayCount(SystemHolidayQuery systemHolidayQuery) throws Exception;

}
