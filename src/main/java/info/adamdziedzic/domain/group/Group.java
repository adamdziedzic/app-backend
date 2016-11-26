package info.adamdziedzic.domain.group;

import info.adamdziedzic.domain.menu.MenuItem;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user_group")
public class Group {
    @Id @GeneratedValue(strategy = GenerationType.AUTO) private Long id;
    private String name;
    @ManyToMany private List<MenuItem> menuItems;
}
