
interface WebPage {

    // Define a method named render that returns a String
    String render();
}

// Concrete Component
class BasicWebPage implements WebPage {

    // Implement the render method to return a string that represents a basic web page
    @Override
    public String render() {
        return "Bassic  Web Page";
    }
}

// Base Decorator
abstract class WebPageDecorator implements WebPage {

    protected WebPage decoratedPage;

    public WebPageDecorator(WebPage page) {
        // Initialize the decoratedPage variable
        this.decoratedPage = page;
    }

    // Implement the render method to return the result of the decoratedPage's render method
    @Override
    public String render() {
        return decoratedPage.render();
    }
}

// Concrete Decorator 1
class AuthenticatedWebPage extends WebPageDecorator {

    public AuthenticatedWebPage(WebPage page) {
        // Pass the page to the superclass constructor
        super(page);
    }

    // Override the render method to add " with Authentication" to the result
    @Override
    public String render() {
        return super.render() + " with Authentication";
    }
}

// Concrete Decorator 2
class AuthorizedWebPage extends WebPageDecorator {

    public AuthorizedWebPage(WebPage page) {
        // Pass the page to the superclass constructor
        super(page);
    }

    // Override the render method to add " with Authorization" to the result
    @Override
    public String render() {
        return super.render() + " with Authorization";
    }
}

public class Web {

    public static void main(String[] args) {
        // Create an instance of BasicWebPage
        WebPage basicPage = new BasicWebPage();

        // Wrap the basicPage with an AuthenticatedWebPage decorator
        WebPage authenticatedPage = new AuthenticatedWebPage(basicPage);

        // Wrap the authenticatedPage with an AuthorizedWebPage decorator
        WebPage authorizedPage = new AuthorizedWebPage(authenticatedPage);

        // Print the result of the render method of the authorizedPage
        System.out.println(authorizedPage.render());

        // Expected Output: Basic Web Page with Authentication with Authorization
    }
}
