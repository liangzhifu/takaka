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
    public void addKirikaeOrderPartsNumberList(List<KirikaeOrderPartsNumber> kirikaeOrderPartsNumberList) throws Exception {
        Principal principal = PrincipalUtils.getPrincipal();
        for(KirikaeOrderPartsNumber kirikaeOrderPartsNumber : kirikaeOrderPartsNumberList){
            kirikaeOrderPartsNumber.setUpdateBy(principal.getId());
            kirikaeOrderPartsNumber.setUpdateTime(new Date());
            kirikaeOrderPartsNumber.setUpdateBy(principal.getId());
            kirikaeOrderPartsNumber.setUpdateTime(new Date());
            kirikaeOrderPartsNumber.setDeleteState(CommonEnum.DeleteStateEnum.DELETE_STATE_NO.getCode());
            Integer num = this.kirikaeOrderPartsNumberDao.insertSelective(kirikaeOrderPartsNumber);
            if(num == 0){
                throw new Exception("新增品号变革异常！");
            }
        }
    }

    @Override
    public void deleteKirikaeOrderPartsNumberByKirikaeOrderId(Integer kirikaeOrderId) throws Exception {
        KirikaeOrderPartsNumberQuery kirikaeOrderPartsNumberQuery = new KirikaeOrderPartsNumberQuery();
        List<KirikaeOrderPartsNumber> kirikaeOrderPartsNumberList = this.kirikaeOrderPartsNumberDao.selectKirikaeOrderPartsNumberList(kirikaeOrderPartsNumberQuery);
        Principal principal = PrincipalUtils.getPrincipal();
        for(KirikaeOrderPartsNumber kirikaeOrderPartsNumber : kirikaeOrderPartsNumberList){
            kirikaeOrderPartsNumber.setUpdateBy(principal.getId());
            kirikaeOrderPartsNumber.setUpdateTime(new Date());
            kirikaeOrderPartsNumber.setDeleteState(CommonEnum.DeleteStateEnum.DELETE_STATE_YES.getCode());
            Integer num = this.kirikaeOrderPartsNumberDao.updateByPrimaryKeySelective(kirikaeOrderPartsNumber);
            if(num == 0){
                throw new Exception("更新品号变革异常！");
            }
        }
    }

    @Override
    public List<KirikaeOrderPartsNumber> listKirikaeOrderPartsNumber(KirikaeOrderPartsNumberQuery kirikaeOrderPartsNumberQuery) throws Exception {
        return this.kirikaeOrderPartsNumberDao.selectKirikaeOrderPartsNumberList(kirikaeOrderPartsNumberQuery);
    }
}
