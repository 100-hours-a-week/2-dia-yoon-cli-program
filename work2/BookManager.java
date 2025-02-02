package work2;

import java.util.ArrayList;

public class BookManager {
    public ArrayList<Book> books = new ArrayList<>();
    private int paperBookCounter = 100; // Paper 책 ID 카운트
    private int eBookCounter = 500; // EBook 책 ID 카운트

    public void addBook(Book book) {
        if (book instanceof Paper) {
            book.bookID = paperBookCounter++;
        } else if (book instanceof EBook) {
            book.bookID = eBookCounter++;
        }
        books.add(book);
    }

    public void displayBooks() {
        for (Book book : books) {
            book.getDetails();
        }
    }

    public void removeBook(int bookID) {
        books.removeIf(book -> book.bookID == bookID);
        System.out.println("Book with ID " + bookID + " has been removed.");
    }

    public boolean isBookAvailable(int bookID) {
        for (Book book : books) {
            if (book.bookID == bookID) {
                return true;
            }
        }
        System.out.println("Book with ID " + bookID + " does not exist. Borrowing or reservation is not possible.");
        return false;
    }
}
