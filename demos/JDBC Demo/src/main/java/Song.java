import java.util.Objects;

public class Song {
    private Integer id;
    private Integer artistId;
    private String title;
    private String album;

    public Song() {
    }

    public Song(Integer id, Integer artistId, String title, String album) {
        this.id = id;
        this.artistId = artistId;
        this.title = title;
        this.album = album;
    }

    public Song(Integer artistId, String title, String album) {
        this.artistId = artistId;
        this.title = title;
        this.album = album;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getArtistId() {
        return artistId;
    }

    public void setArtistId(Integer artistId) {
        this.artistId = artistId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Song song = (Song) o;
        return Objects.equals(id, song.id) && Objects.equals(artistId, song.artistId) && Objects.equals(title, song.title) && Objects.equals(album, song.album);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, artistId, title, album);
    }

    @Override
    public String toString() {
        return "Song{" +
                "id=" + id +
                ", artistId=" + artistId +
                ", title='" + title + '\'' +
                ", album='" + album + '\'' +
                '}';
    }
}
