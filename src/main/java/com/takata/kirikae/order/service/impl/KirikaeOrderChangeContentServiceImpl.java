package com.takata.kirikae.order.service.impl;

import com.takata.kirikae.order.dao.KirikaeOrderChangeContentDao;
import com.takata.kirikae.order.domain.KirikaeOrderChangeContent;
import com.takata.kirikae.order.query.KirikaeOrderChangeContentQuery;
import com.takata.kirikae.order.service.KirikaeOrderChangeContentService;
import com.takata.common.constant.CommonEnum;
import com.takata.common.shiro.Principal;
import com.takata.common.shiro.PrincipalUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author lzf
 **/
@Service("alterationKirikaeOrderChangeContentService")
public class KirikaeOrderChangeContentServiceImpl implements KirikaeOrderChangeContentService {

    @Resource(name = "alterationKirikaeOrderChangeContentDao")
    private KirikaeOrderChangeContentDao kirikaeOrderChangeContentDao;

    @Override
    public void addAlterationKirikaeOrderChangeContentList(List<KirikaeOrderChangeContent> alterationKirikaeOrderChangeContentList) throws Exception {
        Principal principal = PrincipalUtils.getPrincipal();
        for(KirikaeOrderChangeContent alterationKirikaeOrderChangeContent : alterationKirikaeOrderChangeContentList){
            alterationKirikaeOrderChangeContent.setCreateBy(principal.getId());
            alterationKirikaeOrderChangeContent.setCreateTime(new Date());
            alterationKirikaeOrderChangeContent.setUpdateBy(principal.getId());
            alterationKirikaeOrderChangeContent.setUpdateTime(new Date());
            alterationKirikaeOrderChangeContent.setDeleteState(CommonEnum.DeleteStateEnum.DELETE_STATE_NO.getCode());
            Integer num = this.kirikaeOrderChangeContentDao.insertSelective(alterationKirikaeOrderChangeContent);
            if(num == 0){
                throw new Exception("新增切替单变更内容异常！");
            }
        }
    }

    @Override
    public void deleteAlterationKirikaeOrderChangeContentByKirikaeOrderId(Integer kirikaeOrderId) throws Exception {
        Principal principal = PrincipalUtils.getPrincipal();
        KirikaeOrderChangeContentQuery kirikaeOrderChangeContentQuery = new KirikaeOrderChangeContentQuery();
        kirikaeOrderChangeContentQuery.setKirikaeOrderId(kirikaeOrderId);
        List<KirikaeOrderChangeContent> alterationKirikaeOrderChangeContentList = this.kirikaeOrderChangeContentDao.selectAlterationKirikaeOrderChangeContentList(kirikaeOrderChangeContentQuery);
        for(KirikaeOrderChangeContent alterationKirikaeOrderChangeContent : alterationKirikaeOrderChangeContentList){
            alterationKirikaeOrderChangeContent.setUpdateBy(principal.getId());
            alterationKirikaeOrderChangeContent.setUpdateTime(new Date());
            alterationKirikaeOrderChangeContent.setDeleteState(CommonEnum.DeleteStateEnum.DELETE_STATE_YES.getCode());
            Integer num = this.kirikaeOrderChangeContentDao.updateByPrimaryKeySelective(alterationKirikaeOrderChangeContent);
            if(num == 0){
                throw new Exception("更新切替单变更内容异常！");
            }
        }
    }

    @Override
    public List<KirikaeOrderChangeContent> listAlterationKirikaeOrderChangeContent(KirikaeOrderChangeContentQuery kirikaeOrderChangeContentQuery) throws Exception {
        return this.kirikaeOrderChangeContentDao.selectAlterationKirikaeOrderChangeContentList(kirikaeOrderChangeContentQuery);
    }

}
