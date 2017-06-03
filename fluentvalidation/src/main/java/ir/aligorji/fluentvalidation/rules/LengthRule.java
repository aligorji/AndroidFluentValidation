package ir.aligorji.fluentvalidation.rules;


import android.content.Context;

import ir.aligorji.fluentvalidation.R;
import ir.aligorji.fluentvalidation.RuleValidator;
import ir.aligorji.fluentvalidation.ValidationException;

public class LengthRule implements RuleValidator
{


    private final int min;
    private final int max;

    public LengthRule(int min, int max)
    {
        this.min = min;
        this.max = max;
    }

    @Override
    public void validate(Context context, Object value, String display) throws ValidationException
    {
        int len = 0;

        if (value != null)
        {
            if (value instanceof String)
            {
                len = String.valueOf(value).length();
            }
            else if (value instanceof Double)
            {
                String s = String.valueOf(value);

                if (s.endsWith(".0"))
                {
                    s = s.replace(".0", "");
                }

                s = s.replaceAll("[-+/.]", "");

                len = s.length();
            }
        }

        if (min > len || len > max)
        {

            String error;

            if (min == max)
            {
                error = context.getString(R.string.validation_length, display, min + "");
            }
            else
            {
                error = context.getString(R.string.validation_length_min_max, display, min + "", max + "");
            }

            throw new ValidationException(error);
        }
    }
}
