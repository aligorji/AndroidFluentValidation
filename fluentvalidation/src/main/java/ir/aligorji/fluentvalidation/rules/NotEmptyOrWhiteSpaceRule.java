package ir.aligorji.fluentvalidation.rules;


import android.content.Context;

import ir.aligorji.fluentvalidation.R;
import ir.aligorji.fluentvalidation.RuleValidator;
import ir.aligorji.fluentvalidation.ValidationException;

public class NotEmptyOrWhiteSpaceRule implements RuleValidator<String>
{
    @Override
    public void validate(Context context, String value, String display) throws ValidationException
    {
        if (value == null || value.trim().isEmpty())
        {
            throw new ValidationException(context.getString(R.string.validation_not_empty_or_whitespace, display));
        }
    }
}
