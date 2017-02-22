package ir.aligorji.fluentvalidation;



public class ValidationException extends Throwable
{

    public boolean isOverrideMessage()
    {
        return overrideMessage;
    }
    private final boolean overrideMessage;

    public ValidationException(String message)
    {
        this(message, false);
    }
    public ValidationException(String message, boolean overrideMessage)
    {
        super(message);
        this.overrideMessage = overrideMessage;
    }
}
