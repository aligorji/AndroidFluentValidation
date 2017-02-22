package ir.aligorji.fluentvalidation;


public interface TextRuleBuilder
{


    TextRuleBuilder notEmpty();

    TextRuleBuilder notEmptyOrWhiteSpace();

    TextRuleBuilder notEqual(String o);

    TextRuleBuilder equal(String o);

    TextRuleBuilder length(int len);

    TextRuleBuilder length(int min, int max);

    TextRuleBuilder must(ConditionValidator<String> condition);

    TextRuleBuilder emailAddress();

    TextRuleBuilder phoneNumber();

    TextRuleBuilder nationalCode();

    TextRuleBuilder withMessage(String message);
}
