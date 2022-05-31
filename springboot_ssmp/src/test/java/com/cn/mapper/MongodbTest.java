package com.cn.mapper;

import com.cn.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;

import javax.annotation.Resource;

@SpringBootTest
public class MongodbTest {
    @Resource
    private MongoTemplate mongoTemplate;
    @Test
    void save(){
        Book book = new Book();
        book.setId(1);
        book.setType("springboot");
        book.setName("springboot");
        book.setDescription("springboot");
        mongoTemplate.save(book);
    }
}
