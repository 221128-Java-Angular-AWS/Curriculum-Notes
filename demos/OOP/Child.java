public class Child extends Parent{

    //this method is inherited and then overloaded.
    public int multiply(int a, int b) {
        System.out.println("Child override of multiply method");
        return a * b;
    }


    //Overriding:

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
