package com.invmanage.inventory.controllerimpl;

import com.invmanage.inventory.baseController.BaseController;
import com.invmanage.inventory.controller.IProductController;
import com.invmanage.inventory.dto.DtoProduct;
import com.invmanage.inventory.dto.DtoProductIU;
import com.invmanage.inventory.baseController.RootEntity;
import com.invmanage.inventory.service.IProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/products")
public class ProductController extends BaseController implements IProductController {

    @Autowired
    private IProductService productService;

    @PostMapping(path ="/post")
    @Override
    public RootEntity<DtoProduct> createProduct(@RequestBody @Valid  DtoProductIU dtoProductIU) {
        return ok(productService.createProduct(dtoProductIU));
    }

    @PutMapping(path = "/update/{id}")
    @Override
    public RootEntity<DtoProduct> updateProduct(@PathVariable(name = "id") Long id, @RequestBody @Valid DtoProductIU dtoProductIU) {
        return ok(productService.updateProduct(id, dtoProductIU));
    }

    @DeleteMapping(path = "/delete/{id}")
    @Override
    public void deleteProduct(@PathVariable(name = "id") Long id) {
        productService.deleteProduct(id);
    }

    @GetMapping(path = "/get/{id}")
    @Override
    public RootEntity<DtoProduct> getProductById(@PathVariable(name = "id") Long id) {
        return ok(productService.getProductById(id));
    }

    @GetMapping(path = "/")
    @Override
    public RootEntity<List<DtoProduct>> getAllProducts() {
        return ok(productService.getAllProducts());
    }
}