package com.baidu._04_Test;

import java.util.Arrays;
import java.util.List;

public class TestUser {
    public static void main(String[] args) {
        List<User> list = List.of(new User("ikun1", 18), new User("ikun2", 19));
        System.out.println(list);
    }
}
