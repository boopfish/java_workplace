package org.example;

import java.util.HashMap;

public class HashMapTest {
    public static void main(String[] args) {
        HashMap<String, User> hashMap = new HashMap<>();
        hashMap.put("1", new User("zhangsan", 18));
        hashMap.put("1", new User("zhangsan", 18));
        System.out.println(hashMap);
    }
}
