public interface SimpleList<E> {
    /*
    add
    add at index
    clear
    remove at index
    get index
    contains
     */

    void add(E e);
    void add(int index, E e);
    void clear();
    E remove(int index);
    E get(int index);
    int contains(E e);
}
