package work2;
import java.time.LocalDate;

public class Book {
    protected int bookID;
    protected String title;
    protected String author;
    protected boolean isBorrowed;
    protected boolean isReserved;
    protected LocalDate dueDate;


    public Book(int bookID,String title, String author) {
        this.title = title;
        this.bookID = bookID;
        this.author = author;
        this.isBorrowed = false;
        this.isReserved = false;
    }

    public void getDetails() {
        System.out.println("Book ID: " + bookID + ", Title: " + title + ", Author: " + author + ", Borrowed: " + isBorrowed + ", Reserved: " + isReserved);
    }

    public void updateInfo(String title, String author) {
        this.title = title;
        this.author = author;
    }
}