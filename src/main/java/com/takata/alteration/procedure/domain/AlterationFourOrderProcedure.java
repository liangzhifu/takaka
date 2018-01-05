package com.takata.alteration.procedure.domain;

import lombok.Data;

import java.util.Date;

/**
 * @author lzf
 **/
@Data
public class AlterationFourOrderProcedure {

    private Integer id;

    private Integer fourOrderId;

    private Integer procedureSeq;

    private String procedureState;

    private Integer procedureBy;

    private Date createTime;

    private Date procedureTime;

    private Integer procedureType;

    private String procedureCode;

    private Integer deleteState;

}
