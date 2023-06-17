package bitlab.sprint.sprinttask3.repository;

import bitlab.sprint.sprinttask3.model.Comments;
import bitlab.sprint.sprinttask3.model.Tasks;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public interface CommentsRepository extends JpaRepository<Comments, Long> {
    List<Comments> findAllByTaskId(Long id);

    void deleteAllByTaskId(Long id);

    void deleteAllByTaskIdIn(List<Long> id);
}
