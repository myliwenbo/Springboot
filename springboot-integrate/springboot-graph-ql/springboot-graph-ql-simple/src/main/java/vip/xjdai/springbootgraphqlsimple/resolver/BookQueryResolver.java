package vip.xjdai.springbootgraphqlsimple.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;
import vip.xjdai.springbootgraphqlsimple.model.Book;
import vip.xjdai.springbootgraphqlsimple.model.User;

import java.util.ArrayList;
import java.util.List;

@Component
public class BookQueryResolver implements GraphQLQueryResolver {

    public List<Book> QueryBooks() {
        User user = User.builder()
                .id(1)
                .name("Bill Venners")
                .age(40)
                .build();
        Book b = Book.builder()
                .id(1)
                .name("李文泊著作")
                .user(user)
                .publisher("电子工业出版社")
                .build();
        List<Book> bookList = new ArrayList<>();
        bookList.add(b);
        return bookList;
    }
}