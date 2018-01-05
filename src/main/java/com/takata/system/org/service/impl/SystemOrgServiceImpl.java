package com.takata.system.org.service.impl;

import com.takata.common.constant.CommonEnum;
import com.takata.common.shiro.Principal;
import com.takata.common.shiro.PrincipalUtils;
import com.takata.kirikae.org.query.KirikaeOrgQuestionQuery;
import com.takata.kirikae.org.service.KirikaeOrgQuestionService;
import com.takata.system.org.constant.SystemOrgEnum;
import com.takata.system.org.dao.SystemOrgDao;
import com.takata.system.org.domain.SystemOrg;
import com.takata.system.org.query.SystemOrgQuery;
import com.takata.system.org.service.SystemOrgService;
import com.takata.system.user.query.SystemUserOrgQuery;
import com.takata.system.user.service.SystemUserOrgService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

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
        systemOrg.setCreateBy(principal.getId());
        systemOrg.setCreateTime(new Date());
        systemOrg.setUpdateBy(principal.getId());
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
        systemOrg.setUpdateBy(principal.getId());
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
        systemOrg.setUpdateBy(principal.getId());
        systemOrg.setUpdateTime(new Date());
        systemOrg.setDeleteState(CommonEnum.DeleteStateEnum.DELETE_STATE_YES.getCode());

        //删除组织--删除组织关联的切替确认内容
        Integer orgType = systemOrg.getOrgType();
        if (orgType.intValue() == SystemOrgEnum.OrgTypeEnum.ORG_TYPE_THREE.getCode()){
            KirikaeOrgQuestionQuery kirikaeOrgQuestionQuery = new KirikaeOrgQuestionQuery();
            kirikaeOrgQuestionQuery.setOrgId(systemOrg.getId());
            this.kirikaeOrgQuestionService.deleteKirikaeOrgQuestionByOrg(kirikaeOrgQuestionQuery);
        }

        Integer count = this.systemOrgDao.updateSystemOrg(systemOrg);
        if (count != 1){
            throw new Exception("删除组织异常！");
        }

        //删除人员关联的组织
        SystemUserOrgQuery systemUserOrgQuery = new SystemUserOrgQuery();
        systemUserOrgQuery.setOrgId(systemOrg.getId());
        this.systemUserOrgService.deleteSystemUserOrgByOrg(systemUserOrgQuery);

        //删除子组织
        SystemOrgQuery systemOrgQuery = new SystemOrgQuery();
        systemOrgQuery.setOrgPathCode(systemOrg.getOrgPathCode());
        List<Map<String, Object>> mapList = this.systemOrgDao.selectSystemOrgList(systemOrgQuery);
        for(Map<String, Object> map : mapList){
            SystemOrg tempSystemOrg = new SystemOrg();
            tempSystemOrg.setId(Integer.valueOf(map.get("id").toString()));
            tempSystemOrg.setUpdateBy(principal.getId());
            tempSystemOrg.setUpdateTime(new Date());
            tempSystemOrg.setDeleteState(CommonEnum.DeleteStateEnum.DELETE_STATE_YES.getCode());

            //删除组织--删除组织关联的切替确认内容
            orgType = Integer.valueOf(map.get("orgType").toString());
            if (orgType.intValue() == SystemOrgEnum.OrgTypeEnum.ORG_TYPE_THREE.getCode()){
                KirikaeOrgQuestionQuery kirikaeOrgQuestionQuery = new KirikaeOrgQuestionQuery();
                kirikaeOrgQuestionQuery.setOrgId(tempSystemOrg.getId());
                this.kirikaeOrgQuestionService.deleteKirikaeOrgQuestionByOrg(kirikaeOrgQuestionQuery);
            }

            Integer tempCount = this.systemOrgDao.updateSystemOrg(tempSystemOrg);
            if (tempCount != 1){
                throw new Exception("删除组织异常！");
            }

            //删除人员关联的组织
            SystemUserOrgQuery tempSystemUserOrgQuery = new SystemUserOrgQuery();
            tempSystemUserOrgQuery.setOrgId(tempSystemOrg.getId());
            this.systemUserOrgService.deleteSystemUserOrgByOrg(tempSystemUserOrgQuery);
        }
    }

    @Override
    public List<Map<String, Object>> queryCompanyOrgTree(SystemOrgQuery systemOrgQuery) throws Exception {
        return this.systemOrgDao.selectSystemOrgList(systemOrgQuery);
    }

    @Override
    public List<Map<String, Object>> queryAllSystemOrgList() throws Exception {
        return this.systemOrgDao.selectAllSystemOrgList();
    }

    @Override
    public List<Map<String, Object>> listSystemOrgKirikae() throws Exception {
        return this.systemOrgDao.selectSystemOrgKirikaeList();
    }
}