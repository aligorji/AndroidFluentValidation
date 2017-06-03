package ir.aligorji.fluentvalidation;


import android.content.Context;

import ir.aligorji.fluentvalidation.rules.ChangeMessageRule;
import ir.aligorji.fluentvalidation.rules.ConditionRule;
import ir.aligorji.fluentvalidation.rules.EqualNumberRule;
import ir.aligorji.fluentvalidation.rules.GreaterThanOrEqualRule;
import ir.aligorji.fluentvalidation.rules.GreaterThanRule;
import ir.aligorji.fluentvalidation.rules.LengthRule;
import ir.aligorji.fluentvalidation.rules.LessThanOrEqualRule;
import ir.aligorji.fluentvalidation.rules.LessThanRule;
import ir.aligorji.fluentvalidation.rules.NotEmptyNumberRule;
import ir.aligorji.fluentvalidation.rules.NotEqualNumberRule;


public final class NumberRule<T extends Number>
        extends BaseRule<Double>
        implements NumberRuleBuilder<T>
{

    public NumberRule(Context context)
    {
        super(context);
    }

    @Override
    public Double getParsedValue(String value) throws ValidationNumberParseException
    {
        try
        {
            return Double.parseDouble(value.replace("/", "."));
        }
        catch (Throwable ignore)
        {
            throw new ValidationNumberParseException(getContext().getString(R.string.validation_number_parse, getDisplay()));
        }
    }

    @Override
    public NumberRuleBuilder<T> notEmpty()
    {
        add(new NotEmptyNumberRule());
        return this;
    }
    @Override
    public NumberRuleBuilder<T> notEqual(T value)
    {
        add(new NotEqualNumberRule(value));
        return this;
    }
    @Override
    public NumberRuleBuilder<T> equal(T value)
    {
        add(new EqualNumberRule(value));
        return this;
    }
    @Override
    public NumberRuleBuilder<T> length(int len)
    {
        add(new LengthRule(len, len));
        return this;
    }
    @Override
    public NumberRuleBuilder<T> length(int min, int max)
    {
        add(new LengthRule(min, max));
        return this;
    }
    @Override
    public NumberRuleBuilder<T> lessThan(T value)
    {
        add(new LessThanRule(value));
        return this;
    }
    @Override
    public NumberRuleBuilder<T> lessThanOrEqual(T value)
    {
        add(new LessThanOrEqualRule(value));
        return this;
    }
    @Override
    public NumberRuleBuilder<T> greaterThan(T value)
    {
        add(new GreaterThanRule(value));
        return this;
    }
    @Override
    public NumberRuleBuilder<T> greaterThanOrEqual(T value)
    {
        add(new GreaterThanOrEqualRule(value));
        return this;
    }
    @Override
    public NumberRuleBuilder<T> must(ConditionValidator<Number> condition)
    {
        add(new ConditionRule(condition));
        return this;
    }
    @Override
    public NumberRuleBuilder<T> phoneNumber(T value)
    {
        return this;
    }
    @Override
    public NumberRuleBuilder<T> nationalCode(T value)
    {
        return this;
    }
    @Override
    public NumberRuleBuilder<T> withMessage(String message)
    {
        add(new ChangeMessageRule(message));
        return this;
    }
}
