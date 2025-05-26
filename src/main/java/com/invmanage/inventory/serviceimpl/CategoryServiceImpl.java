package com.invmanage.inventory.serviceimpl;

import com.invmanage.inventory.dto.DtoCategory;
import com.invmanage.inventory.dto.DtoCategoryIU;
import com.invmanage.inventory.entity.Category;
import com.invmanage.inventory.exception.BaseException;
import com.invmanage.inventory.exception.ErrorMessage;
import com.invmanage.inventory.exception.MessageType;
import com.invmanage.inventory.repository.ICategoryRepository;
import com.invmanage.inventory.service.ICategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    private ICategoryRepository categoryRepository;


    @Override
    public DtoCategory createCategory(DtoCategoryIU dtoCategoryIU) {
        Category category = new Category();
        BeanUtils.copyProperties(dtoCategoryIU, category);
        Category dbCategory= categoryRepository.save(category);
        DtoCategory dtoCategory = new DtoCategory();
        BeanUtils.copyProperties(dbCategory, dtoCategory);
        return dtoCategory;
    }

    @Override
    public DtoCategory updateCategory(Long id, DtoCategoryIU dtoCategoryIU) {
        DtoCategory dtoCategory = getCategoryById(id);
        if(dtoCategory != null){
            Category category = new Category();
            category.setId(id);
            BeanUtils.copyProperties(dtoCategoryIU, category);
            categoryRepository.save(category);
            DtoCategory dtoCategory1 = new DtoCategory();
            BeanUtils.copyProperties(category, dtoCategory1);
            return dtoCategory1;
        }else{
            throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST, id.toString()));
        }
    }

    @Override
    public void deleteCategory(Long id) {
        Optional<Category> category = categoryRepository.findById(id);
        if(category.isPresent()){
            categoryRepository.delete(category.get());
        }else {
            throw new BaseException(new ErrorMessage(MessageType.NO_CATEGORY_FOUND, id.toString()));
        }
    }

    @Override
    public DtoCategory getCategoryById(Long id) {
        Optional<Category> category = categoryRepository.findById(id);
        if(category.isPresent()){
           DtoCategory dtoCategory = new DtoCategory();
           BeanUtils.copyProperties(category.get(), dtoCategory);
           return dtoCategory;
        }else{
            throw new BaseException(new ErrorMessage(MessageType.NO_CATEGORY_FOUND, id.toString()));
        }
    }

    @Override
    public List<DtoCategory> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        List<DtoCategory> dtoCategories = new ArrayList<>();
        for (Category category : categories) {
            DtoCategory dtoCategory = new DtoCategory();
            BeanUtils.copyProperties(category, dtoCategory);
            dtoCategories.add(dtoCategory);
        }
        return dtoCategories;
    }
}
