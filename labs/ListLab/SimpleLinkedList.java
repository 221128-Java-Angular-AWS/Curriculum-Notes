import java.util.Iterator;

public class SimpleLinkedList<E> implements SimpleList<E>{
    private Node<E> HEAD;

    //constructor
    public SimpleLinkedList() {
        HEAD = null;
    }

    @Override
    public void add(E e) {
        //add element to end of list
    }

    @Override
    public void add(int index, E e) {
        //add element to specified position, splicing it into place
    }

    @Override
    public void clear() {
        //empty array
    }

    @Override
    public void remove(int index) {
        //remove an element from a specified position, splicing it out
    }

    @Override
    public E get(int index) {
        //traverse the list to retrieve a value at position specified
        return null;
    }

    @Override
    public int contains(E e) {
        //traverse the list looking for the specified element, if it is found return the index, otherwise return -1
        return 0;
    }

    @Override
    public int length() {
        return 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Node<E> currentNode = HEAD;

            @Override
            public boolean hasNext() {
                //is there a reference from this node to the next, or is the reference null?
                if(currentNode != null) {
                    return true;
                }
                return false;
            }

            @Override
            public E next() {
                E e = currentNode.e;
                currentNode = currentNode.next;
                return e;
            }
        };
    }


    private class Node<E> {
        E e;
        Node<E> next;
    }
}
