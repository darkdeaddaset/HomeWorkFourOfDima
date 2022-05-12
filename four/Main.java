import com.savin.linkedlist.MyLinkedList;

import java.util.*;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args){
        LinkedList<Integer> list = new LinkedList<>();
        long start = System.nanoTime();
        list.add(5);
        list.add(1);
        list.add(7);
        list.add(7);
        list.add(7);
        list.add(10);
        long finish = System.nanoTime() - start;

        System.out.println(finish);

        start = System.nanoTime();
        list.add(2, 8);
        finish = System.nanoTime() - start;
        System.out.println(finish);

        start = System.nanoTime();
        list.remove(1);
        finish = System.nanoTime() - start;
        System.out.println(finish);
/*
        for(Integer i : list){
            System.out.print(i + "\t");
        }
        System.out.println();

        System.out.println(list.indexOf(5));
        System.out.println(list.size());
        System.out.println(list.remove(0));

        System.out.println("===================================");*/

        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        start = System.nanoTime();
        myLinkedList.add(5);
        myLinkedList.add(1);
        myLinkedList.add(7);
        myLinkedList.add(7);
        myLinkedList.add(7);
        myLinkedList.add(10);
        finish = System.nanoTime() - start;

        System.out.println(finish);
        System.out.println("Remove");
        start = System.nanoTime();
        myLinkedList.add(8, 2);
        finish = System.nanoTime() - start;
        System.out.println(finish);

        for (Integer i : myLinkedList){
            System.out.println(i);
        }

        start = System.nanoTime();
        myLinkedList.remove(1);
        finish = System.nanoTime() - start;
        System.out.println(finish);

        System.out.println(myLinkedList.toString());
        System.out.println(myLinkedList.indexOf(7));
        System.out.println(myLinkedList.size());
        System.out.println(myLinkedList.remove(0));
        myLinkedList.clear();
        System.out.println(myLinkedList.size());


        //testList();
        //testSet();
        //testMap();
    }

    private static void testList(){
        List<Integer> list1 = new ArrayList<>();
        long start = System.nanoTime();
        list1.add(1);
        long finish = System.nanoTime();
        System.out.println(finish - start);
        start = System.nanoTime();
        list1.add(1, 5);
        finish = System.nanoTime();
        System.out.println(finish - start);
        list1.add(10);
        start = System.nanoTime();
        list1.remove(2);
        finish = System.nanoTime();
        long result = finish - start;
        System.out.println("Remove: " + result);

        List<Integer> list2 = new LinkedList<>();
        start = System.nanoTime();
        list2.add(1);
        finish = System.nanoTime();
        System.out.println(finish - start);
        start = System.nanoTime();
        list2.add(1,5);
        finish = System.nanoTime();
        System.out.println(finish - start);
        list2.add(10);
        start = System.nanoTime();
        list2.remove(2);
        finish = System.nanoTime();
        result = finish - start;
        System.out.println("Remove: " + result);
    }
    private static void testSet(){
        Set<Integer> integers = new HashSet<>();
        long start = System.nanoTime();
        integers.add(4);
        long finish = System.nanoTime();
        System.out.println(finish - start);
        integers.add(9);
        integers.add(6);
        integers.add(7);

        start = System.nanoTime();
        integers.remove(9);
        finish = System.nanoTime() - start;
        System.out.println("Remove: " + finish);

        for (int s : integers){
            System.out.println(s);
        }

        Set<Integer> integers1 = new LinkedHashSet<>();
        start = System.nanoTime();
        integers1.add(4);
        finish = System.nanoTime();
        System.out.println(finish - start);
        integers1.add(5);
        integers1.add(6);
        integers1.add(7);
        integers1.add(9);
        start = System.nanoTime();
        integers1.remove(9);
        finish = System.nanoTime() - start;
        System.out.println("Remove: " + finish);


        Set<Integer> integers2 = new TreeSet<>();
        start = System.nanoTime();
        integers2.add(4);
        finish = System.nanoTime();
        System.out.println(finish - start);
        integers2.add(5);
        integers2.add(6);
        integers2.add(7);
        integers2.add(9);
        start = System.nanoTime();
        integers2.remove(6);
        finish = System.nanoTime() - start;
        System.out.println("Remove: " + finish);
    }
    private static void testMap(){
        Map<String, Integer> map = new HashMap<>();
        long start = System.nanoTime();
        map.put("Test", 1);
        map.put("Test1", 11);
        map.put("Test2", 111);
        map.put("Test3", 1111);
        long finish = System.nanoTime() - start;
        System.out.println(finish);

        //System.out.println(map.get("Test3"));

        start = System.nanoTime();
        map.remove("Test");
        map.remove("Test1");
        map.remove("Test2");
        map.remove("Test3");
        finish = System.nanoTime() - start;
        System.out.println(finish);

        Map<String, Integer> linkedHashMap= new LinkedHashMap<>();
        start = System.nanoTime();
        linkedHashMap.put("Test", 1);
        linkedHashMap.put("Test1", 11);
        linkedHashMap.put("Test2", 111);
        linkedHashMap.put("Test3", 1111);
        finish = System.nanoTime() - start;
        System.out.println(finish);

        start = System.nanoTime();
        linkedHashMap.remove("Test");
        linkedHashMap.remove("Test1");
        linkedHashMap.remove("Test2");
        linkedHashMap.remove("Test3");
        finish = System.nanoTime() - start;
        System.out.println(finish);

        Map<String, Integer> t = new TreeMap<>();
        start = System.nanoTime();
        t.put("Test", 1);
        t.put("Test1", 11);
        t.put("Test2", 111);
        t.put("Test3", 1111);
        finish = System.nanoTime() - start;
        System.out.println(finish);

        start = System.nanoTime();
        t.remove("Test");
        t.remove("Test1");
        t.remove("Test2");
        t.remove("Test3");
        finish = System.nanoTime() - start;
        System.out.println(finish);
    }
}