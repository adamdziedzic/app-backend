package info.adamdziedzic.domain.news;

import info.adamdziedzic.domain.menu.MenuItem;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class News {
    @Id @GeneratedValue(strategy = GenerationType.AUTO) private Long id;
    private String title;
    private String content;
    @ManyToOne private MenuItem category;
}
