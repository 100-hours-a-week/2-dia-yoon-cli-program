public class EBook extends Paper {
    public double fileSize;
    public String downloadLink;

    public EBook(int EbookID,String title, String author, String genre, int publishYear, int page, double fileSize, String downloadLink) {
        super(EbookID,title, author, genre, publishYear, page);
        this.fileSize = fileSize;
        this.downloadLink = downloadLink;
    }

    // 다운로드 링크 보내기
    public String getDownloadLink() {
        return downloadLink;
    }

    @Override
    public void getDetails() {
        super.getDetails();
        System.out.println("파일 사이즈: " + fileSize+ ", 다운로드 링크: " + downloadLink);
    }
}

