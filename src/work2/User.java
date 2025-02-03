import java.util.ArrayList;
import java.util.List;

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
        System.out.println("현재 대출 목록 개수: " + borrowedBooks.size());  // 디버깅용 출력
        if (borrowedBooks.isEmpty()) {
            System.out.println("대출하신 도서가 없습니다.");
        } else {
            System.out.println("대출하신 도서 목록입니다.");
            for (Book book : borrowedBooks) {
                System.out.println("책 ID: " + book.bookID + ", 제목: " + book.title);
            }
        }
    }

    // 대여한 책 목록 반환
    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void addBorrowedBook(Book book) {
        borrowedBooks.add(book);  // 대출한 책을 목록에 추가
    }

    // 대여한 책인지 확인
    public boolean removeBorrowedBook(Book book) {
        return borrowedBooks.remove(book);
    }

    public void updateName(String newName){
        this.name = newName;
    }

    public void updateEmail(String newEmail) {
        this.email = newEmail;
    }
}