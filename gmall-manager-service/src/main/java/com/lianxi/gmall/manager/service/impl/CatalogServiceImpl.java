package com.lianxi.gmall.manager.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.lianxi.gmall.bean.PmsBaseCatalog1;
import com.lianxi.gmall.bean.PmsBaseCatalog2;
import com.lianxi.gmall.bean.PmsBaseCatalog3;
import com.lianxi.gmall.manager.mapper.PmsBaseCatalog1Mapper;
import com.lianxi.gmall.manager.mapper.PmsBaseCatalog2Mapper;
import com.lianxi.gmall.manager.mapper.PmsBaseCatalog3Mapper;
import com.lianxi.gmall.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Service
public class CatalogServiceImpl implements CatalogService {

    @Autowired
    PmsBaseCatalog1Mapper pmsBaseCatalog1Mapper;

    @Autowired
    PmsBaseCatalog2Mapper pmsBaseCatalog2Mapper;

    @Autowired
    PmsBaseCatalog3Mapper pmsBaseCatalog3Mapper;


    @Override
    public List<PmsBaseCatalog1> getCatalog1() {

        return pmsBaseCatalog1Mapper.selectAll();

    }

    @Override
    public List<PmsBaseCatalog2> getCatalog2(String catalog1Id) {
        PmsBaseCatalog2 catalog2 = new PmsBaseCatalog2();
        catalog2.setCatalog1Id(catalog1Id);
        List<PmsBaseCatalog2> pmsBaseCatalog2s = pmsBaseCatalog2Mapper.select(catalog2);

        return pmsBaseCatalog2s;
    }

    @Override
    public List<PmsBaseCatalog3> getCatalog3(String catalog2Id) {

        PmsBaseCatalog3 catalog3 = new PmsBaseCatalog3();
        catalog3.setCatalog2Id(catalog2Id);
        return pmsBaseCatalog3Mapper.select(catalog3);
    }
}
