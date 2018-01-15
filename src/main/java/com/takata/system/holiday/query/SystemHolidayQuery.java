package com.takata.system.holiday.query;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author lzf
 **/
@Data
public class SystemHolidayQuery {

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date holidayStart;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date holidayEnd;

    private Integer start;

    private Integer size;

}
