package bookstore.service;

import bookstore.exeption.BookNotForSaleException;
import bookstore.exeption.NotEnoughStockException;
import bookstore.model.Book;

import java.util.*;

public class Inventory {
    private static Map<String, Book> books;
    public Inventory() {
        books = new HashMap<>();
    }
    public void addBook(Book book) {
        books.put(book.getIsbn(),book);
    }

    public ArrayList<Book> removeOutdatedBooks(int years) {
        ArrayList<Book> outDatedBooks = new ArrayList<>();
        Iterator<Map.Entry<String, Book>> iterator = books.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<String, Book> entry = iterator.next();
            Book book = entry.getValue();

            if (book.isOutdated(years)) {
                outDatedBooks.add(book);
                iterator.remove();
            }
        }

        return outDatedBooks;
    }


    public double buyBook(String isbn, int qnt, String email, String address) {
        double paidAmount = 0.0;
        Book book = books.get(isbn);
        if (book == null) {
            throw new RuntimeException("Book with ISBN " + isbn + " not found.");
        }
        if(!book.isAvailable()) {
            System.out.println("Sorry! This book is not available.");
        }
        else{
            try {

                paidAmount = book.buyProcess(qnt, email, address);
                System.out.println("You paid " + paidAmount);

            } catch (NotEnoughStockException e) {
                System.out.println(e.getMessage());
            } catch (BookNotForSaleException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Unexpected error occurred.");
            }
        }
        return paidAmount;
    }

    public int inventorySize(){
        return this.books.size();
    }
}
