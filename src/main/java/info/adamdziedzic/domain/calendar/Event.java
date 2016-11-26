package info.adamdziedzic.domain.calendar;

import info.adamdziedzic.domain.menu.MenuItem;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "event")
public class Event {
    @Id @GeneratedValue(strategy = GenerationType.AUTO) private Long id;
    @ManyToOne private MenuItem category;
    private String name;
    private Date startDate;
    private Date endDate;
}
