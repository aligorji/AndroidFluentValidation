package ir.aligorji.fluentvalidation;


import android.support.annotation.StringRes;


public final class NumberValidator<T extends Number> extends Validator<T>
{

    public NumberValidator(CommandValidator commandValidator, @StringRes int resDisplay)
    {
        super(commandValidator, resDisplay);
    }
    public NumberValidator(CommandValidator commandValidator, String display)
    {
        super(commandValidator, display);
    }


    @Override
    public Number getParsedValue()
    {
        try
        {
            return (Number) getRule().getParsedValue(getValue());
        }
        catch (ValidationNumberParseException e)
        {

        }
        return null;
    }

    @Override
    protected boolean isNumeric()
    {
        return true;
    }

    @Override
    public NumberRule<T> rule()
    {
        return (NumberRule<T>) super.rule();
    }


    public NumberValidator<T> validateIfChangeValue()
    {
        return validateIfChangeValue(true);
    }

    @Override
    public NumberValidator<T> validateIfChangeValue(boolean v)
    {
        isValidateIfChangeValue = v;
        return this;
    }
    public NumberValidator<T> commandValidateIfChangeValue()
    {
        return commandValidateIfChangeValue(true);
    }

    @Override
    public NumberValidator<T> commandValidateIfChangeValue(boolean v)
    {
        isCommandValidateIfChangeValue = v;
        return this;
    }

    @Override
    public NumberValidator<T> stopOnFirstFailure(boolean v)
    {
        super.stopOnFirstFailure(v);
        return this;
    }

    public NumberValidator<T> stopOnFirstFailure()
    {
        return (NumberValidator<T>) super.stopOnFirstFailure(true);
    }

}
