import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        System.out.println(LocalTime.now());
        System.out.println(LocalDateTime.now());
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime currentTime = LocalDateTime.now();
        LocalDateTime nowPlus90Days = currentTime.plusDays(90);
        System.out.println(nowPlus90Days.format(dateFormat));
    }
}
