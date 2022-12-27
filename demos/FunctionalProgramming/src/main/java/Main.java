import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        FunctionalInterface myInt = n -> { int x = n * 2; return x;};



        List<AssociateModel> myList = new ArrayList<>();
        myList.add(new AssociateModel("Kyle", 37));
        myList.add(new AssociateModel("Will", 32));
        myList.add(new AssociateModel("Kirill", 26));
        myList.add(new AssociateModel("Travis M", 34));
        myList.add(new AssociateModel("Brayden", 24));


        myList.stream().filter(a -> {if(a.getAge() < 30) return true; return false;})
                .map(a -> a.getName())
                .limit(5)
                .forEach(s -> System.out.println(s));


        System.out.println(GetSomething.getSomething().orElse("It was empty :("));




    }
}
