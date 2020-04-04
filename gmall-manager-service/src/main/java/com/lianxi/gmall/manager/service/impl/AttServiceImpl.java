package com.lianxi.gmall.manager.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.lianxi.gmall.bean.PmsBaseAttrInfo;
import com.lianxi.gmall.bean.PmsBaseAttrValue;
import com.lianxi.gmall.manager.mapper.AttInfoMapper;
import com.lianxi.gmall.manager.mapper.AttValueMapper;
import com.lianxi.gmall.service.AttService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class AttServiceImpl implements AttService {

    @Autowired
    AttInfoMapper attInfoMapper;

    @Autowired
    AttValueMapper attValueMapper;

    @Override
    public List<PmsBaseAttrInfo> attrInfoList(String catalog3Id) {

        PmsBaseAttrInfo attrInfo = new PmsBaseAttrInfo();
        attrInfo.setCatalog3Id(catalog3Id);
        return attInfoMapper.select(attrInfo);
    }

    @Override
    public void saveAttrInfo(PmsBaseAttrInfo pmsBaseAttrInfo) {

        if (StringUtils.isBlank(pmsBaseAttrInfo.getId())) {
            // 添加平台属性
            attInfoMapper.insertSelective(pmsBaseAttrInfo);  // insertSelective 只把有值的数据插入数据库
            // 添加属性值
            List<PmsBaseAttrValue> attrValueList = pmsBaseAttrInfo.getAttrValueList();
            for (PmsBaseAttrValue attrValue : attrValueList) {
                attrValue.setAttrId(pmsBaseAttrInfo.getId());
                attValueMapper.insertSelective(attrValue);
            }
        } else {
            // 修改平台属性
            attInfoMapper.updateByPrimaryKeySelective(pmsBaseAttrInfo);  // insertSelective 只把有值的数据插入数据库
            // 修改属性值
            List<PmsBaseAttrValue> attrValueList = pmsBaseAttrInfo.getAttrValueList();
            for (PmsBaseAttrValue attrValue : attrValueList) {
                attrValue.setAttrId(pmsBaseAttrInfo.getId());
                attValueMapper.updateByPrimaryKeySelective(attrValue);
            }
        }
    }

    @Override
    public List<PmsBaseAttrValue> getAttrValueList(String attrId) {

        PmsBaseAttrValue attrValue = new PmsBaseAttrValue();
        attrValue.setAttrId(attrId);
        return attValueMapper.select(attrValue);

    }
}
