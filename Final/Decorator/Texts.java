
interface Text {

    String format();
}

// Concrete Class Component -->>   eita basic thakbe
class PlainText implements Text {

    private String text;

    // Constructor
    public PlainText(String text) {
        this.text = text;
    }

    // interface er method call
    @Override
    public String format(){
        return text;
    }

}

// Ekhon basic Decorator class abstract thakbe & interface ke implimants korbe
abstract class DecoratorText implements Text{
    protected Text text;

    public DecoratorText(Text text){
        this.text = text;
    }
}

// ekhan theke Concrete Decorate start jegula basic decorator ke extend korbe ekhane kono parameter hobe na
class BoldText extends DecoratorText{
    public BoldText(Text text){
        super(text);
    }

    // Ekhane interface  er method override korrte hobe
    @Override
    public String format(){
        return "<b>" + text.format() +"</b>";
    }
}

class ItalicText extends DecoratorText{
    public ItalicText(Text text){
        super(text);
    }

    @Override
    public String format(){
        return "<i>"+ text.format()+"</i>";
    }
}

public class Texts {

    public static void main(String[] args) {
        // Shurute basic Concrete class components er jonne sample text nite hobe
        Text text = new PlainText("Hedar text");

        // ekhan theke decorattion start hobe

        text = new BoldText(text);
        text = new ItalicText(text);

        System.out.println(text.format());
    }
}
