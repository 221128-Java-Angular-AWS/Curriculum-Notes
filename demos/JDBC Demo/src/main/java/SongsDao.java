import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class SongsDao {
    public Set<Song> getAllSongs() {
        /*
        First we grab our singleton connection to the database from our connection factory.
        Then we write the SQL statement as a String
        Then we prepare a Set of Song objects to hold the results.
         */
        Connection connection = ConnectionFactory.getConnection();
        String sql = "SELECT * FROM songs";
        Set<Song> songs = new HashSet<>();

        try {
            /*
            Here we are preparing the Statement, which is an object that has the necessary
            info to connect to the database and execute a statement. Note how we get our
            Statement object by calling the connection object's createStatement() method.
            This is how the statement object gets the data from connection.
            We then call the statement object's executeQuery() method, passing it the SQL String
            we wrote earlier. That method returns a ResultSet object, which we store for the next
            part...
             */
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            /*
            The ResultSet object can be thought of as a 2D array, or a list of lists. It's basically
            an Excel spreadsheet, just like you would see if you queried the table yourself in dbeaver.
            Similar to the Iterable interface, we use a .next() method to traverse the results. However,
            instead of using hasNext() to test if there is more in the set, and next() to retrieve it,
            ResultSet only has the next() method. next() returns true if there are more rows in the set,
            and advances an internal iterator. The first time we call next() it will then be pointing
            to the first item in the list. Repeated calls advance the iterator until there are no
            rows left.

            As we traverse these rows, we marshall the data from this format into a set of song objects.
             */
            while(rs.next()) {
                Song song = new Song();
                song.setId(rs.getInt("id"));
                song.setArtistId(rs.getInt("artist_id"));
                song.setTitle(rs.getString("title"));
                song.setAlbum(rs.getString("album"));
                songs.add(song);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return songs;
    }


    public Set<Song> getSongsByArtist(String artist) {
        Connection connection = ConnectionFactory.getConnection();
        String sql = "SELECT S.id, S.artist_id, S.title, S.album  FROM artists A JOIN songs S ON A.id = S.artist_id WHERE A.artist = ?";
        Set<Song> songs = new HashSet<>();

        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, artist);
            ResultSet rs = pstmt.executeQuery();

//            ResultSetMetaData meta = rs.getMetaData();
//            for(int i = 1; i < 7; i++) {
//                System.out.println("COLUMN: " + meta.getColumnLabel(i));
//            }


            while(rs.next()) {
                Song song = new Song();
                song.setId(rs.getInt("id"));
                song.setArtistId(rs.getInt("artist_id"));
                song.setTitle(rs.getString("title"));
                song.setAlbum(rs.getString("album"));
                songs.add(song);

            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return songs;
    }


    public int insertNewSong(Song song) {
        Connection connection = ConnectionFactory.getConnection();
        String sql = "INSERT INTO songs (title, artist_id, album) VALUES (?, ?, ?)";
        Integer result = -1;
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, song.getTitle());
            pstmt.setInt(2, 1);
            pstmt.setString(3, song.getAlbum());
            result = pstmt.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

}
