package ir.aligorji.fluentvalidation.example;


import android.content.Context;

import ir.aligorji.fluentvalidation.CommandValidator;
import ir.aligorji.fluentvalidation.CustomRuleValidator;
import ir.aligorji.fluentvalidation.NumberValidator;
import ir.aligorji.fluentvalidation.TextValidator;
import ir.aligorji.fluentvalidation.ValidationException;

public class ExamCommand extends CommandValidator
{

    public TextValidator firstName;
    public TextValidator lastName;
    public NumberValidator<Integer> age;

    public ExamCommand(Context context)
    {
        super(context);
        firstName = new TextValidator(this, R.string.firstname);
        lastName = new TextValidator(this, R.string.lasttname);
        age = new NumberValidator<Integer>(this, "سن");

        firstName
                .validateIfChangeValue()
                .commandValidateIfChangeValue()
                .stopOnFirstFailure()
                .rule()
                .notEmpty();


        age
                .validateIfChangeValue()
                .commandValidateIfChangeValue()
                .rule()
                .notEmpty()
                .notEqual(10)
                .equal(200);

        custom(new CustomRuleValidator()
        {
            @Override
            public void validate(Context context) throws ValidationException
            {
                if (age.getParsedValue() == null || age.getParsedValue().intValue() < 100)
                {
                    throw new ValidationException("من");
                }
            }
        });

    }

}
