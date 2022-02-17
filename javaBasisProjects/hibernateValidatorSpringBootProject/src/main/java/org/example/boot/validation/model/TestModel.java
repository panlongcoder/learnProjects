package org.example.boot.validation.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonView;
import org.example.boot.validation.enums.Gender;
import org.example.boot.validation.enums.Week;
import support.CommonJsonView;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * @author dragon
 * @date 2021/9/7
 */
public class TestModel implements Serializable {

    private static final long serialVersionUID = 6649751334586172964L;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @JsonView(CommonJsonView.SimpleView.class)
    private LocalDate beginDate;

    @JsonFormat(pattern = "H:mm")
    @JsonView(CommonJsonView.SimpleView.class)
    private LocalTime beginTime;

    @NotNull(message = "星期不能为空")
    @JsonView(CommonJsonView.DetailView.class)
    private Week week;

    @JsonView(CommonJsonView.SimpleView.class)
    private Gender gender;

    public TestModel(Week week, Gender gender) {
        this.week = week;
        this.gender = gender;
    }

    public TestModel() {
    }

    public LocalDate getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(LocalDate beginDate) {
        this.beginDate = beginDate;
    }

    public LocalTime getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(LocalTime beginTime) {
        this.beginTime = beginTime;
    }

    public Week getWeek() {
        return week;
    }

    public void setWeek(Week week) {
        this.week = week;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
