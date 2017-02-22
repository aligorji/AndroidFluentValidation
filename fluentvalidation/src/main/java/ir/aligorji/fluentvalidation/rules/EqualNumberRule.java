package ir.aligorji.fluentvalidation.rules;


import android.content.Context;

import ir.aligorji.fluentvalidation.R;
import ir.aligorji.fluentvalidation.RuleValidator;
import ir.aligorji.fluentvalidation.ValidationException;

public class EqualNumberRule<T extends Number> implements RuleValidator<Number>
{

    private final T equalValue;

    public EqualNumberRule(T value)
    {
        equalValue = value;
    }

    @Override
    public void validate(Context context, Number value, String display) throws ValidationException
    {
        if (value != null && equalValue != null)
        {
            if (value.doubleValue() == equalValue.doubleValue())
            {
                return;
            }
        }
        else
        {
            //all is null
            return;
        }
        throw new ValidationException(context.getString(R.string.validation_equal, display, equalValue));
    }
}
