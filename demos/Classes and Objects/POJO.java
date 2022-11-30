import java.util.Objects;

public class POJO {
    private int field1;
    private String field2;
    private boolean field3;

    public POJO() {
    }

    public POJO(int a, String b, boolean c) {
        this.field1 = a;
        this.field2 = b;
        this.field3 = c;
    }

    public int getField1() {
        return this.field1;
    }

    public void setField1(int i) {
        this.field1 = i;
    }

    public String getField2() {
        return this.field2;
    }

    public void setField2(String str) {
        this.field2 = str;
    }

    public boolean isField3() {
        return this.field3;
    }

    public void setField3(boolean field3) {
        this.field3 = field3;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        POJO pojo = (POJO) o;
        return field1 == pojo.field1 && field3 == pojo.field3 && Objects.equals(field2, pojo.field2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(field1, field2, field3);
    }
}
