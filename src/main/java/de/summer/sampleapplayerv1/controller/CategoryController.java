package de.summer.sampleapplayerv1.controller;

import de.summer.sampleapplayerv1.domain.Category;
import de.summer.sampleapplayerv1.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Slf4j
@RestController
public class CategoryController {

    @Autowired
    CategoryService catService;

    @GetMapping(value="/v1/categoryListById/", produces = {APPLICATION_JSON_VALUE})
    public List<Category> getCategoryListById(@RequestParam(value = "categoryId") long categoryId,
                                          HttpServletRequest req,
                                          HttpServletResponse resp){
        List<Category> categoryList=null;
        try{
            log.info("Request received for categoryid:"+categoryId);
            categoryList=catService.getCategoryListById(categoryId);
            if(categoryList.size()==0){
                resp.setStatus(HttpServletResponse.SC_NO_CONTENT);
            }
        }catch(Exception e){
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            log.info("Exception encountered is:"+e.getMessage());
        }
        return categoryList;
    }

    @GetMapping(value="/v1/categoryList/", produces = {APPLICATION_JSON_VALUE})
    public List<Category> getCategoryList(HttpServletRequest req,
                                          HttpServletResponse resp){
        List<Category> categoryList=null;
        try{
            log.info("Request received for all categories:");
            categoryList=catService.getCategoryList();
            if(categoryList.size()==0){
                resp.setStatus(HttpServletResponse.SC_NO_CONTENT);
            }
        }catch(Exception e){
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            log.info("Exception encountered is:"+e.getMessage());
        }
        return categoryList;
    }


    @PostMapping(value="/v1/updateCategoryList/", produces = {APPLICATION_JSON_VALUE})
    public Category updCategoryList(Category category,HttpServletRequest req,
                                          HttpServletResponse resp){
        Category updresponse=null;
        try{
            log.info("Request received for updating categories:"+category.getCategoryname());
            if ("".equals(category.getCategoryname())){
                resp.setStatus(HttpServletResponse.SC_NO_CONTENT);
            }
            else{
                updresponse=catService.newCategoryList(category);
            }
        }catch(Exception e){
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            log.info("Exception encountered is:"+e.getMessage());
        }
        return updresponse;
    }

}
