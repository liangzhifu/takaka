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
@Service("kirikaeOrderChangeContentService")
public class KirikaeOrderChangeContentServiceImpl implements KirikaeOrderChangeContentService {

    @Resource(name = "kirikaeOrderChangeContentDao")
    private KirikaeOrderChangeContentDao kirikaeOrderChangeContentDao;

    @Override
    public void addKirikaeOrderChangeContentList(List<KirikaeOrderChangeContent> kirikaeOrderChangeContentList) throws Exception {
        Principal principal = PrincipalUtils.getPrincipal();
        for(KirikaeOrderChangeContent kirikaeOrderChangeContent : kirikaeOrderChangeContentList){
            kirikaeOrderChangeContent.setCreateBy(principal.getId());
            kirikaeOrderChangeContent.setCreateTime(new Date());
            kirikaeOrderChangeContent.setUpdateBy(principal.getId());
            kirikaeOrderChangeContent.setUpdateTime(new Date());
            kirikaeOrderChangeContent.setDeleteState(CommonEnum.DeleteStateEnum.DELETE_STATE_NO.getCode());
            Integer num = this.kirikaeOrderChangeContentDao.insertSelective(kirikaeOrderChangeContent);
            if(num == 0){
                throw new Exception("新增切替单变更内容异常！");
            }
        }
    }

    @Override
    public void deleteKirikaeOrderChangeContentByKirikaeOrderId(Integer kirikaeOrderId) throws Exception {
        Principal principal = PrincipalUtils.getPrincipal();
        KirikaeOrderChangeContentQuery kirikaeOrderChangeContentQuery = new KirikaeOrderChangeContentQuery();
        kirikaeOrderChangeContentQuery.setKirikaeOrderId(kirikaeOrderId);
        List<KirikaeOrderChangeContent> kirikaeOrderChangeContentList = this.kirikaeOrderChangeContentDao.selectKirikaeOrderChangeContentList(kirikaeOrderChangeContentQuery);
        for(KirikaeOrderChangeContent kirikaeOrderChangeContent : kirikaeOrderChangeContentList){
            kirikaeOrderChangeContent.setUpdateBy(principal.getId());
            kirikaeOrderChangeContent.setUpdateTime(new Date());
            kirikaeOrderChangeContent.setDeleteState(CommonEnum.DeleteStateEnum.DELETE_STATE_YES.getCode());
            Integer num = this.kirikaeOrderChangeContentDao.updateByPrimaryKeySelective(kirikaeOrderChangeContent);
            if(num == 0){
                throw new Exception("更新切替单变更内容异常！");
            }
        }
    }

    @Override
    public List<KirikaeOrderChangeContent> listKirikaeOrderChangeContent(KirikaeOrderChangeContentQuery kirikaeOrderChangeContentQuery) throws Exception {
        return this.kirikaeOrderChangeContentDao.selectKirikaeOrderChangeContentList(kirikaeOrderChangeContentQuery);
    }

}
