package com.invmanage.inventory.serviceimpl;


import com.invmanage.inventory.dto.DtoProduct;
import com.invmanage.inventory.dto.DtoProductIU;
import com.invmanage.inventory.entity.Category;
import com.invmanage.inventory.entity.Product;
import com.invmanage.inventory.exception.BaseException;
import com.invmanage.inventory.exception.ErrorMessage;
import com.invmanage.inventory.exception.MessageType;
import com.invmanage.inventory.repository.ICategoryRepository;
import com.invmanage.inventory.repository.IProductRepository;
import com.invmanage.inventory.service.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service

public class ProductServiceImpl implements IProductService {

    @Autowired
    private ICategoryRepository categoryRepository;

    @Autowired
    private IProductRepository productRepository;


    @Override
    public DtoProduct createProduct(DtoProductIU dtoProductIU) {
        Long id = dtoProductIU.getCategoryId();
        Optional<Category> category = categoryRepository.findById(id);
        if(category.isPresent()){
            Product product = new Product();
            BeanUtils.copyProperties(dtoProductIU, product);
            product.setCategory(category.get());
            productRepository.save(product);
            DtoProduct dtoProduct = new DtoProduct();
            BeanUtils.copyProperties(product, dtoProduct);
            return dtoProduct;
        }else{
            throw new BaseException(new ErrorMessage(MessageType.NO_CATEGORY_FOUND, id.toString()));
        }
    }

    @Override
    public DtoProduct updateProduct(Long id, DtoProductIU dtoProductIU) {
        Optional<Product> productOptional = productRepository.findById(id);
        if(productOptional.isPresent()){
            Long categoryId = dtoProductIU.getCategoryId();
            Optional<Category> category = categoryRepository.findById(categoryId);
            if(category.isPresent()){
                Product product = new Product();
                BeanUtils.copyProperties(dtoProductIU, product);
                product.setCategory(category.get());
                product.setId(id);
                productRepository.save(product);
                DtoProduct dtoProduct = new DtoProduct();
                BeanUtils.copyProperties(product, dtoProduct);
                return dtoProduct;
            }
        }
        throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST, id.toString()));
    }

    @Override
    public void deleteProduct(Long id) {
        Optional<Product> productOptional = productRepository.findById(id);
        productRepository.delete(productOptional.get());
    }

    @Override
    public DtoProduct getProductById(Long id) {
        Optional<Product> productOptional = productRepository.findById(id);
        DtoProduct dtoProduct = new DtoProduct();
        BeanUtils.copyProperties(productOptional.get(), dtoProduct);
        return dtoProduct;
    }

    @Override
    public List<DtoProduct> getAllProducts() {
        List<Product> productList = productRepository.findAll();
        List<DtoProduct> dtoProductList = new ArrayList<>();
        for(Product product : productList){
            DtoProduct dtoProduct = new DtoProduct();
            BeanUtils.copyProperties(product, dtoProduct);
            dtoProductList.add(dtoProduct);
        }
        return dtoProductList;
    }
}
