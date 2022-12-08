import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a new song by Led Zeppelin: ");
        String title = scanner.nextLine();

        System.out.println("Enter the album: ");
        String album = scanner.nextLine();

        Song song = new Song(1, title, album);

        SongsDao dao = new SongsDao();


        int rowCount = dao.insertNewSong(song);

        System.out.println("rowCount: " + rowCount);


    }
}
