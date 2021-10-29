package vip.xjdai.springbootgraphqlsimple.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Author {

    private Integer id;
    private String name;
    private Integer age;

}