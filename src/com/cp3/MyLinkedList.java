package com.cp3;

import java.util.Iterator;

/**
 * @author:tianhaolin
 * @version:1.0
 */
public class MyLinkedList<E> implements Iterable<E> {

    private int theSize;
    private int count;
    private Node<E> beginNode;
    private Node<E> endNode;

    private class Node<E> {
        private E data;
        private Node<E> prev;
        private Node<E> next;

        private Node(E data, Node<E> prev, Node<E> next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }

        @Override
        public String toString() {
            return "" + data;
        }
    }

    public MyLinkedList() {
        doClear();
    }

    private void doClear() {
        beginNode = new Node<E>(null, null, null);
        endNode = new Node<E>(null, beginNode, null);
        beginNode.next = endNode;
        theSize = 0;
    }

    public boolean isEmpty() {
        return this.theSize == 0;
    }

    public int size() {
        return this.theSize;
    }

    public E get(int index) {
        Node<E> node = getNode(index);
        return node.data;
    }

    private Node<E> getNode(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> nextNode = beginNode.next;
        for (int i = 1; i <= index; i++) {
            nextNode = nextNode.next;
        }
        return nextNode;
    }

    public void add(E element) {
        add(size(), element);
    }

    private Node<E> getNodeBefore(int index) {
        Node<E> nodeBefore;
        if (index - 1 < 0) {
            nodeBefore = beginNode;
        } else {
            nodeBefore = getNode(index - 1);
        }
        return nodeBefore;
    }

    private Node<E> getNodeAfter(int index) {

        Node<E> nodeAfter;
        if (index + 1 == size()) {
            nodeAfter = endNode;
        } else {
            nodeAfter = getNode(index +1);
        }
        return nodeAfter;
    }

    public void add(int index, E element) {
        if (index < 0) {
            throw new IndexOutOfBoundsException();
        }

        Node<E> eNode = new Node<>(element, null, null);
        Node<E> nodeBefore = getNodeBefore(index);
        Node<E> nodeAfter = getNodeAfter(index-1);

        eNode.prev = nodeBefore;
        eNode.next = nodeAfter;

        nodeBefore.next = eNode;
        nodeAfter.prev = eNode;

        this.theSize++;
    }

    public E remove(int index) {
        Node<E> node = getNode(index);
        Node<E> nodeBefore = getNodeBefore(index);
        Node<E> nodeAfter = getNodeAfter(index);
        nodeBefore.next = nodeAfter;
        nodeAfter.prev = nodeBefore;
        this.theSize--;
        return node.data;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public String toString() {
        StringBuffer str = new StringBuffer("[");
        Node<E> node = this.beginNode;
        for (int i = 0; i < size(); i++) {
            node = node.next;
            str.append(node.data + ",");
        }
        str.append("]");
        return str.toString();
    }
}
