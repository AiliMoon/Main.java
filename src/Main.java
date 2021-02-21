public class Main  {
    public static void main(String[] args) {

        Heap<Integer> heap = new Heap<>();
        heap.add(23);
        heap.add(36);
        heap.add(76);
        heap.add(34);
        heap.add(87);

        MyHashMap<Integer, Integer> myHashMap = new MyHashMap<>();
        myHashMap.put(1, 2);
        myHashMap.put(2, 4);
        myHashMap.put(3, 16);

        for(int i = 1; i <= myHashMap.size(); i++) {
            System.out.println(myHashMap.get(i));
        }
    }
}
