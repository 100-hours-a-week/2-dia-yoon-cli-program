import java.time.LocalDate;

public class EBook extends Paper {
    public double fileSize;
    public String downloadLink;
    public int EbookID;

    public EBook(int EbookID,String title, String author, String genre, int publishYear, int page, double fileSize, String downloadLink) {
        super(EbookID,title, author, genre, publishYear, page);
        this.fileSize = fileSize;
        this.downloadLink = downloadLink;
    }
//
//    public void download() {
//        System.out.println("Downloading eBook from: " + downloadLink);
//    }
//
//    public void readOnline() {
//        System.out.println("Reading eBook online.");
//    }

    public String getDownloadLink() {
        return downloadLink;
    }


    @Override
    public void getDetails() {
        System.out.println("EBOOK ID: " + bookID + ", 제목: " + title + ", 작가: " + author);
        System.out.println("장르: " + genre+ ", 출판 연도: " + publishYear+ ", 쪽 수: " + page);
        System.out.println("File Size: " + fileSize+ ", Download Link: " + downloadLink);
        System.out.println();
    }
}
