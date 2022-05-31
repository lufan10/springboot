package com.cn.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cn.domain.Book;
import com.cn.mapper.BookMapper;
import com.cn.service.BookService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class BookServiceImpl implements BookService {
    @Resource
    private BookMapper bookMapper;

    @Override
//    @Cacheable(value = "cacheSpace",key = "#id") //springboot默认缓存技术
//    @Cached(name = "book_",key = "#id",expire = 3600,cacheType = CacheType.BOTH) //jetcach缓存技术
//    @CacheRefresh(refresh = 3600)
    public Book getById(Integer id) {
        return bookMapper.selectById(id);
    }
    @Override
    public Boolean save(Book book) {
        return bookMapper.insert(book)>0;
    }

    @Override
//    @CacheInvalidate(name = "book_",key = "#id")
    public Boolean delete(Integer id) {
        return bookMapper.deleteById(id)>0;
    }

    @Override
//    @CacheUpdate(name="book_",key = "#book.id",value = "#book")
    public Boolean updateById(Book book) {
        return bookMapper.updateById(book)>0;
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
