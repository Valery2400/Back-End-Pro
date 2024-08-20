package de.ait.books.configuration;

import de.ait.books.repository.BookRepository;
import de.ait.books.repository.BookRepositoryImp;
import de.ait.books.repository.BookRepositoryJDBCImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {

    @Value("${repository.type")
    private String repositoryType;

    @Autowired
    private ConfigurableApplicationContext context;

    @Bean
    BookRepository getBookRepository() {
        if (repositoryType.equalsIgnoreCase("list")) {
            return context.getBean(BookRepositoryImp.class);
        } else {
            return context.getBean(BookRepositoryJDBCImp.class);
        }
    }


}
