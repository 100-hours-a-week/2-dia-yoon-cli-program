public class EBook extends Paper {
    public double fileSize;
    public String downloadLink;

    public EBook(int EbookID,String title, String author, String genre, int publishYear, int page, double fileSize, String downloadLink) {
        super(EbookID,title, author, genre, publishYear, page);
        this.fileSize = fileSize;
        this.downloadLink = downloadLink;
    }

    public String getDownloadLink() {
        return downloadLink;
    }

    @Override
    public void getDetails() {
        super.getDetails();
        System.out.println("File Size: " + fileSize+ ", Download Link: " + downloadLink);
    }
}

