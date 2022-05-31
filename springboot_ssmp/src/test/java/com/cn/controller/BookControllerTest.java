package com.cn.controller;

import com.cn.controller.utils.SimulationUtils;
import com.cn.domain.Book;
import com.cn.mapper.BookMapper;
import com.cn.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import javax.annotation.Resource;

/**
 * web环境模拟测试
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@AutoConfigureMockMvc //开启虚拟MVC调用
public class BookControllerTest {
    @Resource
    private BookService bookService;
    @Resource
    private MockMvc mvc;

    @Test
    void testPort() {
        System.out.println("port...");
    }
    @Test
    void testFindALl() throws Exception {
        SimulationUtils.requestGET("/books",mvc);
    }
    @Test
    void testFindById() throws Exception {
        SimulationUtils.requestGET("/books/42",mvc);
    }
//    @Test
//    void testSave(){
//        SimulationUtils.requestPOST("/books",mvc);
//    }
//    @Test
//    void testUpdateById(){
//        SimulationUtils.requestPUT("/books",mvc);
//    }
    @Test
    void testDelete() throws Exception {
        SimulationUtils.requestDELETE("/books/63",mvc);
    }
    @Test
    void testPage() throws Exception {
        SimulationUtils.requestGET("/books/1/10",mvc);

    }

}
