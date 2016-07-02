package info.adamdziedzic.model;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MenuRepository extends CrudRepository<MenuItem, Long> {

    List<MenuItem> findByTitle(String title);
}
