package info.adamdziedzic.controller;

import info.adamdziedzic.model.User;
import info.adamdziedzic.model.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.QueryParam;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    private final UserRepository repository;

    @Autowired public UserController(UserRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String addUser(@RequestBody User user) {
        repository.save(user);
        return "User successfully added";
    }

    @RequestMapping(method = RequestMethod.GET)
    public User getUser(@QueryParam("id") Long id) {
        return repository.findOne(id);
    }
}
