package org.example.boot.validation.service;

import org.example.boot.validation.exception.CustomIllegalException;
import org.example.boot.validation.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 用户 service 服务类
 *
 * @author dragon
 * @since 2020/11/26
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private JdbcTemplate jdbcTemplate;

    @Override
    @Transactional(rollbackFor = CustomIllegalException.class)
    public User save(User user) throws CustomIllegalException {
        String sql = "insert into sys_user(id, username, password) values(? , ? ,?)";
        int affectRows = jdbcTemplate.update(sql, user.getId(), user.getUsername(), user.getPassword());

        if ("dragon".equals(user.getUsername())) {
            throw new CustomIllegalException("用户名为dragon不能修改");
        }

        return user;
    }

    @Override
//    @Transactional(rollbackFor = NumberSourceException.class)
    public User validateAndSave(User user) throws CustomIllegalException{
        User save = save(user);

        return save;

    }
}
