package com.takata.alteration.order.service.impl;

import com.takata.alteration.order.dao.AlterationKirikaeOrderPartsNumberDao;
import com.takata.alteration.order.domain.AlterationKirikaeOrderPartsNumber;
import com.takata.alteration.order.query.AlterationKirikaeOrderPartsNumberQuery;
import com.takata.alteration.order.service.AlterationKirikaeOrderPartsNumberService;
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
@Service("alterationKirikaeOrderPartsNumberService")
public class AlterationKirikaeOrderPartsNumberServiceImpl implements AlterationKirikaeOrderPartsNumberService {

    @Resource(name = "alterationKirikaeOrderPartsNumberDao")
    private AlterationKirikaeOrderPartsNumberDao alterationKirikaeOrderPartsNumberDao;

    @Override
    public void addAlterationKirikaeOrderPartsNumberList(List<AlterationKirikaeOrderPartsNumber> alterationKirikaeOrderPartsNumberList) throws Exception {
        Principal principal = PrincipalUtils.getPrincipal();
        for(AlterationKirikaeOrderPartsNumber alterationKirikaeOrderPartsNumber : alterationKirikaeOrderPartsNumberList){
            alterationKirikaeOrderPartsNumber.setUpdateBy(principal.getId());
            alterationKirikaeOrderPartsNumber.setUpdateTime(new Date());
            alterationKirikaeOrderPartsNumber.setUpdateBy(principal.getId());
            alterationKirikaeOrderPartsNumber.setUpdateTime(new Date());
            alterationKirikaeOrderPartsNumber.setDeleteState(CommonEnum.DeleteStateEnum.DELETE_STATE_NO.getCode());
            Integer num = this.alterationKirikaeOrderPartsNumberDao.insertSelective(alterationKirikaeOrderPartsNumber);
            if(num == 0){
                throw new Exception("新增品号变革异常！");
            }
        }
    }

    @Override
    public void deleteAlterationKirikaeOrderPartsNumberByKirikaeOrderId(Integer kirikaeOrderId) throws Exception {
        AlterationKirikaeOrderPartsNumberQuery alterationKirikaeOrderPartsNumberQuery = new AlterationKirikaeOrderPartsNumberQuery();
        List<AlterationKirikaeOrderPartsNumber> alterationKirikaeOrderPartsNumberList = this.alterationKirikaeOrderPartsNumberDao.selectAlterationKirikaeOrderPartsNumberList(alterationKirikaeOrderPartsNumberQuery);
        Principal principal = PrincipalUtils.getPrincipal();
        for(AlterationKirikaeOrderPartsNumber alterationKirikaeOrderPartsNumber : alterationKirikaeOrderPartsNumberList){
            alterationKirikaeOrderPartsNumber.setUpdateBy(principal.getId());
            alterationKirikaeOrderPartsNumber.setUpdateTime(new Date());
            alterationKirikaeOrderPartsNumber.setDeleteState(CommonEnum.DeleteStateEnum.DELETE_STATE_YES.getCode());
            Integer num = this.alterationKirikaeOrderPartsNumberDao.updateByPrimaryKeySelective(alterationKirikaeOrderPartsNumber);
            if(num == 0){
                throw new Exception("更新品号变革异常！");
            }
        }
    }

    @Override
    public List<AlterationKirikaeOrderPartsNumber> listAlterationKirikaeOrderPartsNumber(AlterationKirikaeOrderPartsNumberQuery alterationKirikaeOrderPartsNumberQuery) throws Exception {
        return this.alterationKirikaeOrderPartsNumberDao.selectAlterationKirikaeOrderPartsNumberList(alterationKirikaeOrderPartsNumberQuery);
    }
}
