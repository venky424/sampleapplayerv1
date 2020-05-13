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
        log.info("Category Service Started for categoryId:"+categoryId);
        try{
            categoryList= catrepo.findAllById(categoryId);
            log.info("Category Service completed for categoryId:"+categoryId);
        }catch(Exception e)
        {
            log.info("Category Service failed for categoryId:"+categoryId);
            log.error("Exception encountered is:"+e.getMessage());
        }

        return categoryList;
    }

    @Override
    public List<Category> getCategoryList() {
        List<Category> categoryList=null;
        log.info("Category Service Started for all categories");
        try{
            categoryList= catrepo.findAll();
         log.info("Category Service completed for all categories");
        }catch(Exception e)
        {
            log.info("Category Service failed for all categories");
            log.error("Exception encountered is:"+e.getMessage());
        }

        return categoryList;
    }

    @Override
    public Category newCategoryList(Category category) {
        Category updresponse=null;
        log.info("Category new Service Started for requested category:"+category.getId());
        try{
            updresponse= catrepo.save(category);
            log.info("Category new Service completed for requested category:"+category.getId());
        }catch(Exception e)
        {
            log.info("Category new Service completed for requested category:"+category.getId());
            log.error("Exception encountered is:"+e.getMessage());
        }
        return updresponse;
    }
}
