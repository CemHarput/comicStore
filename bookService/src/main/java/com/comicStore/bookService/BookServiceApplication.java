package com.comicStore.bookService;

import com.comicStore.bookService.model.Book;
import com.comicStore.bookService.repository.BookRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@SpringBootApplication
@EnableDiscoveryClient
public class BookServiceApplication implements CommandLineRunner {

	private final BookRepository bookRepository;

    public BookServiceApplication(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public static void main(String[] args) {
		SpringApplication.run(BookServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
			Book book1 = new Book(1111,1111,"Spiderman-1",234,"Test Book Object","Test Book Object",new Date(),"3562627384-d484831","4674343","44444","eeee","8468264djgdhs","comic",500);
			Book book2 = new Book(1111,1111,"Spiderman-2",234,"Test Book Object","Test Book Object",new Date(),"3562627384-d484830","4674343","44444","eeee","8468264djgdhs","comic",500);
			List<Book> bookList = bookRepository.saveAll(Arrays.asList(book1,book2));
			System.out.println(bookList);
	}
	@Bean
	public RestTemplate restTemplate(){
		ObjectMapper objectMapper=new ObjectMapper();
		objectMapper.registerModule(new JavaTimeModule());
		return new RestTemplate();
	}
}
