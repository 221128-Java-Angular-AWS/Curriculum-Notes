/*
Bundling data and behaviors together is called "encapsulation" and this is how we came up with the concept
of classes and objects. Encapsulation also includes the concept of hiding the internal state of the data
and allowing access to modify it.
 */

public class Parent {
    // this is data, a variable called a of type int
    int a;

    //These are methods, behaviors. There is a toString and a multiply method here.
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

}
