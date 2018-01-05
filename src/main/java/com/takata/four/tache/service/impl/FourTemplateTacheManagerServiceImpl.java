package com.takata.four.tache.service.impl;

import com.takata.four.tache.dao.FourTemplateTacheManagerDao;
import com.takata.four.tache.domain.FourTemplateTacheManager;
import com.takata.four.tache.query.FourTemplateTacheManagerQuery;
import com.takata.four.tache.service.FourTemplateTacheManagerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author lzf
 **/
@Service("fourTemplateTacheManagerService")
public class FourTemplateTacheManagerServiceImpl implements FourTemplateTacheManagerService {

    @Resource(name = "fourTemplateTacheManagerDao")
    private FourTemplateTacheManagerDao fourTemplateTacheManagerDao;

    @Override
    public void addFourTemplateTacheManager(Integer tacheId, String[] userIds) throws Exception {
        FourTemplateTacheManager fourTemplateTacheManager = new FourTemplateTacheManager();
        for(String userId : userIds){
            fourTemplateTacheManager.setId(null);
            fourTemplateTacheManager.setTacheId(tacheId);
            fourTemplateTacheManager.setUserId(Integer.valueOf(userId));
            Integer num = this.fourTemplateTacheManagerDao.insertFourTemplateTacheManager(fourTemplateTacheManager);
            if(num != 1){
                throw new Exception("增加模板工单管理者异常！");
            }
        }
    }

    @Override
    public void deleteFourTemplateTacheManager(FourTemplateTacheManager fourTemplateTacheManager) throws Exception {
        Integer num = this.fourTemplateTacheManagerDao.deleteFourTemplateTacheManager(fourTemplateTacheManager);
        if(num != 1){
            throw new Exception("删除模板工单管理者异常！");
        }
    }

    @Override
    public void deleteFourTemplateTacheManagerByUser(Integer userId) throws Exception {
        FourTemplateTacheManagerQuery fourTemplateTacheManagerQuery = new FourTemplateTacheManagerQuery();
        fourTemplateTacheManagerQuery.setUserId(userId);
        List<Map<String, Object>> mapList = this.fourTemplateTacheManagerDao.selectFourTemplateTacheManagerList(fourTemplateTacheManagerQuery);
        FourTemplateTacheManager fourTemplateTacheManager = new FourTemplateTacheManager();
        for(Map<String, Object> map : mapList){
            Integer id = Integer.valueOf(map.get("id").toString());
            fourTemplateTacheManager.setId(id);
            this.deleteFourTemplateTacheManager(fourTemplateTacheManager);
        }
    }

    @Override
    public List<Map<String, Object>> listFourTemplateTacheManager(FourTemplateTacheManagerQuery fourTemplateTacheManagerQuery) throws Exception {
        return this.fourTemplateTacheManagerDao.selectFourTemplateTacheManagerList(fourTemplateTacheManagerQuery);
    }
}
