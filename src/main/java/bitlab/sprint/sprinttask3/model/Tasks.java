package bitlab.sprint.sprinttask3.model;

import bitlab.sprint.sprinttask3.enam.TaskStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "t_tasks")
@Getter
@Setter
public class Tasks extends Basic {
    private String title;
    private String description; // TEXT
    private TaskStatus status; // 0 - todo, 1 - intest, 2 - done, 3 - failed

    @ManyToOne
    private Folders folder;
}
