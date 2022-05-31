package com.cn.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cn.domain.Book;
import com.cn.mapper.BookMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class BookServiceTest {
    @Resource
    private BookMapper bookMapper;
    @Resource
    private BookService bookService;

    @Test
    void testById() {
        Book byId = bookService.getById(5);
        System.out.println(byId);
    }
    @Test
    void testGetPage() {
        IPage<Book> page = bookService.getPage(2, 8);
        System.out.println(page);
    }
}
