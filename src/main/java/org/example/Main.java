package org.example;

import list.SimpleLinkedList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        List<Integer> javaList = new ArrayList<>();
        javaList.add(1);
        javaList.add(2);
        javaList.add(3);

        System.out.println("size: " + javaList.size());
        Iterator<Integer> jit = javaList.iterator();
        //jit.remove();


        SimpleLinkedList<Integer> list = new SimpleLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        System.out.println("size: " + list.size());
        Iterator<Integer> it = list.iterator();
        while(it.hasNext()) {
            int i = it.next();
            System.out.println(i);
            //it.remove();
        }
        System.out.println("size: " + list.size());
    }
}