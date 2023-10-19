package com.blogApp.services.impl;

import com.blogApp.entites.Category;
import com.blogApp.exceptions.ResourceNotFoundException;
import com.blogApp.payload.CategoryDto;
import com.blogApp.repositories.CategoryRepo;
import com.blogApp.services.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {


    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        Category category = this.modelMapper.map(categoryDto, Category.class);
        Category addCat = this.categoryRepo.save(category);
        return this.modelMapper.map(addCat,CategoryDto.class);
    }

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {
       Category category = this.categoryRepo.findById(categoryId)
               .orElseThrow(()-> new ResourceNotFoundException("Category", "categoryId", categoryId));

        category.setCategoryTitle(categoryDto.getCategoryTitle());
        category.setCategoryDescription(categoryDto.getCategoryDescription());

        Category updateCat = this.categoryRepo.save(category);

        return this.modelMapper.map(updateCat,CategoryDto.class);
    }

    @Override
    public void deleteCategory(Integer categoryId) {
        Category category =this.categoryRepo.findById(categoryId)
                .orElseThrow(()-> new ResourceNotFoundException("Category", "CategoryId", categoryId));
        this.categoryRepo.delete(category);

    }

    @Override
    public CategoryDto getCategory(Integer categoryId) {
       Category category = this.categoryRepo.findById(categoryId)
               .orElseThrow(()-> new ResourceNotFoundException("Category", "CategoryId", categoryId));


        return this.modelMapper.map(category,CategoryDto.class);
    }

    @Override
    public List<CategoryDto> getCategories() {
        List<Category> categories = this.categoryRepo.findAll();
        List<CategoryDto> catDto=categories.stream().map((cat)-> this.modelMapper.map(cat, CategoryDto.class)).collect((Collectors.toList()));
        return catDto;
    }
}
