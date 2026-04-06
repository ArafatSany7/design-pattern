
interface Text {
    String format();
}

class SimpleText implements Text {
    private final String text;

    public SimpleText(String text) {
        this.text = text;
    }

    @Override
    public String format() {
        return this.text;
    }
}

abstract class TextDecorator implements Text {
    protected Text decoratedText;

    public TextDecorator(Text text) {
        this.decoratedText = text;
    }

    @Override
    public String format() {
        // Return the result of calling format() on decoratedText
        return decoratedText.format();
    }
}

class BoldText extends TextDecorator {
    public BoldText(Text text) {
        super(text);
    }

    @Override
    public String format() {
        // Extend the functionality by adding "<b>" before and "</b>" after the text
        return "<b>" + super.format() + "</b>";
    }
}

// Text.
class ItalicText extends TextDecorator {
    public ItalicText(Text text) {
        super(text);
    }

    @Override
    public String format() {
        // Extend the functionality by adding "<i>" before and "</i>" after the text
        return "<i>" + super.format() + "</i>";
    }
}

public class Texts {
    public static void main(String[] args) {

        Text simpleText = new SimpleText("Hello, World!");

        Text boldText = new BoldText(simpleText);
        Text fullyFormattedText = new ItalicText(boldText);

        // Output the formatted text
        System.out.println(fullyFormattedText.format());
        // Expected output: <i><b>Hello, World!</b></i>
    }
}
