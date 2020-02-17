package eye2web.articles.exception;

public class NotFoundException extends RuntimeException {

    public NotFoundException(final String message) {
        super(String.format("Not found: %s", message));
    }

}
