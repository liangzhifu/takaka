package com.takata.alteration.order.service.impl;

import com.takata.alteration.order.dao.AlterationKirikaeOrderChangeContentDao;
import com.takata.alteration.order.domain.AlterationKirikaeOrderChangeContent;
import com.takata.alteration.order.query.AlterationKirikaeOrderChangeContentQuery;
import com.takata.alteration.order.service.AlterationKirikaeOrderChangeContentService;
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
public class AlterationKirikaeOrderChangeContentServiceImpl implements AlterationKirikaeOrderChangeContentService {

    @Resource(name = "alterationKirikaeOrderChangeContentDao")
    private AlterationKirikaeOrderChangeContentDao alterationKirikaeOrderChangeContentDao;

    @Override
    public void addAlterationKirikaeOrderChangeContentList(List<AlterationKirikaeOrderChangeContent> alterationKirikaeOrderChangeContentList) throws Exception {
        Principal principal = PrincipalUtils.getPrincipal();
        for(AlterationKirikaeOrderChangeContent alterationKirikaeOrderChangeContent : alterationKirikaeOrderChangeContentList){
            alterationKirikaeOrderChangeContent.setCreateBy(principal.getId());
            alterationKirikaeOrderChangeContent.setCreateTime(new Date());
            alterationKirikaeOrderChangeContent.setUpdateBy(principal.getId());
            alterationKirikaeOrderChangeContent.setUpdateTime(new Date());
            alterationKirikaeOrderChangeContent.setDeleteState(CommonEnum.DeleteStateEnum.DELETE_STATE_NO.getCode());
            Integer num = this.alterationKirikaeOrderChangeContentDao.insertSelective(alterationKirikaeOrderChangeContent);
            if(num == 0){
                throw new Exception("新增切替单变更内容异常！");
            }
        }
    }

    @Override
    public void deleteAlterationKirikaeOrderChangeContentByKirikaeOrderId(Integer kirikaeOrderId) throws Exception {
        Principal principal = PrincipalUtils.getPrincipal();
        AlterationKirikaeOrderChangeContentQuery alterationKirikaeOrderChangeContentQuery = new AlterationKirikaeOrderChangeContentQuery();
        alterationKirikaeOrderChangeContentQuery.setKirikaeOrderId(kirikaeOrderId);
        List<AlterationKirikaeOrderChangeContent> alterationKirikaeOrderChangeContentList = this.alterationKirikaeOrderChangeContentDao.selectAlterationKirikaeOrderChangeContentList(alterationKirikaeOrderChangeContentQuery);
        for(AlterationKirikaeOrderChangeContent alterationKirikaeOrderChangeContent : alterationKirikaeOrderChangeContentList){
            alterationKirikaeOrderChangeContent.setUpdateBy(principal.getId());
            alterationKirikaeOrderChangeContent.setUpdateTime(new Date());
            alterationKirikaeOrderChangeContent.setDeleteState(CommonEnum.DeleteStateEnum.DELETE_STATE_YES.getCode());
            Integer num = this.alterationKirikaeOrderChangeContentDao.updateByPrimaryKeySelective(alterationKirikaeOrderChangeContent);
            if(num == 0){
                throw new Exception("更新切替单变更内容异常！");
            }
        }
    }

    @Override
    public List<AlterationKirikaeOrderChangeContent> listAlterationKirikaeOrderChangeContent(AlterationKirikaeOrderChangeContentQuery alterationKirikaeOrderChangeContentQuery) throws Exception {
        return this.alterationKirikaeOrderChangeContentDao.selectAlterationKirikaeOrderChangeContentList(alterationKirikaeOrderChangeContentQuery);
    }

}
