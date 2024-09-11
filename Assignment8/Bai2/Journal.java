package Assignment8.Bai2;

import Assignment8.Bai2.Enums.DocumentType;

import java.util.Date;

public class Journal extends Document {
    private int NumberPublish;
    private Date monthPublish;


    public Journal(int id, String PublisherName, int AmountPublished, int NumberPublish, Date monthPublish) {
        super(id, PublisherName, AmountPublished, DocumentType.JOURNAL);
        this.NumberPublish = NumberPublish;
        this.monthPublish = monthPublish;
    }

    @Override
    public void PrintDetails() {
        System.out.printf("ID: %d, Publisher Name: %s, Amount Published: %d, Number Publish: %d, Month Publish: %s, Type: %s\n", super.getId(), super.getPublisherName(), super.getAmountPublished(), NumberPublish, monthPublish.toString(), super.getDocumentType());
    }
}
