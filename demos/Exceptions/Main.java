import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)  {
        ThrowingClass throwing = new ThrowingClass();



        try{
            throwing.throwRandomException();
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
        } catch(FileNotFoundException e){
            e.printStackTrace();
        } catch(CloneNotSupportedException e) {
            e.printStackTrace();
        } catch (CustomException e) {
            e.printStackTrace();
        } finally {
            System.out.println("finally ALWAYS happens");
        }

        //try with resources
        try(Scanner sc = new Scanner(System.in)) {

        }catch(Exception e) {
            e.printStackTrace();
        }


    }
}
