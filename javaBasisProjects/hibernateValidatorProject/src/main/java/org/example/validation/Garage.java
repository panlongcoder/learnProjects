package org.example.validation;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @author dragon
 * @since 2020/11/25
 */
public class Garage {

    private String name;

    public Garage(String name) {
        this.name = name;
    }

    public boolean checkCar(@Valid @NotNull Car car) {
        //...
        return false;
    }
}
