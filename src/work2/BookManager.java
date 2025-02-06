import java.util.ArrayList;
import java.util.List;

public class BookManager {
    public ArrayList<Book> books = new ArrayList<>();
    private List<User> users;

    public BookManager(List<User> users) {
        this.users = users;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    // 책 추가
    public void addBook(Book book) {
        books.add(book);
    }

    // 전체 도서 목록 출력
    public void displayBooks() {
        for (Book book : books) {
            book.getDetails();
            System.out.println();
        }
    }

    // 도서 제거
    public void removeBook(int bookID) {
        books.removeIf(book -> book.bookID == bookID);
        System.out.println("책 아이디 " + bookID + " 가 제거되었습니다. ");
    }
}
