package com.olx.service;

import com.olx.dto.Category;
import com.olx.dto.Status;

import java.util.List;

public interface MasterDataService {

    List<Status> getStatus();

    Status getStatusById(int id);

    List<Category> getCategories();

    Category getCategoryById(int id);
}
