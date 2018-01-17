package com.takata.system.file.domain;

import lombok.Data;

import java.util.Date;

/**
 * @author lzf
 **/
@Data
public class FileUpload {

    private Integer fileId;

    private String fileName;

    private String fileAlias;

    private String fileType;

    private String excelPdfName;

    private Date createDate;

    private Integer createBy;

}
