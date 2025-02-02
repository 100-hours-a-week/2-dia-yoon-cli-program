package work2;
import java.time.LocalDate;

public class Paper extends Book {
    public String genre;
    public int publishYear;
    public int page;
    public int PaperID;

    public Paper(int PaperID,String title, String author, String genre, int publishYear, int page) {
        super(PaperID, title, author);
        this.genre = genre;
        this.publishYear = publishYear;
        this.page = page;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    @Override
    public void getDetails() {
        System.out.println("Book ID: " + bookID + ", Title: " + title + ", Author: " + author);
        System.out.println("Genre: " + genre+ ", publishYear: " + publishYear+ ", Page: " + page);
        System.out.println();
    }

}
