package com.takata.alteration.procedure.domain;

import lombok.Data;

import java.util.Date;

/**
 * @author lzf
 **/
@Data
public class AlterationKirikaeOrderProcedure {

    private Integer id;

    private Integer kirikaeOrderId;

    private Integer procedureState;

    private Integer procedureSeq;

    private Integer deleteState;

    private Integer procedureCode;

    private Integer procedureType;

    private Integer procedureBy;

    private Date procedureTime;

    private Date createTime;

}
