import java.util.ArrayList;
import java.util.Collections;

public class Heap<E extends Comparable<E>> {

    private ArrayList<E> list = new ArrayList<E>();

    public Heap() {

    }

    public Heap(E[] objects) {
        for (int i = 0; i < objects.length; i++) {
            add(objects[i]);
        }
    }

    public void add(E element) {
        list.add(element);

        int current = list.size() - 1;
        while (current > 0) {
            int parentIndex = (current - 1) / 2;

            if (list.get(current).compareTo(list.get(parentIndex)) > 0) {
//                E temp = list.get(current);
//                list.set(current, list.get(parentIndex));
//                list.set(parentIndex, temp);
                Collections.swap(list, parentIndex, current);
            }
            else {
                break;
            }
            current = parentIndex;
        }
    }

    public E remove() {
        if (list.size() == 0) {
            return null;
        }
        E removedObject = list.get(0);
        list.set(0, list.get(list.size() - 1));
        list.remove(list.size() - 1);

        int currentIndex = 0;
        while (currentIndex < list.size()) {
            int leftChild = 2 * currentIndex + 1;
            int rightChild = 2 * currentIndex + 2;

            if (leftChild >= list.size()) {
                break;
            }

            int maxIndex = leftChild;
            // есть ли у правого потомка свои потомки
            if (rightChild < list.size()) {
                // если мах меньше чем правый потомок, то мах == правый потомок
                if (list.get(maxIndex).compareTo(list.get(rightChild)) < 0) {
                    maxIndex = rightChild;
                }
            }
            // если родитель меньше макс индекса, то текущий индекс(родитель) становится максимальным индексом
            if (list.get(currentIndex).compareTo(list.get(maxIndex)) < 0) {
                Collections.swap(list, currentIndex, maxIndex);
                currentIndex = maxIndex;
            } else {
                break;
            }
        }
        return removedObject;
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int getSize() {
        return list.size();
    }

    @Override
    public String toString() {
        return list.toString();
    }
}
