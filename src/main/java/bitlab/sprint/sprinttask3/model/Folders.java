package bitlab.sprint.sprinttask3.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "t_folders")
@Getter
@Setter
public class Folders extends Basic{
   private String name;

   @ManyToMany
   private List<Categories> categories;
}
