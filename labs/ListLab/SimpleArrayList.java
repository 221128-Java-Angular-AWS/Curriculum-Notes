import java.util.Iterator;

public class SimpleArrayList<E> implements SimpleList<E>{
    private int BASE_SIZE = 4;
    private int MAX_SIZE;
    private int cursor;
    private Object[] array;

    //constructor
    public SimpleArrayList() {
        init();
    }

    private void init() {
        MAX_SIZE = BASE_SIZE;
        array = new Object[MAX_SIZE];
        cursor = 0;//cursor always points to the last empty space in the array (or may point off the end of the array when we must grow)

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
        //make sure we have space in the array to fit another element - when length == max_size we must grow before adding
            //if not: invoke grow()
            //if so: add element

        while(cursor >= MAX_SIZE) {
            grow();
        }

        array[cursor] = e;
        cursor++;
    }

    @Override
    public void add(int index, E e) throws IndexOutOfBoundsException {
        //add element to specified position, shifting all later elements one space
        //need to make sure index is withing our array's limits
            //if index >= MAX_SIZE - now we need to grow
            //if index < 0 - this is bad times
        //if index < cursor - we MAY need to shift
            //if array[index] == null, then we do not need to shift
            //start at end of array, use for loop to traverse backwards toward cursor shifting elements one space
        //if index = cursor - all we need to do is the same as the add operation above
        //if index > cursor - we need to add the element there, and advance cursor to an appropriate position

        if(index < 0) {
            throw new IndexOutOfBoundsException();
        }

        while(index >= MAX_SIZE) {
            grow();
        }

        if(index == cursor) {
            add(e);
            return;
        }

        if(index > cursor) {
            array[index] = e;
            cursor = index + 1;
            return;
        }

        if(index < cursor) {
            for(int i = cursor; i > index; i--) {
                array[i] = array[i-1];
            }
            array[index] = e;
        }
    }

    @Override
    public void clear() {
        //empty array - returning to the original BASE_SIZE
        init();
    }

    @Override
    public void remove(int index) throws IndexOutOfBoundsException {
        //remove an element from a specified position, shifting all later elements back one space to fill in the gap
        if(index < 0 || index >= cursor) {
            throw new IndexOutOfBoundsException();
        }
        array[index] = null;

        if(index < cursor) {
            for(int i = index; i < cursor-1; i++) {
                array[i] = array[i+1];
            }
            array[cursor-1] = null;
        }

        cursor--;
    }

    @Override
    public E get(int index) throws IndexOutOfBoundsException{
        //retrieve a value from the list at position specified
        if(index < 0 || index >= cursor) {
            throw new IndexOutOfBoundsException();
        }
        return (E)array[index];
    }

    @Override
    public int contains(E e) {
        //traverse the list looking for the specified element, if it is found return the index, otherwise return -1
        for(int i = 0; i < cursor; i++) {
            if(array[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int length() {
        return cursor;
    }


    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int i = 0;
            @Override
            public boolean hasNext() {
                if(i < cursor) {
                    return true;
                }

                return false;
            }

            @Override
            public E next() {
                return (E)array[i++];
            }
        };
    }
}
