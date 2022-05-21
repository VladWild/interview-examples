package com.vlad.wild.jpa.hibernate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.format.support.DefaultFormattingConversionService;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import com.vlad.wild.jpa.hibernate.JpaHibernateTest.Person;
import com.vlad.wild.jpa.hibernate.JpaHibernateTest.Car;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

/**
 * Оптимальный ли тут будет запрос?
 */

@DataJpaTest
@ExtendWith(SpringExtension.class)
@PropertySource("classpath:application.properties")
@ContextConfiguration(classes = DefaultFormattingConversionService.class)
@EntityScan(basePackageClasses = {Person.class, Car.class})
@EnableJpaRepositories(basePackageClasses = PersonRepository.class)
public class JpaHibernateTest {

    @Autowired
    private PersonRepository personRepository;

    @Test
    @Sql("classpath:insert.sql")
    public void problemTest() {
        Iterable<Person> persons = personRepository.findAll();
        System.out.println(persons);
    }

    /**
     * public interface PersonRepository extends CrudRepository<Person, String> {
     *
     * }
     */

    @Entity
    @Table(name = "persons")
    public static class Person {
        private Long id;
        private String name;
        private Set<Car> cars;

        @Id
        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @OneToMany
        @JoinColumn(name = "person_id")
        public Set<Car> getCars() {
            return cars;
        }

        public void setCars(Set<Car> cars) {
            this.cars = cars;
        }
    }

    @Entity
    @Table(name = "cars")
    public static class Car {
        private Long id;
        private String model;

        @Id
        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }
    }
}
