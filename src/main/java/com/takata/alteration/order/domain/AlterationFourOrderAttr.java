package com.takata.alteration.order.domain;

import lombok.Data;

/**
 * @author lzf
 **/
@Data
public class AlterationFourOrderAttr {

    private Integer id;

    private Integer fourOrderId;

    private Integer attrId;

    private Integer attrChecked;

    private String attrValue;

    private Integer attrType;

    private String attrName;

    private Integer attrOther;

}
