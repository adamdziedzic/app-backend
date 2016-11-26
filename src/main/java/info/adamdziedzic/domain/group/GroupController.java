package info.adamdziedzic.domain.group;

import com.google.common.collect.Lists;
import info.adamdziedzic.domain.menu.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/group")
public class GroupController {

    @Autowired private GroupRepository repository;
    @Autowired private MenuRepository menuRepository;

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

    @RequestMapping(value = "/{id}/addMenuItems", method = RequestMethod.POST)
    public @ResponseBody Group addMenuItems(@PathVariable("id") long id, @RequestBody List<Long> menuItemIds) {
        Group group = repository.findOne(id);
        menuItemIds.forEach(menuItemId -> group.getMenuItems().add(menuRepository.findOne(menuItemId)));
        repository.save(group);
        return group;
    }
}
