interface FormattedText {
    String format();
}

class SimpleText implements FormattedText {
    private final String text;

    public SimpleText(String text) {
        this.text = text;
    }

    @Override
    public String format() {
        return this.text;
    }
}

abstract class TextDecorator implements FormattedText {
    protected FormattedText decoratedText;

    public TextDecorator(FormattedText text) {
        this.decoratedText = text;
    }

    @Override
    public String format() {
        return decoratedText.format();
    }
}

class BoldText extends TextDecorator {
    public BoldText(FormattedText text) {
        super(text);
    }

    @Override
    public String format() {
        return "<b>" + super.format() + "</b>";
    }
}

class ItalicText extends TextDecorator {
    public ItalicText(FormattedText text) {
        super(text);
    }

    @Override
    public String format() {
        return "<i>" + super.format() + "</i>";
    }
}

public class Text {
    public static void main(String[] args) {
        FormattedText text = new ItalicText(new BoldText(new SimpleText("Hello, Worlddd!")));

        System.out.println(text.format());
    }
}
