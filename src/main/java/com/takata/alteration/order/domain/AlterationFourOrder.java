package com.takata.alteration.order.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author lzf
 **/
@Data
public class AlterationFourOrder {

    private Integer id;

    private Integer orderId;

    private Integer templateId;

    private Integer templateVersion;

    private String changeAfterProductNo;

    private String changeBeforProductNo;

    private String realChangeTime;

    private String estimateChangeTime;

    private String releaseDate;

    private String issueNumber;

    private String productLine;

    private String carName;

    private String installationMat;

    private String changeContent;

    private Integer cycleId;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date realCompleteTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date requireCompleteTime;

    private Integer isDelay;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date noticeTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date delayNoticeTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date alarmTime;

    private String contractState;

    private String orderTache;

    private Integer contractUser;

    private String confirmOrderStateCode;

    private Integer isAgreement;

    private List<AlterationFourOrderAttr> alterationFourOrderAttrList;

}
