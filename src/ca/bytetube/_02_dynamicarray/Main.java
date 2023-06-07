package ca.bytetube._02_dynamicarray;

public class Main {
    public static void main(String[] args) {
        test2();
    }


    public static void test1() {
        ArrayList<Integer> arrayList = new ArrayList<>(20);
        for (int i = 0; i < 10; i = i + 2) {
            arrayList.add(0,i);
        }

        arrayList.add(5,100);
        System.out.println(arrayList);
        Integer removed = arrayList.remove(2);
        System.out.println(removed);

        System.out.println(arrayList);
        System.out.println(arrayList.indexOf(4));
        System.out.println(arrayList.contains(100));
       // System.out.println(arrayList.get(5));
    }

    public static void test2(){
        ArrayList<Person> arrayList = new ArrayList<>();
        Person p1 = new Person("bytetube",7);
        Person p2 = new Person("dal",33);
        Person p3 = new Person("david",24);
        Person p4 = new Person("tony",27);
        arrayList.add(p1);
        arrayList.add(p2);
        arrayList.add(p3);
        arrayList.add(p4);
        System.out.println(arrayList);

        //Person person = arrayList.remove(1);
       // System.out.println(person);
        System.out.println(arrayList);
        arrayList.set(arrayList.size()-1, new Person("tony",27));
        System.out.println(arrayList);
        System.out.println(arrayList.indexOf(p4));
    }
}
