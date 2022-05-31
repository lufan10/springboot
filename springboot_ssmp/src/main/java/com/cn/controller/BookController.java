package com.cn.controller;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cn.controller.utils.R;
import com.cn.domain.Book;
import com.cn.service.BookService;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;

@RestController
@RequestMapping("/books")
public class BookController {
    @Resource
    private BookService bookservice;

    @GetMapping
    public R getAll() {
        return new R(true, bookservice.getAll());
    }

    @PostMapping
    public R save(@RequestBody Book book){
        Boolean flag = bookservice.save(book);
        return new R(flag, flag ? "添加成功^_^" : "添加失败-_-!");
    }

    @PutMapping
    public R updateById(@RequestBody Book book) {
        return new R(bookservice.updateById(book));
    }

    @DeleteMapping("{id}")
    public R delete(@PathVariable Integer id) {
        return new R(bookservice.delete(id));
    }

    @GetMapping("{id}")
    public R getById(@PathVariable Integer id) {
        return new R(true, bookservice.getById(id));
    }
    @GetMapping("{currentPage}/{pageSize}")
    public R getPage(@PathVariable int currentPage, @PathVariable int pageSize,Book book) {
        Page<Book> page = bookservice.getPage(currentPage, pageSize,book);
        if(currentPage>page.getPages()){
            page=bookservice.getPage((int)page.getPages(),pageSize,book);
        }
        return new R(true,page );
    }


}
