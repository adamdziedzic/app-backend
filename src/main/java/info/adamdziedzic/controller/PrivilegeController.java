package info.adamdziedzic.controller;

import info.adamdziedzic.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/privilege")
public class PrivilegeController {

    @Autowired private PrivilegeRepository repository;
    @Autowired private GroupRepository groupRepository;
    @Autowired private MenuRepository menuRepository;

    @RequestMapping(method = RequestMethod.POST)
    public String addPrivilege(@RequestParam("groupId") Long groupId, @RequestParam("menuItemId") Long menuItemId ) {
        Group group = groupRepository.findOne(groupId);
        MenuItem menuItem = menuRepository.findOne(menuItemId);
        Privilege privilege = new Privilege();
        privilege.setGrup(group);
        privilege.setMenuItem(menuItem);
        repository.save(privilege);
        return "Privilege successfully added!";
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Privilege> getPrivileges(@RequestParam("groupId") Long groupId) {
        return repository.findByGrup(groupRepository.findOne(groupId));
    }
}
