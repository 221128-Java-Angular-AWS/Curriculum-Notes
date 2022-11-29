public class Main {
    public static void main(String[] args) {
        Parent p = new Parent();
        int product = p.multiply(2, 2);

        System.out.println("parent product 2x2 = " + product);

        Parent c = new Child(); //sub-type polymorphism, see below
        product = c.multiply(2, 2);

        System.out.println("child product 2x2 = " + product);



        /*
        note how this is a reference to type Parent, but the object itself is of type Child.
        parent is a class, child is its subclass, as Child extends Parent.
        This is called sub-type polymorphism. Note that we can also store it in a reference of type Object,
        this is because implicitly all objects inherit from the Object class
         */
        Child c1 = new Child();
        Parent c2 = new Child();
        Object c3 = new Child();

        System.out.println(c1.add(1,2,3,4,5,6,7,8,9));

    }
}
