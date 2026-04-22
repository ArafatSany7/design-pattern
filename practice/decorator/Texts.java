
interface Text {

    String format();
}

class plainText implements Text {

    private final String text;

    public plainText(String text) {
        this.text = text;
    }

    @Override
    public String format() {
        return text;
    }
}

abstract class textDecorator implements Text {

    protected final Text text;

    public textDecorator(Text text) {
        this.text = text;
    }
}

class BoldText extends textDecorator {

    public BoldText(Text text) {
        super(text);
    }

    @Override
    public String format() {
        return "<b >" + text.format() + "</b>";
    }
}

class ItalicText extends textDecorator {

    public ItalicText(Text text) {
        super(text);
    }

    @Override
    public String format() {
        return "<i>" + text.format() + "</i>";
    }
}

public class Texts {

    public static void main(String[] args) {
        Text text = new plainText("Normal Text");

        text = new BoldText(text);
        text = new ItalicText(text);
        System.out.println(text.format());
    }
}
