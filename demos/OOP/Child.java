/*
This class extends the Parent class. This is the most basic form of inheritance in Java.
This means that the child class has all the same data and behaviors (fields and methods) of the parent
class. We inherited these.
 */

public class Child extends Parent {
    //this method is inherited and then overridden
    public int multiply(int a, int b) {
        System.out.println("Child override of multiply method");
        return a * b;
    }


    /*
    Overloading - here we have several methods with the same symbol (the same name). They are
    differentiated by the parameter lists. The first add() method has 2 parameters. The next has 3,
    and the last one can have any number of parameters. When we invoke an add() method by name, the
    JVM chooses an appropriate overload based on the parameters we send.
     */
    public int add(int a, int b) {
        System.out.println("2 parameter method invoked");
        return a + b;
    }

    public int add(int a, int b, int c) {
        System.out.println("3 parameter method invoked");
        return a+b+c;
    }

    /*
    Note that this overload overlaps with the 2- and 3-parameter versions. This is okay, the JVM will
    use the most specific method it can find.
     */
    public int add(int ...nums) {
        System.out.println("var-args method invoked");
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        return sum;

    }


}
