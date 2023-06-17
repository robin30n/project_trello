package bitlab.sprint.sprinttask3.repository;

import bitlab.sprint.sprinttask3.model.Categories;
import bitlab.sprint.sprinttask3.model.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TasksRepository extends JpaRepository<Tasks, Long> {
    List<Tasks> findAllByFolderId(Long id);

    List<Tasks> getAllByFolderId(Long id);

    void deleteAllByFolder_Id(Long id);
}
