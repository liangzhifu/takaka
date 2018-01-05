package com.takata.alteration.order.domain;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author lzf
 **/
@Data
public class AlterationKirikaeOrder {

    private Integer id;

    private Integer orderId;

    private String tkNo;

    private String designChangeNo;

    private Date salesDate;

    private String salesApproved;

    private String salesChecked;

    private String salesPrepared;

    private Integer salesCustomerProtocal;

    private Date engineeringData;

    private String engineeringApproved;

    private String engineeringChecked;

    private String engineeringPrepared;

    private String customer;

    private String vehicleName;

    private String destination;

    private Integer isirProcessing;

    private Integer customerEngineering;

    private Integer customerEngineeringApproval;

    private Integer regulation;

    private Integer regulationApproval;

    private String interchangeabilityOld;

    private String interchangeabilityNew;

    private Integer serviceSuplied;

    private Integer designCosts;

    private Integer designCostsPay;

    private Integer customerEo;

    private Integer partsNumberChange;

    private Integer presenceRequired;

    private Date designChangeTiming;

    private Integer desingChangeType;

    private String manufactureInternal;

    private String manufacturePrepared;

    private Integer kirikaeOrderType;

    private List<AlterationKirikaeOrderChangeContent> alterationKirikaeOrderChangeContentList;

    private List<AlterationKirikaeOrderPartsNumber> alterationKirikaeOrderPartsNumberList;

}
