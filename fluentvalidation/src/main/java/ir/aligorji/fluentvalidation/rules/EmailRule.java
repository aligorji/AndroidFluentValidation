package ir.aligorji.fluentvalidation.rules;


import android.content.Context;

import ir.aligorji.fluentvalidation.R;
import ir.aligorji.fluentvalidation.RuleValidator;
import ir.aligorji.fluentvalidation.ValidationException;

public class EmailRule implements RuleValidator<String>
{

    @Override
    public void validate(Context context, String value, String display) throws ValidationException
    {
        if (value != null)
        {
            if (!android.util.Patterns.EMAIL_ADDRESS.matcher(value).matches())
            {
                throw new ValidationException(context.getString(R.string.validation_email, display));
            }
        }
    }
}
