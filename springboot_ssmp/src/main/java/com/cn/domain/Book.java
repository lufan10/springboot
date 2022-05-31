package com.cn.domain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Component
@ConfigurationProperties(prefix = "testcase.book")
public class Book implements Serializable {
    private int id;
    private String type;
    private String name;
    private String description;
}








