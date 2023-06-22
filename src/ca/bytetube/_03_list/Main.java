package ca.bytetube._03_list;

import ca.bytetube._03_list.doubly.DoublyCircularLinkedList;
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
//        test3();
        josephus(8,2);
    }


    public static void test1(){
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 10; i < 16; i++) {
            list.add(0,i);
        }


//        System.out.println();
//        while (list.size > 0 ){
//            list.remove(0);
//        }

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


    public static void test3(){
        DoublyCircularLinkedList<Integer> list = new DoublyCircularLinkedList<>();
        for (int i = 10; i < 16; i++) {
            list.add(0,i);
        }
        System.out.println();
        while (list.size > 0 ){
            list.remove(0);
        }
        System.out.println();

    }


    public static void josephus(int numOfPpl,int step){
        DoublyCircularLinkedList<Integer> list = new DoublyCircularLinkedList<>();
        for (int i = 1; i <= numOfPpl ; i++) {
            list.add(i);
        }

        list.reset();
        while (list.size > 1){
            next(list,step);
            System.out.println(list.remove());
        }


    }

    private static void next(DoublyCircularLinkedList<Integer> list, int step){
        for (int i = 0; i < step; i++) {
            list.next();
        }
    }

}
