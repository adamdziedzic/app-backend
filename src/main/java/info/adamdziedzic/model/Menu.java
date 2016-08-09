package info.adamdziedzic.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
public class Menu {
    private List<MenuItem> menuItems;
}
