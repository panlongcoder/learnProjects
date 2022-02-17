package org.example.boot.validation.enums;

import cn.hutool.json.JSONUtil;

/**
 * @author dragon
 * @date 2021/9/6
 */
public enum Week {

    MONDAY(1, "星期一"),

    TUESDAY(2, "星期二"),

    WEDNESDAY(3, "星期三"),

    THURSDAY(4, "星期四"),

    FRIDAY(5, "星期五"),

    SATURDAY(6, "星期六"),

    SUNDAY(7, "星期日");

    private int code;

    private String name;

    Week(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return JSONUtil.createObj().set("code", this.name())
                .set("name", this.getName()).toString();
    }

    public static void main(String[] args) {
        String s = JSONUtil.createObj().set("code", "FRIDAY")
                .set("name", "星期五").toString();

        System.out.println(s);
    }
}

