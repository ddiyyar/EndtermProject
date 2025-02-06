import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookManager {
    private String url;
    private String user;
    private String password;

    // Incapsulation ^
    public BookManager(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    // Метод, чтобы добавить книгу
    public boolean addBook(Book book) {
        String sql = "INSERT INTO books (isbn, title, author, published_date, read_count, likes, dislikes, link) " +
                "VALUES (?, ?, ?, ?, 0, 0, 0, ?)";
        try (Connection con = DriverManager.getConnection(url, this.user, this.password);
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setString(1, book.getIsbn());
            pst.setString(2, book.getTitle());
            pst.setString(3, book.getAuthor());
            pst.setDate(4, new java.sql.Date(book.getPublishedDate().getTime()));
            pst.setString(5, book.getLink());

            int affectedRows = pst.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    // Метод, чтобы найти книгу по ее уникальному коду
    public Book getBookByISBN(String isbn) {
        String sql = "SELECT * FROM books WHERE isbn = ?";
        try (Connection con = DriverManager.getConnection(url, this.user, this.password);
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setString(1, isbn);
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    Book book = new Book();
                    book.setIsbn(rs.getString("isbn"));
                    book.setTitle(rs.getString("title"));
                    book.setAuthor(rs.getString("author"));
                    book.setPublishedDate(rs.getDate("published_date"));
                    book.setReadCount(rs.getInt("read_count"));
                    book.setLikes(rs.getInt("likes"));
                    book.setDislikes(rs.getInt("dislikes"));
                    book.setLink(rs.getString("link"));
                    return book;
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    // Метод, чтобы найти книгу по названию
    public Book getBookByTitle(String title) {
        String sql = "SELECT * FROM books WHERE title = ?";
        try (Connection con = DriverManager.getConnection(url, this.user, this.password);
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setString(1, title);
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    Book book = new Book();
                    book.setIsbn(rs.getString("isbn"));
                    book.setTitle(rs.getString("title"));
                    book.setAuthor(rs.getString("author"));
                    book.setPublishedDate(rs.getDate("published_date"));
                    book.setReadCount(rs.getInt("read_count"));
                    book.setLikes(rs.getInt("likes"));
                    book.setDislikes(rs.getInt("dislikes"));
                    book.setLink(rs.getString("link"));
                    return book;
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    // Метод, чтобы найти книги по автору
    public Book getBookByAuthor(String author) {
        String sql = "SELECT * FROM books WHERE author = ?";
        try (Connection con = DriverManager.getConnection(url, this.user, this.password);
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setString(1, author);
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    Book book = new Book();
                    book.setIsbn(rs.getString("isbn"));
                    book.setTitle(rs.getString("title"));
                    book.setAuthor(rs.getString("author"));
                    book.setPublishedDate(rs.getDate("published_date"));
                    book.setReadCount(rs.getInt("read_count"));
                    book.setLikes(rs.getInt("likes"));
                    book.setDislikes(rs.getInt("dislikes"));
                    book.setLink(rs.getString("link"));
                    return book;
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    // Метод, чтобы вывести все книги
    public List<Book> getAllBooks() {
        String sql = "SELECT * FROM books";
        List<Book> books = new ArrayList<>();
        try (Connection con = DriverManager.getConnection(url, this.user, this.password);
             PreparedStatement pst = con.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                Book book = new Book();
                book.setIsbn(rs.getString("isbn"));
                book.setTitle(rs.getString("title"));
                book.setAuthor(rs.getString("author"));
                book.setPublishedDate(rs.getDate("published_date"));
                book.setReadCount(rs.getInt("read_count"));
                book.setLikes(rs.getInt("likes"));
                book.setDislikes(rs.getInt("dislikes"));
                book.setLink(rs.getString("link"));
                books.add(book);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return books;
    }
}
