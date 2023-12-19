package com.launchcode.munchincrunch.data;

import com.launchcode.munchincrunch.models.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Integer> {
}
