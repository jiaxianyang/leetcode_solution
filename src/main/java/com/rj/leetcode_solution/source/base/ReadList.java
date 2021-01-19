package com.rj.leetcode_solution.source.base;


import com.rj.leetcode_solution.common.entity.Person;
import com.rj.leetcode_solution.common.utils.json.JsonUtil;

import java.util.ArrayList;

public class ReadList {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>(10);
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        System.out.println(JsonUtil.toJsonString(list));
        list.add(2, "f");
        System.out.println(JsonUtil.toJsonString(list));
        //测试系统copy
        testSystemCopy();
    }


    public static void testSystemCopy() {
        Person[] arr = new Person[10];
        arr[0] = new Person("jiaxianyang", 0);
        arr[1] = new Person("jiaxianyang1", 1);
        arr[2] = new Person("jiaxianyang2", 2);
        arr[3] = new Person("jiaxianyang3", 3);
        arr[4] = new Person("jiaxianyang4", 4);
        arr[5] = new Person("jiaxianyang5", 5);
        arr[6] = new Person("jiaxianyang6", 6);
        System.out.println(JsonUtil.toJsonString(arr));
        System.arraycopy(arr, 4, arr, 4 + 1,
                7 - 4);
        arr[4] = new Person("test", 101);
        System.out.println(JsonUtil.toJsonString(arr));
    }
}
