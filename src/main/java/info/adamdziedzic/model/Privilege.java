package info.adamdziedzic.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Privilege {
    @Id @GeneratedValue(strategy = GenerationType.AUTO) private Long id;
    @OneToOne private Group grup;
    @OneToOne private MenuItem menuItem;
}
