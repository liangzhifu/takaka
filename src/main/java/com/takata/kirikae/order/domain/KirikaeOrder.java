package com.takata.kirikae.order.domain;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

/**
 * @author lzf
 **/
@Data
public class KirikaeOrder {

    private Integer id;

    private Integer orderId;

    private String tkNo;

    private String designChangeNo;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date salesDate;

    private String salesApproved;

    private String salesChecked;

    private String salesPrepared;

    private Integer salesCustomerProtocal;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
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

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date designChangeTiming;

    private Integer desingChangeType;

    private String manufactureInternal;

    private String manufacturePrepared;

    private Integer kirikaeOrderType;

    private List<KirikaeOrderChangeContent> kirikaeOrderChangeContentList;

    private List<KirikaeOrderPartsNumber> kirikaeOrderPartsNumberList;

}
