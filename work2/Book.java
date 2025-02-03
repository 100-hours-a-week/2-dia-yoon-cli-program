public class Book {
    protected int bookID;
    protected String title;
    protected String author;
    protected boolean isBorrowed;

    public Book(int bookID,String title, String author) {
        this.title = title;
        this.bookID = bookID;
        this.author = author;
        this.isBorrowed = false;
    }

    public void getDetails() {
        System.out.println("책 ID: " + bookID + ", 제목: " + title + ", 작가: " + author + ", 대여 여부: " + isBorrowed);
    }

    public int getBookID() {
        return bookID;
    }
    // 대출 여부 확인
    public boolean isBorrowed() {
        return isBorrowed;
    }
    public void setBorrowed(boolean borrowed) {
        isBorrowed = borrowed;
    }

}