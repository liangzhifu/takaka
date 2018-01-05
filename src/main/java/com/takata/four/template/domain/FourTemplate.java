package com.takata.four.template.domain;

import lombok.Data;

/**
 * @author lzf
 **/
@Data
public class FourTemplate {

    private Integer id;

    private String templateName;

    private Integer cycleId;

    private Integer templateVersion;

    private Integer deleteState;

}
