package com.takata.four.tache.service.impl;

import com.takata.common.constant.CommonEnum;
import com.takata.common.shiro.Principal;
import com.takata.common.shiro.PrincipalUtils;
import com.takata.four.tache.dao.FourTemplateTacheUserDao;
import com.takata.four.tache.domain.FourTemplateTacheUser;
import com.takata.four.tache.query.FourTemplateTacheUserQuery;
import com.takata.four.tache.service.FourTemplateTacheUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author lzf
 **/
@Service("fourTemplateTacheUserService")
public class FourTemplateTacheUserServiceImpl implements FourTemplateTacheUserService {

    @Resource(name = "fourTemplateTacheUserDao")
    private FourTemplateTacheUserDao fourTemplateTacheUserDao;

    @Override
    public void addFourTemplateTacheUser(Integer tacheId, String[] userIds) throws Exception {
        FourTemplateTacheUser fourTemplateTacheUser = new FourTemplateTacheUser();
        Principal principal = PrincipalUtils.getPrincipal();
        fourTemplateTacheUser.setCreateBy(principal.getId());
        fourTemplateTacheUser.setCreateTime(new Date());
        fourTemplateTacheUser.setUpdateBy(principal.getId());
        fourTemplateTacheUser.setUpdateTime(new Date());
        fourTemplateTacheUser.setDeleteState(CommonEnum.DeleteStateEnum.DELETE_STATE_NO.getCode());
        for(String userId : userIds){
            fourTemplateTacheUser.setId(null);
            fourTemplateTacheUser.setUserId(Integer.valueOf(userId));
            fourTemplateTacheUser.setTacheId(tacheId);
            Integer num = this.fourTemplateTacheUserDao.insertFourTemplateTacheUser(fourTemplateTacheUser);
            if(num != 1){
                throw new Exception("新增模板工单处理者异常！");
            }
        }
    }

    @Override
    public void deleteFourTemplateTacheUser(FourTemplateTacheUser fourTemplateTacheUser) throws Exception {
        Principal principal = PrincipalUtils.getPrincipal();
        fourTemplateTacheUser.setUpdateBy(principal.getId());
        fourTemplateTacheUser.setUpdateTime(new Date());
        fourTemplateTacheUser.setDeleteState(CommonEnum.DeleteStateEnum.DELETE_STATE_YES.getCode());
        Integer num = this.fourTemplateTacheUserDao.updateFourTemplateTacheUser(fourTemplateTacheUser);
        if(num != 1){
            throw new Exception("删除模板工单处理者异常！");
        }
    }

    @Override
    public void deleteFourTemplateTacheUserByUser(Integer userId) throws Exception {
        FourTemplateTacheUserQuery fourTemplateTacheUserQuery = new FourTemplateTacheUserQuery();
        fourTemplateTacheUserQuery.setUserId(userId);
        List<Map<String, Object>> mapList = this.fourTemplateTacheUserDao.selectFourTemplateTacheUserList(fourTemplateTacheUserQuery);
        FourTemplateTacheUser fourTemplateTacheUser = new FourTemplateTacheUser();
        for(Map<String, Object> map : mapList){
            Integer id = Integer.valueOf(map.get("id").toString());
            fourTemplateTacheUser.setId(id);
            this.deleteFourTemplateTacheUser(fourTemplateTacheUser);
        }
    }

    @Override
    public List<Map<String, Object>> listFourTemplateTacheUser(FourTemplateTacheUserQuery fourTemplateTacheUserQuery) throws Exception {
        return this.fourTemplateTacheUserDao.selectFourTemplateTacheUserList(fourTemplateTacheUserQuery);
    }
}
