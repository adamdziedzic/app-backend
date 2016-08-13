package info.adamdziedzic.controller;

import com.google.common.collect.Lists;
import info.adamdziedzic.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.QueryParam;
import java.util.*;
import java.util.stream.Collectors;

@RestController
public class MenuController {

    @Autowired private MenuRepository repository;
    @Autowired private UserRepository userRepository;

    @RequestMapping(value = "/menu", method = RequestMethod.GET)
    public @ResponseBody Menu getMenu(@QueryParam("username") String username, @QueryParam("password") String password) {
        //validate credentials
        if (!userRepository.findByUsername(username).getPassword().equals(password)) {
            throw new IllegalArgumentException("Username does not match password!");
        }

        return new Menu(getMenuItemsForUser(userRepository.findByUsername(username)));
    }

    private List<MenuItem> getMenuItemsForUser(User user) {
        return userRepository.findByUsername(user.getUsername()).getGroups().stream().flatMap(group -> group.getMenuItems().stream()).distinct().collect(Collectors.toList());
    }

    @RequestMapping(value = "/menu/add", method = RequestMethod.POST)
    public @ResponseBody String addMenuItem(@RequestBody MenuItem request) {
        repository.save(request);
        return "success";
    }

    @RequestMapping(value = "/menu/all", method = RequestMethod.GET)
    public @ResponseBody Menu getAllMenuItems() {
        return new Menu(Lists.newArrayList(repository.findAll()));
    }

}