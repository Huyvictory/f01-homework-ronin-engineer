package Assignment8.Bai2;

import Assignment8.Bai2.Enums.DocumentType;

public class Book extends Document {
    private String AuthorName;
    private int Pages;

    public Book(int id, String PublisherName, int AmountPublished, String AuthorName, int Pages) {
        super(id, PublisherName, AmountPublished, DocumentType.BOOK);
        this.AuthorName = AuthorName;
        this.Pages = Pages;
    }

    @Override
    public void PrintDetails() {
        System.out.printf("ID: %d, Publisher Name: %s, Amount Published: %d, Author Name: %s, Pages: %d, Type: %s\n", super.getId(), super.getPublisherName(), super.getAmountPublished(), AuthorName, Pages, super.getDocumentType());
    }
}
