package org.example.boot.validation;

import org.example.boot.validation.exception.CustomIllegalException;
import org.example.boot.validation.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author dragon
 * @date 2021/9/7
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceTest {

    @Resource
    private UserService userService;

    @Test
    public void test() throws CustomIllegalException {
        userService.save(null);
    }

}
