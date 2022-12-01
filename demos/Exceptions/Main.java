import java.io.FileNotFoundException;
import java.io.IOException;

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
        }


    }
}
