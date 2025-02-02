package work2;
import java.util.ArrayList;

public class User {
    int userID;
    String name;
    String email;
    ArrayList<Book> borrowedBooks = new ArrayList<>();

    public User(int userID, String name, String email) {
        this.userID = userID;
        this.name = name;
        this.email = email;
    }

    public int getUserID() {
        return userID;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void checkList() {
        if (borrowedBooks.isEmpty()) {
            System.out.println("대출하신 도서가 없습니다.");
        } else {
            System.out.println("대출하신 도서 목록입니다.");
            for (Book book : borrowedBooks) {
                System.out.println("책 ID: " + book.bookID + ", 제목: " + book.title);
            }
        }
    }
    public void addBorrowedBook(Book book) {
        borrowedBooks.add(book);  // 대출한 책을 목록에 추가
    }

    public void removeBorrowedBook(Book book) {
        borrowedBooks.remove(book);  // 반납된 책을 목록에서 제거
    }

    public void updateName(String newName){
        this.name = newName;
    }

    public void updateEmail(String newEmail) {
        this.email = newEmail;
    }
}