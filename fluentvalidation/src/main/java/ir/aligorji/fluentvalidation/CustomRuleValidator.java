package ir.aligorji.fluentvalidation;


import android.content.Context;

public interface CustomRuleValidator
{
    void validate(Context context) throws ValidationException;
}
