package com.vlad.wild.spring;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ExampleService {

    public void method1() {

        //do something ...

        method2();

        //do something ...
    }

    @Transactional
    public void method2() {

        //all code in transactional

    }
}
