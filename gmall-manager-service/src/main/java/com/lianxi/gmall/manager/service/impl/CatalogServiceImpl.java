package com.lianxi.gmall.manager.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.lianxi.gmall.bean.PmsBaseCatalog1;
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
}
