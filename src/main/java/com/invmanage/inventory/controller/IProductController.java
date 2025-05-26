package com.invmanage.inventory.controller;

import com.invmanage.inventory.dto.DtoProduct;
import com.invmanage.inventory.dto.DtoProductIU;
import com.invmanage.inventory.baseController.RootEntity;

import java.awt.print.Pageable;
import java.util.List;

public interface IProductController {

    RootEntity<DtoProduct> createProduct(DtoProductIU dtoProductIU);
    RootEntity<DtoProduct> updateProduct(Long id, DtoProductIU dtoProductIU);
    void deleteProduct(Long id);
    RootEntity<DtoProduct> getProductById(Long id);
    RootEntity<List<DtoProduct>> getAllProducts();
}
