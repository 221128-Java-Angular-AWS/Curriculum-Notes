import java.io.Serializable;

public interface SimpleList<E> extends Iterable<E> {
    /*
    add
    add at index
    clear
    remove at index
    get index
    contains
     */

    void add(E e);
    void add(int index, E e) throws IndexOutOfBoundsException;
    void clear();
    void remove(int index) throws IndexOutOfBoundsException;
    E get(int index) throws IndexOutOfBoundsException;
    int contains(E e);
    int length();
}
