package com.olx.repository;

import com.olx.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriesRepository extends JpaRepository<CategoryEntity, Integer> {

}
