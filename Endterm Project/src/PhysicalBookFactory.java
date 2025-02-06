import java.util.Date;

public class PhysicalBookFactory extends BookFactory {
    @Override
    public Book createBook(String isbn, String title, String author, Date publishedDate, String link) {
        return new Book(isbn, title, author, publishedDate, 0, 0, 0, link);
    }
}

