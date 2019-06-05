package com.sq.server.service;


import com.sq.server.dataobject.ProductCategory;

import java.util.List;

public interface CategoryService {
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categotyTypeList);
}
