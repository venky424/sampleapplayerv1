package de.summer.sampleapplayerv1.service;

import de.summer.sampleapplayerv1.domain.Category;
import de.summer.sampleapplayerv1.repository.CategoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    CategoryRepository catrepo;

    @Override
    public List<Category> getCategoryListById(long categoryId) {
        List<Category> categoryList=null;
        log.info("Category Servive Started for categoryId:"+categoryId);
        try{
            categoryList= catrepo.findAllBy(categoryId);
        }catch(Exception e)
        {
            log.error("Exception encountered is:"+e.getMessage());
        }

        return categoryList;
    }

    @Override
    public List<Category> getCategoryList() {
        List<Category> categoryList=null;
        log.info("Category Servive Started for all categories");
        try{
            categoryList= catrepo.findAll();
        }catch(Exception e)
        {
            log.error("Exception encountered is:"+e.getMessage());
        }

        return categoryList;
    }
}
