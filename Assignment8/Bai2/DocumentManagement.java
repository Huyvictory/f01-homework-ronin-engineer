package Assignment8.Bai2;

import Assignment8.Bai2.Enums.DocumentType;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class DocumentManagement {
    public ArrayList<Document> documentList = new ArrayList<>();

    private void DisplayDocumentTypes() {
        System.out.println("-----------------------");
        System.out.println("1. BOOK");
        System.out.println("2. JOURNAL");
        System.out.println("3. NEWSPAPER");
        System.out.println("-----------------------");
    }

    public void CreateNewDocument() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the publisher name of the new document: ");
        String publisherName = scanner.next();
        System.out.println("Please enter the amount published of the new document: ");
        int amountPublished = scanner.nextInt();

        String documentType;
        DocumentType documentTypeType;
        while (true) {
            try {
                DisplayDocumentTypes();
                System.out.println("Please enter the type of the new document: ");
                documentType = scanner.next();
                documentTypeType = DocumentType.valueOf(documentType);
                break;
            } catch (Exception e) {
                System.out.println("Wrong input, please try again");
            }
        }


        switch (documentTypeType) {
            case BOOK: {
                System.out.println("Please enter the author name of the book: ");
                String authorName = scanner.next();
                System.out.println("Please enter the pages of the book: ");
                int pages = scanner.nextInt();


                documentList.add(new Book(documentList.size() + 1, publisherName, amountPublished, authorName, pages));
                break;
            }
            case JOURNAL: {
                System.out.println("Please enter the number of the journal: ");
                int numberPublish = scanner.nextInt();
                System.out.println("Please enter the month of the journal: ");
                Date monthPublish = new Date();
                documentList.add(new Journal(documentList.size() + 1, publisherName, amountPublished, numberPublish, monthPublish));
                break;
            }
            case NEWSPAPER: {
                Date dayPublish = new Date();
                documentList.add(new Newspaper(documentList.size() + 1, publisherName, amountPublished, dayPublish));
                break;
            }
        }

        System.out.printf("%s added successfully", documentTypeType);
    }

    public void DisplayDocuments(ArrayList<Document> documents) {
        System.out.println("-----------------------");
        System.out.println("Documents:");
        for (Document document : documents) {
            document.PrintDetails();
        }
        System.out.println("-----------------------");
    }

    public void DeleteDocumentById() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the id of the document to be deleted: ");
        int id = scanner.nextInt();

        if (documentList.isEmpty()) {
            System.out.println("Document list is empty");
            return;
        }

        for (Document document : documentList) {
            if (document.getId() == id) {
                documentList.remove(document);
                break;
            }
        }

        System.out.printf("Document with id %d deleted successfully\n", id);
        DisplayDocuments(documentList);
    }

    public void FindDocumentByType() {
        Scanner scanner = new Scanner(System.in);
        DocumentType documentType;
        while (true) {
            try {
                DisplayDocumentTypes();
                System.out.println("Please enter the type of the document to be found: ");
                String type = scanner.next();
                documentType = DocumentType.valueOf(type);
                break;
            } catch (Exception e) {
                System.out.println("Wrong input, please try again");
            }
        }

        if (documentList.isEmpty()) {
            System.out.println("Document list is empty");
            return;
        }

        for (Document document : documentList) {
            if (document.getDocumentType() == documentType) {
                document.PrintDetails();
            }
        }
    }

    public void DisplayCommands() {
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("1. Create a new document added into document list");
        System.out.println("2. Delete a document by id");
        System.out.println("3. Show list of documents");
        System.out.println("4. Find the document by type");
        System.out.println("5. Exit");
        System.out.println("-------------------------------------------------------------------------------");
    }
}
