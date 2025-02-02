package work2;
import java.util.ArrayList;

// User.java
public class User {
    int userID;
    String name;
    String email;
    private ArrayList<Book> borrowedBooks = new ArrayList<>();

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
        System.out.println("Checking borrowed books for User ID: " + userID);
    }

    // 대출한 도서 목록에 책 추가
    public void borrowBook(Book book) {
        borrowedBooks.add(book);
    }

    // 대출한 도서 목록 출력
    public void displayBorrowedBooks() {
        if (borrowedBooks.isEmpty()) {
            System.out.println("대출한 도서가 없습니다.");
        } else {
            for (Book book : borrowedBooks) {
                System.out.println("책 아이디: " + book.bookID + ", 제목: " + book.title);
            }
        }
    }
    public void updateName(String newName){
        this.name = newName;
    }

    public void updateEmail(String newEmail) {
        this.email = newEmail;
    }
}