package ee.mainor.demo.mapper;

import ee.mainor.demo.dto.CreateBookRequest;
import ee.mainor.demo.dto.BookDto;
import ee.mainor.demo.model.Book;

public class BookMapper {

    public static Book updateEntity(BookDto source, Book target) {
        target.setAuthor(source.getAuthor());
        target.setTitle(source.getTitle());
        target.setYear(source.getYear());
        target.setGenre(source.getGenre());
        target.setOwnerid(source.getOwnerid());
        target.setDeadline(source.getDeadline());
        return target;
    }

    public static BookDto toDto(Book request) {
        BookDto bookDto = new BookDto();
        bookDto.setId(request.getId());
        bookDto.setAuthor(request.getAuthor());
        bookDto.setTitle(request.getTitle());
        bookDto.setYear(request.getYear());
        bookDto.setGenre(request.getGenre());
        bookDto.setOwnerid(request.getOwnerid());
        bookDto.setDeadline(request.getDeadline());
        return bookDto;
    }


    public static Book toEntity(CreateBookRequest request) {
        Book book = new Book();
        book.setAuthor(request.getAuthor());
        book.setTitle(request.getTitle());
        book.setYear(request.getYear());
        book.setGenre(request.getGenre());
        return book;
    }

}
