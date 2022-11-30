public class MyClass {
    //Class/Static scoped stuff:
    public static int a;
    public static String str;
    public static void staticMethod() {
        System.out.println("This is a static method");
    }

    //This stuff is object scoped, only exists once we instantiate an object of this class
    public int b;
    public String str2;
    public void objectMethod() {
        System.out.println("This is a non-static method on an object of type MyClass");
    }


    //This method will have its own variables which are "method scoped"
    public void methodScope() {
        int c;
        char d;
        String str3 = "This is method scoped!";

        {

        }


    }


}
