public class GenericQueue<E>  {

    MyLinkedList<E> list;

    GenericQueue() {
        list = new MyLinkedList<>();
    }

    public void enqueue(E e) {
        list.addLast(e);
    }

    public E dequeue() {
        return list.removeFirst();
    }

    public int getSize() {
        return list.size();
    }

    @Override
    public String toString() {
        return list.toString();
    }
}
