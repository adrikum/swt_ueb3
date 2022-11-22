package org.example;

import list.SimpleLinkedList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        SimpleLinkedList<Integer> list = new SimpleLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        System.out.println("size: " + list.size());
        Iterator<Integer> it = list.iterator();
        while(it.hasNext()) {
            int i = it.next();
            System.out.println(i);
            it.remove();
        }

        System.out.println("size: " + list.size());
        System.out.println(list);

        list.add(3);
        list.add(4);
        list.add(5);

        System.out.println(list);
    }
}