package bookstore.model;

import bookstore.exeption.BookNotForSaleException;

public class DemoBook extends Book{

    public DemoBook(String isbn, String title, int yearPublished, double price) {
        super(isbn, title, yearPublished, price);
    }

    @Override
    public boolean isAvailable() {
        return false;
    }

    @Override
    public double buyProcess(int qnt, String email, String address) {
        //System.out.println("Sorry! This book is not for sale it's just a Demo.");
        throw new BookNotForSaleException("Sorry! This book \"" + title + "\" is not for sale it's just a Demo.");
    }
}