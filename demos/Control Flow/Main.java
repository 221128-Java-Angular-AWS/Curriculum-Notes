import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("One");
        System.out.println("Two");
        System.out.println("Three");

        int a = 1;
        int b = 5;
        int c = 10;

        //Branching:
        if(a < b) {
            System.out.println("This happens!");
        }

        if(b < a) {
            System.out.println("This never happens");
        }

        System.out.println("We skipped past that if block!");

        if(c < a) {
            System.out.println("This will get skipped");
        } else {
            System.out.println("This happens becuase the predicate was false!");
        }

        if(b < a) {
            System.out.println("We know this gets skipped.");
        } else if(b % 2 == 0) {
            System.out.println("b is not even so this is skipped");
        } else if(c % 2 == 0) {
            System.out.println("This one does happen, because c is even");
        } else {
            System.out.println("This is effectively the default, when all other cases are false");
        }

        String str = "value";
        switch(str) {
            case "value":
                System.out.println("if str == 'value', do this!");
                break;
            case "something else":
                System.out.println("This is a different case!");
                break;
            default:
                System.out.println("This is the default!");
        }

        //lets say you are taking input from the user, navigating menus. for instance, "press Q to quit"
        System.out.print("=================Main Menu===============\n N) new item\n Q) quit");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        switch(input) {
            case "Q":
            case "q":
                System.out.println("They hit quit!");
                break;
        }


        for(int i = 1; i < 10; i++) {
            System.out.println("For loop...");
        }

        int i = 100;
        while(i < 10) {
            System.out.println("While loop...");
            i++;
        }

        int j = 100;
        do {
            System.out.println("This is do-while");
        } while(j < 10);


        List<String> myList = new ArrayList<>();
        myList.add("Hello");
        myList.add("World!");
        for (String element : myList) {
            System.out.println(element);
        }





    }
}
