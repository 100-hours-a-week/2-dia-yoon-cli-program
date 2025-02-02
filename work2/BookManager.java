package work2;

import java.util.ArrayList;

public class BookManager {
    public ArrayList<Book> books = new ArrayList<>();

    public void addBook(Book book) {
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
