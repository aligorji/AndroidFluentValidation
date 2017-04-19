package ir.aligorji.fluentvalidation.rules;


import android.content.Context;

import ir.aligorji.fluentvalidation.R;
import ir.aligorji.fluentvalidation.RuleValidator;
import ir.aligorji.fluentvalidation.ValidationException;

public class NotEmptyNumberRule<T extends Number> implements RuleValidator<T>
{

    @Override
    public void validate(Context context, T value, String display) throws ValidationException
    {
        if (value == null || value.toString().isEmpty())
        {
            throw new ValidationException(context.getString(R.string.validation_not_empty, display));
        }
    }
}
