import java.util.ArrayList;
import java.util.List;

public class UserManager {
    public ArrayList<Book> books = new ArrayList<>();
    private List<User> users;

    public UserManager(List<User> users, ArrayList<Book> books) {  // 생성자 수정
        this.users = users;
        this.books = books;
    }

    // 대출
    public void borrow(int bookID, int userID) {
        // 대출 처리
        Book bookToBorrow = findBookByID(bookID);
        User user = findUserByID(userID);

        if (bookToBorrow != null && user != null) {
            // 다른 사람이 대여 중인 책
            if (bookToBorrow.isBorrowed()) {
                System.out.println("이 책은 다른 사람이 대여 중입니다.");
                return;
            }

            // 본인이 이미 대여한 책을 다시 대여하려 할 때
            for (Book borrowedBook : user.getBorrowedBooks()) {
                if (borrowedBook.getBookID() == bookID) {
                    System.out.println("이미 대여한 책입니다.");
                    return;
                }
            }

            // 정상 대출
            user.addBorrowedBook(bookToBorrow);
            bookToBorrow.setBorrowed(true);
            System.out.println("책 대출되었습니다. ");
        } else {
            System.out.println("책을 찾을 수 없거나 사용자 정보가 잘못되었습니다.");
        }
    }

    private Book findBookByID(int bookID) {
        for (Book book : books) {
            if (book.bookID == bookID) {
                return book;
            }
        }
        return null;
    }

    private User findUserByID(int userID) {
        for (User user : users) {
            if (user.getUserID() == userID) {
                return user;
            }
        }
        return null;
    }

    // 반납
    public void returnBook(int bookID, int userID) {
        Book bookToReturn = findBookByID(bookID);
        User user = findUserByID(userID);

        if (bookToReturn != null && user != null) {
            // 사용자가 대여한 책이 맞는지 확인
            if (user.removeBorrowedBook(bookToReturn)) {
                bookToReturn.setBorrowed(false); // 대여 상태를 false로 설정
                System.out.println("책이 반납되었습니다.");
            } else {
                System.out.println("반납할 책을 대여한 기록이 없습니다.");
            }
        } else {
            System.out.println("책을 찾을 수 없거나 사용자 정보가 잘못되었습니다.");
        }
    }

    public Book getBookByID(int bookID) {
        for (Book book : books) {
            if (book.getBookID() == bookID) {
                return book;
            }
        }
        return null;
    }
}
