package de.summer.sampleapplayerv1.service;

import de.summer.sampleapplayerv1.dao.CategoryDao;
import de.summer.sampleapplayerv1.domain.Category;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Slf4j
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    CategoryDao catDao;

    @Override
    public List<Category> getCategoryList(long categoryId) {
        List<Category> categoryList=null;
        log.info("Category Servive Started");
        try{
            categoryList=catDao.getCategoryList(categoryId);
        }catch(Exception e)
        {
            log.error("Exception encountered is:"+e.getMessage());
        }

        return categoryList;
    }
}
