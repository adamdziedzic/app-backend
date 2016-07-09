package info.adamdziedzic.controller;

import com.google.common.collect.Lists;
import info.adamdziedzic.model.Group;
import info.adamdziedzic.model.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/group")
public class GroupController {

    @Autowired private GroupRepository repository;

    @RequestMapping(method = RequestMethod.POST)
    public String addGroup(@RequestBody Group group) {
        repository.save(group);
        return "Group successfully added!";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Group getGroup(@PathVariable("id") Long id) {
        return repository.findOne(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Group> getAllGroups() {
        return Lists.newArrayList(repository.findAll());
    }
}
