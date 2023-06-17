package ca.bytetube._03_list;

import ca.bytetube._03_list.doubly.LinkedList;
import ca.bytetube._03_list.single.SingleCircularLinkedList;
import ca.bytetube._03_list.single.SingleLinkedList;

public class Main {
    public static void main(String[] args) {
//        List<Integer> list = new SingleLinkedList<>();
//        for (int i = 10; i < 20; i++) {
//            list.add(0,i);
//        }
//
//        System.out.println(list.remove(5));
//
//        System.out.println(list);
        test2();
    }


    public static void test1(){
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 10; i < 20; i++) {
            list.add(0,i);
        }


        System.out.println();
        while (list.size > 0 ){
            list.remove(0);
        }

        System.out.println();
    }

    public static void test2(){
        SingleCircularLinkedList<Integer> list = new SingleCircularLinkedList<>();
        for (int i = 10; i < 20; i++) {
            list.add(0,i);
        }


        System.out.println();
        while (list.size > 0){
            list.remove(0);
            System.out.println(list);
        }

       // System.out.println(list);
    }
}
