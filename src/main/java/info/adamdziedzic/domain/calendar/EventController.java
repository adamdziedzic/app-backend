package info.adamdziedzic.domain.calendar;

import com.google.common.collect.Lists;
import info.adamdziedzic.domain.menu.MenuItem;
import info.adamdziedzic.domain.menu.MenuItemType;
import info.adamdziedzic.domain.menu.MenuRepository;
import info.adamdziedzic.network.request.AddEventRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@RequestMapping("/event")
public class EventController {

    @Autowired private MenuRepository menuRepository;
    @Autowired private EventRepository eventRepository;

    @RequestMapping(method = GET)
    public List<Event> getAllEvents() {
        return Lists.newArrayList(eventRepository.findAll());
    }

    @RequestMapping(value = "/{id}", method = GET)
    public Event getEvent(@PathVariable("id") Long id) {
        return eventRepository.findOne(id);
    }

    @RequestMapping(method = POST)
    public String addEvent(@RequestBody AddEventRequest request) {
        MenuItem menuItem = menuRepository.findOne(request.getMenuItemId());
        if (menuItem.getType() != MenuItemType.NEWS) return "Podaj prawidłowe id kategorii!";

        Event event = new Event();
        event.setName(request.getName());
        event.setCategory(menuItem);
        event.setStartDate(request.getStartDate());
        event.setEndDate(request.getEndDate());

        eventRepository.save(event);

        return "Gratulacje! Dodałeś wydarzenie!";
    }

}
