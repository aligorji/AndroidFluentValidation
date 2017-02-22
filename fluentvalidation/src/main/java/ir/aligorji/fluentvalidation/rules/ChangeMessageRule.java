package ir.aligorji.fluentvalidation.rules;


import android.content.Context;

import ir.aligorji.fluentvalidation.RuleValidator;
import ir.aligorji.fluentvalidation.ValidationException;

public class ChangeMessageRule<T> implements RuleValidator<T>
{

    private final String message;

    public ChangeMessageRule(String message)
    {
        this.message = message;
    }

    @Override
    public void validate(Context context, T value, String display) throws ValidationException
    {
        throw new ValidationException(message, true);
    }
}
