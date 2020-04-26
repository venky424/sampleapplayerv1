package de.summer.sampleapplayerv1.dao;

import de.summer.sampleapplayerv1.domain.Category;

import java.util.List;

public interface CategoryDao {

    public List<Category> getCategoryList(long categoryId);
}
