package info.adamdziedzic.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;

@Getter
@AllArgsConstructor
public class Menu {
    private ArrayList<MenuItem> menuItems;
}
