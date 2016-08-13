package info.adamdziedzic.controller;

import info.adamdziedzic.model.Group;
import info.adamdziedzic.model.GroupRepository;
import info.adamdziedzic.model.User;
import info.adamdziedzic.model.UserRepository;
import info.adamdziedzic.network.request.AddGroupRequest;
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
    private final GroupRepository groupRepository;

    @Autowired public UserController(UserRepository repository, GroupRepository groupRepository) {
        this.repository = repository;
        this.groupRepository = groupRepository;
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

    @RequestMapping(value = "/addGroup", method = RequestMethod.POST)
    public String addGroup(@RequestBody AddGroupRequest request) {
        Group groupToAdd = groupRepository.findOne(request.getGroupId());
        User user = repository.findByUsername(request.getUsername());
        user.getGroups().add(groupToAdd);
        repository.save(user);
        return "group added successfully";
    }
}
