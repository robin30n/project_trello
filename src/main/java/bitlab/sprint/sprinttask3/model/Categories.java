package bitlab.sprint.sprinttask3.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "t_categories")
@Getter
@Setter
public class Categories extends Basic{
    private String name;
}
