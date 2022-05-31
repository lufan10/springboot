package com.cn.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cn.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
public class BookMapperTest {
    @Resource
    private BookMapper mapper;

    @Test
    void select() {
        Book book = mapper.selectById(2);
        System.out.println(book);
    }
    @Test
    void selectAll() {
        List<Book> books = mapper.selectList(null);
        for (Book book : books) {
            System.out.println(book);
        }
    }
//    @Test
//    void getPage1() {
//        PageHelper.startPage(2,8);
//        List<Book> books = mapper.selectList(null);
//        PageInfo<Book> bookPageInfo = new PageInfo<>();
//        long total = bookPageInfo.getTotal();
//        System.out.println(total);
//    }
    @Test
    void getPage2() {
        Page<Book> page = new Page<>(2,10);
        mapper.selectPage(page, null);
    }
    @Test
    void update() {
        Book book = new Book(3, "eee", "111", "c22");
        mapper.updateById(book);
    }
}
