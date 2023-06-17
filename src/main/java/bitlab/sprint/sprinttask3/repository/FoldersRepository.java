package bitlab.sprint.sprinttask3.repository;

import bitlab.sprint.sprinttask3.model.Comments;
import bitlab.sprint.sprinttask3.model.Folders;
import bitlab.sprint.sprinttask3.model.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoldersRepository extends JpaRepository<Folders, Long> {

}
