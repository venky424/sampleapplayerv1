package de.summer.sampleapplayerv1.repository;

import de.summer.sampleapplayerv1.domain.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends CrudRepository<Category,Long> {

    List<Category> findAllByCategoryId(long CategoryId);

    List<Category> findAll();
}
