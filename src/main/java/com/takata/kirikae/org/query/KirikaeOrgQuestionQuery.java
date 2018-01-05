package com.takata.kirikae.org.query;

import lombok.Data;

/**
 * @author lzf
 **/
@Data
public class KirikaeOrgQuestionQuery {

    private Integer orgId;

    private Integer questionId;

    private String confirmProject;

    private String confirmContent;

}
