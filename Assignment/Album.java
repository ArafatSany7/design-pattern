import java.time.Year;

public class Album {
    private String title;
    private String genre;
    private int releaseYear;

    public Album(String title, String genre, int releaseYear) {
        this.title = title;
        this.genre = genre;
        this.releaseYear = releaseYear;
    }

    public Album(String title, String genre) {
        this(title, genre, Year.now().getValue());
    }

    public void display() {
        System.out.println("Title: " + title + ", Genre: " + genre + ", Releeease Year: " + releaseYear);
    }

    public static void main(String[] args) {

        Album album1 = new Album("Abbey Road", "Rock", 1969);

        Album album2 = new Album("Green River", "Rock");

        album1.display();
        album2.display();

    }
}
