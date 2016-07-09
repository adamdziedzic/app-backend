package info.adamdziedzic.model;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PrivilegeRepository extends CrudRepository<Privilege, Long> {

    List<Privilege> findByGrup(Group group);
}
