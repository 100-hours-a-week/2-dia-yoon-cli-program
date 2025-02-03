package work2;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BookManager {
    public ArrayList<Book> books = new ArrayList<>();
    public ArrayList<Book> reservedBooks = new ArrayList<>();
    private List<User> users;

    // 책 추가
    public void addBook(Book book) {
        books.add(book);
    }

    // 전체 책 목록 출력
    public void displayBooks() {
        for (Book book : books) {
            book.getDetails();
        }
    }

    // 책 제거
    public void removeBook(int bookID) {
        books.removeIf(book -> book.bookID == bookID);
        System.out.println("Book with ID " + bookID + " has been removed.");
    }

    // 대출
    public void borrow(int bookID, int userID) {
        Book bookToBorrow = null;
        for (Book book : books) {
            if (book.bookID == bookID) {
                bookToBorrow = book;
                break;
            }
        }

        if (bookToBorrow == null) {
            System.out.println("책이 존재하지 않습니다.");
            return;
        }

        if (bookToBorrow.isBorrowed) {
            System.out.println("다른 사용자가 대출 중인 책입니다.");
        } else {
            bookToBorrow.isBorrowed = true;
            bookToBorrow.dueDate = LocalDate.now().plusWeeks(1); // Set due date as 1 week from now
            System.out.println("책 아이디 " + bookID + "가 유저 아이디 " + userID + "에 의하여 대출되었습니다.");
            System.out.println("대출 기한: " + bookToBorrow.dueDate);

            // 대출한 책을 해당 사용자에게 추가
            for (User user : users) {
                if (user.getUserID() == userID) {
                    user.addBorrowedBook(bookToBorrow);
                    break;
                }
            }
        }
    }



    public void displayBorrowedBooks(int userID) {
        for (Book book : books) {
            if (book.isBorrowed) {
                System.out.println("책 아이디: " + book.bookID + ", 제목: " + book.title + ", 대출 기한: " + book.dueDate);
            }
        }
    }

    // 반납
    public void returnBook(int bookID, int userID) {
        Book bookToReturn = null;
        for (Book book : books) {
            if (book.bookID == bookID) {
                bookToReturn = book;
                break;
            }
        }

        if (bookToReturn == null) {
            System.out.println("책이 존재하지 않습니다.");
            return;
        }

        if (!bookToReturn.isBorrowed) {
            System.out.println("대출하지 않은 책입니다.");
        } else {
            bookToReturn.isBorrowed = false;
            bookToReturn.dueDate = null;
            System.out.println("책 아이디 " + bookID + "가 유저 아이디 " + userID + " 에 의하여 반납되었습니다.");
        }
    }

//    // 예약 도서 추가
//    public void reserveBook(int bookID, int userID) {
//        Book bookToReserve = null;
//        for (Book book : books) {
//            if (book.bookID == bookID) {
//                bookToReserve = book;
//                break;
//            }
//        }
//
//        if (bookToReserve == null) {
//            System.out.println("책이 존재하지 않습니다.");
//            return;
//        }
//
//        if (reservedBooks.contains(bookToReserve)) {
//            System.out.println("이미 예약된 책입니다.");
//        } else {
//            reservedBooks.add(bookToReserve);
//            System.out.println("책 아이디 " + bookID + "가 예약되었습니다.");
//        }
//    }
//
//    // 예약 도서 목록 확인
//    public void displayReservedBooks() {
//        if (reservedBooks.isEmpty()) {
//            System.out.println("예약된 도서가 없습니다.");
//        } else {
//            for (Book book : reservedBooks) {
//                book.getDetails();
//            }
//        }
//    }
}
