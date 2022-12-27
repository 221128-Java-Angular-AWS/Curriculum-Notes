@java.lang.FunctionalInterface
public interface FunctionalInterface {
    int testFunc1(int a);
    static int testFunc2(int c) {
        return 2;
    }
    default int testFunc3(int d) {
        return 1;
    }
}
