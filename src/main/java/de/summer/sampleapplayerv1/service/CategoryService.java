package de.summer.sampleapplayerv1.service;

import de.summer.sampleapplayerv1.domain.Category;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

public interface CategoryService {

    public List<Category> getCategoryListById(long categoryId);

    public List<Category> getCategoryList();

    public String newCategoryList(String categoryname, String categorydescr, String createdby, String updatedby);

    public String updCategoryList(long id,String categoryname, String categorydescr, String createdby, String updatedby);

    public String delCategoryList(long id);
}
