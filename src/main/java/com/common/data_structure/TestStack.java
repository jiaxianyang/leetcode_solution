package com.common.data_structure;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TestStack {

    public static void main(String[] args) {
        Deque<String> queue = new ArrayDeque<>();
        queue.push("one");
        queue.push("two");
        queue.push("three");
        queue.push("four");
        System.out.println(queue);
        queue.poll();
        System.out.println(queue);
    }
}
