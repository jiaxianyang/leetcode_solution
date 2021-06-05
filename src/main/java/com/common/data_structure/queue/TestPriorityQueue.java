package com.common.data_structure.queue;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

/**
 * TestPriorityQueue简介
 * <p>
 * 测试优先队列
 *
 * @author jiaxianyang
 * @date 2021-06-03 17:38
 */
public class TestPriorityQueue {

    public static void main(String[] args) {
        Queue<Integer> integerPriorityQueue = new PriorityQueue<>(7);


        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            integerPriorityQueue.add(new Integer(random.nextInt(100)));
        }

        for (int i = 0; i < 10; i++) {
            System.out.println("processing Integer: " + integerPriorityQueue.poll());
        }


        //优先队列使用示例

        Queue<Customer> customerPriorityQueue = new PriorityQueue<>(7, idComparator);

        addDataToQueue(customerPriorityQueue);


        pollDataFromQueue(customerPriorityQueue);
    }


    //匿名Comparator实现
    public static Comparator<Customer> idComparator = new Comparator<Customer>() {
        @Override

        public int compare(Customer c1, Customer c2) {

            return (int) (c2.getId() - c1.getId());

        }

    };

    //用于往队列增加数据的通用方法

    private static void addDataToQueue(Queue<Customer> customerPriorityQueue) {

        Random rand = new Random();

        for (int i = 0; i < 7; i++) {

            int id = rand.nextInt(100);

            customerPriorityQueue.add(new Customer(id, "Pankaj " + id));

        }

    }


    //用于从队列取数据的通用方法

    private static void pollDataFromQueue(Queue<Customer> customerPriorityQueue) {

        while (true) {

            Customer cust = customerPriorityQueue.poll();

            if (cust == null) break;

            System.out.println("Processing Customer with ID=" + cust.getId());

        }

    }
}
