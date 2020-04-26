package de.summer.sampleapplayerv1.controller;

import de.summer.sampleapplayerv1.domain.Category;
import de.summer.sampleapplayerv1.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping(value="/v1/categoryList/", produces = {APPLICATION_JSON_VALUE})
    public List<Category> getCategoryList(@RequestParam(value = "categoryId") long categoryId,
                                          HttpServletRequest req,
                                          HttpServletResponse resp){
        List<Category> categoryList=null;
        try{
            log.info("Request received for categoryid:"+categoryId);
            categoryList=catService.getCategoryList(categoryId);
            if(categoryList.size()==0){
                resp.setStatus(HttpServletResponse.SC_NO_CONTENT);
            }
        }catch(Exception e){
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            log.info("Exception encountered is:"+e.getMessage());
        }
        return categoryList;
    }
}
