package com.invmanage.inventory.service;

import com.invmanage.inventory.dto.DtoProduct;
import com.invmanage.inventory.dto.DtoProductIU;

import java.util.List;

public interface IProductService {


    DtoProduct createProduct(DtoProductIU dtoProductIU);
    DtoProduct updateProduct(Long id, DtoProductIU dtoProductIU);
    void deleteProduct(Long id);
    DtoProduct getProductById(Long id);
    List<DtoProduct> getAllProducts();
}
