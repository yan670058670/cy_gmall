package com.lianxi.gmall.service;

import com.lianxi.gmall.bean.PmsBaseCatalog1;
import com.lianxi.gmall.bean.PmsBaseCatalog2;
import com.lianxi.gmall.bean.PmsBaseCatalog3;

import java.util.List;

public interface CatalogService {

    // 获取一级分类
    List<PmsBaseCatalog1> getCatalog1();

    // 获取二级分类
    List<PmsBaseCatalog2> getCatalog2(String catalog1Id);

    // 获取三级分类
    List<PmsBaseCatalog3> getCatalog3(String catalog2Id);
}
