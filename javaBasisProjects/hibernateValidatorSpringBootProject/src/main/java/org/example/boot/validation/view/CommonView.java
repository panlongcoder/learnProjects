package org.example.boot.validation.view;

/**
 * @author dragon
 * @date 2021/9/10
 */
public interface CommonView {

    interface SimpleView{}

    interface DetailView extends SimpleView {}

    interface SecretView extends DetailView {}
}
