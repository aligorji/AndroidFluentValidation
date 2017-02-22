package ir.aligorji.fluentvalidation.rules;


import android.content.Context;
import android.text.TextUtils;

import ir.aligorji.fluentvalidation.R;
import ir.aligorji.fluentvalidation.RuleValidator;
import ir.aligorji.fluentvalidation.ValidationException;

public class NotEqualRule implements RuleValidator<String>
{

    private final String equalValue;

    public NotEqualRule(String value)
    {
        equalValue = value;
    }


    @Override
    public void validate(Context context, String value, String display) throws ValidationException
    {
        if (TextUtils.equals(value, equalValue))
        {
            throw new ValidationException(context.getString(R.string.validation_not_equal, display, equalValue));
        }
    }
}
