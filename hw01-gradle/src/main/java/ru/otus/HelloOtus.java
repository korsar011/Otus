package ru.otus;

import com.google.common.collect.ImmutableList;

import java.util.List;

public class HelloOtus {
    public static void main(String[] args) {
        List<Integer> numbers = ImmutableList.of(1,2,3);
        System.out.println(numbers);
    }
}

