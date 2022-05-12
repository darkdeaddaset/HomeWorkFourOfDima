package com.savin.linkedlist;

public interface ILinkedList<E> extends Iterable<E>{
    void add(E element);
    void add(E element, int index);
    void clear();
    E get(int index);
    int indexOf(E element);
    E remove(int index);
    E set(int index, E element);
    int size();
    Object[] toArray();
    <E1> E1[] toArray(E1[] a);
    String toString();
}
