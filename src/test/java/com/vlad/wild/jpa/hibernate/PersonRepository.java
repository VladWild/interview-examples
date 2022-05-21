package com.vlad.wild.jpa.hibernate;

import org.springframework.data.repository.CrudRepository;
import com.vlad.wild.jpa.hibernate.JpaHibernateTest.Person;

public interface PersonRepository extends CrudRepository<Person, String> {

}