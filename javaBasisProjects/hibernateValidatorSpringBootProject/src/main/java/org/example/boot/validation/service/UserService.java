package org.example.boot.validation.service;

import org.example.boot.validation.exception.CustomIllegalException;
import org.example.boot.validation.model.User;
import org.springframework.validation.annotation.Validated;


/**
 * user service interface
 *
 * @author dragon
 * @since 2020/11/26
 */
@Validated
public interface UserService {

     User save(User  user) throws CustomIllegalException;

     User validateAndSave(User user) throws CustomIllegalException;
}
