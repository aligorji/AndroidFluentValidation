package ir.aligorji.fluentvalidation.rules;


import android.content.Context;

import ir.aligorji.fluentvalidation.ConditionValidator;
import ir.aligorji.fluentvalidation.RuleValidator;
import ir.aligorji.fluentvalidation.ValidationException;

public class ConditionRule<T> implements RuleValidator<T>
{

    private final ConditionValidator<T> condition;
    public ConditionRule(ConditionValidator<T> condition)
    {
        this.condition = condition;
    }

    @Override
    public void validate(Context context, T value, String display) throws ValidationException
    {
        if (!condition.condition(value))
        {
            throw new ValidationException(condition.getErrorMessage());
        }
    }
}
