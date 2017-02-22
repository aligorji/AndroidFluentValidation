package ir.aligorji.fluentvalidation;


public interface NumberRuleBuilder<T extends Number>
{

    NumberRuleBuilder notEqual(T o);

    NumberRuleBuilder equal(T o);

    NumberRuleBuilder length(int len);

    NumberRuleBuilder length(int min, int max);

    NumberRuleBuilder lessThan(T value);

    NumberRuleBuilder lessThanOrEqual(T value);

    NumberRuleBuilder greaterThan(T value);

    NumberRuleBuilder greaterThanOrEqual(T value);

    NumberRuleBuilder must(ConditionValidator<Number> condition);

    NumberRuleBuilder phoneNumber(T value);

    NumberRuleBuilder nationalCode(T value);

    NumberRuleBuilder withMessage(String message);
}
