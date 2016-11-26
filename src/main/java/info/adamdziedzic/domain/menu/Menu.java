package info.adamdziedzic.domain.menu;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class Menu {
    private List<MenuItem> menuItems;
}
