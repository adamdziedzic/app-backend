package info.adamdziedzic.domain.menu;

import com.google.common.collect.Lists;
import info.adamdziedzic.domain.user.User;
import info.adamdziedzic.domain.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.QueryParam;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/menu")
public class MenuController {

    @Autowired private MenuRepository repository;
    @Autowired private UserRepository userRepository;

    @RequestMapping(method = RequestMethod.GET)
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

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public @ResponseBody String addMenuItem(@RequestBody MenuItem request) {
        repository.save(request);
        return "success";
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public @ResponseBody Menu getAllMenuItems() {
        return new Menu(Lists.newArrayList(repository.findAll()));
    }

}