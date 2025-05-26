package com.invmanage.inventory.controller;

import com.invmanage.inventory.dto.DtoCategory;
import com.invmanage.inventory.dto.DtoCategoryIU;
import com.invmanage.inventory.baseController.RootEntity;

import java.util.List;

public interface ICategoryController {

    RootEntity<DtoCategory> createCategory(DtoCategoryIU dtoCategoryIU);
    RootEntity<DtoCategory> updateCategory(Long id, DtoCategoryIU dtoCategoryIU);
    void deleteCategory(Long id);
    RootEntity<DtoCategory> getCategoryById(Long id);
    RootEntity<List<DtoCategory>> getAllCategories();

}
