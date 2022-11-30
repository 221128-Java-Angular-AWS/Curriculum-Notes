public class Main {
    static String classScope = "This string is class/static scoped.";
    public static void main(String[] args) {


        //We can access static/class scoped stuff by just de-referencing the class itself
        MyClass.staticMethod();


        //Here we have a code block, and anything declared inside is block scoped
        String methodScoped = "This string is in the main method scope.";
        {
            System.out.println(methodScoped);
            System.out.println(classScope);
            String blockString = "This is block scoped.";
            System.out.println(blockString);
        }


        Object obj = new Object();
        Object obj2 = obj;









    }

    public void myMethod() {

    }
}
