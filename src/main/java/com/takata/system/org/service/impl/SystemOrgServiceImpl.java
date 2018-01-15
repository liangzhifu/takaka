package com.takata.system.org.service.impl;

import com.takata.common.constant.CommonEnum;
import com.takata.common.shiro.Principal;
import com.takata.common.shiro.PrincipalUtils;
import com.takata.kirikae.org.service.KirikaeOrgQuestionService;
import com.takata.system.org.constant.SystemOrgEnum;
import com.takata.system.org.dao.SystemOrgDao;
import com.takata.system.org.domain.SystemOrg;
import com.takata.system.org.query.SystemOrgQuery;
import com.takata.system.org.service.SystemOrgService;
import com.takata.system.user.service.SystemUserOrgService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author lzf
 **/
@Service("systemOrgService")
public class SystemOrgServiceImpl implements SystemOrgService {

    @Resource(name = "systemOrgDao")
    private SystemOrgDao systemOrgDao;

    @Resource(name = "systemUserOrgService")
    private SystemUserOrgService systemUserOrgService;

    @Resource(name = "kirikaeOrgQuestionService")
    private KirikaeOrgQuestionService kirikaeOrgQuestionService;

    @Override
    public void addSystemOrg(SystemOrg systemOrg) throws Exception {
        SystemOrg parentOrg = new SystemOrg();
        parentOrg.setId(systemOrg.getParentId());
        parentOrg = this.systemOrgDao.selectByPrimaryKey(parentOrg);
        Principal principal = PrincipalUtils.getPrincipal();
        systemOrg.setCreateBy(principal != null ? principal.getId() : null);
        systemOrg.setCreateTime(new Date());
        systemOrg.setUpdateBy(principal != null ? principal.getId() : null);
        systemOrg.setUpdateTime(new Date());
        systemOrg.setCompanyId(parentOrg.getCompanyId());
        systemOrg.setDeleteState(CommonEnum.DeleteStateEnum.DELETE_STATE_NO.getCode());
        Integer count = this.systemOrgDao.insertSystemOrg(systemOrg);
        if (count != 1){
            throw new Exception("添加组织异常！");
        }
        systemOrg.setOrgPathCode(parentOrg.getOrgPathCode()+systemOrg.getId()+",");
        this.systemOrgDao.updateSystemOrg(systemOrg);
        Integer orgType = systemOrg.getOrgType();
        if (orgType.intValue() == SystemOrgEnum.OrgTypeEnum.ORG_TYPE_THREE.getCode()){
            //科室，自动添加对象外切替确认内容关联
            //对象外切替确认内容ID默认为1
            String[] questionIds = {"1"};
            this.kirikaeOrgQuestionService.addKirikaeOrgQuestion(systemOrg.getId(), questionIds);
        }
    }

    @Override
    public void editSystemOrg(SystemOrg systemOrg) throws Exception {
        Principal principal = PrincipalUtils.getPrincipal();
        systemOrg.setUpdateBy(principal != null ? principal.getId() : null);
        systemOrg.setUpdateTime(new Date());
        Integer count = this.systemOrgDao.updateSystemOrg(systemOrg);
        if (count != 1){
            throw new Exception("修改组织异常！");
        }
    }

    @Override
    public void deleteSystemOrg(SystemOrg systemOrg) throws Exception {
        systemOrg = this.systemOrgDao.selectByPrimaryKey(systemOrg);
        Principal principal = PrincipalUtils.getPrincipal();
        systemOrg.setUpdateBy(principal != null ? principal.getId() : null);
        systemOrg.setUpdateTime(new Date());
        systemOrg.setDeleteState(CommonEnum.DeleteStateEnum.DELETE_STATE_YES.getCode());

        //删除组织--删除组织关联的切替确认内容
        Integer orgType = systemOrg.getOrgType();
        if (orgType.intValue() == SystemOrgEnum.OrgTypeEnum.ORG_TYPE_THREE.getCode()){
            this.kirikaeOrgQuestionService.deleteKirikaeOrgQuestionByOrg(systemOrg.getId());
        }

        Integer count = this.systemOrgDao.updateSystemOrg(systemOrg);
        if (count != 1){
            throw new Exception("删除组织异常！");
        }

        //删除人员关联的组织
        this.systemUserOrgService.deleteSystemUserOrgByOrg(systemOrg.getId());

        //删除子组织
        SystemOrgQuery systemOrgQuery = new SystemOrgQuery();
        systemOrgQuery.setOrgPathCode(systemOrg.getOrgPathCode());
        List<SystemOrg> systemOrgList = this.systemOrgDao.selectSystemOrgList(systemOrgQuery);
        for(SystemOrg tempSystemOrg : systemOrgList){
            tempSystemOrg.setUpdateBy(principal != null ? principal.getId() : null);
            tempSystemOrg.setUpdateTime(new Date());
            tempSystemOrg.setDeleteState(CommonEnum.DeleteStateEnum.DELETE_STATE_YES.getCode());

            //删除组织--删除组织关联的切替确认内容
            orgType = tempSystemOrg.getOrgType();
            if (orgType.intValue() == SystemOrgEnum.OrgTypeEnum.ORG_TYPE_THREE.getCode()){
                this.kirikaeOrgQuestionService.deleteKirikaeOrgQuestionByOrg(tempSystemOrg.getId());
            }

            Integer tempCount = this.systemOrgDao.updateSystemOrg(tempSystemOrg);
            if (tempCount != 1){
                throw new Exception("删除组织异常！");
            }

            //删除人员关联的组织
            this.systemUserOrgService.deleteSystemUserOrgByOrg(tempSystemOrg.getId());
        }
    }

    @Override
    public List<SystemOrg> listSystemOrg(SystemOrgQuery systemOrgQuery) throws Exception {
        return this.systemOrgDao.selectSystemOrgList(systemOrgQuery);
    }

}
