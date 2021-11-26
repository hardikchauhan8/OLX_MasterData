package com.olx.utils;

import com.olx.dto.Category;
import com.olx.entity.CategoryEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;

import java.util.List;
import java.util.stream.Collectors;

public class CategoryConverter {
    public static Category convertEntityToDto(ModelMapper modelMapper, CategoryEntity categoryEntity) {
        TypeMap<CategoryEntity, Category> typeMap = modelMapper.typeMap(CategoryEntity.class, Category.class);
        typeMap.addMappings(mapper -> mapper.map(CategoryEntity::getName, Category::setName));
        return modelMapper.map(categoryEntity, Category.class);
    }

    public static CategoryEntity convertDtoToEntity(ModelMapper modelMapper, Category category) {
        TypeMap<Category, CategoryEntity> typeMap = modelMapper.typeMap(Category.class, CategoryEntity.class);
        typeMap.addMappings(mapper -> mapper.map(Category::getName, CategoryEntity::setName));
        return modelMapper.map(category, CategoryEntity.class);
    }

    public static List<Category> convertListEntityToDto(ModelMapper modelMapper, List<CategoryEntity> categoryEntityList) {
        TypeMap<CategoryEntity, Category> typeMap = modelMapper.typeMap(CategoryEntity.class, Category.class);
        typeMap.addMappings(mapper -> mapper.map(CategoryEntity::getName, Category::setName));
        return categoryEntityList
                .stream()
                .map(categoryEntity -> modelMapper.map(categoryEntity, Category.class))
                .collect(Collectors.toList());
    }

    public static List<CategoryEntity> convertListDtoToEntity(ModelMapper modelMapper, List<Category> categoryList) {
        TypeMap<Category, CategoryEntity> typeMap = modelMapper.typeMap(Category.class, CategoryEntity.class);
        typeMap.addMappings(mapper -> mapper.map(Category::getName, CategoryEntity::setName));
        return categoryList
                .stream()
                .map(category -> modelMapper.map(category, CategoryEntity.class))
                .collect(Collectors.toList());
    }
}
