import java.util.Collection;
import java.util.Iterator;

public abstract class MyAbstractClass<E> implements MyList<E>{

    public boolean add(E o) {
        add(size(), o);
        return true;
    }

    @Override
    public boolean contains(Object o) {

        Iterator<E> iterator = iterator();
        while (iterator.hasNext()) {
            if (iterator.next().equals(o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {

        for (Object e : c) {
            if(!contains(e)) {
                return false;
            }
        }
        return true;
    }
}
