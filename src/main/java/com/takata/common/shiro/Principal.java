package com.takata.common.shiro;

import com.takata.system.user.domain.SystemUser;
import lombok.Data;

/**
 * @author lzf
 **/
@Data
public class Principal {

    private Integer id;

    private String userCode;

    private String userName;

    private Integer companyId;

    public Principal(SystemUser systemUser) {
        this.id = systemUser.getId();
        this.userCode = systemUser.getUserCode();
        this.userName = systemUser.getUserName();
    }

}
