package com.savin.test;

import java.util.*;

public class TestClass {
    public void testList(){
        System.out.println("Test List");

        List<Integer> array = new ArrayList<>();
        List<Integer> linked = new LinkedList<>();

        System.out.println("Add Array: " + addCollection(array));
        System.out.println("Add LinkedList: " + addCollection(linked));

        System.out.println("Remove Array: " + removeCollection(array,15));
        System.out.println("Remove LinkedList: " + removeCollection(linked, 15));

        System.out.println("Contains Array: " + containsCollection(array, 50));
        System.out.println("Contains LinkedList: " + containsCollection(linked, 50));

        System.out.println("==============================================================");
    }

    private static long addCollection(Collection<Integer> collection){
        long start = System.nanoTime();
        for (int i = 0; i < 100; i++){
            collection.add(i);
        }
        long finish = System.nanoTime() - start;
        return finish;
    }

    private static long removeCollection(Collection<Integer> collection, int i){
        long start = System.nanoTime();
        for (int j = 0; j<i; j++){
            collection.remove(j);
        }
        long finish = System.nanoTime() - start;
        return finish;
    }

    private static long containsCollection(Collection<Integer> collection, Integer integer){
        long start = System.nanoTime();
        boolean result = collection.contains(integer);
        System.out.println(result);
        long finish = System.nanoTime() - start;
        return finish;
    }

    public void testSet(){
        System.out.println("Test Set");

        Set<Integer> hashset = new HashSet<>();
        Set<Integer> linkedHashSet = new LinkedHashSet<>();
        Set<Integer> treeSet = new TreeSet<>();

        System.out.println("Add HashSet: " + addCollection(hashset));
        System.out.println("Add LinkedHashSet: " + addCollection(linkedHashSet));
        System.out.println("Add TreeSet: " + addCollection(treeSet));

        System.out.println("Remove HashSet: " + removeCollection(hashset, 15));
        System.out.println("Remove LinkedHashSet: " + removeCollection(linkedHashSet, 15));
        System.out.println("Remove TreeSet: " + removeCollection(treeSet, 15));

        System.out.println("Search HashSet: " + containsCollection(hashset, 50));
        System.out.println("Search LinkedHashSet: " + containsCollection(linkedHashSet, 50));
        System.out.println("Search TreeSet: " + containsCollection(treeSet, 50));

        System.out.println("==============================================================");
    }

    private static long addMap(Map<Integer,Integer> map){
        long start = System.nanoTime();
        for (int i = 0 ; i < 100; i++){
            map.put(i, i);
        }
        long finish = System.nanoTime() - start;
        return finish;
    }

    private static long removeMap(Map<Integer, Integer> map, int index){
        long start = System.nanoTime();
        for (int i = 0; i < index; i++){
            map.remove(i);
        }
        long finish = System.nanoTime() - start;
        return finish;
    }

    private static long containsMap(Map<Integer, Integer> map, Integer index){
        long start = System.nanoTime();
        System.out.println(map.containsKey(index));
        long finish = System.nanoTime() - start;
        return finish;
    }

    public void testMap(){
        System.out.println("Test Map");

        Map<Integer, Integer> hashMap = new HashMap<>();
        Map<Integer, Integer> linkedHashMap = new LinkedHashMap<>();
        Map<Integer, Integer> treeMap = new TreeMap<>();

        System.out.println("Add HashMap: " + addMap(hashMap));
        System.out.println("Add LinkedHashMap: " + addMap(linkedHashMap));
        System.out.println("Add TreeMap: " + addMap(treeMap));

        System.out.println("Remove HashMap: " + removeMap(hashMap, 50));
        System.out.println("Remove LinkedHashMap: " + removeMap(linkedHashMap, 50));
        System.out.println("Remove TreeMap: " + removeMap(treeMap, 50));

        System.out.println("Contains HashMap: " + containsMap(hashMap, 50));
        System.out.println("Contains LinkedHashMap: " + containsMap(linkedHashMap, 50));
        System.out.println("Contains TreeMap: " + containsMap(treeMap, 50));

        System.out.println("==============================================================");
    }
}
