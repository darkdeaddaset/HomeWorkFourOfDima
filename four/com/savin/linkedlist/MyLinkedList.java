package com.savin.linkedlist;

import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class MyLinkedList<E> implements ILinkedList<E>{
    private Node<E> first;
    private Node<E> last;
    private int size;

    @Override
    public void add(E element) {
        if (first == null){
            addFirst(element);
            last = first;
        } else {
            addLast(element);
        }
        size++;
    }

    @Override
    public void add(E element, int index){
        isElementPosition(index);

        if (first == null || index == size){
            add(element);
        }
        if (index == 0){
            addFirst(element);
        } else {
            Node<E> temp = first;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.nextNode;
            }
            temp.nextNode = new Node<>(element, temp.nextNode);
        }
        size++;
    }

    private void addFirst(E element){
        first = new Node<>(element, first);
    }

    private void addLast(E element){
        Node<E> newNode = new Node<>(element, null);
        last.nextNode= newNode;
        last = newNode;
    }

    private void isElementPosition(int index){
        if (!isPosition(index)){
            throw new IndexOutOfBoundsException(outOfBoundsMessage(index));
        }
    }


    private boolean isPosition(int index){
        return index >= 0 && index < this.size;
    }

    private String outOfBoundsMessage(int index){
        return "Index: " + index + ", Size: " + index;
    }

    @Override
    public int size(){
        return size;
    }

    @Override
    public void clear(){
        Node<E> next;
        for(Node<E> node = this.first; node != null; node = next) {
            next = node.nextNode;
            node.element = null;
            node.nextNode = null;
        }

        this.first = this.last = null;
        this.size = 0;
    }

    @Override
    public E get(int index){
        if (index == 0){
            return first.element;
        }
        if (index == size - 1){
            return last.element;
        } else {
            Node<E> node = first.nextNode;
            for (int i = 1; i < index; i++){
                node = node.nextNode;
            }
            return node.element;
        }
    }

    @Override
    public int indexOf(E element) {
        int index = 0;
        Node<E> node;
        if (element == null) {
            for(node = this.first; node != null; node = node.nextNode) {
                if (node.element == null) {
                    return index;
                }

                ++index;
            }
        } else {
            for(node = this.first; node != null; node = node.nextNode) {
                if (element.equals(node.element)) {
                    return index;
                }

                ++index;
            }
        }

        return -1;
    }

    private Node<E> node(int index){
        Node<E> node = first;

        for (int i = 0; i < index; i++){
            node = node.nextNode;
        }

        return node;
    }

    @Override
    public E remove(int index) {
        E element;

        if (index == size - 1){
            element = last.element;
            if (size <= 1){
                clear();
            } else {
                last = node(size - 2);
                last.nextNode = null;
                size--;
            }
        }
        if (index == 0) {
            element = first.element;
            first = first.nextNode;
            size--;
        } else {
            Node<E> nodeRomove = node(index-1);
            Node<E> temp = nodeRomove.nextNode;
            nodeRomove.nextNode = temp.nextNode;
            element = nodeRomove.element;
            size--;
        }
        return element;
    }

    @Override
    public E set(int index, E element) {
        isElementPosition(index);

        Node<E> node = first;
        for (int i = 0; i < index; i++){
            node = node.nextNode;
        }
        node.element = element;
        return node.element;
    }

    @Override
    public Object[] toArray() {
        Object[] objects = new Object[size];
        int i = 0;
        for (Node<E> node = first; node != null; node = node.nextNode){
            objects[i++] = node.element;
        }

        return objects;
    }

    @Override
    public <E1> E1[] toArray(E1[] a) {
        if (a.length < this.size){
            a = (E1[]) Array.newInstance(a.getClass().getComponentType(), this.size);
        }

        int i = 0;
        Object[] result = a;

        for (Node<E> node = this.first; node != null; node = node.nextNode){
            result[i++] = node.nextNode;
        }

        if (a.length > size){
            a[size] = null;
        }

        return a;
    }

    @Override
    public String toString() {
        return  "MyLinkedList{" +
                "first=" + first.element +
                ", last=" + last.element +
                ", size=" + size +
                '}';
    }

    @Override
    public Iterator<E> iterator() {
        return new MyIterator(this.first);
    }

    private static class Node<E>{
        private E element;
        private Node<E> nextNode;

        Node(E element, Node<E> nextNode){
            this.element = element;
            this.nextNode = nextNode;
        }
    }

    private class MyIterator implements Iterator<E>{
        private Node<E> currentNode = new Node<>(null, first);
        private int index;

        public MyIterator(Node<E> first){
            currentNode = first;
        }

        @Override
        public boolean hasNext(){
            return currentNode.nextNode != null;
        }

        @Override
        public E next(){
            if (currentNode == null){
                throw new NoSuchElementException();
            }
            currentNode = currentNode.nextNode;
            return currentNode.element;
        }
    }
}