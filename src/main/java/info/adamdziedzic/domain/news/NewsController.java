package info.adamdziedzic.domain.news;

import com.google.common.collect.Lists;
import info.adamdziedzic.domain.menu.MenuItem;
import info.adamdziedzic.domain.menu.MenuItemType;
import info.adamdziedzic.domain.menu.MenuRepository;
import info.adamdziedzic.network.request.AddNewsRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/news")
public class NewsController {

    @Autowired private NewsRepository repository;
    @Autowired private MenuRepository menuRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<News> getAllNews() {
        return Lists.newArrayList(repository.findAll());
    }

    @RequestMapping(method = RequestMethod.POST)
    public String addNews(@RequestBody AddNewsRequest request) {
        MenuItem menuItem = menuRepository.findOne(request.getMenuItemId());
        if (menuItem.getType() != MenuItemType.NEWS) return "Podaj prawidłowe id kategorii!";
        News news = new News();
        news.setCategory(menuItem);
        news.setContent(request.getContent());
        news.setTitle(request.getTitle());
        repository.save(news);
        return "Gratulacje! Dodałeś nowego newsa!";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public News getNews(@PathVariable("id") Long id) {
        return repository.findOne(id);
    }
}
