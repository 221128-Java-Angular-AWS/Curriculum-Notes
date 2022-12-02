import java.io.*;
import java.util.Scanner;

public class Maiun {//oops, typo!
    public static void main(String[] args) {

        try(FileWriter fileWriter = new FileWriter("file.txt", true);//append mode?
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);) {

            Scanner sc = new Scanner(System.in);

            boolean quit = false;
            while(!quit) {
                System.out.println("Enter some text to be written to the file: ");
                bufferedWriter.write(sc.nextLine() + "\n");
                //bufferedWriter.flush();
                System.out.println("Would you like to continue adding more text? (Y/N)");
                String doQuit = sc.nextLine();
                if(doQuit.equals("N") || doQuit.equals("n")) {
                    quit = true;
                }
            }

            //bufferedWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }





        System.out.println("Now reading from the file...");
        try(FileReader fileReader = new FileReader("file.txt")) {

            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while(bufferedReader.ready()) {
                System.out.println(bufferedReader.readLine());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
