import java.io.FileNotFoundException;
import java.io.IOException;

public class ThrowingClass {
    public void throwRandomException() throws FileNotFoundException, ClassNotFoundException,
            CloneNotSupportedException, CustomException {
        int rng = (int)(Math.random() * 10);

        switch(rng) {
            case 0:
                throw new FileNotFoundException("Throwing an exception");
            case 1:
                throw new CloneNotSupportedException("Throwing an exception");
            case 2:
                throw new ClassNotFoundException("Throwing an exception");
            case 3:
                throw new CustomException("Throwing an exception");
            default:
                return;
        }
    }
}
