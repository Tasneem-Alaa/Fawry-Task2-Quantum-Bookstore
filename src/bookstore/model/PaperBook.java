package bookstore.model;
import bookstore.exeption.NotEnoughStockException;
public class PaperBook extends Book{
    private int stock;

    public PaperBook(String isbn, String title, int yearPublished, double price, int stock) {
        super(isbn, title, yearPublished, price);
        this.stock = stock;
    }

    @Override
    public boolean isAvailable() {
        return stock > 0;
    }

    @Override
    public double buyProcess(int qnt, String email, String address) {
        if(qnt > this.stock) {
            //System.out.println("Sorry! Not enough stock for: " + this.title);
            throw new NotEnoughStockException("Not enough stock for \"" + title + "\"");
        }
        else {
            this.decreaseStock(qnt);
            System.out.println("Shipping \"" + this.title + "\" to " + address);
            //ShippingService.sendBook(this, qnt, address);

            return qnt * this.price;
        }
    }

    public void decreaseStock(int qnt) {
        if (this.stock == qnt) {
            System.out.println("Warning: this was the last quantity for this book so it's not available now");
        }
        this.stock -= qnt;
    }
}