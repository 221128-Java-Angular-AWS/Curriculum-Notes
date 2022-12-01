public class Main {
    public static void main(String[] args) {
        String str = "hello, world!";
        char[] array = str.toCharArray();


        //Arrays have a length of N
        //Arrays have elements from indices 0 - N-1
        for(int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
        }

        char[] array2 = new char[]{'H', 'E', 'L', 'L', 'O'};




    }
}
