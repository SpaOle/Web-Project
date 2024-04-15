package ee.mainor.demo.service;

import ee.mainor.demo.dto.CreateBookRequest;
import ee.mainor.demo.dto.BookDto;
import ee.mainor.demo.dto.GiveUserRequest;
import ee.mainor.demo.mapper.BookMapper;
import ee.mainor.demo.model.Book;
import ee.mainor.demo.model.User;
import ee.mainor.demo.repository.BookRepository;
import ee.mainor.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAmount;
import java.time.temporal.TemporalUnit;
import java.util.List;


@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private final UserRepository userRepository;

    public BookDto create(CreateBookRequest createBookRequest) {
        Book book = BookMapper.toEntity(createBookRequest);
        return BookMapper.toDto(bookRepository.save(book));
    }

    public BookDto update(Integer id, BookDto bookDto) {
        Book book = BookMapper.updateEntity(bookDto, requireBook(id));

        return BookMapper.toDto(bookRepository.save(book));
    }

    public List<BookDto> getAll() {
        return bookRepository.findAll()
                .stream()
                .map(BookMapper::toDto)
                .toList();
    }

    public BookDto findById(Integer id) {
        Book book = requireBook(id);
        return BookMapper.toDto(book);
    }

    private Book requireBook(Integer id) {
        return bookRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Book not found"));
    }

    private User requireUser(Integer id) {
        return userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("User not found"));
    }

    public BookDto giveToUser(Integer id, GiveUserRequest request) {
        Book book = requireBook(id);
        User user = requireUser(request.getOwnerid());

        book.setOwnerid(user.getId());
        book.setDeadline(Instant.now().plus(7, ChronoUnit.DAYS));
        return BookMapper.toDto(bookRepository.save(book));
    }

    public void deleteById(Integer id) {
        Book book = requireBook(id);
        bookRepository.deleteById(id);
    }

    public BookDto returnToLibrary(Integer id) {
        Book book = requireBook(id);
        book.setOwnerid(null);
        book.setDeadline(null);
        return BookMapper.toDto(bookRepository.save(book));
    }
}
