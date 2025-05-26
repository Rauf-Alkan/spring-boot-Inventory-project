package com.invmanage.inventory.controllerimpl;

import com.invmanage.inventory.baseController.BaseController;
import com.invmanage.inventory.controller.ICategoryController;
import com.invmanage.inventory.dto.DtoCategory;
import com.invmanage.inventory.dto.DtoCategoryIU;
import com.invmanage.inventory.baseController.RootEntity;
import com.invmanage.inventory.service.ICategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/categories")
public class CategoryController extends BaseController implements ICategoryController {

    @Autowired
    private ICategoryService categoryService;


    @PostMapping(path = "/post")
    @Override
    public RootEntity<DtoCategory> createCategory(@Valid @RequestBody DtoCategoryIU dtoCategoryIU) {
        return ok(categoryService.createCategory(dtoCategoryIU));
    }

    @PutMapping(path = "/update/{id}")
    @Override
    public RootEntity<DtoCategory> updateCategory(@PathVariable(name = "id") Long id, @Valid @RequestBody DtoCategoryIU dtoCategoryIU) {
        return ok(categoryService.updateCategory(id, dtoCategoryIU));
    }

    @DeleteMapping(path = "/delete/{id}")
    @Override
    public void deleteCategory(@PathVariable(name = "id") Long id) {
        categoryService.deleteCategory(id);
    }

    @GetMapping(path = "/get/{id}")
    @Override
    public RootEntity<DtoCategory> getCategoryById(@PathVariable(name = "id") Long id) {
        return ok(categoryService.getCategoryById(id));
    }

    @GetMapping
    @Override
    public RootEntity<List<DtoCategory>> getAllCategories() {
        return ok(categoryService.getAllCategories());
    }
}
