package ir.aligorji.fluentvalidation.rules;


import android.content.Context;

import ir.aligorji.fluentvalidation.R;
import ir.aligorji.fluentvalidation.RuleValidator;
import ir.aligorji.fluentvalidation.ValidationException;

public class GreaterThanOrEqualRule<T extends Number> implements RuleValidator<Number>
{

    private final T paramValue;

    public GreaterThanOrEqualRule(T value)
    {
        paramValue = value;
    }

    @Override
    public void validate(Context context, Number value, String display) throws ValidationException
    {
        if (paramValue == null)
        {
            return;
        }

        if (value != null && value.doubleValue() >= paramValue.doubleValue())
        {
            return;
        }

        throw new ValidationException(context.getString(R.string.validation_greater_than_or_equal, display, paramValue));
    }
}
