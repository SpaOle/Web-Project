package ee.mainor.demo.repository;

import ee.mainor.demo.model.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Integer> {

    List<Book> findAll();

}
