package ir.aligorji.fluentvalidation;


import android.content.Context;

public interface RuleValidator<T>
{
    void validate(Context context, T value, String display) throws ValidationException;
}
