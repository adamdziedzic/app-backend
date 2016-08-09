package info.adamdziedzic.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Builder
public class User {

    @Id @GeneratedValue(strategy = GenerationType.AUTO) private Long id;
    private String username;
    private String password;
    @ManyToMany private List<Group> groups;
}
