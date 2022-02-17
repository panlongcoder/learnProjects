package com.dragon.mybatis.custom.test.entity;

/**
 * @author dragon
 * @since 2021/2/8
 */
public class User {
    //主键标识
    private Integer id;
    //用户名
    private String username;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
