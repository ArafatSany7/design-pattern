
interface file {

    void open(String book);
}

// Create Adaptee class for openning Ebook
class Ebook {

    public void OpenEbook(String book) {
        System.out.println("Book " + book + " has opened as a ebook");
    }
}

// Create Adapter class for new ebook which also implement interface
class EbookAdapter implements file {

    // data type will bw previous adaptee class name
    private Ebook ebook;

    public EbookAdapter(Ebook ebook) {
        this.ebook = ebook;
    }

    @Override
    public void open(String open) {
        ebook.OpenEbook(open);
    }
}

// Existing Adapter class
class pdf implements file {

    @Override
    public void open(String book) {
        System.out.println("Book " + book + "has been opened via pdf");
    }
}

public class Task2 {

    public static void main(String[] args) {
        file ebookopen = new EbookAdapter(new Ebook());
        file pdfopen = new pdf();
        ebookopen.open("Dhoner Book");
        pdfopen.open("Hedar Book");
    }
}
