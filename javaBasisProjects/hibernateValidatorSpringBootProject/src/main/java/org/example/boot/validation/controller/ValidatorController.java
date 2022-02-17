package org.example.boot.validation.controller;

import com.fasterxml.jackson.annotation.JsonView;
import org.example.boot.validation.enums.Gender;
import org.example.boot.validation.enums.Week;
import org.example.boot.validation.exception.CustomIllegalException;
import org.example.boot.validation.model.TestModel;
import org.example.boot.validation.model.User;
import org.example.boot.validation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import support.CommonJsonView;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * validator controller
 *
 * @author dragon
 * @since 2020/11/26
 */
@RestController
@RequestMapping("/validation")
public class ValidatorController {

    @Autowired
    private UserService userService;

    @PostMapping("/user")
    @JsonView(CommonJsonView.SimpleView.class)
    public User save(@RequestBody User user) throws CustomIllegalException {
        User returnUser = userService.save(user);

        return returnUser;
    }

    @PutMapping("/user")
    @JsonView(CommonJsonView.SecretView.class)
    public User update(@RequestBody User user) {
//        return userService.update(user);

        return null;
    }

    @PostMapping
    public TestModel add(@Validated @RequestBody TestModel testModel) {
        System.out.println(testModel);
        return testModel;
    }


    @GetMapping
    public Map<Gender, List<TestModel>> list() {
        TestModel testModel1 = new TestModel(Week.FRIDAY, Gender.MAN);
        TestModel testModel2 = new TestModel(Week.MONDAY, Gender.WOMAN);
        TestModel testModel3 = new TestModel(Week.TUESDAY, Gender.MAN);
        TestModel testModel4 = new TestModel(Week.WEDNESDAY, Gender.MAN);
        TestModel testModel5 = new TestModel(Week.TUESDAY, Gender.WOMAN);
        TestModel testModel6 = new TestModel(Week.SUNDAY, Gender.WOMAN);

        ArrayList<TestModel> models = new ArrayList<>();
        models.add(testModel1);
        models.add(testModel2);
        models.add(testModel3);
        models.add(testModel4);
        models.add(testModel5);
        models.add(testModel6);
        models.add(testModel1);

        return models.stream()
                .collect(Collectors.groupingBy(TestModel::getGender));

    }

    @GetMapping("/simple")
    @JsonView(CommonJsonView.SimpleView.class)
    public List<TestModel> simple() {
        TestModel testModel1 = new TestModel(Week.FRIDAY, Gender.MAN);
        testModel1.setBeginDate(LocalDate.now());
        testModel1.setBeginTime(LocalTime.now());
        TestModel testModel2 = new TestModel(Week.MONDAY, Gender.WOMAN);
        TestModel testModel3 = new TestModel(Week.TUESDAY, Gender.MAN);
        TestModel testModel4 = new TestModel(Week.WEDNESDAY, Gender.MAN);
        TestModel testModel5 = new TestModel(Week.TUESDAY, Gender.WOMAN);
        TestModel testModel6 = new TestModel(Week.SUNDAY, Gender.WOMAN);
        testModel6.setBeginDate(LocalDate.now());
        testModel6.setBeginTime(LocalTime.now());
        ArrayList<TestModel> models = new ArrayList<>();
        models.add(testModel1);
        models.add(testModel2);
        models.add(testModel3);
        models.add(testModel4);
        models.add(testModel5);
        models.add(testModel6);
        models.add(testModel1);

        return models;
    }


}
