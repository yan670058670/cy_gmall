package com.lianxi.gmall.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lianxi.gmall.bean.PmsBaseAttrInfo;
import com.lianxi.gmall.bean.PmsBaseAttrValue;
import com.lianxi.gmall.service.AttService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@CrossOrigin
public class AttController {

    @Reference
    AttService attService;

    @RequestMapping("attrInfoList")
    @ResponseBody
    public List<PmsBaseAttrInfo> attrInfoList(String catalog3Id){
        List<PmsBaseAttrInfo> attrInfos = attService.attrInfoList(catalog3Id);
        return attrInfos;
    }


    @RequestMapping("saveAttrInfo")
    @ResponseBody
    public String saveAttrInfo(@RequestBody PmsBaseAttrInfo pmsBaseAttrInfo){
        attService.saveAttrInfo(pmsBaseAttrInfo);
        return "success";
    }

    @RequestMapping("getAttrValueList")
    @ResponseBody
    public List<PmsBaseAttrValue> getAttrValueList(String attrId){

        List<PmsBaseAttrValue> attrValues = attService.getAttrValueList(attrId);

        return attrValues;
    }


}
