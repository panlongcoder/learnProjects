package org.example.boot.validation.enums;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
import support.CommonJsonView;

/**
 * @author dragon
 * @date 2021/9/6
 */

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Gender {

    MAN(1, "MAN", "女性"),

    WOMAN(2, "WOMAN", "男性");

    @JsonIgnore
    @JsonView(CommonJsonView.SimpleView.class)
    private final Integer code;

    @JsonProperty
    @JsonView(CommonJsonView.SimpleView.class)
    private final String name;

    @JsonView(CommonJsonView.SimpleView.class)
    private final String value;

    Gender(Integer code, String name, String value) {
        this.code = code;
        this.name = name;
        this.value = value;
    }

    public Integer getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }
}
