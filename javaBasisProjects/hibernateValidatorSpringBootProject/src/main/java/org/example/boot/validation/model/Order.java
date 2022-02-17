package org.example.boot.validation.model;

import support.CreateCheck;
import support.UpdateCheck;

import javax.validation.constraints.NotNull;

/**
 * order model
 *
 * @author dragon
 * @since 2020/11/26
 */
public class Order {

    @NotNull(message = "订单编号不能为空")
    private Long number;

    @NotNull(message = "订单名称不能为空", groups = CreateCheck.class)
    private String name;

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
