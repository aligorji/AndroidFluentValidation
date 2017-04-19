package ir.aligorji.fluentvalidation;


import android.content.Context;

import ir.aligorji.fluentvalidation.rules.ChangeMessageRule;
import ir.aligorji.fluentvalidation.rules.ConditionRule;
import ir.aligorji.fluentvalidation.rules.EmailRule;
import ir.aligorji.fluentvalidation.rules.EqualRule;
import ir.aligorji.fluentvalidation.rules.LengthRule;
import ir.aligorji.fluentvalidation.rules.NotEmptyOrWhiteSpaceRule;
import ir.aligorji.fluentvalidation.rules.NotEmptyRule;
import ir.aligorji.fluentvalidation.rules.NotEqualRule;


public final class TextRule extends BaseRule<String> implements TextRuleBuilder
{

    public TextRule(Context context)
    {
        super(context);
    }

    @Override
    public String getParsedValue(String value)
    {
        return value;
    }

    //===================================

    @Override
    public TextRuleBuilder notEmpty()
    {
        add(new NotEmptyRule());
        return this;
    }
    @Override
    public TextRuleBuilder notEmptyOrWhiteSpace()
    {
        add(new NotEmptyOrWhiteSpaceRule());
        return this;
    }
    @Override
    public TextRuleBuilder notEqual(String value)
    {
        add(new NotEqualRule(value));
        return this;
    }
    @Override
    public TextRuleBuilder equal(String value)
    {
        add(new EqualRule(value));
        return this;
    }
    @Override
    public TextRuleBuilder length(int len)
    {
        add(new LengthRule(len, len));
        return this;
    }
    @Override
    public TextRuleBuilder length(int min, int max)
    {
        add(new LengthRule(min, max));
        return this;
    }
    @Override
    public TextRuleBuilder must(ConditionValidator<String> condition)
    {
        add(new ConditionRule<>(condition));
        return this;
    }
    @Override
    public TextRuleBuilder emailAddress()
    {
        add(new EmailRule());
        return this;
    }
    @Override
    public TextRuleBuilder phoneNumber()
    {
        return this;
    }
    @Override
    public TextRuleBuilder nationalCode()
    {
        return this;
    }
    @Override
    public TextRuleBuilder withMessage(String message)
    {
        add(new ChangeMessageRule(message));
        return this;
    }

}
