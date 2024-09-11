package Assignment8.Bai2;

import Assignment8.Bai2.Enums.DocumentType;

import java.util.Date;

public class Newspaper extends Document {
    private Date dayPublish;


    public Newspaper(int id, String PublisherName, int AmountPublished, Date dayPublish) {
        super(id, PublisherName, AmountPublished, DocumentType.NEWSPAPER);
        this.dayPublish = dayPublish;
    }

    @Override
    public void PrintDetails() {
        System.out.printf("ID: %d, Publisher Name: %s, Amount Published: %d, Day Publish: %s, Type: %s\n", super.getId(), super.getPublisherName(), super.getAmountPublished(), dayPublish.toString(), super.getDocumentType());
    }
}
