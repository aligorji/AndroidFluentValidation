package ir.aligorji.fluentvalidation;


public interface Rule
{
    boolean isValid();
    String getErrors();
    void setValue(String value);
    void reset();
    void validate();
    void stopOnFirstFailure(boolean v);
    void setDisplay(String display);
    Object getParsedValue(String value) throws ValidationNumberParseException;
}
