package com.cn.controller.utils;

import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor //无参构造器
@Data
public class R {
    //私有的成员变量
    private Boolean flag;
    private Object data;
    private String msg;

    public R(Boolean flag) {
        this.flag = flag;
    }
    public R(String msg) {
        this.flag = false;
        this.msg = msg;
    }

    public R(Boolean flag, String msg) {
        this.flag = flag;
        this.msg = msg;
    }

    public R(Boolean flag, Object data) {
        this.flag = flag;
        this.data = data;
    }
}