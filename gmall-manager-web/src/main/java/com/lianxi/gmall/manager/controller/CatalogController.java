package com.lianxi.gmall.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lianxi.gmall.bean.PmsBaseCatalog1;
import com.lianxi.gmall.service.CatalogService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class CatalogController {

    @Reference
    CatalogService catalogService;

    @RequestMapping("getCatalog1")
    public List<PmsBaseCatalog1> getCatalog1(){

        List<PmsBaseCatalog1> catalog1s = catalogService.getCatalog1();

        return catalog1s;
    }

}
