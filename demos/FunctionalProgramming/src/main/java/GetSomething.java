import java.util.Optional;

public class GetSomething {
    public static Optional<String> getSomething() {
        String str = null;
        if(Math.random() >= 0.5) {
            str = "value is present!";
        }

        return Optional.ofNullable(str);
    }
}
