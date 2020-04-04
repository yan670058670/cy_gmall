package com.lianxi.gmall.service;

import com.lianxi.gmall.bean.PmsBaseAttrInfo;
import com.lianxi.gmall.bean.PmsBaseAttrValue;

import java.util.List;

public interface AttService {

    // 获取三级分类下的属性信息
    List<PmsBaseAttrInfo> attrInfoList(String catalog3Id);

    // 保存平台属性信息
    void saveAttrInfo(PmsBaseAttrInfo pmsBaseAttrInfo);

    // 获取属值列表用于修改
    List<PmsBaseAttrValue> getAttrValueList(String attrId);
}
