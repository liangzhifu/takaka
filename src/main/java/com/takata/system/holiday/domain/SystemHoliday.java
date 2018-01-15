package com.takata.system.holiday.domain;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author lzf
 **/
@Data
public class SystemHoliday {

    private Integer id;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date holiday;

}
