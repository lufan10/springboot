package com.cn.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cn.domain.Book;
import com.cn.mapper.BookMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@SpringBootTest
//测试事务回滚
@Transactional
//@Rollback(false) //关闭回滚
@Rollback(true) //开启回滚
public class BookServiceTest {
    @Resource
    private BookMapper bookMapper;
    @Resource
    private BookService bookService;
    @Resource
    private Book book;

    @Test
    void testById() {
        Book byId = bookService.getById(book.getId());
        System.out.println(byId);
    }
    @Test
    void testSave() {
        Boolean save = bookService.save(book);
        System.out.println(save);
    }
    @Test
    void testGetPage() {
        IPage<Book> page = bookService.getPage(2, 8);
        System.out.println(page);
    }

}
