package org.example.boot.validation.model;

import com.fasterxml.jackson.annotation.JsonView;
import support.CommonJsonView;
import support.CreateCheck;
import support.UpdateCheck;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.List;

/**
 * user model
 *
 * @author dragon
 * @since 2020/11/26
 */
public class User implements Serializable {

    @NotNull(message = "id must not be null", groups = UpdateCheck.class)
    @Positive(message = "is must be positive", groups = UpdateCheck.class)
    @Null(message = "id must be null", groups = CreateCheck.class)
    @JsonView(CommonJsonView.SimpleView.class)
    private Integer id;

    @NotNull(message = "name must not be null")
    @JsonView(CommonJsonView.SimpleView.class)
    private String username;

    @Min(value = 2, message = "age必须大于等于{value}")
    @Max(value = 30, message = "age必须小于等于{value}")
    @JsonView(CommonJsonView.SecretView.class)
    private Integer age;


    private String password;

    @NotNull(message = "订单不能为空")
    @Valid
    private List<Order> orders;

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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
