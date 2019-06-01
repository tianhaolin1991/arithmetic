package com.cp3;

import java.util.ArrayList;

/**
 * @author:tianhaolin
 * @version:1.0
 */
public class MyListTest {
    public static void main(String[] args) {
        //MyArrayListTest
        MyArrayList<String> strings = new MyArrayList<>();
        strings.add("a");
        strings.add("b");
        strings.add("c");

        strings.add(1,"d");
        strings.remove(2);
        //String s = strings.get(3);
        System.out.println(strings);

        MyLinkedList<String> linkedList = new MyLinkedList<>();
        linkedList.add("a");
        linkedList.add("b");
        linkedList.add("c");

        linkedList.add(1,"d");

        String remove = linkedList.remove(0);
        System.out.println(remove);
        System.out.println(linkedList);

    }
}
