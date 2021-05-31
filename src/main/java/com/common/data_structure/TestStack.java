package com.common.data_structure;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TestStack {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack);
        System.out.println(stack.search(4));
        stack.pop();
//        stack.pop();

        System.out.println(stack);
        Integer topElement = stack.peek();
        System.out.println(topElement);
        System.out.println("2 的位置： " + stack.search(1));


        System.out.println("======================================");

        Queue<String> queue = new LinkedList<>();
        queue.offer("one");
        queue.offer("two");
        queue.offer("three");
        queue.offer("four");
        System.out.println(queue);
        String polledElement = queue.poll();
        System.out.println(polledElement);
        System.out.println(queue);
        String peekedElement = queue.peek();
        System.out.println(peekedElement);
        System.out.println(queue);
        while (queue.size() > 0) {
            System.out.println(queue.poll());
        }
    }
}
