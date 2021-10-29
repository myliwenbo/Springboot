package vip.xjdai.springbootgraphqlsimple.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;
import vip.xjdai.springbootgraphqlsimple.model.Author;
import vip.xjdai.springbootgraphqlsimple.model.Book;

import java.util.ArrayList;
import java.util.List;

@Component
public class BookQueryResolver implements GraphQLQueryResolver {
    public List<Book> findBooks() {
        Author author = Author.builder()
                .id(1)
                .name("Bill Venners")
                .age(40)
                .build();
        Book b = Book.builder()
                .id(1)
                .name("scala编程第三版")
                .author(author)
                .publisher("电子工业出版社")
                .build();
        List<Book> bookList = new ArrayList<Book>();
        bookList.add(b);
        return bookList;
    }
}