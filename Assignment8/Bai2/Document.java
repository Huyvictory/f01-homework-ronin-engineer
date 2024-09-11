package Assignment8.Bai2;

import Assignment8.Bai2.Enums.DocumentType;

public class Document {
    private int id;
    private String PublisherName;
    private int AmountPublished;
    private DocumentType documentType;

    public int getId() {
        return id;
    }

    public String getPublisherName() {
        return PublisherName;
    }

    public int getAmountPublished() {
        return AmountPublished;
    }

    public DocumentType getDocumentType() {
        return documentType;
    }

    public Document(int id, String PublisherName, int AmountPublished, DocumentType documentType) {
        this.id = id;
        this.PublisherName = PublisherName;
        this.AmountPublished = AmountPublished;
        this.documentType = documentType;
    }

    public void PrintDetails() {
        System.out.printf("ID: %d, Publisher Name: %s, Amount Published: %d\n", id, PublisherName, AmountPublished);
    }
}
