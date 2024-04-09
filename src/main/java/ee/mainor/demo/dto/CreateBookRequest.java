package ee.mainor.demo.dto;

import lombok.Data;

@Data
public class CreateBookRequest {

    private String author;
    private String title;
    private Integer year;
    private String genre;

}
