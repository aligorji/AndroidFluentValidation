package ir.aligorji.fluentvalidation;


public interface ConditionValidator<T>
{
    boolean condition(T value);
    String getErrorMessage();
}
