package ee.mainor.demo.repository;

import ee.mainor.demo.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Integer> {

    List<User> findAll();
}

