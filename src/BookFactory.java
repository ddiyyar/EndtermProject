import java.util.Date;

public abstract class BookFactory {
    public abstract Book createBook(String isbn, String title, String author, Date publishedDate, String link);
}
