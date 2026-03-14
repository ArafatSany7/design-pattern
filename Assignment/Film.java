public class Film {
    private String title;
    private String director;

    public Film(String title, String director) {
        this.title = title;
        this.director = director;
    }

    public void display() {
        System.out.println("Title: " + title + ", Director: " + director);
    }

    public static void main(String[] args) {
        Film myFilm = new Film("Inception", "Christopher Nolan");

        myFilm.display();

    }

}
