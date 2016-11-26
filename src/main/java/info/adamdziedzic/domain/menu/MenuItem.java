package info.adamdziedzic.domain.menu;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "menu_item")
public class MenuItem {

    @Id @GeneratedValue(strategy = GenerationType.AUTO) private Long id;
    @Enumerated(EnumType.STRING) private MenuItemType type;
    private String title;
}
