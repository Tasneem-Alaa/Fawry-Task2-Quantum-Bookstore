package bookstore.main;

import static bookstore.tests.BookStoreTesting.*;

public class Main {
    public static void main(String[] args) {
        System.out.println(">>> Testing Add Book:");
        testAddBook();

        System.out.println("################################################################");
        System.out.println(">>> Testing Remove Outdated Books:");
        testRemoveOutdatedBooks(20);  // ممكن تغيري الرقم لو حابة

        System.out.println("################################################################");
        System.out.println(">>> Testing Buy Paper Book:");
        testBuyPaperBook();

        System.out.println("################################################################");
        System.out.println(">>> Testing Buy EBook:");
        testBuyEBook();

        System.out.println("################################################################");
        System.out.println(">>> Testing Buy Demo Book:");
        testBuyDemoBook();

        System.out.println("################################################################");
        System.out.println(">>> Testing Buy a not found Book :");
        testBuyBookNotFound();

    }
}