/*
Bundling data and behaviors together is called "encapsulation" and this is how we came up with the concept
of classes and objects. Encapsulation also includes the concept of hiding the internal state of the data
and allowing access to modify it.
 */

public class Parent {
    /*
    Here we have data. Several variables (called fields in a class in java). Encapsulation includes the concept
    that a class object should have behaviors that allow modification of its internal data. That data should never
    be accessed or changed directly. To control this we use access modifiers.
     */
    public int a; //public access - available anywhere
    protected int b; //protected access - accessible from this class or from child-classes
    int c; //with no access modifier this one is "package-private" which makes it accessible from here, children, and any other classes in the same package
    private int d; //private access - available only from within this class


    /*
    These are methods, behaviors. There is a toString() and a multiply() method here. Below that there
    are "mutators" or "getters" and "setters". These methods are made public and should be used to read and
    modify the private state variables in this class. This is how we achieve that second part of encapsulation.
    This also represents an interface of sorts. We create publicly accessible getters and setters to
    access the private fields.
     */
    public int multiply(int a, int b) {
        System.out.println("Parent version of multiply method");
        int product = 0;
        for(int i = 0; i < b; i++) {
            product += a;
        }
        return product;
    }

    public String toString() {
        return new String(String.valueOf(a));
    }

    //getter - by convention should be named "getVariableName()"
    public int getD() {
        return d;
    }

    //setter - by convention should be named "setVariableName()"
    public void setD(int d) {
        this.d = d;
    }
}
