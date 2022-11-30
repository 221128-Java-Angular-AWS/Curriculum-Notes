public class Main {
    public static void main(String[] args) {
        //ternary operator, like an if statement but not
        String str = (10 % 2 == 0)? "even" : "odd";



        int i = 0;
        i++; //postfix increment operator
        ++i; //prefix increment operator



        int a = 1;
        System.out.println("a = " + a++);
        System.out.println("a = " + ++a);
        System.out.println("a = " + a);



        Object o1 = new MyClass(1);
        Object o2 = new MyClass(1);
        Object copy = o1;
        Object o3 = new MyClass(2);
        Object child = new MySubClass(6);

        if(o3 instanceof MySubClass) {
            System.out.println("instanceof true!");
        }




        if (o1.equals(o2)) {
            System.out.println("These are equal.");
        }


    }
}
