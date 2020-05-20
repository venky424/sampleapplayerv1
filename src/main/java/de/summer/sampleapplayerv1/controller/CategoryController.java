package de.summer.sampleapplayerv1.controller;

import de.summer.sampleapplayerv1.domain.Category;
import de.summer.sampleapplayerv1.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
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


    @PostMapping(value="/v1/newCategoryList/", produces = {APPLICATION_JSON_VALUE})
    public String updCategoryList(@RequestParam(value="categoryname") String categoryname,
                                          @RequestParam(value="categorydescr") String categorydescr,
                                          @RequestParam(value="createdby") String createdby,
                                          @RequestParam(value="updatedby") String updatedby,
                                          HttpServletRequest req,
                                          HttpServletResponse resp){
        String updresponse=null;
        try{
            log.info("Request received for updating category for the details:"+categoryname,categorydescr,createdby,updatedby);
            if ("".equals(categoryname)){
                resp.setStatus(HttpServletResponse.SC_NO_CONTENT);
            }
            else{
                updresponse=catService.newCategoryList(categoryname,categorydescr,createdby,updatedby);
            }
        }catch(Exception e){
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            log.info("Exception encountered is:"+e.getMessage());
        }
        return updresponse;
    }


    @PutMapping(value="/v1/updCategoryList/", produces = {APPLICATION_JSON_VALUE})
    public String updCategoryList(@RequestParam(value="id") long id,
                                    @RequestParam(value="categoryname") String categoryname,
                                    @RequestParam(value="categorydescr") String categorydescr,
                                    @RequestParam(value="createdby") String createdby,
                                    @RequestParam(value="updatedby") String updatedby,
                                    HttpServletRequest req,
                                    HttpServletResponse resp){
        String updresponse=null;
        try{
            log.info("Request received for updating category for the details:"+categoryname,categorydescr,createdby,updatedby);
            if ("".equals(categoryname)){
                resp.setStatus(HttpServletResponse.SC_NO_CONTENT);
            }
            else{
                updresponse=catService.updCategoryList(id,categoryname,categorydescr,createdby,updatedby);
            }
        }catch(Exception e){
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            log.info("Exception encountered is:"+e.getMessage());
        }
        return updresponse;
    }

    @DeleteMapping(value="/v1/delCategoryList/", produces = {APPLICATION_JSON_VALUE})
    public String delCategoryList(@RequestParam(value="id") long id,
                                    HttpServletRequest req,
                                    HttpServletResponse resp){
        String updresponse=null;
        try{
            log.info("Request received for updating category for the details:"+id);
            if ("".equals(id)){
                resp.setStatus(HttpServletResponse.SC_NO_CONTENT);
            }
            else{
                updresponse=catService.delCategoryList(id);
            }
        }catch(Exception e){
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            log.info("Exception encountered is:"+e.getMessage());
        }
        return updresponse;
    }

}
