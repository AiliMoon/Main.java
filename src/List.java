import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class List<E> extends MyAbstractClass<E>{

    private static final int INITIAL_CAPACITY = 10;
    private E[] data;
    private int size = 0;


    public List() {
        this(INITIAL_CAPACITY);
    }

    public List(int capacity) {
        data = (E[]) new Object[capacity];
    }

    @Override
    public void add(int index, E o) {
        if(index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException("Index: " + index + " size: " + size);
        }
        ensureCapacity();

        if (size - index >= 0) System.arraycopy(data, index, data, index + 1, size - index);
        data[index] = o;
        size++;
    }

    private void ensureCapacity() {
        if(data.length <= size) {
            E[] buff = (E[]) (new Object[data.length * 2 + 1]);
            System.arraycopy(data, 0, buff, 0, size);
            data = buff;
        }
    }

    public E get(int index) {
        checkIndex(index);
        return data[index];
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("Index: " + index + ", size: " + size);
        }
    }

    @Override
    public int indexOf(E o) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public E remove(int index) {
        checkIndex(index);

        E e = data[index];

        if (size - 1 - index >= 0) System.arraycopy(data, index + 1, data, index, size - 1 - index);

       /*
       *checkIndex(index);

        E e = data[index];

        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        data[size - 1] = null;
        size--;
        return e; */

        data[--size] = null;
        return e;
    }

    @Override
    public E set(int index, E o) {
        checkIndex(index);
        E temp = data[index];
        data[index] = o;
        return temp;
    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayListIterator();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(data, size);
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean remove(Object o) {
        E e = (E)o;
        int index = indexOf(e);

        if (index == -1) {
            return false;
        }
        remove(index);
        return true;
    }


    public int lastIndexOf(E e) {
       for (int i = size - 1; i >= 0; i--) {
           if (data[i].equals(e)) {
               return i;
           }
       }
        return -1;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        E[] a = (E[])c.toArray();

        for(E e : a) {
            add(e);
        }
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {

        for(int i = 0; i < size; i++) {
           if (c.contains(data[i])) {
               remove(data[i]);
               return true;
           }
        }
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
        data = (E[]) (new Object[INITIAL_CAPACITY]);
        size = 0;
    }

    public void trimToSize() {
        if(size != data.length) {
            E[] buff = (E[]) new Object[size];
            System.arraycopy(data, 0, buff, 0, size);
            data = buff;
        }
    }

    @Override
    public String toString() {
        StringBuilder text = new StringBuilder("[");
        for (int i = 0; i < size; i++){
            text.append(data[i]);

            if(i < size - 1){
                text.append(", ");
            }
        }
        text.append("]");
        return text.toString();
    }

    private class ArrayListIterator implements Iterator<E> {

        private int current;

        @Override
        public boolean hasNext() {
            return current < size;
        }

        @Override
        public E next() {
            return data[current++];
        }
    }
}
