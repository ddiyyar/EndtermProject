import java.util.Date;

public class EBook extends Book {
    private double fileSize;

    public EBook(String isbn, String title, String author, Date publishedDate, int readCount, int likes, int dislikes, String link, double fileSize) {
        super(isbn, title, author, publishedDate, readCount, likes, dislikes, link);
        this.fileSize = fileSize;
    }

    public double getFileSize() {
        return fileSize;
    }

    public void setFileSize(double fileSize) {
        this.fileSize = fileSize;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Размер файла: " + fileSize + " MB";
    }
}

