package de.summer.sampleapplayerv1.dao;

import de.summer.sampleapplayerv1.domain.Category;
import de.summer.sampleapplayerv1.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CategoryDaoImpl implements CategoryDao{

    @Autowired
    CategoryRepository catRepo;

    @Override
    public List<Category> getCategoryList(long categoryId) {
        List<Category> categoryList=null;
        categoryList=catRepo.findAllBy(categoryId);
        return categoryList;
    }
}
