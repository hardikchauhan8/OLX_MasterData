package com.olx.service;

import com.olx.dto.Category;
import com.olx.dto.Status;
import com.olx.exception.InvalidCategoryIdException;
import com.olx.exception.InvalidStatusIdException;
import com.olx.repository.CategoriesRepository;
import com.olx.repository.StatusRepository;
import com.olx.utils.CategoryConverter;
import com.olx.utils.StatusConverter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MasterDataServiceImpl implements MasterDataService {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    CategoriesRepository categoriesRepository;

    @Autowired
    StatusRepository statusRepository;

    @Override
    public List<Status> getStatus() {
        return StatusConverter.convertListEntityToDto(modelMapper, statusRepository.findAll());
    }

    @Override
    public Status getStatusById(int id) {
        if (statusRepository.findById(id).isPresent()) {
            return StatusConverter.convertEntityToDto(modelMapper, statusRepository.getById(id));
        } else {
            throw new InvalidStatusIdException(id);
        }
    }

    @Override
    public List<Category> getCategories() {
        return CategoryConverter.convertListEntityToDto(modelMapper, categoriesRepository.findAll());
    }

    @Override
    public Category getCategoryById(int id) {
        if (categoriesRepository.findById(id).isPresent()) {
            return CategoryConverter.convertEntityToDto(modelMapper, categoriesRepository.getById(id));
        } else {
            throw new InvalidCategoryIdException(id);
        }
    }
}
