
import java.util.Collection;
import java.util.Deque;
import java.util.Iterator;

public class MyLinkedList<E> extends MyAbstractClass<E> implements Deque<E> {

    private Node<E> head;
    private Node<E> tail;
    private int size;

    public MyLinkedList() {

    }

    @Override
    public void add(int index, E o) {
        if (index == 0) {
            addFirst(o);
        } else if (index >= size) {
            addLast(o);
        } else {
            Node<E> current = head;

            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            Node<E> temp = current.next;
            current.next = new Node<>(o);
            (current.next).next = temp;
            size++;
        }
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public E remove(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        else if (index == 0) {
            return removeFirst();
        }
        else if (index == size - 1) {
            return removeLast();
        }
        else {
            Node<E> previous = head;

            for (int i = 0; i < index - 1; i++) {
                previous = previous.next;
            }

            Node<E> current = previous.next;
            previous.next = current.next;
            size--;
            return current.element;
        }
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }

        Node<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.element;
    }

    @Override
    public E set(int index, E o) {
        Node<E> previous = head;

        for (int i = 0; i < index - 1; i++) {
            previous = previous.next;
        }
        Node<E> current = previous.next;
        previous.next = new Node<>(o);
        previous.next = current.next;
        return current.element;
    }

    @Override
    public void addFirst(E o) {
        Node<E> newNode = new Node<>(o);
        newNode.next = head;
        head = newNode;
        size++;

        if (tail == null) {
            tail = head;
        }
    }

    @Override
    public void addLast(E o) {
        Node<E> newNode = new Node<>(o);

        if (tail == null) {
            tail = head = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    @Override
    public boolean offerFirst(Object o) {
        return false;
    }

    @Override
    public boolean offerLast(Object o) {
        return false;
    }

    @Override
    public E removeFirst() {
        if (size == 0) {
            return null;
        } else {
            Node<E> temp = head;
            head = head.next;
            if (head == null) {
                tail = null;
            }
            size--;
            return temp.element;
        }
    }

    @Override
    public E removeLast() {
        if (size == 0) {
            return null;
        } else {
            Node<E> current = head;

            for (int i = 0; i < size - 2; i++) {
                current = current.next;
            }
            Node<E> temp = tail;
            tail = current;
            tail.next = null;
            size--;
            return temp.element;
        }
    }

    @Override
    public E pollFirst() {
        return null;
    }

    @Override
    public E pollLast() {
        return null;
    }

    @Override
    public E getFirst() {
        if (size == 0) {
            return null;
        }
        else {
            return head.element;
        }
    }

    @Override
    public E getLast() {
        if (size == 0) {
            return null;
        }
        return tail.element;
    }

    @Override
    public E peekFirst() {
        return null;
    }

    @Override
    public E peekLast() {
        return null;
    }

    @Override
    public boolean removeFirstOccurrence(Object o) {
        return false;
    }

    @Override
    public boolean removeLastOccurrence(Object o) {
        return false;
    }

    @Override
    public boolean offer(Object o) {
        return false;
    }

    @Override
    public E remove() {
        return null;
    }

    @Override
    public E poll() {
        return null;
    }

    @Override
    public E element() {
        return null;
    }

    @Override
    public E peek() {
        return null;
    }

    @Override
    public void push(Object o) {

    }

    @Override
    public E pop() {
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator iterator() {
        return new LinkedListIterator();
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public void clear() {
        head = tail = null;
        size = 0;
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }

    @Override
    public Iterator descendingIterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator<E> implements Iterator<E> {

        Node<E> current = (Node<E>) head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            E temp = current.element;
            current = current.next;
            return temp;
        }
    }

    private static class Node<E> {
        E element;
        Node<E> next;

        Node(E element) {
            this.element = element;
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("head -> ");
        Node<E> current = head;
        for (int i = 0; i < size; i++) {
            result.append(current.element);
            current = current.next;
            if(current != null) {
                result.append(" -> ");
            }
            else {
                result.append(" <- tail");
            }
        }
        return result.toString();
    }
}
