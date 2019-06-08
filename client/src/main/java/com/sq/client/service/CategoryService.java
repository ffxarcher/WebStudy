package com.sq.client.service;

import com.sq.client.dataobject.ProductCategory;

import java.util.List;

public interface CategoryService {
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categotyTypeList);
}
