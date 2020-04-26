package de.summer.sampleapplayerv1.service;

import de.summer.sampleapplayerv1.domain.Category;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CategoryService {

    public List<Category> getCategoryList(long categoryId);
}
