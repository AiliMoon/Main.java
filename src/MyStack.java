import java.util.ArrayList;
import java.util.EmptyStackException;

public class MyStack<E> {

    private ArrayList<E> list = new ArrayList<>();

    public int size() {
        return list.size();
    }

    public void push(E o) {
        list.add(o);
    }

    public E peek() {
        return list.get(size() - 1);
    }

    public E pop() {
        if (!isEmpty()) {
            E o = list.get(size() - 1);
            list.remove(size() - 1);
            return o;
        }
        else {
            throw new EmptyStackException();
        }
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

}
