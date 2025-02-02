// Paper.java
package work2;

import java.time.LocalDate;

public class Paper extends Book {
    public String genre;
    public int publishYear;
    public int page;
    public int PaperID;

    public Paper(String title, String author, String genre, int publishYear, int page) {
        super(title, author);
        this.genre = genre;
        this.publishYear = publishYear;
        this.page = page;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }


    public void borrow(int userID) {
        if (!isBorrowed) {
            isBorrowed = true;
            dueDate = LocalDate.now().plusWeeks(1);
            System.out.println(title + " borrowed by User ID: " + userID);
            System.out.println("Due Date: " + LocalDate.now() + " ~ " + dueDate);
        } else {
            System.out.println(title + " is already borrowed.");
        }
    }

    @Override
    public void getDetails() {
        System.out.println("Book ID: " + bookID + ", Title: " + title + ", Author: " + author);
        System.out.println("Genre: " + genre+ ", publishYear: " + publishYear+ ", Page: " + page);
        System.out.println();
    }

    public void returnBook(int userID) {
        if (isBorrowed) {
            isBorrowed = false;
            dueDate = null;
            System.out.println("Book returned by User ID: " + userID);
        } else {
            System.out.println("Book was not borrowed.");
        }
    }
}
