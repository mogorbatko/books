package com.gorbatko.books.condition;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public enum Sort {
    ASC("ASC"),
    DESC("DESC");

    private static final Set<String> SORTS = Arrays.stream(values())
            .map(Sort::getName)
            .collect(Collectors.toSet());

    public static boolean isExist(String sort) {
        return SORTS.contains(sort);
    }

    private final String name;
    Sort(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
