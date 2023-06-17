package bitlab.sprint.sprinttask3.repository;

import bitlab.sprint.sprinttask3.model.Categories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriesRepository extends JpaRepository<Categories, Long> {

}
