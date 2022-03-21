package com.vlad.wild.streams;

import java.util.stream.Stream;

public class MainExample {

    public static void main(String[] args) {

        Stream.of(2, 3, 4, 5).filter(value -> {
            System.out.println(value);
            return value > 3;
        }).map(value -> String.valueOf(value));

    }
}
