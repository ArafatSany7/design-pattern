// --- Document Hierarchy ---

abstract class Document {
    public abstract void open(String filename);
}

class WordDocument extends Document {
    @Override
    public void open(String filename) {
        System.out.println("Opening Word Document: " + filename);
    }
}

class ExcelDocument extends Document {
    @Override
    public void open(String filename) {
        System.out.println("Opening Excel Document: " + filename);
    }
}

class GoogleDoc extends Document {
    @Override
    public void open(String filename) {
        System.out.println("Opening Google Doc: " + filename);
    }
}

class GoogleSheet extends Document {
    @Override
    public void open(String filename) {
        System.out.println("Opening Google Sheet: " + filename);
    }
}

// --- Abstract Factory Hierarchy ---

interface DocumentAbstractFactory {
    Document createDocument();
}

class WordDocumentFactory implements DocumentAbstractFactory {
    @Override
    public Document createDocument() {
        return new WordDocument();
    }
}

class ExcelDocumentFactory implements DocumentAbstractFactory {
    @Override
    public Document createDocument() {
        return new ExcelDocument();
    }
}

class GoogleDocFactory implements DocumentAbstractFactory {
    @Override
    public Document createDocument() {
        return new GoogleDoc();
    }
}

class GoogleSheetFactory implements DocumentAbstractFactory {
    @Override
    public Document createDocument() {
        return new GoogleSheet();
    }
}

// --- Factory Utility ---

class DocumentFactory {
    public static Document createDocument(DocumentAbstractFactory factory) {
        return factory.createDocument();
    }
}

public class RealShit {
    public static void main(String[] args) {
        // Create an Office Word Document
        Document wordDoc = DocumentFactory.createDocument(new WordDocumentFactory());
        wordDoc.open("word_file.docx");

        // Create a Google Doc
        Document googleDoc = DocumentFactory.createDocument(new GoogleDocFactory());
        googleDoc.open("google_doc_file.gdoc");

        // Create an Office Excel Document
        Document excelDoc = DocumentFactory.createDocument(new ExcelDocumentFactory());
        excelDoc.open("excel_file.xlsx");

        // Create a Google Sheet
        Document googleSheet = DocumentFactory.createDocument(new GoogleSheetFactory());
        googleSheet.open("google_sheet_file.gsheet");
    }
}
