package vip.xjdai.springbootgraphqlsimple.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Book {
    private Integer id;
    private String name;
    private Author author;
    private String publisher;
}