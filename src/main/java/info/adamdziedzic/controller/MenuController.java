package info.adamdziedzic.controller;

import com.google.common.collect.Lists;
import info.adamdziedzic.model.Menu;
import info.adamdziedzic.model.MenuItem;
import info.adamdziedzic.model.MenuItemType;
import info.adamdziedzic.model.MenuRepository;
import info.adamdziedzic.network.response.AddMenuItemResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class MenuController {

    @Autowired private MenuRepository repository;

    @RequestMapping(value = "/menu", method = RequestMethod.GET)
    public @ResponseBody Menu getMenu(@RequestParam("username") String username) {
        return new Menu(Lists.newArrayList(repository.findAll()));
//        ArrayList<MenuItem> menuItems = new ArrayList<>();
//        menuItems.add(new MenuItem(1L, MenuItemType.CALENDAR, "Calendar"));
//        menuItems.add(new MenuItem(2L, MenuItemType.FORM, "Form"));
//        menuItems.add(new MenuItem(3L, MenuItemType.NEWS, "Today's news"));
//        return new Menu(menuItems);
    }

    @RequestMapping(value = "/menu/add", method = RequestMethod.POST)
    public @ResponseBody String addMenuItem(@RequestBody MenuItem request) {
        repository.save(request);
        return "success";
    }

}