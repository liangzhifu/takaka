package com.takata.alteration.order.service;

import com.takata.alteration.order.domain.AlterationFourOrderAttr;

import java.util.List;

public interface AlterationFourOrderAttrService {

    /**
     * 增加4M变更单属性
     * @param alterationFourOrderAttr 4M变更单属性实体
     * @throws Exception 异常
     */
    void addAlterationFourOrderAttr(AlterationFourOrderAttr alterationFourOrderAttr) throws Exception;

    /**
     * 增加4M变更单属性列表
     * @param alterationFourOrderAttrList 4M变更单属性实体列表
     * @throws Exception 异常
     */
    void addAlterationFourOrderAttrList(List<AlterationFourOrderAttr> alterationFourOrderAttrList) throws Exception;

}
