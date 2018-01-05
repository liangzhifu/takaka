package com.takata.kirikae.procedure.domain;

import lombok.Data;

/**
 * @author lzf
 **/
@Data
public class KirikaeProcedure {

    private Integer id;

    private Integer templateId;

    private Integer procedureSeq;

    private Integer procedureCode;

    private Integer procedureType;

    private String procedureName;

    private Integer deleteState;

}
