// EBook.java
package work2;

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

    public void download() {
        System.out.println("Downloading eBook from: " + downloadLink);
    }

    public void readOnline() {
        System.out.println("Reading eBook online.");
    }

    @Override
    public void getDetails() {
        System.out.println("Book ID: " + bookID + ", Title: " + title + ", Author: " + author);
        System.out.println("Genre: " + genre+ ", publishYear: " + publishYear+ ", Page: " + page);
        System.out.println("File Size: " + fileSize+ ", Download Link: " + downloadLink);
        System.out.println();
    }
}
