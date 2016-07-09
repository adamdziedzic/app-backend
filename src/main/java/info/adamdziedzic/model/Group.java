package info.adamdziedzic.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user_group")
public class Group {
    @Id @GeneratedValue(strategy = GenerationType.AUTO) private Long id;
    private String name;
}
