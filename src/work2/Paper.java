public class Paper extends Book {
    public String genre;
    public int publishYear;
    public int page;

    public Paper(int PaperID,String title, String author, String genre, int publishYear, int page) {
        super(PaperID, title, author);
        this.genre = genre;
        this.publishYear = publishYear;
        this.page = page;
    }

    @Override
    public void getDetails() {
        super.getDetails();
        System.out.println("장르: " + genre + ", 출판 연도: " + publishYear+ ", 쪽 수: " + page);
    }
}
