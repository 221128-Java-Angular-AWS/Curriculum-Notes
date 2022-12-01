public class MyConcreteImplementation implements MyInterface, MyOtherInterface {
    public int subtract(int a, int b) {
        return a - b;
    }

    public void printMessage(String msg) {
        System.out.println(msg);
    }
}
