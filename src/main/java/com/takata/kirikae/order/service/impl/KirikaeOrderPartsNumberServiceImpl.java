package com.takata.kirikae.order.service.impl;

import com.takata.kirikae.order.dao.KirikaeOrderPartsNumberDao;
import com.takata.kirikae.order.domain.KirikaeOrderPartsNumber;
import com.takata.kirikae.order.query.KirikaeOrderPartsNumberQuery;
import com.takata.kirikae.order.service.KirikaeOrderPartsNumberService;
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
@Service("kirikaeOrderPartsNumberService")
public class KirikaeOrderPartsNumberServiceImpl implements KirikaeOrderPartsNumberService {

    @Resource(name = "kirikaeOrderPartsNumberDao")
    private KirikaeOrderPartsNumberDao kirikaeOrderPartsNumberDao;

    @Override
    public void addAlterationKirikaeOrderPartsNumberList(List<KirikaeOrderPartsNumber> alterationKirikaeOrderPartsNumberList) throws Exception {
        Principal principal = PrincipalUtils.getPrincipal();
        for(KirikaeOrderPartsNumber alterationKirikaeOrderPartsNumber : alterationKirikaeOrderPartsNumberList){
            alterationKirikaeOrderPartsNumber.setUpdateBy(principal.getId());
            alterationKirikaeOrderPartsNumber.setUpdateTime(new Date());
            alterationKirikaeOrderPartsNumber.setUpdateBy(principal.getId());
            alterationKirikaeOrderPartsNumber.setUpdateTime(new Date());
            alterationKirikaeOrderPartsNumber.setDeleteState(CommonEnum.DeleteStateEnum.DELETE_STATE_NO.getCode());
            Integer num = this.kirikaeOrderPartsNumberDao.insertSelective(alterationKirikaeOrderPartsNumber);
            if(num == 0){
                throw new Exception("新增品号变革异常！");
            }
        }
    }

    @Override
    public void deleteAlterationKirikaeOrderPartsNumberByKirikaeOrderId(Integer kirikaeOrderId) throws Exception {
        KirikaeOrderPartsNumberQuery kirikaeOrderPartsNumberQuery = new KirikaeOrderPartsNumberQuery();
        List<KirikaeOrderPartsNumber> alterationKirikaeOrderPartsNumberList = this.kirikaeOrderPartsNumberDao.selectAlterationKirikaeOrderPartsNumberList(kirikaeOrderPartsNumberQuery);
        Principal principal = PrincipalUtils.getPrincipal();
        for(KirikaeOrderPartsNumber alterationKirikaeOrderPartsNumber : alterationKirikaeOrderPartsNumberList){
            alterationKirikaeOrderPartsNumber.setUpdateBy(principal.getId());
            alterationKirikaeOrderPartsNumber.setUpdateTime(new Date());
            alterationKirikaeOrderPartsNumber.setDeleteState(CommonEnum.DeleteStateEnum.DELETE_STATE_YES.getCode());
            Integer num = this.kirikaeOrderPartsNumberDao.updateByPrimaryKeySelective(alterationKirikaeOrderPartsNumber);
            if(num == 0){
                throw new Exception("更新品号变革异常！");
            }
        }
    }

    @Override
    public List<KirikaeOrderPartsNumber> listAlterationKirikaeOrderPartsNumber(KirikaeOrderPartsNumberQuery kirikaeOrderPartsNumberQuery) throws Exception {
        return this.kirikaeOrderPartsNumberDao.selectAlterationKirikaeOrderPartsNumberList(kirikaeOrderPartsNumberQuery);
    }
}
