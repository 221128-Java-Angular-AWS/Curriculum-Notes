public class Main {

    public static void main(String[] args) {
        //Primitives are simple variables that store a little bit of data,
        short s = 21555;
        int i = 215555555; //integer, whole numbers including negatives
        long l = 999999999; //very large integers
        float f = 2.2f; //less precise floating point number
        double d =  5.5f; //more precise floating point number
        boolean b = true; //true or false values only
        char c = 'G';
        byte by = 127;

        //Everything besides primitives are classes. These are wrapper classes, special class versions
        //of the primitives with some helper behaviors.
        Short sh = s;
        Integer in = i;
        Long lo = l;
        Float fl = f;
        Double db = d;
        Boolean bool = b;
        Character ch = c;
        Byte byt = by;

        //Strings are not primitives, they are class objects. String is not really a wrapper but can be thought
        //of that way. The primitive held within a string is a c-style character array
        String str = "Hello, World!";
        String hello = str.substring(0, 6);


        //This is what is "inside" a string, this is a character array
        char[] cStyleString = new char[]{'h','e','l','l','o'};


    }

}
