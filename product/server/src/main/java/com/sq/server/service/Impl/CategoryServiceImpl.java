package com.sq.server.service.Impl;

import com.sq.server.dataobject.ProductCategory;
import com.sq.server.repository.ProductCategoryRepository;
import com.sq.server.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private ProductCategoryRepository repository;

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categotyTypeList) {
        return repository.findByCategoryTypeIn(categotyTypeList);
    }
}
