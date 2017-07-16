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
    public NumberValidator<Integer> type;

    public ExamCommand(Context context)
    {
        super(context);
        firstName = new TextValidator(this, R.string.firstname);
        lastName = new TextValidator(this, R.string.lasttname);
        age = new NumberValidator<Integer>(this, "سن");

        fink();

        firstName.alive(false)
                .rule()
                .notEmpty()
                .length(4, 10);

        type = new NumberValidator<Integer>(this, "نوع");

        age.alive()
                .rule()
                .notEmpty()
                .notEqual(10)
                .length(5);

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
