package com.cn.mapper;

import com.alibaba.fastjson.JSON;
import com.cn.controller.utils.JsonData;
import com.cn.domain.Book;
import com.cn.service.BookService;

import org.apache.http.HttpHost;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

@SpringBootTest
public class ESTest {
    @Resource
    private BookMapper bookMapper;
    @Resource
    private BookService bookService;
    @Resource
    private RestHighLevelClient client;
    @BeforeEach
    /**
     * 初始化ES客户端
     */
    void setUp() {
        this.client=new RestHighLevelClient(RestClient.builder(HttpHost.create("http://localhost:9200")));
    }
    @AfterEach
    /**
     * 关闭ES客服端
     */
    void tearDown() throws IOException {
        this.client.close();
    }

    @Test
    /**
     * 使用客户端发送一个请求并创建一个名叫books名称的索引
     */
    void testCreatIndex() throws IOException {
        CreateIndexRequest request = new CreateIndexRequest("books");
        client.indices().create(request, RequestOptions.DEFAULT);
    }
    @Test
    /**
     * 使用客户端发送一个请求并创建一个名叫books名称的索引,同时携带ik分词器的json参数
     */
    void testCreatIndexByIk() throws IOException {
        CreateIndexRequest request = new CreateIndexRequest("books");
        //设置请求中的参数
        JsonData jsonData = new JsonData();
        String json = jsonData.getJson();
        request.source(json, XContentType.JSON);
        client.indices().create(request, RequestOptions.DEFAULT);
    }
    @Test
    /**
     * 批量添加数据库中的数据到ES文档中
     */
    void testCreatDoc() throws IOException {
        List<Book> bookList = bookMapper.selectList(null);
        BulkRequest bulk = new BulkRequest();
        for (Book book : bookList) {
            IndexRequest request = new IndexRequest("books").id(String.valueOf(book.getId()));
            request.source(JSON.toJSONString(book),XContentType.JSON);
            bulk.add(request);
        }
        client.bulk(bulk,RequestOptions.DEFAULT);
    }
    /**
     * 按id查询ES文档
     */
    @Test
    void testSelectById() throws IOException {
        GetRequest request = new GetRequest("books", "43");
        GetResponse response = client.get(request, RequestOptions.DEFAULT);
        String json = response.getSourceAsString();
        System.out.println(json);
    }
    /**
     * 按条件查询
     */
    @Test
    void testSelectCount() throws IOException {
        SearchRequest request = new SearchRequest("books");
        SearchSourceBuilder builder = new SearchSourceBuilder();
        builder.query(QueryBuilders.termQuery("all","spring"));
        request.source(builder);
        SearchResponse response = client.search(request, RequestOptions.DEFAULT);
        SearchHits hits = response.getHits();
        for (SearchHit hit : hits) {
            String source = hit.getSourceAsString();
            Book book = JSON.parseObject(source, Book.class);
            System.out.println(book);
        }
    }
    /**
     * 根据id删除ES文档
     */
    @Test
    void testDelete() throws IOException {
        DeleteRequest request=new DeleteRequest("books", String.valueOf(42));
        client.delete(request,RequestOptions.DEFAULT);

    }
    /**
     * 根据id修改ES文档
     */
    @Test
    void testUpdate() throws IOException {
        UpdateRequest request=new UpdateRequest("books","44");
        String json="{\n" +
                "                    \"description\": \"深人Spring源码剖析Spring源码中蕴含的10大设计模式\",\n"+
                "                    \"name\": \"Spring 核心原理与30个类书写实战\",\n" +
                "                    \"type\": \"迪迦奥特曼\"\n" +
                "                }";
        request.doc(json,XContentType.JSON);
        client.update(request,RequestOptions.DEFAULT);

    }



}
