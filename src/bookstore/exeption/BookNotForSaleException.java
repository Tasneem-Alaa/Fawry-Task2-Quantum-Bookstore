package bookstore.exeption;

public class BookNotForSaleException extends RuntimeException {
    public BookNotForSaleException(String message) {
        super(message);
    }
}
