public class SimpleArrayList<E> implements SimpleList<E>{
    private int BASE_SIZE = 4;
    private int MAX_SIZE;
    private int length;
    private Object[] array;

    //constructor
    public SimpleArrayList() {
        array = new Object[BASE_SIZE];
        MAX_SIZE = BASE_SIZE;
        length = 0;
    }

    private void grow() {
        MAX_SIZE *= 2;
        Object[] temp = array;
        array = new Object[MAX_SIZE];
        for(int i = 0; i < temp.length; i++) {
            array[i] = temp[i];
        }
    }

    @Override
    public void add(E e) {
        //add element to end of list
    }

    @Override
    public void add(int index, E e) {
        //add element to specified position, shifting all later elements one space
    }

    @Override
    public void clear() {
        //empty array, should we resize back to base size?
    }

    @Override
    public E remove(int index) {
        //remove an element from a specified position, shifting all later elements back one space to fill in the gap
        return null;
    }

    @Override
    public E get(int index) {
        //retrieve a value from the list at position specified
        return null;
    }

    @Override
    public int contains(E e) {
        //traverse the list looking for the specified element, if it is found return the index, otherwise return -1
        return 0;
    }
}
