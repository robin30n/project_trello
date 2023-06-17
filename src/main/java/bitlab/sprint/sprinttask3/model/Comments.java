package bitlab.sprint.sprinttask3.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.scheduling.config.Task;

@Entity
@Table(name = "t_comments")
@Getter
@Setter
public class Comments extends Basic{
    private String comment;
    @ManyToOne
    private Tasks task;
}
