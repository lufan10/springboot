package com.cn.controller.utils;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.ContentResultMatchers;
import org.springframework.test.web.servlet.result.HeaderResultMatchers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.result.StatusResultMatchers;

/**
 * 模拟虚拟请求匹配
 */

public class SimulationUtils {
    public static ResultMatcher getStatus(){
        //设定预期值
        StatusResultMatchers status = MockMvcResultMatchers.status();
        //预计本次调用时成功的状态码为200
        ResultMatcher ok = status.isOk();
        return ok;
    }
    public static ResultMatcher getContent(){
        //设定预期值
        ContentResultMatchers content = MockMvcResultMatchers.content();
        //预计本次调用时成功的状态码为200
        //ResultMatcher result = content.string("springboot");
        ResultMatcher result = content.json("{\'id\':1,\'name\':\'spring\'}");
        return result;
    }
    public static ResultMatcher getHeader(){
        //设定预期值
        HeaderResultMatchers header = MockMvcResultMatchers.header();
        //预计本次调用时成功的状态码为200
        ResultMatcher contentType = header.string("Content-Type", "application/json");
        return contentType;
    }


    public static void requestGET(String url, MockMvc mvc ) throws Exception {

        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get(url);
        //执行对应的请求
        ResultActions  actions= mvc.perform(builder);
        //1.匹配响应执行状态
        ResultMatcher ok = getStatus();
        actions.andExpect(ok);
        //2.匹配响应体(包括字符串和json)
//        ResultMatcher result = getContent();
//        actions.andExpect(result);
        //3.匹配响应头
        ResultMatcher contentType = getHeader();
        actions.andExpect(contentType);


    }
    public static void requestPOST(String url,MockMvc mvc) throws Exception{
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post(url);
        //执行对应的请求
        ResultActions actions = mvc.perform(builder);
        //1.匹配响应执行状态
        ResultMatcher ok = getStatus();
        actions.andExpect(ok);
        //2.匹配响应体(包括字符串和json)
//        ResultMatcher result = getContent();
//        actions.andExpect(result);
        //3.匹配响应头
        ResultMatcher contentType = getHeader();
        actions.andExpect(contentType);


    }
    public static void requestPUT(String url, MockMvc mvc)throws Exception{
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.put(url);
        //执行对应的请求
        ResultActions actions= mvc.perform(builder);
        //1.匹配响应执行状态
        ResultMatcher ok = getStatus();
        actions.andExpect(ok);
        //2.匹配响应体(包括字符串和json)
//        ResultMatcher result = getContent();
//        actions.andExpect(result);
        //3.匹配响应头
        ResultMatcher contentType = getHeader();
        actions.andExpect(contentType);


    }
    public static void requestDELETE(String url, MockMvc mvc)throws Exception{
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.delete(url);
        //执行对应的请求
        ResultActions actions = mvc.perform(builder);
        //1.匹配响应执行状态
        ResultMatcher ok = getStatus();
        actions.andExpect(ok);
        //2.匹配响应体(包括字符串和json)
//        ResultMatcher result = getContent();
//        actions.andExpect(result);
        //3.匹配响应头
        ResultMatcher contentType = getHeader();
        actions.andExpect(contentType);
    }

}
