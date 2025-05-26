package com.invmanage.inventory.service;

import com.invmanage.inventory.dto.DtoCategory;
import com.invmanage.inventory.dto.DtoCategoryIU;

import java.util.List;

public interface ICategoryService {

    DtoCategory createCategory(DtoCategoryIU dtoCategoryIU);
    DtoCategory updateCategory(Long id, DtoCategoryIU dtoCategoryIU);
    void deleteCategory(Long id);
    DtoCategory getCategoryById(Long id);
    List<DtoCategory> getAllCategories();
}
