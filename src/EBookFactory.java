import java.util.Date;

public class EBookFactory extends BookFactory {
    @Override
    public Book createBook(String isbn, String title, String author, Date publishedDate, String link) {
        return new EBook(isbn, title, author, publishedDate, 0, 0, 0, link, 1.5);
    }
}

