import java.util.Collection;
import java.util.Iterator;

public interface MyList<E> extends Collection<E> {

    void add(int index, E o);

    int indexOf(E o);

    E remove(int index);

    E set(int index, E o);

    E get(int index);


    default boolean isEmpty() {
       return size() == 0;
    }


    @Override
    Iterator<E> iterator();
}
