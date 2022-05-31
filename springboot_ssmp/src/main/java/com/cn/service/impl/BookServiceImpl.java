package com.cn.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cn.domain.Book;
import com.cn.mapper.BookMapper;
import com.cn.service.BookService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class BookServiceImpl implements BookService {
    @Resource
    private BookMapper bookMapper;
    @Override
    public Boolean save(Book book) {
        return bookMapper.insert(book)>0;
    }

    @Override
    public Boolean delete(Integer id) {
        return bookMapper.deleteById(id)>0;
    }

    @Override
    public Boolean updateById(Book book) {
        return bookMapper.updateById(book)>0;
    }

    @Override
    public Book getById(Integer id) {

        return bookMapper.selectById(id);
    }

    @Override
    public List<Book> getAll() {
        return bookMapper.selectList(null);
    }

    @Override
    public Page<Book> getPage(int currentPage, int pageSize) {
        Page<Book> page = new Page<>(currentPage,pageSize);
        bookMapper.selectPage(page, null);
        return page;
    }

    @Override
    public Page<Book> getPage(int currentPage, int pageSize, Book book) {

        LambdaQueryWrapper<Book> lqw = new LambdaQueryWrapper<>();
        lqw.like(Strings.isNotEmpty(book.getType()),Book::getType,book.getType());
        lqw.like(Strings.isNotEmpty(book.getName()),Book::getName,book.getName());
        lqw.like(Strings.isNotEmpty(book.getDescription()),Book::getDescription,book.getDescription());
        Page<Book> page = new Page<>(currentPage,pageSize);
        bookMapper.selectPage(page, lqw);
        return page;
    }
}
