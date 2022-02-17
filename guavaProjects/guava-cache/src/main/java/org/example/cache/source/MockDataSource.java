package org.example.cache.source;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/**
 * 模拟数据库
 *
 * @author dragon
 * @date 2021/10/28
 */
@Data
public class MockDataSource {

    public static final List<Person> personList = new ArrayList<>();

    static {
        for (int i = 0; i < 10000; i++) {
            Person person = new Person();
            person.setName("test" + i);
            person.setAge(i + 1);
            person.setId(i);
            personList.add(person);
        }
    }


    public Person get(int id) {
        return personList.stream()
                .filter(Objects::nonNull)
                .filter(item -> item.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void set(int id, Person person) {
        personList.stream()
                .filter(Objects::nonNull)
                .forEach(item -> {
                    if (item.getId() == id) {
                        item.setName(person.getName());
                        item.setAge(person.getAge());
                    }
                });

    }

    public boolean delete(int id) {
        Iterator<Person> iterator = personList.iterator();
        while (iterator.hasNext()) {
            Person loop = iterator.next();
            if (loop.getId() == id) {
                iterator.remove();
                return true;
            }
        }

        return false;
    }

    public Person update(Person person) {
        Person personDb = get(person.getId());
        if (personDb == null) {
            personDb.setName(person.getName());
            personDb.setAge(person.getAge());
        }  else {
            throw new RuntimeException("更新异常");
        }

        return person;

    }

    public Person save(Person person) {
        person.setId(personList.size());
        personList.add(person);
        return person;
    }


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Person {

        private String name;

        private Integer age;


        private Integer id;

    }
}
