package com.myhospital.utility;

import java.util.ArrayList;
import java.util.List;

public class Test {

    private int age;
    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj) && ((Test)obj).getAge() == this.age;
    }

    public static void main(String...strings) {
        Test test = new Test();
        Test test1 = new Test();

        test.setAge(5);
        test1.setAge(5);

        List<Test> l = new ArrayList<>();
        l.add(test1);
        l.add(test);
        l.add(test);

        for(Test t : l)
            System.out.println(test.equals(t));
    }
}
