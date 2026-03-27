abstract class Document {
    public abstract void open();
}

class WordDocument extends Document {
    @Override
    public void open() {
        System.out.println("Opening Word Document.");
    }
}

class ExcelDocument extends Document {
    @Override
    public void open() {
        System.out.println("Opening Excel Document.");
    }
}

class DocumentFactory {
    public enum DocumentType {
        WORD, EXCEL
    }

    public static Document getDocument(DocumentType type) {
        switch (type) {
            case WORD:
                return new WordDocument();
            case EXCEL:
                return new ExcelDocument();
            default:
                throw new IllegalArgumentException("Unknown document type: " + type);
        }
    }
}

public class Documents {
    public static void main(String[] args) {

        Document wordDoc = DocumentFactory.getDocument(DocumentFactory.DocumentType.WORD);
        wordDoc.open();

        Document excelDoc = DocumentFactory.getDocument(DocumentFactory.DocumentType.EXCEL);
        excelDoc.open();
    }

}
