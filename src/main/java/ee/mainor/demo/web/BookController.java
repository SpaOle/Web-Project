package ee.mainor.demo.web;

import ee.mainor.demo.dto.CreateBookRequest;
import ee.mainor.demo.dto.BookDto;
import ee.mainor.demo.dto.GiveUserRequest;
import ee.mainor.demo.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("book")
public class BookController {

    private final BookService bookService;

    @PostMapping
    public BookDto create(@RequestBody CreateBookRequest request) {
        return bookService.create(request);
    }

    @PutMapping("{id}")
    public BookDto update(@PathVariable Integer id, @RequestBody BookDto request) {
        return bookService.update(id ,request);
    }

    @GetMapping("{id}")
    public BookDto findById(@PathVariable Integer id) {
        return bookService.findById(id);
    }

    @GetMapping
    public List<BookDto> getAll() {
        return bookService.getAll();
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable Integer id) {
        bookService.deleteById(id);
    }

    @PostMapping("{id}/give")
    public BookDto giveToUser(@PathVariable Integer id, @RequestBody GiveUserRequest request) {
        return bookService.giveToUser(id ,request);
    }

}
