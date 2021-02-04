package _13_Workshop.CustomLinkedList;

import com.sun.source.tree.BreakTree;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;
import java.util.function.Consumer;

public class CustomLinkedList {

    private Node head;
    private Node tail;
    private int size;

    private static class Node {
        private int element;
        private Node next;
        private Node previous;

        public Node(int element) {
            this.element = element;
        }
    }

    public void addFirst(int element) {
        Node newNode = new Node(element);
        if (this.head != null) {
            newNode.next = this.head;
            this.head.previous = newNode;
        }

        this.head = newNode;

        if (isEmpty()) {
            this.tail = this.head;
        }

        this.size++;
    }

    public void addLast(int element) {
        if (isEmpty()) {
            addFirst(element);
            return;
        }

        Node newNode = new Node(element);
        this.tail.next = newNode;
        newNode.previous = this.tail;
        this.tail = newNode;
        this.size++;
    }

    public int removeLast() {

        if (this.size < 2) {
            return removeFirst();
        }

        int removedElement = this.tail.element;
        this.tail = this.tail.previous;
        this.tail.next = null;
        this.size--;
        return removedElement;
    }

    public void clear() {
        if (!this.isEmpty()) {
            Node current = this.head;
            while (current != null) {
                Node next = current.next;
                current.previous = null;
                current.next = null;
                current = null;
            }
            this.size = 0;
            this.head = null;
            this.tail = null;
        }
    }

    public int removeFirst() {
        if (this.isEmpty()) {
            throw new IllegalStateException("The data structure you're trying to remove from is empty");
        }

        int removedElement = this.head.element;
        this.head = this.head.next;
        if (this.size > 1) {
            this.head.previous = null;
        }

        this.size--;

        if (this.isEmpty()) {
            this.head = this.tail = null;
        }
        return removedElement;
    }

    public void forEach(Consumer<Integer> consumer) {
        Node current = this.head;
        while (current != null) {
            consumer.accept(current.element);
            current = current.next;
        }

    }

    public int[] toArray() {
        int[] array = new int[this.size];
//variant 1 = with array
        Node current = this.head;
        int index = 0;
        while (current != null) {
            array[index] = current.element;
            current = current.next;
            index++;
        }


// variant 2 - with list
        List<Integer> list = new ArrayList<>();
        forEach(list::add);
        return list.stream().mapToInt(e -> e).toArray();

        //return array;
    }

    public int get(int index) {
        validateIndex(index);

        Node current = this.head;
        int currentIndex = 0;
        int element = 0;

        while (current != null) {
            if (index == currentIndex) {
                element = current.element;
                break;
            }
            currentIndex++;
            current = current.next;
        }
        return element;
    }

    private void validateIndex(int index) {
        if (index < 0 || index >= this.size) {
            throw new IllegalArgumentException(String.format("Index: %d, size - There is no such index in data structure."
                    , index, this.size));
        }
    }

    public int getSize() {
        return this.size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

}

