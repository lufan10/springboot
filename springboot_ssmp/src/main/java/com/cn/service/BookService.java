package com.cn.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cn.domain.Book;

import java.util.List;

public interface BookService{
    Boolean save(Book book);

    Boolean delete(Integer id);

    Boolean updateById(Book book);

    Book getById(Integer id);

    List<Book> getAll();
    Page<Book> getPage(int currentPage, int pageSize);

    Page<Book> getPage(int currentPage, int pageSize, Book book);
}
