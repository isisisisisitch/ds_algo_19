package ca.bytetube._03_list;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new SingleLinkedList<>();
        for (int i = 10; i < 20; i++) {
            list.add(0,i);
        }

        System.out.println(list.remove(5));

        System.out.println(list);

    }
}
