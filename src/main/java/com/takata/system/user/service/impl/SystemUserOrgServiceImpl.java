package com.takata.system.user.service.impl;

import com.takata.common.constant.CommonEnum;
import com.takata.common.shiro.Principal;
import com.takata.common.shiro.PrincipalUtils;
import com.takata.system.user.dao.SystemUserOrgDao;
import com.takata.system.user.domain.SystemUserOrg;
import com.takata.system.user.query.SystemUserOrgQuery;
import com.takata.system.user.service.SystemUserOrgService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author lzf
 **/
@Service("systemUserOrgService")
public class SystemUserOrgServiceImpl implements SystemUserOrgService {

    @Resource(name = "systemUserOrgDao")
    private SystemUserOrgDao systemUserOrgDao;

    @Override
    public void addSystemUserOrg(Integer userId, String[] orgIds) throws Exception {
        Principal principal = PrincipalUtils.getPrincipal();
        for (String orgId : orgIds){
            SystemUserOrg systemUserOrg = new SystemUserOrg();
            systemUserOrg.setUserId(userId);
            systemUserOrg.setOrgId(Integer.valueOf(orgId));
            systemUserOrg.setCreateBy(principal != null ? principal.getId() : null);
            systemUserOrg.setCreateTime(new Date());
            systemUserOrg.setUpdateBy(principal != null ? principal.getId() : null);
            systemUserOrg.setUpdateTime(new Date());
            systemUserOrg.setDeleteState(CommonEnum.DeleteStateEnum.DELETE_STATE_NO.getCode());
            Integer count = this.systemUserOrgDao.insertSystemUserOrg(systemUserOrg);
            if (count != 1){
                throw new Exception("添加用户组织关联异常！");
            }
        }
    }

    @Override
    public void editSystemUserOrg(Integer userId, String[] orgIds) throws Exception {
        SystemUserOrgQuery systemUserOrgQuery = new SystemUserOrgQuery();
        systemUserOrgQuery.setUserId(userId);
        List<SystemUserOrg> systemUserOrgList = this.systemUserOrgDao.selectSystemUserOrgList(systemUserOrgQuery);
        for(SystemUserOrg systemUserOrg : systemUserOrgList){
            this.deleteSystemUserOrg(systemUserOrg);
        }
        this.addSystemUserOrg(userId, orgIds);
    }

    @Override
    public Integer deleteSystemUserOrg(SystemUserOrg systemUserOrg) throws Exception {
        Principal principal = PrincipalUtils.getPrincipal();
        systemUserOrg.setUpdateBy(principal != null ? principal.getId() : null);
        systemUserOrg.setUpdateTime(new Date());
        systemUserOrg.setDeleteState(CommonEnum.DeleteStateEnum.DELETE_STATE_YES.getCode());
        Integer count = this.systemUserOrgDao.updateSystemUserOrg(systemUserOrg);
        if (count != 1){
            throw new Exception("删除用户组织关联异常！");
        }
        return count;
    }

    @Override
    public void deleteSystemUserOrgByUser(Integer userId) throws Exception {
        SystemUserOrgQuery systemUserOrgQuery = new SystemUserOrgQuery();
        systemUserOrgQuery.setUserId(userId);
        List<SystemUserOrg> systemUserOrgList = this.systemUserOrgDao.selectSystemUserOrgList(systemUserOrgQuery);
        for (SystemUserOrg systemUserOrg : systemUserOrgList){
            this.deleteSystemUserOrg(systemUserOrg);
        }
    }

    @Override
    public void deleteSystemUserOrgByOrg(Integer orgId) throws Exception {
        SystemUserOrgQuery systemUserOrgQuery = new SystemUserOrgQuery();
        systemUserOrgQuery.setOrgId(orgId);
        List<SystemUserOrg> systemUserOrgList = this.systemUserOrgDao.selectSystemUserOrgList(systemUserOrgQuery);
        for (SystemUserOrg systemUserOrg : systemUserOrgList){
            this.deleteSystemUserOrg(systemUserOrg);
        }
    }

    @Override
    public List<SystemUserOrg> listSystemUserOrg(SystemUserOrgQuery systemUserOrgQuery) throws Exception {
        return this.systemUserOrgDao.selectSystemUserOrgList(systemUserOrgQuery);
    }

}
