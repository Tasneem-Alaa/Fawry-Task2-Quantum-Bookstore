package bookstore.model;

public class EBook extends Book{
    private String fileType;

    public EBook(String isbn, String title, int yearPublished, double price, String fileType) {
        super(isbn, title, yearPublished, price);
        this.fileType = fileType;
    }

    @Override
    public boolean isAvailable() {
        return true;
    }

    @Override
    public double buyProcess(int qnt, String email, String address) {
        System.out.println("Sending \"" + this.title + "\" to " + email);
        //MailService.sendBook(this, fileType, email);
        return this.price;
    }
}
