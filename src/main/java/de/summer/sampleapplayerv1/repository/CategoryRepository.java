package de.summer.sampleapplayerv1.repository;

import de.summer.sampleapplayerv1.domain.Category;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface CategoryRepository extends CrudRepository<Category,Long> {
    List<Category> findAllBy(long categoryId);
}
