package bookstore.tests;

import bookstore.model.Book;
import bookstore.model.DemoBook;
import bookstore.model.EBook;
import bookstore.model.PaperBook;
import bookstore.service.Inventory;

import java.util.ArrayList;

public class BookStoreTesting {

    public static void testAddBook() {
        System.out.println("\n~~~~~~~ test Add Book ~~~~~~~");

        Inventory inventory = new Inventory();

        Book paper = new PaperBook("AAA123", "Clean Code", 2018, 550.0, 10);
        Book ebook  = new EBook("BBB123", "Java", 2025, 420.0, "pdf");
        Book demo   = new DemoBook("CCC123", "OOP", 2022, 0.0);

        System.out.println("Adding PaperBook: Clean Code");
        inventory.addBook(paper);
        System.out.println("Adding EBook: Java");
        inventory.addBook(ebook);
        System.out.println("Adding DemoBook: OOP");
        inventory.addBook(demo);

        System.out.println("Inventory now contains: " + inventory.inventorySize() + " books.");
    }

    public static void testRemoveOutdatedBooks(int years) {
        System.out.println("\n~~~~~~~ test Remove Outdated Books for: " + years + " years old books ~~~~~~~");

        Inventory inventory = new Inventory();

        System.out.println("Adding PaperBook: Java Book (2000)");
        inventory.addBook(new PaperBook("AA123", "Java Book", 2000, 100.0, 5));
        System.out.println("Adding PaperBook: C++ Book (2022)");
        inventory.addBook(new PaperBook("BBB123", "C++ Book", 2022, 200.0, 10));

        ArrayList<Book> removedBooks = inventory.removeOutdatedBooks(years);

        System.out.println("Removed " + removedBooks.size() + " outdated book(s):");
        for (Book book : removedBooks) {
            System.out.println("  -> " + book.getTitle() + " (" + book.getYearPublished() + ")");
        }

        System.out.println("Inventory size after removal: " + inventory.inventorySize());
    }

    public static void testBuyPaperBook() {
        System.out.println("\n~~~~~~~ test Buy Paper Book ~~~~~~~");

        Inventory inventory = new Inventory();

        System.out.println("Adding PaperBook: Data Structures");
        inventory.addBook(new PaperBook("AAA123", "Data Structures", 2015, 300.0, 2));

        System.out.println("Buying 1 copy of Data Structures");
        double paid = inventory.buyBook("AAA123", 1, "tasnemalaa30@mail.com", "Cairo");
        System.out.println("Paid Amount = " + paid);

        System.out.println("Trying to buy 5 copies of Data Structures (expecting NotEnoughStockException)");
        inventory.buyBook("AAA123", 5, "tasnemalaa30@gmail.com", "Cairo");
    }

    public static void testBuyEBook() {
        System.out.println("\n~~~~~~~ test Buy EBook ~~~~~~~");

        Inventory inventory = new Inventory();

        System.out.println("Adding EBook: Machine Learning");
        inventory.addBook(new EBook("CCC111", "Machine Learning", 2021, 250.0, "pdf"));

        System.out.println("Buying 3 copies of Machine Learning");
        double paid = inventory.buyBook("CCC111", 3, "tasnemalaa30@mail.com", "Cairo");
        System.out.println("Paid Amount = " + paid);
    }

    public static void testBuyDemoBook() {
        System.out.println("\n~~~~~~~ test Buy Demo Book ~~~~~~~");

        Inventory inventory = new Inventory();

        System.out.println("Adding DemoBook: Java");
        inventory.addBook(new DemoBook("DDD111", "Java", 2024, 0.0));

        System.out.println("Trying to buy DemoBook: Java (expecting BookNotForSaleException)");
        inventory.buyBook("DDD111", 1, "tasneem@mail.com", "Cairo");
    }

    public static void testBuyBookNotFound() {
        System.out.println("\n~~~~~~~ test Buy Book Not Found ~~~~~~~");

        Inventory inventory = new Inventory();

        System.out.println("Trying to buy a book with ISBN 'XYZ999' that does not exist (expecting BookNotFoundException)");

        try {
            inventory.buyBook("XYZ999", 1, "tasnemalaa30@gmail.com", "Cairo");
            System.out.println("ERROR: Expected exception was not thrown!");
        } catch (RuntimeException e) {
            System.out.println("Caught expected exception: " + e.getMessage());
        }
    }

}