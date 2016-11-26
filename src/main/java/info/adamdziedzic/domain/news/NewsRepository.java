package info.adamdziedzic.domain.news;

import info.adamdziedzic.domain.menu.MenuItem;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface NewsRepository extends CrudRepository<News, Long> {
    List<News> findByTitle(String title);
    List<News> findByCategory(MenuItem category);
}
