package bookstore.model;

import java.time.LocalDate;

public abstract class Book {
    protected String isbn;
    protected String title;
    protected int yearPublished;
    protected double price;


    public Book(String isbn, String title, int yearPublished, double price) {
        this.isbn = isbn;
        this.title = title;
        this.yearPublished = yearPublished;
        this.price = price;
    }

    public abstract boolean isAvailable();
    public abstract double buyProcess(int qnt, String email, String address);
    public boolean isOutdated(int numYears) {
        return (LocalDate.now().getYear() - getYearPublished()) > numYears;
    }


    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    //getter & setter
    public int getYearPublished () {
        return yearPublished ;
    }

    public void setYearPublished (int year) {
        this.yearPublished  = year;
    }

    public String getIsbn() {
        return isbn;
    }
}
