public class Main {

    public static void main(String[] args) {
        /*
        Primitives are simple variables that store one piece of data. Primitives are stored in the stack
        portion of memory.
         */
        short s = 21555;
        int i = 215555555; //integer, whole numbers including negatives
        long l = 999999999; //very large integers
        float f = 2.2f; //less precise floating point number
        double d =  5.5f; //more precise floating point number
        boolean b = true; //true or false values only
        char c = 'G';
        byte by = 127;

        /*
        Everything besides primitives are classes. These are wrapper classes, special class versions
        of the primitives with some helper behaviors.
         */
        Short sh = s;
        Integer in = i;
        Long lo = l;
        Float fl = f;
        Double db = d;
        Boolean bool = b;
        Character ch = c;
        Byte byt = by;

        /*
        Note that we don't use the new keyword with a constructor for these. We just auto-box these, basically
        treating them like primitives. The JVM doesn't care, you can use primitives, and you can use wrappers
        anywhere a primitive is appropriate. The reverse is not true, you can't always use a primitive where a
        wrapper would work.
         */
        //Character newChar = new Character('H'); //this is no longer valid syntax.
        Character newChar = 'C'; //Just auto-box it instead



        /*
        Strings are not primitives, they are class objects. String is not really a wrapper but can be thought
        of that way. The primitive held within a string is a c-style character array. Strings are so integral
        to the language that they have special rules, and we wouldn't want to instantiate a string like other objects
        */
        //This is what is "inside" a string, a character array
        char[] cStyleString = new char[]{'h','e','l','l','o'};

        String newString = new String("Hello, World!");//this isn't the best way to create a string
        String str = "Hello, World!"; //this is better
        String str2 = "Hello, World!"; //both of these string references are actually pointing to the same thing
        String hello = str.substring(0, 6); //strings are class objects, and thus have methods like substring()

        /*
        Strings get special optimizations in Java. Strings get put in a memory location called the "String Pool".
        If we create a string with the new keyword, that doesn't end up in the string pool. We can add a string
        to the pool by using the intern() method. If we instantiate the string without the new keyword (see above)
        that string is automatically interned in the string pool.
         */
        String newStringInPool = newString.intern(); //this creates a copy of the string value in the string pool
        String anotherStringInPool = "This one goes right into the string pool automatically.";

        /*
        likewise, there are other optimizations at work as well. Concatenating strings is very inefficient. So we
        have a tool called the StringBuilder. This class will build an object that has efficient methods for
        doing concatenation.
         */
        StringBuilder sb = new StringBuilder();
        sb.append("Hi,");
        sb.append(" Kyle.");
        System.out.println(sb.toString());

    }

}
