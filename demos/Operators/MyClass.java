import java.util.Objects;

public class MyClass {
    public int i;
    public int j;
    public MyClass(int i) {
        this.i = i;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyClass myClass = (MyClass) o;
        return i == myClass.i;
    }

    @Override
    public int hashCode() {
        return Objects.hash(i, j);
    }
}
