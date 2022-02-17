package org.example.jdk.java8.optional;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * @author dragon
 * @since 2021/3/3
 */
public class OptionalDemo {

    public static void main(String[] args) {
        Optional<String> optional = Optional.of("hero");

        optional.ifPresent(System.out::println);

        System.out.println(optional.orElse("dragon"));

        Employee employee = new Employee();
        employee.setName("dragon");

        Employee employee1 = new Employee();
        employee1.setName("mars");

        Company company = new Company();
        company.setName("长江实业");

        List<Employee> employees = Arrays.asList(employee, employee1);
        company.setEmployeeList(employees);

        Optional<Company> companyOptional = Optional.of(company);

        System.out.println(companyOptional.map(Company::getEmployeeList).orElse(Collections.emptyList()));

        Optional.empty().orElseThrow(() -> new RuntimeException());
    }

    static class Company {
        private String name;

        private List<Employee> employeeList;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<Employee> getEmployeeList() {
            return employeeList;
        }

        public void setEmployeeList(List<Employee> employeeList) {
            this.employeeList = employeeList;
        }
    }

    static class Employee {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
