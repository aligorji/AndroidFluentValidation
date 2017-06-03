package ir.aligorji.fluentvalidation.rules;


import android.content.Context;

import ir.aligorji.fluentvalidation.R;
import ir.aligorji.fluentvalidation.RuleValidator;
import ir.aligorji.fluentvalidation.ValidationException;

public class NotEqualNumberRule<T extends Number> implements RuleValidator<T>
{

    private final T equalValue;

    public NotEqualNumberRule(T value)
    {
        equalValue = value;
    }


    @Override
    public void validate(Context context, T value, String display) throws ValidationException
    {
        if (value == null || equalValue == null)
        {
            return;
        }

        if (value.doubleValue() == equalValue.doubleValue())
        {
            throw new ValidationException(context.getString(R.string.validation_not_equal, display, equalValue));
        }

    }
}
